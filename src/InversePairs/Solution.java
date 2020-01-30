package InversePairs;

import java.util.Scanner;

//在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
// 输入一个数组,求出这个数组中的逆序对的总数P。
// 并将P对1000000007取模的结果输出。 即输出P%1000000007
//输入
//1,2,3,4,5,6,7,0
//输出
//7

//思路：暴力蛮解
public class Solution {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String[] date=in.nextLine().split(",");
        int length=date.length;
       int[]array=new int[length];
        for(int i=0;i<length;i++)
        {array[i]=Integer.valueOf(date[i]);}
        System.out.println(new Solution().InversePairs(array));
    }

//暴力蛮解：时间复杂度O（n^2）
    //过不了
        public int InversePairs1(int [] array) {
            int P=0;
            for (int left=0;left<array.length;left++)
            {int right=array.length-1;
                while (left<right)
                {
                    if(array[left]>array[right]) {P++;}
                    right--;
                }
            }
       return P%1000000007; }
       //思路：归并

    public int InversePairs(int [] array)
    {
        return divide(array,0,array.length-1);
    }

  //分治
    public int divide(int[] array,int left,int right)
    {
        if(left==right) return 0;
        int mid=(left+right)/2;
        return divide(array,left,mid)+divide(array,mid+1,right)+merge(array,left,right);
    }

    //合并,返回逆序对数
    public  int merge(int[] array,int left,int right)
    {int mid=(left+right)/2;
        int[] copy=new int[right-left+1];
        int tail1=mid;
        int tail2=right;
        int copyindex=copy.length-1;
        int max=0;
        int P=0;
        while (tail1>=left&&tail2>mid)
        {
            if(array[tail1]>array[tail2])
            {max=array[tail1];
            P=P+tail2-mid;
            tail1--;
        }
        else {max=array[tail2];
          tail2--;  }
        copy[copyindex--]=max;
    }

    /*也行
        if(tail1<left) {while (copyindex>=0){copy[copyindex--]=array[tail2--];}}
        else if(tail2==mid) {while (copyindex>=0) copy[copyindex--]=array[tail1--];}
        */
    for (;tail2>mid;tail2--)
    {copy[copyindex--]=array[tail2];}
    for (;tail1>=left;tail1--)
    {copy[copyindex--]=array[tail1];}
        for (int i=0;i<copy.length;i++)
        {array[i+left]=copy[i];}
        return P;}}