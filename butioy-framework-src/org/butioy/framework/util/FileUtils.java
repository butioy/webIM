package org.butioy.framework.util;

import java.io.File;
import java.io.IOException;

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
	
}
