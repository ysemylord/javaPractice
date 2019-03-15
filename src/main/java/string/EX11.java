package string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EX11 {
    public static void main(String[] args) {
        String reg="(?i)((^[aeiou])|(\\s+[aeiou]))\\w+?[aeiou]\\b";
        String source="Arline ate eight apples and one orange while Anita hand't any";
        Pattern pattern=Pattern.compile(reg);
        Matcher matcher= pattern.matcher(source);
        while(matcher.find()){
            System.out.println("\""+matcher.group()+"\""+" matched at "+matcher.start()+"-"+matcher.end());
        }
    }
}
