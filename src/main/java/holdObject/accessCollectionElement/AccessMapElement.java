package holdObject.accessCollectionElement;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AccessMapElement {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("ZhuXun", "are very handsome");
        map.put("Kobe", "are very storng");
        map.put("Jack Ma", "are very clever and rich");
        map.put("Andy Lau", "are very man and charismatic");

        //通过Entry的set结合遍历
        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        for (Map.Entry<String, String> entry : entrySet) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            System.out.println(key+":"+map.get(key));
        }
    }
}
