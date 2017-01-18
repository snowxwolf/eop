package com.xwolf.eop.test.core;

import com.xwolf.eop.common.util.UUIDUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * <p>
 * </p>
 *
 * @author xwolf
 * @date 2017-01-14 11:37
 * @since V1.0.0
 */
public class hash {

    @Test
    public void testMap(){
        Map<String,Object> map=new HashMap<>();
        map.put("23",null);
        map.put("1",23);
        map.put("2",10);
        System.out.println(map);
        Set<String> keys=map.keySet();
        for(String key:keys){
            System.out.println(key+","+map.get(key));
        }
        Set<Map.Entry<String,Object>> entries=map.entrySet();
        for (Map.Entry<String,Object> entry:entries){
            System.out.println(entry.getKey()+","+entry.getValue());
        }
    }
    public static void main(String[] args) {

        String a= "true";
        int hash=a.hashCode();
        System.out.println(hash);
        System.out.println(hash%1024);


    }
}
