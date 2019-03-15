package string;

import util.TextFile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EX17_REG_annotation {
    public static void main(String[] args) {
        //开启dotall模式 .才能表示行终结符，才能匹配
        /**
         *这种注释
         */
        String reg="(?m)(?s)//(.*?)$|/\\*(.*?)\\*/";
        String fileName="/Users/xuyabo/Documents/java/thinkingInJavaPractice/src/main/java/string/EX16_JGrep_dir.java";
        String inputString=TextFile.read(fileName);
        Matcher matcher= Pattern.compile(reg).matcher(inputString);
        while(matcher.find()){
            String group1=matcher.group(1);
            String group2=matcher.group(2);
            System.out.println(group1!=null?group1:group2);
        }

    }
}
