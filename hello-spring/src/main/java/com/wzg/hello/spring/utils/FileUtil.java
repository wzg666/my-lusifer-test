package com.wzg.hello.spring.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

/**
 * @ClassName FileUtil
 * @Description TODO
 * @Author wzg
 * Date 2020/11/6 10:42
 * Version 1.0
 */
public class FileUtil {
    /**
     * 判断文件存在
     * @param path
     * @return
     */
    public static boolean fileExit(String path) {
        //根据指定的文件名创建File对象
        File file = new File(path);
        //要删除的文件存在且是文件
        if (file.exists() && file.isFile()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断文件不存在
     * @param path
     * @return
     */
    public static boolean fileNotExit(String path) {
        return !fileExit(path);
    }

    /**
     * 删除文件
     * @param path
     */
    public static void deleteFile(String path) {
        deleteFile(new File(path));
    }

    /**
     * 删除文件
     * @param file
     */
    public static void deleteFile(File file) {
        if (file.exists() && file.isFile()) {
            file.delete();
        }
        if (file.exists() && file.isDirectory() && (file.listFiles() == null || file.listFiles().length == 0)) {
            file.delete();
        }
    }

    /**
     * 获取所有的文件
     * @param folderPath
     * @param allFiles
     * @return
     */
    public static List<String> getAllFilesName(File folderPath, List<String> allFiles) {
        if (folderPath.isFile()) {
            allFiles.add(folderPath.getPath());
            return allFiles;
        }
        File[] files = folderPath.listFiles();
        if (files == null) {
            return allFiles;
        }
        for (File f : files) {
            if (f.isDirectory()) {
                getAllFiles(f, allFiles);
            } else {
                allFiles.add(f.getName());
            }
        }
        return allFiles;
    }

    /**
     * 获取所有的文件
     * @param folderPath
     * @param allFiles
     * @return
     */
    public static List<String> getAllFiles(File folderPath, List<String> allFiles) {
        if (folderPath.isFile()) {
            allFiles.add(folderPath.getPath());
            return allFiles;
        }
        File[] files = folderPath.listFiles();
        if (files == null) {
            return allFiles;
        }
        for (File f : files) {
            if (f.isDirectory()) {
                getAllFiles(f, allFiles);
            } else {
                allFiles.add(f.getPath());
            }
        }
        return allFiles;
    }

    /**
     * 获取所有的文件夹
     * @param folderPath
     * @param allFiles
     * @return
     */
    public static List<String> getAllFolders(File folderPath, List<String> allFiles) {
        File[] files = folderPath.listFiles();
        if (files == null) {
            return allFiles;
        }
        for (File f : files) {
            if (f.isDirectory()) {
                allFiles.add(f.getPath());
                getAllFolders(f, allFiles);
            }
        }
        return allFiles;
    }

    /**
     * 分类获取所有的文件和文件夹
     * @param path
     * @return
     */
    public static Map<String, List<String>> getAllFiles(String path) {
        Map<String, List<String>> map = new HashMap<>();
        List<String> files = new ArrayList<>();
        List<String> folders = new ArrayList<>();
        getAllFiles(new File(path), files);
        getAllFolders(new File(path), folders);
        map.put("file", files);
        map.put("folder", folders);
        return map;
    }

    /**
     * 删除该路径下所有文件
     * @param path
     */
    public static void deleteAllFile(String path) {
        Map<String, List<String>> map = getAllFiles(path);
        map.get("file").stream().forEach(str -> {
            deleteFile(str);
        });
        Collections.reverse(map.get("folder"));
        map.get("folder").stream().forEach(str -> {
            deleteFile(str);
        });
        deleteFile(path);
    }

    /**
     * 创建文件夹
     * @param path
     */
    public static void createFolder(String path) {
        if (path != null) {
            String[] paths = path.split("\\\\");
            if (paths == null || paths.length == 0) {
                paths = path.split("/");
            }
            StringBuffer sb = new StringBuffer("");
            Arrays.stream(paths).forEach(str -> {
                sb.append(str).append("\\");
                if (!fileExit(sb.toString())) {
                    File file = new File(sb.toString());
                    file.mkdir();
                }
            });
        }
    }

    /**
     * 复制单个文件
     * @param srcFilePathStr
     * @param desPathStr
     */
    public static void copyFile(String srcFilePathStr, String desPathStr) {
        try {
            //创建输入流对象
            FileInputStream fis = new FileInputStream(srcFilePathStr);

            //创建输出流对象
            FileOutputStream fos = new FileOutputStream(desPathStr);

            //创建搬运工具
            byte datas[] = new byte[1024 * 8];
            //创建长度
            int len = 0;
            //循环读取数据
            while ((len = fis.read(datas)) != -1) {
                fos.write(datas, 0, len);
            }
            fis.close();
            fos.close();
        } catch (Exception e) {
            System.out.println("have a error in copy file :" + srcFilePathStr);
        }
    }

    /**
     * 将一个目录下的文件复制到另外一个目录
     * @param source
     * @param target
     */
    public static void copyFolder(String source, String target) {
        List<String> sourceFiles = new ArrayList<>();
        getAllFiles(new File(source) , sourceFiles);
        List<String> sourceFolders = new ArrayList<>();
        getAllFolders(new File(source), sourceFolders);
        //创建目录
        sourceFolders.stream().forEach(str -> {
            createFolder(str.replace(source, target));
        });
        //移动文件
        sourceFiles.stream().forEach(str -> {
            copyFile(str, str.replace(source, target));
        });
    }

    /**
     * TODO
     * @param path
     * @param type
     */
    public static void clearFile(String path, String type) {
        if (path == null || !path.endsWith("."+type)) {
            return;
        }
        deleteFile(path);
        File file = new File(path);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
