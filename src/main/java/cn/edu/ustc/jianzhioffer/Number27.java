package cn.edu.ustc.jianzhioffer;


import cn.edu.ustc.leetcode.util.RandomListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/*
数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，
超过数组长度的一半，因此输出2。如果不存在则输出0。

*/


public class Number27 {
    public int MoreThanHalfNum_Solution(int[] array) {
        if (array == null)
            return 0;
        int num = array[0];
        int count = 1;
        for (int i = 1; i < array.length; i++) {
            if (count == 0) {
                num = array[i];
                count = 1;
            } else if (num == array[i]) {
                count++;
            } else {
                count--;
            }
        }
        int times = 0;
        for (int i = 0; i < array.length; i++) {
            if (num == array[i]) {
                times++;
            }
        }
        return times > (array.length / 2) ? num : 0;
    }
}
