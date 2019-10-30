package cn.edu.ustc.jianzhioffer;

import java.util.ArrayList;
import java.util.Stack;

/*
定义栈的数据结构，
请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
*/
public class Number20 {
    Stack<Integer> stack=new Stack<>();
    int min=Integer.MAX_VALUE;
    public void push(int node) {
        if(node<=min){
            stack.push(min);
            min=node;
        }
        stack.push(node);
    }

    public void pop() {
        if(min==stack.pop())
            min=stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return min;
    }
}
