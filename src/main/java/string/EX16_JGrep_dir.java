//: strings/JGrep.java
package string; /* Added by Eclipse.py */
// A very simple version of the "grep" program.
// {Args: JGrep.java "\\b[Ssct]\\w+"}

/**
 * 注释
 * 注释
 */

import util.TextFile;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EX16_JGrep_dir {
  public static void main(String[] args) throws Exception {
    if(args.length < 2) {
      System.out.println("Usage: java JGrep file regex");
      System.exit(0);
    }
    Pattern p = Pattern.compile(args[1]);
    // Iterate through the lines of the input file:
    int index = 0;
    Matcher m = p.matcher("");//hahaah
    String fileName = args[0];
    File file=new File(fileName);
    if(file.isDirectory()) {
      File[] files=file.listFiles();
      for (File fileElement : files) {
        matchFile(index,m,fileElement.getAbsolutePath());
      }
    }else{
      matchFile(index, m, fileName);
    }
  }

  private static void matchFile(int index, Matcher m, String fileName) {
    for (String line : new TextFile(fileName)) {
      m.reset(line);
      while (m.find())
        System.out.println(index++ + ": " +
                m.group() + ": " + m.start());
    }
  }
}
