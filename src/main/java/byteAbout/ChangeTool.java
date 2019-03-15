package byteAbout;

public class ChangeTool {
    private static final char[] HEX_CHAR = {'0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /**
     * 将二进制数组转化为16进制字符串
     * @param bytes
     * @return
     */
    public static String bytesToHexFun(byte... bytes) {
        char[] buf = new char[bytes.length * 2];
        int index = 0;
        for (byte b : bytes) {
            buf[index++] = HEX_CHAR[b >>> 4 & 0xf];
            buf[index++] = HEX_CHAR[b & 0xf];
        }
        return new String(buf);
    }

    /**
     * 将字节数组转化为整形
     * @param b
     * @return
     * @throws Exception
     */
    public static int byteArrayToInt(byte... b)  {

        byte[] bytes=new byte[]{0x00,0x00,0x00,0x00};
        int index=bytes.length-1;
        for (int i = b.length-1; i >=0; i--) {
            bytes[index--]=b[i];
        }
        return   bytes[3] & 0xFF |
                (bytes[2] & 0xFF) << 8 |
                (bytes[1] & 0xFF) << 16 |
                (bytes[0] & 0xFF) << 24;
    }

    /**
     * 将byte转化为Ascii字符串
     * @return
     */
    public static String byteArrayToAscII(byte... b){
        StringBuilder UIDSB = new StringBuilder();
        for (int i = 0; i < b.length; i++) {
            UIDSB.append((char) b[i]);
        }
        return UIDSB.toString();
    }

    /**
     * 把byte转为字符串的bit
     */
    public static String byteToBit(byte b) {
        return ""
                + (byte) ((b >> 7) & 0x1) + (byte) ((b >> 6) & 0x1)
                + (byte) ((b >> 5) & 0x1) + (byte) ((b >> 4) & 0x1)
                + (byte) ((b >> 3) & 0x1) + (byte) ((b >> 2) & 0x1)
                + (byte) ((b >> 1) & 0x1) + (byte) ((b >> 0) & 0x1);
    }

    /**
     * 将byte转换为一个长度为8的byte数组，数组每个值代表bit
     */
    public static byte[] getBooleanArray(byte b) {
        byte[] array = new byte[8];
        for (int i = 7; i >= 0; i--) {
            array[i] = (byte)(b & 1);
            b = (byte) (b >> 1);
        }
        return array;
    }
}
