public class BaseByte {

    /**
     * ASCII码表中
     * 67对应字符C
     * 所以将整型数据67转化为字符后，得到的是字符C（字节型数据同理）
     *
     * @throws Exception
     */
    @org.junit.Test
    public void intToChar() throws Exception {
        byte[] bytes = "ABCD".getBytes();
        for (byte b : bytes) {
            System.out.println(b);
        }

    }

    @org.junit.Test
    public void charToInt() throws Exception {


    }
}
