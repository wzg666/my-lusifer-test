package utils;

import com.wzg.hello.utils.utils.ProcessUtil;

/**
 * @ClassName ProcessUtilTest
 * @Description TODO
 * @Author wzg
 * Date 2020/11/11 15:10
 * Version 1.0
 */
public class ProcessUtilTest {
//    public static void main(String[] args) {
//        String httpJarUrl = "F:\\包\\b_interference_api_a\\jar\\6.0.7\\b_interference_api-v6.0.7.jar";
//        String httpBatUrl = "F:\\包\\b_interference_api_a\\jar\\6.0.7\\runhttp.bat";
//        String taskName = "b_interference_api-v6.0.7";
//        System.out.println(ProcessUtil.runBat(httpBatUrl));
//        System.out.println(ProcessUtil.isRunning("java.exe"));
//    }

    public static void main(String[] args) {
        String exeUrl = "F:\\包\\bgan\\bgan_attack1.7.9.35\\BganAttack.exe";
        System.out.println(ProcessUtil.runExe(exeUrl));
    }
}
