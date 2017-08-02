package com.piduqu.radar.util;


import com.piduqu.radar.common.utils.JsonUtil;
import org.apache.log4j.Logger;
import org.springframework.validation.FieldError;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 梁亮 on 2015/9/8 0008.
 * Cell:15884457479
 * Email:dreamto1@126.com
 * Description:
 * <p/>
 * Functions:
 * 1.
 */
public class CommonUtil {

    private static Logger logger = Logger.getLogger(CommonUtil.class);

    static SimpleDateFormat ymdhms = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    static SimpleDateFormat ymdhm = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    static SimpleDateFormat ymd = new SimpleDateFormat("yyyy-MM-dd");
    static SimpleDateFormat ym = new SimpleDateFormat("yyyy-MM");
    static SimpleDateFormat yyyymmdd = new SimpleDateFormat("yyyyMMddHHmmss");
    static SimpleDateFormat ymd_chinese = new SimpleDateFormat("yyyy年-MM月-dd日");
    static Random random = new Random();

    private static final String[] codes = {
            "0","1","2","3","4","5","6","7","8","9",
            "a","b","c","d","e","f","g","h","i","j","k","m","n","p","q","r","s","t","u","v","w","x","y","z",
            "A","B","C","D","E","F","G","H","I","J","K","L","M","N","P","Q","R","S","T","U","V","W","X","Y","Z"
    };

    private static final String[] num_codes = {"0","1","2","3","4","5","6","7","8","9"};

    /**
     * 判断对象为空
     * @param obj
     * @return
     */
    public static boolean isEmpty(Object obj) {
        if (obj == null) {
            return true;

        } else if (obj instanceof String && (obj.toString().trim().equals(""))) {
            return true;

        } else if (obj instanceof Number && ((Number) obj).doubleValue() == 0) {
            return true;

        } else if (obj instanceof Collection && ((Collection) obj).isEmpty()) {
            return true;

        } else if (obj instanceof Map && ((Map) obj).isEmpty()) {
            return true;

        } else if (obj instanceof Object[] && ((Object[]) obj).length == 0) {
            return true;

        }
        return false;
    }

    /**
     * 判断对象不为空
     * @param obj
     * @return
     */
    public static boolean isNotEmpty(Object obj) {
        return !isEmpty(obj);
    }

    /**
     * 生成唯一ID
     * @return
     */
    public static String getUuid() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replace("-","");
    }

    /**
     * 生成短信验证码
     * @return
     */
    public static String getVcode(){
        //验证码
        String vcode = "";
        for (int i = 0; i < 6; i++) {
            vcode = vcode + (int)(Math.random() * 9);
        }
        return vcode;
    }
    /**
     * 判断是否是邮箱
     * @param email
     * @return true:是  false:否
     */
    public static boolean isEmail(String email)
    {
        if (isEmpty(email)){
            return false;
        }
        boolean tag = true;
        final String pattern1 = "^([a-z0-9A-Z]+[-|\\.|_]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        final Pattern pattern = Pattern.compile(pattern1);
        final Matcher mat = pattern.matcher(email);
        if (!mat.find()) {
            tag = false;
        }
        return tag;
    }

    /**
     * 判断是否是手机号
     * @param phone
     * @return
     */
    public static boolean isPhone(String phone)
    {
        if (isEmpty(phone)){
            return false;
        }
        boolean tag = true;
        final String pattern1 = "^0?(13|14|15|18|17)[0-9]{9}$";
        final Pattern pattern = Pattern.compile(pattern1);
        final Matcher mat = pattern.matcher(phone);
        if (!mat.find()) {
            tag = false;
        }
        return tag;
    }
    public static boolean isPassword(String password){
        if(isEmpty(password))
            return false;
        boolean fg = password.length() >= 8;
        return fg;
    }

    /**
     * 组装字符串
     * @param ss  字符串列表
     * @param split 分割符
     * @return  组合过后字符串
     */
    public static String combination(String[] ss,String split) {
        if(ss.length==0)
            return null;
        StringBuffer sb = new StringBuffer();
        for (String str : ss) {
            sb.append(str);
            sb.append(split);
        }
        return sb.toString().substring(0, sb.length() - 1);
    }

    /**
     * 修正页码
     * @param value
     * @return
     */
    public static Integer checkPage(Object value) {
        Integer page = 0;
        if (value != null) {
            if (value instanceof String) {
                page = Integer.parseInt((String) value);
            } else if (value instanceof Integer) {
                page = (Integer) value;
            }
            page = page < 0 ? 0 : page;
        }
        return page;
    }

    /**
     * 获取请求IP地址
     * @param request
     * @return
     */
    public static String getIP(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    /**
     * 比较时间大小 返回date1是否大于date2
     * @param date1
     * @param date2
     * @return
     */
    public static boolean before(Date date1, Date date2) {
        return date1.getTime() > date2.getTime();
    }

    /**
     * 日期格式化成:"yyyy-MM-dd HH:mm:ss"
     * @param date
     * @return
     */
    public static String getymdhms(Date date) {
        return ymdhms.format(date);
    }

    /**
     * 日期格式化成:"yyyy-MM-dd HH:mm"
     * @param date
     * @return
     */
    public static String getymdhm(Date date) {
        return ymdhm.format(date);
    }

    public static String getStringTime(String date) throws ParseException {
        Date time = ymdhms.parse(date);
        return ymdhm.format(time);
    }
    /**
     * 日期格式化成:"yyyy-MM-dd"
     * @param date
     * @return
     */
    public static String getymd(Date date) {
        return ymd.format(date);
    }

    /**
     * 日期格式化成:"yyyy-MM"
     * @param date
     * @return
     */
    public static String getym(Date date) {
        return ym.format(date);
    }

    public static Date getDateBySecond(String dateStr){
        if (isEmpty(dateStr)){
            return null;
        }
        Date date = null;
        try {
            date = ymdhms.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 获取时间偏移的有效链接时间
     * @return
     */
    public static Date getValidityTime(int day, int hour, int minute){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, day);
        calendar.add(Calendar.HOUR_OF_DAY, hour);
        calendar.add(Calendar.MINUTE, minute);
        return calendar.getTime();
    }

    public static String getCheckCode(int code_num){
        StringBuilder builder = new StringBuilder("");
        for(int i = 0; i< code_num; i++){
            builder.append(codes[random.nextInt(codes.length -1)]);
        }
        return String.valueOf(builder);
    }

    /**
     * 获得手机验证码
     * @param code_num
     * @return
     */
    public static String getPhoneCode(int code_num) {
        StringBuilder builder = new StringBuilder("");
        for(int i = 0; i< code_num; i++){
            builder.append(num_codes[random.nextInt(num_codes.length -1)]);
        }
        return String.valueOf(builder);
    }

    public static <T> List<T> listToList(List list, Class<T> entityClass){
        List<T> data = new ArrayList<>();
        if (null != list && null != entityClass) {
            for (Object ad : list) {
                data.add(CommonUtil.objectToEntity(ad, entityClass));
            }
        }
        return data;
    }

    public static <T> T objectToEntity(Object object, Class<T> entityClass) {
        T result = null;
        if (object != null && entityClass != null) {
            try {
                result = (T) Class.forName(entityClass.getName()).newInstance();
                Field[] fields = object.getClass().getDeclaredFields();
                List<String> fieldList = getFieldNameList(entityClass);
                Field resultField = null;
                for (Field field : fields) {
                    field.setAccessible(true);
                    if (fieldList.contains(field.getName()) && field.get(object) != null) {
                        resultField = entityClass.getDeclaredField(field.getName());
                        resultField.setAccessible(true);
                        if (resultField.getType().equals(Integer.class) || resultField.getType().equals(int.class)) {
                            resultField.set(result, Integer.valueOf(String.valueOf(field.get(object))));
                        } else if (resultField.getType().equals(Date.class)) {
                            if (field.getType().equals(Date.class)) {
                                resultField.set(result, field.get(object));
                            } else if (field.getType().equals(String.class)) {
                                resultField.set(result, CommonUtil.getDateBySecond(String.valueOf(field.get(object))));
                            }
                        } else if(resultField.getType().equals(String.class)){
                            if(field.getType().equals(Date.class))
                                resultField.set(result, getymdhm((Date) field.get(object)));
                            else
                                resultField.set(result, String.valueOf(field.get(object)));
                        }
                    }
                }
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return result;
    }

    public static void objectToObject(Object object, Object objectTo) {
        if (object != null && objectTo != null) {
            try {
                Field[] fields = object.getClass().getDeclaredFields();
                List<String> fieldList = getFieldNameList(objectTo.getClass());
                Field resultField = null;
                for (Field field : fields) {
                    field.setAccessible(true);
                    if (fieldList.contains(field.getName()) && field.get(object) != null) {
                        resultField = objectTo.getClass().getDeclaredField(field.getName());
                        resultField.setAccessible(true);
                        if (resultField.getType().equals(Integer.class) || resultField.getType().equals(int.class)) {
                            resultField.set(objectTo, Integer.valueOf(String.valueOf(field.get(object))));
                        } else if (resultField.getType().equals(Date.class)) {
                            if (field.getType().equals(Date.class)) {
                                resultField.set(objectTo, field.get(object));
                            } else if (field.getType().equals(String.class)) {
                                resultField.set(objectTo, CommonUtil.getDateBySecond(String.valueOf(field.get(object))));
                            }
                        } else {
                            resultField.set(objectTo, String.valueOf(field.get(object)));
                        }

                    }
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    private static List<String> getFieldNameList(Class cla){
        if(isEmpty(cla))
            return null;
        List<String> result = new ArrayList<>();
        for(Field field:cla.getDeclaredFields()){
            result.add(field.getName());
        }
        return result;
    }

    public static String getErrors(List<FieldError> fieldErrorList) {
        StringBuffer sb = new StringBuffer();
        StringBuffer info = new StringBuffer();
        for(FieldError fieldError:fieldErrorList) {
            sb.append(fieldError.getField());
            sb.append(":");
            sb.append(fieldError.getDefaultMessage());
            sb.append(";");
            logger.info(sb.toString());
            info.append(fieldError.getDefaultMessage());
            info.append(";");
        }
        return info.toString();
    }

    public static Object[] findAnnotation(Method method, Class annotationClass){
        Object methodAnnotation = method.getAnnotation(annotationClass);
        Object classAnnotation = method.getDeclaringClass().getAnnotation(annotationClass);
        Object[] result = {classAnnotation, methodAnnotation};
        return result;
    }

//    public static String getControllerParaJson(Object[] args) {
//        List<Object> objectList = new ArrayList<>();
//        for (Object o : args) {
//            if (o instanceof BaseRequest)
//                objectList.add(o);
//        }
//        return JsonUtil.entityToJson(objectList);
//    }

    public static String getParaJson(Object[] args) {
        List<Object> objectList = new ArrayList<>();
        for (Object o : args) {
            objectList.add(o);
        }
        return JsonUtil.entityToJson(objectList);
    }

//    public static boolean needLog(JoinPoint point) throws NoSuchMethodException {
//        //默认不记录日志
//        boolean result = false;
//        Object target = point.getTarget();
//        //拦截的方法名称
//        String methodName = point.getSignature().getName();
//        //拦截的方法参数类型
//        Class[] parameterTypes = ((MethodSignature) point.getSignature()).getMethod().getParameterTypes();
//        Method method = null;
//        //通过反射获得拦截的method
//        method = target.getClass().getMethod(methodName, parameterTypes);
//        Object[] annotations = CommonUtil.findAnnotation(method, Log.class);
//        for (Object annotation : annotations) {
//            if(CommonUtil.isEmpty(annotation))
//                continue;
//            Log log = (Log) annotation;
//            result = log.needLog();
//        }
//        return result;
//    }

    public static Integer string2Integer(String integer){
        if (null == integer || "".equals(integer.trim())){
            return null;
        }
        try{
            return Integer.valueOf(integer);
        }catch (Exception e){
            return null;
        }
    }

    public static Byte string2Byte(String num){
        if (null == num || "".equals(num.trim())){
            return null;
        }
        try{
            return Byte.parseByte(num);
        }catch (Exception e){
            return null;
        }
    }


    //region 检查是PC端还是移动端
    // \b 是单词边界(连着的两个(字母字符 与 非字母字符) 之间的逻辑上的间隔),
    // 字符串在编译时会被转码一次,所以是 "\\b"
    // \B 是单词内部逻辑间隔(连着的两个字母字符之间的逻辑上的间隔)
    static String phoneReg = "\\b(ip(hone|od)|android|opera m(ob|in)i"
            +"|windows (phone|ce)|blackberry"
            +"|s(ymbian|eries60|amsung)|p(laybook|alm|rofile/midp"
            +"|laystation portable)|nokia|fennec|htc[-_]"
            +"|mobile|up.browser|[1-4][0-9]{2}x[1-4][0-9]{2})\\b";
    static String tableReg = "\\b(ipad|tablet|(Nexus 7)|up.browser"
            +"|[1-4][0-9]{2}x[1-4][0-9]{2})\\b";

    //移动设备正则匹配：手机端、平板
    static Pattern phonePat = Pattern.compile(phoneReg, Pattern.CASE_INSENSITIVE);
    static Pattern tablePat = Pattern.compile(tableReg, Pattern.CASE_INSENSITIVE);

    /**
     * 匹配UserAgent文件头
     * @param userAgent 浏览器标识
     * @return true:移动设备接入，false:pc端接入
     */
    public static boolean checkMobile(String userAgent){
        if(null == userAgent){
            userAgent = "";
        }
        userAgent = userAgent.toLowerCase();
        // 匹配
        Matcher matcherPhone = phonePat.matcher(userAgent);
        Matcher matcherTable = tablePat.matcher(userAgent);
        if(matcherPhone.find() || matcherTable.find()){
            return true;
        } else {
            return false;
        }
    }
    //endregion

    public static String getNumber(String str) {
        if (str == null) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        Pattern p=Pattern.compile("(\\d+)");
        Matcher m=p.matcher(str);
        while (m.find()) {
            sb.append(m.group(1));
        }
        return sb.toString();
    }

    public static final String SPECIAL_CHAR = "[`~!@#$%^&*+=|{}',:;\"[url=file://\\[\\].<]\\[\\].<>/[/url]?～！＠＃￥％……＆×（）——＋｜｛｝【】［］‘；：＂。，、．＜＞／？]";

    public static String StringFilter(String srcStr){
        return Pattern.compile(SPECIAL_CHAR).matcher(srcStr).replaceAll("").replaceAll("[url=]\\\\[/url]", "").trim();
    }

//    public static String formatResumCity(String resume_city){
//        if(CommonUtil.isEmpty(resume_city)){
//            return "无";
//        }
//        if(StringUtils.contains(resume_city, ";")){
//            return resume_city.split(";")[0];
//        }
//        return resume_city;
//    }


    public static String getOrderNO(){
        int r1=(int)(Math.random()*(10));//产生2个0-9的随机数
        int r2=(int)(Math.random()*(10));
        long now = System.currentTimeMillis();//一个13位的时间戳
        StringBuffer sb = new StringBuffer();
        sb.append(CommonUtil.yyyymmdd.format(new Date()));
        sb.append(r1);
        sb.append(r2);
        sb.append(now);
        return sb.toString();
    }

    public static String formatNumber(Double d){
        DecimalFormat df = new DecimalFormat("#.00");
        String amount = df.format(d);
        return  amount.startsWith(".")?"0"+amount:df.format(d);
    }

    public static Date getDateForymd(String date_str){
        if(CommonUtil.isEmpty(date_str)){
            return null;
        }
        try {
            return ymd.parse(date_str);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 日期格式化成:"yyyy年-MM月-dd日"
     * @param date
     * @return
     */
    public static String ymd_chinese(Date date) {
        return ymd_chinese.format(date);
    }


    /**
     * 时间天偏移，即获取传入时间的前或后的几天
     * @param date 时间
     * @param offset 正数：向前，负数：向后。如1表示明天，-1表示昨天
     * @return
     */
    public static Date getDateOffSet(Date date,int offset){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(calendar.DATE,offset);
        return calendar.getTime();
    }


    /**
     * 时间月偏移
     * @param date
     * @param offset
     * @return
     */
    public static Date getDateMonthOffSet(Date date,int offset){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(calendar.MONTH,offset);
        return calendar.getTime();
    }
}
