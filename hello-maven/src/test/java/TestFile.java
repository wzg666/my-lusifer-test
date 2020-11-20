import com.wzg.hello.maven.servlet.utils.FileUtil;

/**
 * @ClassName TestFile
 * @Description TODO
 * @Author wzg
 * Date 2020/11/7 3:17
 * Version 1.0
 */
public class TestFile {
    public static void main(String[] args) {
        FileUtil.deleteAllFile("F:\\wzg\\worksapce_file\\match\\DataCenter");
        FileUtil.copyFolder("F:\\wzg\\worksapce_file\\match\\DataCenter1", "F:\\wzg\\worksapce_file\\match\\DataCenter");
        FileUtil.deleteAllFile("F:\\wzg\\worksapce_file\\match\\match_code_log\\log");
    }
}
