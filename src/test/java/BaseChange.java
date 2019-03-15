import net.mindview.atunit.Test;

public class BaseChange {

    /**
     *
     * ASCII码表中
     * 67对应字符C
     * 所以将整型数据67转化为字符后，得到的是字符C（字节型数据同理）
     * @throws Exception
     */
    @org.junit.Test
    public void intToChar() throws Exception {
        char char1=67;
        System.out.println(char1);

    }

    @org.junit.Test
    public void charToInt() throws Exception {
        int int1='C';
        System.out.println(int1);


    }
}
