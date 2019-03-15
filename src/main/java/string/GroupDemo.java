package string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ?!的意义
 * http://www.cnblogs.com/wangqiguo/archive/2012/05/08/2486548.html
 */
public class GroupDemo {
    public static void main(String[] args) {
        String POEM = "a Twas brillig, and the slithy toves\n" +
                "Did gyre and gimble in the wabe.\n" +
                "All mimsy were the borogoves,\n" +
                "And the mome raths outgrabe.\n\n" +
                "Beware the Jabberwock, a my son,\n" +
                "The jaws that bite, the claws that catch.\n" +
                "Beware the Jubjub bird, and shun\n" +
                "The frumious Bandersnatch.";
        Pattern pattern = Pattern.compile("\\b((?![A-Z])\\w+)\\b");//不是大写字母开头的单词
        Matcher matcher = pattern.matcher(POEM);
        while (matcher.find()) {
            String word = matcher.group(1);//如果使用group会将单词边界也打印出来
            System.out.println(word+" is at "+matcher.start(1)+"-"+matcher.end(1));
        }
    }
}
