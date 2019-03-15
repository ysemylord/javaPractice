package byteAbout;

import java.util.Arrays;

public class ProtocolParseTool {

    private byte[] mDataBytes;
    private String mMessageId;
    private int mLength;
    private byte[] msgBodyBytes;
    private String msgBodyHexStr;

    public ProtocolParseTool(byte[] dataBytes) {
        this.mDataBytes = dataBytes;
        mMessageId = ChangeTool.bytesToHexFun(mDataBytes[0], mDataBytes[1]);
        mLength = ChangeTool.byteArrayToInt(mDataBytes[2], mDataBytes[3]);
        int from = 4;
        int to = from + getMessageLength();
        msgBodyBytes = (Arrays.copyOfRange(mDataBytes, from, to));
        msgBodyHexStr = ChangeTool.bytesToHexFun(Arrays.copyOfRange(mDataBytes, from, to));
    }

    /**
     * 获取消息ID
     *
     * @return
     */
    public String getMessageId() {
        return mMessageId;
    }

    /**
     * 获取消息数据长度
     *
     * @return
     */
    public int getMessageLength() {
        return mLength;

    }

    /**
     * 获取消息的数据实体的16进制字符串形式
     *
     * @return
     */
    public String getMessageBodyToHexStr() {

        return msgBodyHexStr;
    }

    /**
     * 获取消息的数据实体的字节数组形式
     *
     * @return
     */
    public byte[] getMessageBodyToBytes() {
        return msgBodyBytes;
    }

}
