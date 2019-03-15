package string;

import java.util.Scanner;

public class EX20_Scanner {
    public static void main(String[] args) {
        String inputStr="11 111 13.3 12.1 JACK";
        Scanner scanner=new Scanner(inputStr);
        int intt=scanner.nextInt();
        long longg=scanner.nextLong();
        float floatt=scanner.nextFloat();
        double doublee=scanner.nextDouble();
        String string=scanner.next();
    }
}
