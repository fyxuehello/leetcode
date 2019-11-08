package cn.edu.ustc.jianzhioffer;


/*
请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
输出描述:
如果当前字符流没有存在出现一次的字符，返回#字符。
* */
public class Number52 {
    int[] record=new int[256];
    StringBuilder s=new StringBuilder();
    public void init(int[] record){//将其初始化为0
        for(int i=0;i<256;i++){
            record[i]=0;
        }
    }
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        s.append(ch);
        record[ch]++;
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        String ss=s.toString();
        for(int i=0;i<ss.length();i++){
            if(record[ss.charAt(i)]==1){
                return ss.charAt(i);
            }
        }
        return '#';
    }

}
