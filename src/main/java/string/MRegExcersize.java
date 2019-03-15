package string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class MRegExcersize {
    public static void main(String[] args) {
        String source="I am a boy boy boy ";
        String reg="[^a]";
        Pattern pattern= Pattern.compile(reg);
        Matcher matcher= pattern.matcher(source);
        System.out.println(matcher.find());
    }
}
