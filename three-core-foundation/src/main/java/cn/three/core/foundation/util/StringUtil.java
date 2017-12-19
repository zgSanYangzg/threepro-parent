package cn.three.core.foundation.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/12/7 0007.
 */
public class StringUtil {
    /**
     * 判断输入的字符串参数是否为空。
     * @param args 输入的字串
     * @return true/false
     */
    public static boolean validateNull(String args) {
        if (args == null || args.length() == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断输入的字符串参数是否为空或者是"null"字符,如果是,就返回target参数,如果不是,就返回source参数。
     */
    public static String chanageNull(String source, String target) {
        if (source == null || source.length() == 0 || source.equalsIgnoreCase("null")) {
            return target;
        } else {
            return source;
        }
    }

    /**
     * 过滤<, >,\n 字符的方法。
     * @param input 需要过滤的字符
     * @return 完成过滤以后的字符串
     */
    public static String filterHtml(String input) {
        if (input == null) {
            return null;
        }
        if (input.length() == 0) {
            return input;
        }
        input = input.replaceAll("&", "&amp;");
        input = input.replaceAll("<", "&lt;");
        input = input.replaceAll(">", "&gt;");
        input = input.replaceAll(" ", "&nbsp;");
        input = input.replaceAll("'", "&#39;");
        input = input.replaceAll("\"", "&quot;");
        return input.replaceAll("\n", "<br>");
    }

    /**
     * 计算字符串的长度(忽略空格,一个汉字按2个长度计算，如果是null,则长度为0)
     * @param value
     * @return 返回字符串的长度
     */
    public static int length(String value) {
        if (value==null) return 0;
        value = value.trim();
        int valueLength = 0;
        String chinese = "[\u0391-\uFFE5]";
        /* 获取字段值的长度，如果含中文字符，则每个中文字符长度为2，否则为1 */
        for (int i = 0; i < value.length(); i++) {
            /* 获取一个字符 */
            String temp = value.substring(i, i + 1);
            /* 判断是否为中文字符 */
            if (temp.matches(chinese)) {
                /* 中文字符长度为2 */
                valueLength += 2;
            } else {
                /* 其他字符长度为1 */
                valueLength += 1;
            }
        }
        return valueLength;
    }

	/*
	 *
	 */
    /**
     * 将科学计算的double值转换成正常显示的字符串
     * @param value 需要转换的double值
     * @return 转换之后的字符串
     */
    public static String formatFloatNumber(double value) {
        if(value != 0.00){
            java.text.DecimalFormat df = new java.text.DecimalFormat("########.00");
            return df.format(value);
        }else{
            return "0.00";
        }
    }

    /**
     * 银联所需工具类
     * @param str
     * @return
     */
    public static boolean isEmpty(String str){
        return str==null||str.trim().length()==0?true:false;
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }
    /**
     * 获取传入时间所对应的年月日时间  .
     * @param date 当前时间 .
     * @return 返回字符串格式 yyyyMMdd .
     */
    public static String getRelevantDate(Date date){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        String dateString = formatter.format(date);
        return dateString;
    }

    /**
     * 获取传入时间所对应的时分秒时间 .
     * @param date 当前时间 .
     * @return 返回字符串格式 HHmmss .
     */
    public static String getRelevantTime(Date date){
        SimpleDateFormat formatter = new SimpleDateFormat("HHmmss");
        String dateString = formatter.format(date);
        return dateString;
    }
    /**
     * 字符串补位.
     * @param val 字符串 .
     * @param type r右补位l左补位 .
     * @param size 补足长度 .
     * @param delim 补位用字符串 .
     * @return String .
     */
    public static String pad(String val, String type, int size, String delim) {
        if(isEmpty(val)) return val;
        if ("r".equals(type)) {
            if (val.length() >= size) {
                return val.substring(0, size);
            } else {
                return val + repeat('r', delim, size - val.length());
            }
        } else {
            if (val.length() >= size) {
                return val.substring(val.length() - size);
            } else {
                return repeat('l', delim, size - val.length()) + val;
            }
        }
    }
    /**
     * 重复字符串 .
     * @param type r右补位l左补位 .
     * @param val 字符串 .
     * @param len 长度 .
     * @return .
     */
    public static String repeat(char type, String val, int len) {
        if(isEmpty(val)) return val;
        StringBuffer tBuffer = new StringBuffer();
        while (tBuffer.length() < len) {
            tBuffer.append(val);
        }

        if ('r' == type) {
            return tBuffer.substring(0, len);
        } else {
            return tBuffer.substring(tBuffer.length() - len);
        }

    }

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
    }

    public static String paserMaptoStr(Map<String, Object> dataMap) {
        StringBuffer sb = new StringBuffer();
        for(Map.Entry<String, Object> entry:dataMap.entrySet()){
            sb.append("&").append(entry.getKey()).append("=").append(entry.getValue());
        }
        if(sb.length()>0){
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }


    public static Map<String, String> paserStrtoMap(String respStr) {
        Map<String, String> data = new HashMap<String, String>();
        if (isNotEmpty(respStr)) {
            String[] strs = respStr.split("&");
            for (String str : strs) {
                if (isEmpty(str)) {
                    continue;
                }
                int index = str.indexOf("=");
//				if (entryStrs.length > 1) {
//					data.put(entryStrs[0], entryStrs[1]);
//				}
                data.put(str.substring(0, index),str.substring(index+1));
            }
        }
        return data;
    }
}
