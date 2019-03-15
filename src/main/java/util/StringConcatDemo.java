package util;

public class StringConcatDemo {
    public static void main(String[] args) {
        String string = "start";
        for (int i = 0; i < 100; i++) {
            string = string + "hello";
        }
    }
}
