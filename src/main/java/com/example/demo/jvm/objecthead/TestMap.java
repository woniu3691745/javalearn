package com.example.demo.jvm.objecthead;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lidongliang
 * create at: 2020/11/23  下午3:44
 */
public class TestMap {

    public static void main(String[] args) {
        Map m = new HashMap();
        m.put("1", 1);
        m.put("1", 2);
        System.out.println(m.get("1"));






    }
}
