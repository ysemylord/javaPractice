package others;

public class IntegerDemo {
    public static void main(String[] args) {

        //将整数转化为16进制形式的字符串
        int num = 13;
        String hexStr = Integer.toHexString(num);
        System.out.println("0x" + hexStr);


        //将16进制形式的字符串解析为整数
        String hex="d";
        int res=Integer.parseInt(hex,16);
        System.out.println(res);
    }
}
