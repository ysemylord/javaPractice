package string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EX10 {
    public static void main(String[] args) {
        String source="Java now has regular expressions";
        String[] regs=new String[]{
                "^Java","\\Breg.*","n.w\\s+h(a|i)s",
                "s?","s*","s+",
                "s{4}","s{1}","s{0,3}"
               };
        for (String reg:regs) {
            Pattern pattern=Pattern.compile(reg);
            Matcher matcher=pattern.matcher(source);
            System.out.println("input :"+reg);
            while(matcher.find()) {
                System.out.println("match " + matcher.group() + " at " +matcher.start()+"-"+matcher.end());
            }

        }
    }
}
