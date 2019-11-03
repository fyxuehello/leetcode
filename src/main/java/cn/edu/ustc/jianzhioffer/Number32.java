package cn.edu.ustc.jianzhioffer;


import cn.edu.ustc.leetcode.util.RandomListNode;

import java.util.ArrayList;
import java.util.Collections;

/*
输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
*/

public class Number32 {
    public String PrintMinNumber(int[] numbers) {
        int len = numbers.length;
        String s = "";
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            list.add(numbers[i]);
        }
        Collections.sort(list, (Integer o1, Integer o2) -> (o1 + "" + o2).compareTo(o2 + "" + o1));
        for (Integer i : list) {
            s += i;
        }
        return s;
    }
}
