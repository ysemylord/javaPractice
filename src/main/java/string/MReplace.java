package string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MReplace {
    public static void main(String[] args) {
        //replceAllDemo();
        appendReplaceDemo();
    }

    private static void appendReplaceDemo() {
        String input="fsf 12sfdsdrfsere";
        Matcher matcher= Pattern.compile("[1-9]").matcher(input);
        StringBuffer stringBuffer=new StringBuffer();
        while(matcher.find()){
            //将替换位置处及之前位置处的字符复制到StringBuffer中；
            matcher.appendReplacement(stringBuffer,"digit"+matcher.group()+" ");
            System.out.println(stringBuffer);
        }
        matcher.appendTail(stringBuffer);//将替换位置之后的字符复制到StringBuffer
        System.out.println(stringBuffer);
    }

    private static void replceAllDemo() {
        String input="12sfdsdrfsere";
        Matcher matcher= Pattern.compile("[1-9]").matcher(input);
        String newInput=null;
        while(matcher.find()){
            newInput=matcher.replaceAll("digit ");
        }
        System.out.println(newInput);
    }
}
