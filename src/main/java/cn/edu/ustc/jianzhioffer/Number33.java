package cn.edu.ustc.jianzhioffer;


import java.util.ArrayList;
import java.util.LinkedHashMap;

/*
把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。
 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。*/

public class Number33 {
    public int GetUglyNumber_Solution(int index) {
        if(index<7)
            return index;
        int p2=0,p3=0,p5=0;
        int newNum=1;
        ArrayList<Integer> list=new ArrayList<>();
        list.add(newNum);
        while(list.size()<index){
            newNum=Math.min(list.get(p2)*2,Math.min(list.get(p3)*3,list.get(p5)*5));
            if(list.get(p2)*2==newNum)
                p2++;
            if(list.get(p3)*3==newNum)
                p3++;
            if(list.get(p5)*5==newNum)
                p5++;
            list.add(newNum);
        }
        return newNum;
    }
}
