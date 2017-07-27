package com.piduqu.radar.service.impl;

import com.mongodb.BasicDBObject;
import com.mongodb.QueryBuilder;
import com.piduqu.radar.entity.mongo.InnerResume;
import com.piduqu.radar.service.TalentDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

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

}
