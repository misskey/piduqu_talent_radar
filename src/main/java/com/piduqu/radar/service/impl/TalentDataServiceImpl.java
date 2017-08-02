package com.piduqu.radar.service.impl;

import com.mongodb.BasicDBObject;
import com.mongodb.QueryBuilder;
import com.piduqu.radar.common.JsonResult;
import com.piduqu.radar.common.utils.CommonUtils;
import com.piduqu.radar.entity.mongo.InnerResume;
import com.piduqu.radar.entity.mongo.Talent_Resume;
import com.piduqu.radar.service.TalentDataService;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author 无聊的挂面
 * @since 2017-07-19 18:05
 */
@Service("talentDataService")
public class TalentDataServiceImpl implements TalentDataService {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * Mongodb查询排序
     * @param expert_type
     * @return
     */
    @Override
    public List<InnerResume> getTalentDataList(String expert_type) {
        Query query = new Query();
        query.addCriteria(Criteria.where("expert_type").is("诺贝尔奖"));


        query.with(new Sort(Sort.Direction.DESC, "create_time"));
        query.skip(0).limit(10);
        List<InnerResume> list = mongoTemplate.find(query, InnerResume.class);

        return list;
    }

    /**
     * Mongodb查询
     * 指定返回字段，有的文档数据量太大，所以指定其中某几个字段
     * @param expert_type
     * @return
     */
    @Override
    public List<InnerResume> getTalentDataListProjection(String expert_type){
        QueryBuilder queryBuilder = new QueryBuilder();
        queryBuilder.or(new BasicDBObject("expert_type", "诺贝尔奖"), new BasicDBObject("expert_type","诺贝尔奖"));
//        1或者true表示返回字段
//        0或者false表示不返回该字段
//        _id:默认就是1，没指定返回该字段时，默认会返回，除非设置为0是，就不会返回该字段。
//        指定返回字段，有时文档字段多并数据大时，我们指定返回我们需要的字段，这样既节省传输数据量，减少了内存消耗，提高了性能，在数据大时，性能很明显的。
        BasicDBObject fieldsObject=new BasicDBObject();
        fieldsObject.put("name", 1);
        BasicQuery basicQuery = new BasicQuery(queryBuilder.get(),fieldsObject);
        List<InnerResume> list = mongoTemplate.find(basicQuery, InnerResume.class).subList(1, 10);
        return list;
    }

    /**
     * Mongodb查询
     * 分页
     * @param expert_type
     * @return
     */
    @Override
    public List<InnerResume> getTalentDataListPage(String expert_type){
        Query query = new Query();
        query.addCriteria(Criteria.where("expert_type").is("诺贝尔奖"));
        query.with(new Sort(Sort.Direction.DESC, "create_time"));
        query.skip(0).limit(10);
        List<InnerResume> list = mongoTemplate.find(query, InnerResume.class);
        return list;
    }

    @Override
    public JsonResult save(Object o, String collectionName) throws ParseException {
//        mongoTemplate.save(o,collectionName);
        if(!CommonUtils.isPhone(((Talent_Resume) o).getTelphone())){
            return JsonResult.failure("电话号码格式不正确");
        }
        else if(!CommonUtils.isEmail(((Talent_Resume) o).getEmail())){
            return JsonResult.failure("邮箱格式不正确");
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        ((Talent_Resume) o).setImport_time(sdf.parse(sdf.format(new Date())));
        mongoTemplate.insert(o,collectionName);
        return JsonResult.success("简历导入成功");
    }

    @Override
    public List<InnerResume> getTalentDataListByFiles(String[] resume_id,String[] return_field ,HttpServletResponse response) throws Exception {
        Query query = new Query();
        List<InnerResume> resumelst = new ArrayList<>();
        Field[] fields = InnerResume.class.getDeclaredFields();
        for(String id:resume_id){
            resumelst.add(mongoTemplate.findById(id, InnerResume.class));
        }
//        File file = new File("test.xls");
//        file.createNewFile();
        response.setContentType("application/x-download");//下面三行是关键代码，处理乱码问题
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-Disposition", "attachment;filename="+new String("resume.xls".getBytes("gbk"), "iso8859-1"));

//        WritableWorkbook workbook = Workbook.createWorkbook(file);
        WritableWorkbook workbook = Workbook.createWorkbook(response.getOutputStream());
        WritableSheet workSheet = workbook.createSheet("first sheet",0);
        // 构造excel 表头
        for(int j=0;j<return_field.length;j++){
            workSheet.addCell(new Label(j,0,return_field[j]));
        }
        //填充表格
        for(int i = 1;i<=resumelst.size();i++){
            for(int j=0;j<return_field.length;j++){
                for(int k=0;k<fields.length;k++){
                    if (return_field[j].equals(fields[k].getName())){
                        fields[k].setAccessible(true);
                        workSheet.addCell(new Label(j,i,fields[k].get(resumelst.get(i-1)).toString()));
                    }
                }
            }
        }
        workbook.write();
        workbook.close();

//        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(new File(file.getName())),"utf-8");
//        IOUtils.copy(inputStreamReader, response.getOutputStream(), "utf-8");

        return null;
    }

    @Override
    public JsonResult statistics() {

        QueryBuilder queryBuilder = new QueryBuilder();
        Date startDate = new Date();
//        startDate.s
//        sta
        queryBuilder.put("import_time").lessThanEquals(new Date());

// 要查询的字段
//        BasicDBObject fieldsObject = new BasicDBObject();
//        fieldsObject.put("name", 1);
//        fieldsObject.put("age", 1);
//        fieldsObject.put("createTime", 1);

// 执行查询
        Query query = new BasicQuery(queryBuilder.get(), null);
        List<Map> list = mongoTemplate.find(query, Map.class, "talent_resume");
        int count = (int) mongoTemplate.count(query,"talent_resume");


        return JsonResult.success();
    }
}
