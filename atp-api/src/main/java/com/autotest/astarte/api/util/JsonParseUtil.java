package com.autotest.astarte.api.util;

import java.util.HashMap;
import java.util.Map;

public class JsonParseUtil {

    public static String get(){
        Map map = new HashMap();
        map.put("1","a");
        map.put("2","b");
        String f = "AAAA";
        for(Object k : map.values()){
            if(k.equals("a")){
                return k.toString();
            }
        }
        return f;
    }
    public static void main(String[] args) {
        System.out.println(get());
    }
}
