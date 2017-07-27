package com.piduqu.radar.common.utils;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.validation.FieldError;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author 无聊的挂面
 * @since 2017-07-11 16:28
 */
public class CommonUtils {

    static SimpleDateFormat ymdhms = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    static SimpleDateFormat ymdhm = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    static SimpleDateFormat ymd = new SimpleDateFormat("yyyy-MM-dd");
    static SimpleDateFormat ym = new SimpleDateFormat("yyyy-MM");
    static SimpleDateFormat yyyymmdd = new SimpleDateFormat("yyyyMMddHHmmss");
    static SimpleDateFormat ymd_chinese = new SimpleDateFormat("yyyy年-MM月-dd日");

    /**
     * 生成唯一ID
     * @return
     */
    public static String getUUID() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replace("-","");
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

    public static String getErrors(List<FieldError> fieldErrorList) {
        StringBuffer sb = new StringBuffer();
        StringBuffer info = new StringBuffer();
        for(FieldError fieldError:fieldErrorList) {
            sb.append(fieldError.getField());
            sb.append(":");
            sb.append(fieldError.getDefaultMessage());
            sb.append(";");
            info.append(fieldError.getDefaultMessage());
            info.append(";");
        }
        return info.toString();
    }

    public static List getErrorsList(List<FieldError> fieldErrorList) {
        StringBuffer sb = new StringBuffer();
        StringBuffer info = new StringBuffer();
        List<ErrorObject> infoList = new ArrayList<>();
        ErrorObject errorObject = null;
        for(FieldError fieldError:fieldErrorList) {
            errorObject = new ErrorObject();
            errorObject.setFiled(fieldError.getField());
            errorObject.setErrorMsg(fieldError.getDefaultMessage());
            infoList.add(errorObject);
            sb.append(fieldError.getField());
            sb.append(":");
            sb.append(fieldError.getDefaultMessage());
            sb.append(";");
            info.append(fieldError.getDefaultMessage());
            info.append(";");
        }
        return infoList;
    }

    private static class ErrorObject{

        private String filed;

        private String errorMsg;

        public String getFiled() {
            return filed;
        }

        public void setFiled(String filed) {
            this.filed = filed;
        }

        public String getErrorMsg() {
            return errorMsg;
        }

        public void setErrorMsg(String errorMsg) {
            this.errorMsg = errorMsg;
        }
    }

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
}
