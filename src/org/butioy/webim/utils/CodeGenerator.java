package org.butioy.webim.utils;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Author butioy
 * Date 2016-02-13 12:06
 * Since 2015 - 2016
 */
public class CodeGenerator {

    /**
     * 默认的CODE码起始值
     */
    private static final String DEFAULT_CODE = "10000";

    /**
     * 生成Code码
     * @param startCode CODE码起始值
     * @param total 生成数量
     * @return 生成的CODE码集合
     */
    public static List<String> generate( String startCode, int total ) {
        if( total <= 0 ) {
            return null;
        }
        List<String> codes = Lists.newArrayList();
        if( StringUtils.isBlank(startCode) ) {
            startCode = DEFAULT_CODE;
        }
        Integer start = Integer.valueOf(startCode);
        for( int i=1; i<=total; i++ ) {
            int temp = start + i;
            codes.add(temp+"");
        }
        return codes;
    }

}
