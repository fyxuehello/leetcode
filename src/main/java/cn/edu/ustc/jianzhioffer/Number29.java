package cn.edu.ustc.jianzhioffer;


/*
输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
*/

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Number29 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res=new ArrayList<>();

        if(k>input.length||k==0){
            return res;
        }
        PriorityQueue<Integer> queue=new PriorityQueue<>(k,(Integer o1,Integer o2)->o1.compareTo(o2));
        for(int i=0;i<input.length;i++){
            if(queue.size()!=k){
                queue.add(input[i]);
            }else if(queue.peek()>input[i]){
                queue.poll();
                queue.add(input[i]);
            }
        }
        for(Integer i:queue){
            res.add(i);
        }
        return res;

    }
}
