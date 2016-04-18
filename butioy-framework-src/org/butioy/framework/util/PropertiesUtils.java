package org.butioy.framework.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * *.properties属性配置文件操作工具类
 * Created with IntelliJ IDEA.
 * Author butioy
 * Date 2015-09-18 23:10
 */
public class PropertiesUtils {

    private static final Logger LOG = LoggerFactory.getLogger( PropertiesUtils.class );

    private Properties props = new Properties();

    private File file;

    /**
     * 构造函数
     * @param propertiesName 文件名称
     */
    public PropertiesUtils(String propertiesName) {
        URL url = Thread.currentThread().getContextClassLoader().getResource(propertiesName);
        try {
            Assert.notNull(url);
            String urlStr =  url.toString();
            urlStr = urlStr.replace("file:/", "/");
            urlStr = urlStr.replace("\\", "/");
            File file = new File(urlStr);
            this.propsLoad(file);
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error("properties配置文件【" + propertiesName + "】未找到", e);
        }
    }

    /**
     * 构造函数
     * @param file 文件
     */
    public PropertiesUtils(File file) {
        this.propsLoad(file);
    }

    /**
     * 辅助方法，根据file创建工具对象
     * @param file
     */
    private void propsLoad(File file) {
        FileReader reader = null;
        try {
            this.file = file;
            reader = new FileReader(file);
            props.load(reader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            LOG.error("properties配置文件【" + file.getPath() + "】未找到", e);
        } catch (IOException e) {
            e.printStackTrace();
            LOG.error("读取properties配置文件【" + file.getPath() + "】失败", e);
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                LOG.error("关闭读取配置文件【" + file.getPath() + "】流失败", e);
            }
        }
    }

    /**
     * 根据key获取value
     * @param key
     * @return
     */
    public  String getValue(String key) {
        return props.getProperty(key);
    }

    /**
     * 向properties文件写入键值对
     * @param keyName
     * @param keyValue
     */
    public void writeProperties(String keyName, String keyValue) {
        Map<String, String> propertiesMap = new HashMap<String, String>();
        propertiesMap.put(keyName, keyValue);
        batchWriteProperties(propertiesMap);
    }

    /**
     * 批量更新properties的键值对
     * @param propertiesMap
     */
    public void batchWriteProperties(Map<String, String> propertiesMap) {
        FileWriter writer = null;
        try {
            // 调用 Hashtable 的方法 put，使用 getProperty 方法提供并行性。
            // 强制要求为属性的键和值使用字符串。返回值是 Hashtable 调用 put 的结果。
            writer = new FileWriter(this.file);
            //            OutputStream fos = new FileOutputStream(profilepath);
            for (String key : propertiesMap.keySet()) {
                this.props.setProperty(key, propertiesMap.get(key));
            }
            // 以适合使用 load 方法加载到 Properties 表中的格式，
            // 将此 Properties 表中的属性列表（键和元素对）写入输出流
            this.props.store(writer, "batch update");
        } catch (IOException e) {
            LOG.error("批量向【"+this.file.getName()+"】写入数据失败", e);
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                LOG.error("关闭【"+this.file.getName()+"】输出流失败", e);
            }
        }
    }

    /**
     * 更新properties文件
     * @param keyName 名称
     * @param keyValue 值
     */
    public void updateProperties(String keyName,String keyValue) {
        Map<String, String> propertiesMap = new HashMap<String, String>();
        propertiesMap.put(keyName, keyValue);
        this.batchUpdateProperties(propertiesMap);
    }

    /**
     * 批量更新键值对
     * @param propertiesMap
     */
    public void batchUpdateProperties(Map<String, String> propertiesMap) {
        BufferedWriter output = null;
        try {
            // 调用 Hashtable 的方法 put，使用 getProperty 方法提供并行性。
            // 强制要求为属性的键和值使用字符串。返回值是 Hashtable 调用 put 的结果。
            //            OutputStream fos = new FileOutputStream(profilepath);
            output = new BufferedWriter(new FileWriter(this.file));
            for (String key : propertiesMap.keySet()) {
                this.props.setProperty(key, propertiesMap.get(key));
            }
            // 以适合使用 load 方法加载到 Properties 表中的格式，
            // 将此 Properties 表中的属性列表（键和元素对）写入输出流
            props.store(output, "batch update ");
        } catch (IOException e) {
            LOG.error("批量更新文件【"+this.file.getName()+"】内容失败", e);
        } finally {
            try {
                if (output != null) {
                    output.close();
                }
            } catch (IOException e) {
                LOG.error("关闭【"+this.file.getName()+"】输出流失败", e);
            }
        }
    }

}
