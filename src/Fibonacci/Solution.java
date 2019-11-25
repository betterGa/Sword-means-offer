package Fibonacci;

//大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
//n<=39

import java.lang.reflect.Field;
import java.util.ArrayList;

//方法一：动态规划
/*
public class Solution {
   static int[] fobonacci=new int[39];
    public int Fibonacci(int n) {
        fobonacci[0]=1;
        fobonacci[1]=1;
        for(int i=2;i<=n;i++)
        {
            fobonacci[i]=fobonacci[i-1]+fobonacci[i-2];

        }
        return fobonacci[n];

    }
}
*/

//方法二：递归
public class Solution {
    public int Fibonacci(int n) {
if (n==0) return 0;
if(n==1) return 1;
else return Fibonacci(n-1)+Fibonacci(n-2);
    }
}

