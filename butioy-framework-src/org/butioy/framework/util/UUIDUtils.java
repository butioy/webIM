package org.butioy.framework.util;

import java.util.UUID;

/**
 * Created by butioy on 2016/1/24.
 */
public class UUIDUtils {

    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-","");
    }

}
