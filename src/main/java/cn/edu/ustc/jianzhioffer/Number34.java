package cn.edu.ustc.jianzhioffer;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;

/*
在一个字符串(0<=字符串长度<=10000，全部由字母组成)
中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
*/

public class Number34 {
    public int FirstNotRepeatingChar(String str) {
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                int time = map.get(str.charAt(i));
                map.put(str.charAt(i), ++time);
            } else {
                map.put(str.charAt(i), 1);
            }
        }
        for (int j = 0; j < str.length(); j++) {
            if (map.get(str.charAt(j)) == 1)
                return j;
        }
        return -1;
    }
}
