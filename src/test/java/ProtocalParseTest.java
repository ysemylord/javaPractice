import byteAbout.ChangeTool;
import byteAbout.ProtocolParseTool;
import net.mindview.atunit.Test;

import java.util.Arrays;

public class ProtocalParseTest {

    /**
     * 解析心跳包
     */
    @org.junit.Test
    public  void parseJumpBytes() throws Exception {
        byte[] bytes = new byte[]{(byte) 0x90, 0x09,
                0x00, 0x02,
                0x43, 0x0D};

        ProtocolParseTool protocolParseTool=new ProtocolParseTool(bytes);
        System.out.println("消息ID " + protocolParseTool.getMessageId());
        int messageLength = protocolParseTool.getMessageLength();
        System.out.println("消息长度 " + messageLength);
        System.out.println("数据实体 " + protocolParseTool.getMessageBodyToHexStr());
    }

    /**
     * 解析实时数据
     */
    @org.junit.Test
    public  void parseRealTimeData() throws Exception {
        byte[] bytes = new byte[]{
                (byte) 0x90, 0x10,//消息ID
                0x00, (byte) 0x04,//消息长度
                0x00, 0x04,//楼层
                (byte) 0xff,
                0x44
        };
        ProtocolParseTool protocolParseTool=new ProtocolParseTool(bytes);

        String messageId = protocolParseTool.getMessageId();
        System.out.println("消息ID: " + messageId);

        int messageLength = protocolParseTool.getMessageLength();
        System.out.println("消息长度: " + messageLength);

        byte[] msgBytes = protocolParseTool.getMessageBodyToBytes();

        System.out.println("楼层: "+ ChangeTool.byteArrayToInt(msgBytes[0],msgBytes[1]));

        byte byte1 = msgBytes[2];
        String runStateStr1= ChangeTool.byteToBit(byte1);
        System.out.println("runStage :"+runStateStr1);
        System.out.println("运行方向 :"+runStateStr1.substring(0,1));
        System.out.println("方向箭头显示控制 : "+runStateStr1.substring(1,3));
        System.out.println("开关门状态 :"+runStateStr1.substring(4,6));
        System.out.println("开关门状态 2 :"+runStateStr1.substring(6,8));

        byte runState2 = msgBytes[3];
        String runState2Str= ChangeTool.byteToBit(runState2);
        System.out.println("检修状态："+runState2Str.substring(4,5));
        System.out.println("运行状态："+runState2Str.substring(5,6));
        System.out.println("到站信号："+runState2Str.substring(6,7));
    }

    /**
     * 解析音视频对讲
     * @throws Exception
     */
    @org.junit.Test
    public  void parseTackBackData() throws Exception {
        byte[] bytes = new byte[]{
                (byte) 0x90, 0x7f,//消息ID
                0x00, 0x25,//消息长度
                (byte) 0x7f,//服务器ip，第1段
                (byte) 0xff,//服务器ip，第2段
                (byte) 0xff,//服务器ip，第3段
                (byte) 0xff,//服务器ip，第4段
                0x50,//端口
                0x61, 0x62, 0x63, 0x64, 0x65, 0x66, 0x67, 0x68, 0x69, 0x6A,//房间号
                (byte) 0x30, (byte) 0x39,//密码 12345
                0x61, 0x62, 0x63, 0x64, 0x65, 0x66, 0x67, 0x68, 0x69, 0x6A, 0x6B, 0x6C, 0x6D, 0x6E, 0x6F, 0x70, 0x71, 0x72, 0x73, 0x74//签权
        };

        ProtocolParseTool protocolParseTool=new ProtocolParseTool(bytes);

        System.out.println("消息ID " + protocolParseTool.getMessageId());

        int messageLength = protocolParseTool.getMessageLength();
        System.out.println("消息长度 " + messageLength);

        byte[] talkBackMsgBody = protocolParseTool.getMessageBodyToBytes();
        int ip1th = ChangeTool.byteArrayToInt(talkBackMsgBody[0]);
        int ip2th = ChangeTool.byteArrayToInt(talkBackMsgBody[1]);
        int ip3th = ChangeTool.byteArrayToInt(talkBackMsgBody[2]);
        int ip4th = ChangeTool.byteArrayToInt(talkBackMsgBody[3]);
        System.out.println("ip: " + ip1th+","+ip2th+","+ip3th+ip3th);
        System.out.println("端口: " + ChangeTool.byteArrayToInt(talkBackMsgBody[4]));



        System.out.println("房间号:" + ChangeTool.byteArrayToAscII(Arrays.copyOfRange(talkBackMsgBody,5,5+10)));


        int pwd=ChangeTool.byteArrayToInt(talkBackMsgBody[15],talkBackMsgBody[16]);
        System.out.println("密码:"+pwd);



        System.out.println("UID:"+ChangeTool.byteArrayToAscII(Arrays.copyOfRange(talkBackMsgBody,17,17+20)));

    }


    //5.故障事件
    @org.junit.Test
    public  void parseFaultData() throws Exception {
        byte[] bytes = new byte[]{
                (byte) 0x90, 0x13,//消息ID
                0x00, 0x02,//消息长度
                0x00, 0x11
        };
        ProtocolParseTool protocolParseTool=new ProtocolParseTool(bytes);
        System.out.println("消息ID " + protocolParseTool.getMessageId());
        int messageLength = protocolParseTool.getMessageLength();
        System.out.println("消息长度 " + messageLength);
        byte[] talkBackMsgBody = protocolParseTool.getMessageBodyToBytes();
        int defaultCode = ChangeTool.byteArrayToInt(talkBackMsgBody[0],talkBackMsgBody[1]);
        System.out.println("defalutCode: " + defaultCode);
    }

}
