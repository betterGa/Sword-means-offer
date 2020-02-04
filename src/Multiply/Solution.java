package Multiply;

//给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
// 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
// 不能使用除法。

//思路：除了A[i]其他元素相乘
import java.util.ArrayList;
public class Solution {
    public int[] multiply(int[] A) {
//思路：挨个算......
        int length=A.length;
        int[]B=new int[length];
        for(int i=0;i<length;i++)
        {
            B[i]=1;
            for(int j=0;j<length;j++)
            {if(j==i) continue;
                B[i]=B[i]*B[j];
            }
        }
    return B;
    }
}