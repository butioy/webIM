package org.butioy.framework.util;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by butioy on 2015/5/16.
 */
public class ParamUtils {

    public static String getParameter( HttpServletRequest request, String key ) {
        return getParameter( request, key, "" );
    }

    public static String getParameter( HttpServletRequest request, String key, String defaultValue ) {
        String result = request.getParameter(key);
        if( StringUtils.isBlank(result) ) {
            result = defaultValue;
        }
        return result;
    }

    public static String[] getParameters( HttpServletRequest request, String key ) {
        return getParameters( request, key, "" );
    }

    public static String[] getParameters( HttpServletRequest request, String key, String defaultValue ) {
        String[] results = request.getParameterValues(key);
        if( null != results && results.length > 0 ) {
            for( String s : results ) {
                if( StringUtils.isBlank(s) ) {
                    s = defaultValue;
                }
            }
        } else results = new String[]{defaultValue};
        return results;

    }

    public static Long getLongParameter( HttpServletRequest request, String key ) {
        return getLongParameter(request, key, 0L);
    }

    public static Long getLongParameter( HttpServletRequest request, String key, Long defaultValue ) {
        String temp = getParameter(request, key, defaultValue.toString());
        Long result = defaultValue;
        if( StringUtils.isNotBlank(temp) && temp.matches("^[+-]?\\d+$") )
            result = Long.valueOf(temp);
        return result;
    }

    public static Long[] getLongParameters( HttpServletRequest request, String key ) {
        return getLongParameters(request, key, 0L);
    }

    public static Long[] getLongParameters( HttpServletRequest request, String key, Long defaultValue ) {
        String[] temps = getParameters(request, key, defaultValue.toString());
        Long[] results = new Long[]{defaultValue};
        if( null != temps && temps.length > 0 ) {
            results = new Long[temps.length];
            for( int i=0; i<temps.length; i++ ) {
                String temp = temps[i];
                if( StringUtils.isNotBlank(temp) && temp.matches("^[+-]?\\d+$") ) {
                    results[i] = Long.valueOf(temp);
                } else results[i] = defaultValue;
            }
        }
        return results;
    }


    public static Integer getIntParameter( HttpServletRequest request, String key ) {
        return getIntParameter(request, key, 0);
    }

    public static Integer getIntParameter( HttpServletRequest request, String key, Integer defaultValue ) {
        String temp = getParameter(request, key, defaultValue.toString());
        Integer result = defaultValue;
        if( StringUtils.isNotBlank(temp) && temp.matches("^[+-]?\\d+$") )
            result = Integer.valueOf(temp);
        return result;
    }

    public static Integer[] getIntParameters( HttpServletRequest request, String key ) {
        return getIntParameters(request, key, 0);
    }

    public static Integer[] getIntParameters( HttpServletRequest request, String key, Integer defaultValue ) {
        String[] temps = getParameters(request, key, defaultValue.toString());
        Integer[] results = new Integer[]{defaultValue};
        if( null != temps && temps.length > 0 ) {
            results = new Integer[temps.length];
            for( int i=0; i<temps.length; i++ ) {
                String temp = temps[i];
                if( StringUtils.isNotBlank(temp) && temp.matches("^[+-]?\\d+$") ) {
                    results[i] = Integer.valueOf(temp);
                } else results[i] = defaultValue;
            }
        }
        return results;
    }

    public static Boolean getBooleanParameter( HttpServletRequest request, String key ) {
        return getBooleanParameter(request, key, false);
    }

    public static Boolean getBooleanParameter( HttpServletRequest request, String key, boolean defaultValue ) {
        String value = getParameter(request, key);
        boolean result = defaultValue;
        if( StringUtils.isNotBlank(value) )
            result = Boolean.parseBoolean(value);
        return result;
    }

}