package com.wzg.hello.utils.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ClassName ProcessUtil
 * @Description 进程工具类
 * @Author wzg
 * Date 2020/11/11 14:54
 * Version 1.0
 */
public class ProcessUtil {

    /**
     * 关闭进程
     * @param taskNamne
     * @return
     */
    public static boolean kill(String taskNamne) {
        boolean flag;
        synchronized (ProcessUtil.class) {
            try {
                String batStr = "taskkill /f /im " + taskNamne;
                Runtime.getRuntime().exec(batStr);
                flag = true;
            } catch (IOException e) {
                flag = false;
            }
        }
        return flag;
    }

    /**
     * 运行进程
     * @return
     */
    public static boolean run(String taskNamne) {
        boolean flag;
        synchronized (ProcessUtil.class) {
            try {
                Runtime.getRuntime().exec(taskNamne);
                flag = true;
            } catch (IOException e) {
                flag = false;
            }
        }
        return flag;
    }

    public static boolean runExe(String exeUrl) {
        boolean flag = false;
        synchronized (ProcessUtil.class) {
            try {
                Runtime.getRuntime().exec(exeUrl);
                flag = true;
            } catch (IOException e) {
                flag = false;
            }
        }
        return flag;
    }

    /**
     * 运行bat文件，以及设置重试次数
     * @param batUrl
     * @param reNum
     * @return
     */
    public static boolean runBat(String batUrl, int reNum) {
        if (reNum < 1) {
            return false;
        }
        boolean flag = false;
        synchronized (ProcessUtil.class) {
            int i = -1;
            while (++i<reNum && !flag) {
                try {
                    Runtime.getRuntime().exec(batUrl);
                    flag = true;
                } catch (IOException e) {
                    flag = false;
                }
            }
        }
        return flag;
    }

    /**
     * 运行bat文件
     * @param batUrl
     * @return
     */
    public static boolean runBat(String batUrl) {
        return runBat(batUrl, 1);
    }

    /**
     * 判断线程是否在运行
     * @param processName
     * @return
     */
    public static boolean isRunning(String processName) {
        BufferedReader bufferedReader = null;
        synchronized (ProcessUtil.class) {
            try {
                Process process = Runtime.getRuntime().exec("tasklist /FI \"IMAGENAME eq " + processName + "\"");
                bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String line = null;
                while ((line = bufferedReader.readLine()) != null) {
                    if (line.contains(processName)) {
                        return true;
                    }
                }
                return false;
            } catch (IOException e) {
                return false;
            } finally {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e) {
                    }
                }
            }
        }
    }
}
