package ltd.syskaoqin.springboot.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Teears
 * @version 1.0.0
 * @ClassName ListAndMapConvert
 * @Description TODO
 * @createTime 2021年03月20日20:10
 */
public class ListAndMapConvert {

    public static Map<String,Integer> convertRecord(List<Map<String,Integer>> list){
        Map<String,Integer> map = new HashMap<>();
        for(Map<String,Integer> m:list){
            map.put(String.valueOf(m.get("key")),m.get("value"));
        }
        return map;
    }
}
