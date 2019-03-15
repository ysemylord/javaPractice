package string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EX9_Pattern2 {
    public static void main(String[] args) {
        String sentence1="I am a good boy";

        Pattern pattern=Pattern.compile("[aeiouAEIOU]");
        Matcher matcher=pattern.matcher(sentence1);
        String res=matcher.replaceAll("_");
        System.out.println(res);


    }
}
