package cn.edu.ustc.jianzhioffer;

/*
题目：
我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */
public class Number10 {
    public int RectCover(int target) {
        if (target <= 2)
            return target;
        int preNum = 2;
        int prepreNum = 1;
        int res = 0;
        for (int i = 3; i <= target; i++) {
            res = preNum + prepreNum;
            prepreNum = preNum;
            preNum = res;
        }
        return res;
    }
}
