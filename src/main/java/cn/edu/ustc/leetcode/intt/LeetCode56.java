package cn.edu.ustc.leetcode.intt;

import java.util.ArrayList;
import java.util.List;

/*
题目：
Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
思路：

*/
public class LeetCode56 {
    public int[][] merge(int[][] intervals) {
        if(intervals.length<=1)
            return intervals;
        List<int[]> res=new ArrayList<>();
        int[] newInterval=intervals[0];
        res.add(newInterval);
        for(int[] interval:intervals){
            if(newInterval[1]<=interval[0]){
                newInterval[1]=Math.max(newInterval[1],interval[1]);
            }else{
                newInterval=interval;
                res.add(interval);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
