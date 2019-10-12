package cn.edu.ustc.leetcode.Concurrent;

public interface Computable<A,V> {
    V compute(A arg) throws InterruptedException;
}
