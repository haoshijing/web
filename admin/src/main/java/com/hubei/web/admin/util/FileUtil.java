package com.hubei.web.admin.util;

import java.io.File;
import java.io.FileOutputStream;

/**
 * @author haoshijing
 * @version 2018年03月16日 11:34
 **/
public final class FileUtil {
    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath+File.separatorChar+fileName);
        out.write(file);
        out.flush();
        out.close();
    }
}
