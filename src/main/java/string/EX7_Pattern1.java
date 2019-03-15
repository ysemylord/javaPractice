package string;

import java.util.regex.Pattern;

public class EX7_Pattern1 {
    public static void main(String[] args) {
        String sentence1="fsdjfsdkljf";
        String sentence2="Fsdjfsdkljf";
        String sentence3="Wsdjfsdkljf。";
        String sentence4="sdjfsdkljf。";
        Pattern pattern=Pattern.compile("\\p{Upper}.*。");
        boolean re1=pattern.matcher(sentence1).matches();
        boolean re2=pattern.matcher(sentence2).matches();
        boolean re3=pattern.matcher(sentence3).matches();
        boolean re4=pattern.matcher(sentence4).matches();
        System.out.println(re1);
        System.out.println(re2);
        System.out.println(re3);
        System.out.println(re4);
    }
}
