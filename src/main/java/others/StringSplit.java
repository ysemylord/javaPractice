package others;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class StringSplit {
    public static void main(String[] args) {
        String str = "" +
                "address_id:" +
                "user_id: " +
                "consignee:" +
                "mobile：" +
                "province  ：" +
                "city:  " +
                "district：" +
                "property：" +
                "street： " +
                "addition_info：" +
                "latitude：" +
                "longitude：" +
                "tag_id  :" +
                "tag_name   :" +
                "is_default：" +
                "";
        String[] strings = str.split(":|：");
        JsonObject jsonObject=new JsonObject();
        for (String string : strings) {
            string=string.replace(" ","");
                System.out.println(string);

        }
    }


}
