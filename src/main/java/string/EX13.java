package string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EX13 {
    private static class Display {
        private boolean regexPrinted = false;
        private String regex;
        Display(String regex) { this.regex = regex; }
        void display(String message) {
            if(!regexPrinted) {
                print(regex);
                regexPrinted = true;
            }
            print(message);
        }
    }
    static void examine(String s, String regex) {
        Display d = new Display(regex);
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(s);
        while(m.find())
            d.display("find() '" + m.group() +
                    "' start = "+ m.start() + " end = " + m.end());
        if(m.lookingAt()) // No reset() necessary
            d.display("lookingAt() start = "
                    + m.start() + " end = " + m.end());
        if(m.matches()) // No reset() necessary
            d.display("matches() start = "
                    + m.start() + " end = " + m.end());
    }
    public static void main(String[] args) {
        String POEM = "Twas brillig, and the slithy toves\n" +
                "Did gyre and gimble in the wabe.\n" +
                "All mimsy were the were borogoves,\n";
        String[] regs=new String[]{"Twas","Did gyre and gimble in the wabe.","were"};
        String[] poem=POEM.split("\\n");
        for (String input : poem) {
            for (String reg:regs) {
                examine(input,reg);
            }
        }
    }

    static void print(String msg){
        System.out.println(msg);

    }
}
