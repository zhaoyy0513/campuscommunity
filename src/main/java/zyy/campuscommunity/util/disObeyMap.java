package zyy.campuscommunity.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Zled
 * @date 2019/5/28 20:19
 */
public class disObeyMap {

    public static String getTypeByDisObeyNum(int disObeyNum) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "暴恐违禁");
        map.put(2, "文本色情");
        map.put(3, "政治敏感");
        map.put(4, "恶意推广");
        map.put(5, "低俗辱骂");
        map.put(6, "低质灌水");
        if (map.containsKey(disObeyNum)) {
            //如果包含该键，则得到相应的值
            return map.get(disObeyNum);
        }
        return "error";
    }
}
