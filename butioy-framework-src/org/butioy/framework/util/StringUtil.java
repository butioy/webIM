package org.butioy.framework.util;

import org.apache.commons.lang3.StringUtils;

import java.util.Random;

/**
 * 字符串工具类
 * Created with IntelliJ IDEA.
 * Author butioy
 * Date 2015-10-12 02:24
 */
public class StringUtil {

    /**
     * 截取字符串的开始和结束位置的","
     * @param value 要去掉逗号“,”的字符串
     * @return 去掉“,”后的字符串
     */
    public static String subStringComma ( String value ) {
        if(StringUtils.isNotBlank(value)) {
            value = value.trim();
            if( value.startsWith(",") ) {
                value = value.substring(1);
            }
            if( value.endsWith(",") ) {
                value = value.substring(0, value.length()-1);
            }
        }
        return value;
    }

    /**
     * 随机生成八位的密码（包含大小写英文字母和数字）
     * @return 随机生成的八位密码
     */
    public static String randomPasswordFor8() {
        return randomPassword(8);
    }

    /**
     * 随机生成 <code>length</code> 位的密码（包含大小写英文字母和数字）
     * @param length 生成的密码长度
     * @return 随机生成的 <code>length</code> 位密码
     */
    public static String randomPassword( final int length ) {
        StringBuilder password = new StringBuilder("");
        final int maxNum = 36;
        final String[] arr = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q",
                "r","s","t","u","v","w","x","y","z","A","B","C","D","E","F","G","H","I","J",
                "K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","0","1","2",
                "3","4","5","6","7","8","9"};
        Random random = new Random();
        int count = 0; //生成的随机数个数;
        while(count < length ) {
            //生成随机数，取绝对值，防止生成负数，
            int ran = Math.abs(random.nextInt(maxNum)); //生成的数最大为36-1
            if(  ran >= 0 && ran < arr.length) {
                password.append(arr[ran]);
                count ++;
            }
        }
        return password.toString();
    }

}
