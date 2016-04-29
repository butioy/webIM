package org.butioy.framework.util;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Pattern;

import jdk.nashorn.internal.runtime.regexp.joni.Matcher;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;
import org.apache.commons.lang3.StringUtils;

public class FileUtils {

	public static String getExt( String fileName ) {
		if( StringUtils.isNotBlank(fileName) && fileName.indexOf(".") != -1 ) {
			return fileName.substring(fileName.lastIndexOf(".")+1);
		}
		return "";
	}
	
	public static String getWebRootPath() {
		String webRootPath = FileUtils.class.getResource("").getPath();
		webRootPath = webRootPath.substring(0, webRootPath.indexOf("/WEB-INF")).replaceAll("file:", "");
		return formatFilePath(webRootPath);
	}
	
	public static String formatFilePath( String filePath ) {
		if( StringUtils.isNotBlank(filePath) ) {
			filePath = filePath.replaceAll("\\\\", "/");
			return filePath.replaceAll("/{2,}", "/");
		}
		return "";
	}
	
	public static boolean createFile( String filePath ) {
		if( StringUtils.isNotBlank(filePath) ) {
			File file = new File(filePath);
			if( file.exists() ) {
				return true;
			}
			if( !file.getParentFile().exists() ) {
				file.getParentFile().mkdirs();
			}
			try {
				return file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}
	
	public static boolean createDir( String dirPath ) {
		if( StringUtils.isNotBlank(dirPath) ) {
			File file = new File(dirPath);
			if( file.exists() && file.isDirectory() ) {
				return true;
			}
			return file.mkdirs();
		}
		return false;
	}

	/**
	 * 验证文件名是否合法
	 * 文件名只能输入【汉子/英文大小写字母/数字/下划线】
	 * @param fileName 需要验证的文件名
	 * @return true:验证通过； false:验证未通过
     */
	public static boolean validFileName( String fileName ) {
		String reg = "^[\\u4e00-\\u9fa5\\da-zA-Z_]+[\\.a-zA-Z]*$";
		Pattern pattern = Pattern.compile(reg);
		java.util.regex.Matcher matcher = pattern.matcher(fileName);
		return matcher.matches();
	}

	public static void main(String[] args) {
		String[] files = new String[3];
		files[0] = "ssss_00001";
		files[1] = "ssss_00002";
		files[2] = "ssss_00003";
		String str = StringUtils.join(files,",");
		System.out.println(str);
	}

}
