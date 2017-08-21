package com.company.week01;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class testHashCode {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>(6, 1f);

        System.out.println(map.size());

        map.put("aaa", "aaa1");
        map.put("bbb", "bbb2");
        map.put("ccc", "qwew");

        Iterator<Map.Entry<String, String>> entry = map.entrySet().iterator();

        while (entry.hasNext()) {
            Map.Entry<String, String> e = entry.next();
            e.getValue();
            e.getKey();

            System.out.println(e.hashCode());
        }

        System.out.println(map.hashCode());

        Set<String> asc = map.keySet();
        System.out.println(map.entrySet());
        System.out.println(asc);

    }
}
