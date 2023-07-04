package com.system.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

public class FlagUtil {

    //返回成功
    public static String getSuccess(Map m) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Map map = new HashMap();
        map.put("flag",true);
        if(m != null){
            map.putAll(m);
        }
        String s = objectMapper.writeValueAsString(map);
        return s;
    }

    //返回失败
    public static String getFail(Map m) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Map map = new HashMap();
        map.put("flag",false);
        if(m != null){
            map.putAll(m);
        }
        String s = objectMapper.writeValueAsString(map);
        return s;
    }
}
