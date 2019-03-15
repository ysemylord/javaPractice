package others;

public class BaseByte {
    public static void main(String[] args) {
        String string="abc";
        byte[] bytes = string.getBytes();
        for(byte b:bytes){
            System.out.print(b+" ");
        }
    }
}
