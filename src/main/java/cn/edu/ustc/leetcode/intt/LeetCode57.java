package cn.edu.ustc.leetcode.intt;

import java.util.ArrayList;
import java.util.List;

/*
题目：
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
思路：

*/
public class LeetCode57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res=new ArrayList<>();
        //首先把intervals[i][1]小于newInterval[0]的区间添加进去
        int i=0;
        while(i<intervals.length&&intervals[i][1]<newInterval[0]){
            res.add(intervals[i]);
            i++;
        }
        //把intervals后面和newInterval重合的区间合并
        while(i<intervals.length&&intervals[i][0]<=newInterval[1]){
            newInterval[0]=Math.min(newInterval[0],intervals[i][0]);
            newInterval[1]=Math.max(newInterval[1],newInterval[1]);
            i++;
        }
        res.add(newInterval);
        //把intervals后面剩下的添加进来
        while(i<intervals.length){
            res.add(intervals[i]);
            i++;
        }
        return res.toArray(new int[res.size()][]);
    }
}
