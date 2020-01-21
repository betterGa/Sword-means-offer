package GetNumberOfK;
public class Solution {
    //统计一个数字在排序数组中出现的次数。
    public int GetNumberOfK1(int [] array , int k) {
//思路1：先得找个这个数字，已经是有序数组，可以用折半查找法
        //需要找到这个数字第一次出现的下标
        int left=0;
        int right=array.length-1;
        int mid=(left+right)/2;
        while (left!=right)
        {  mid=(left+right)/2;
            if(k>array[mid])left=mid+1;
      else   if(k<array[mid]) right=mid-1;
      //因为有重复元素，所以需要去左边找以确定第一次出现的下标
       else right=mid;}
       int time=0;
     for(int i=left;i<array.length;i++)
     {if(array[i]==k)
    time++;
     }
      return time;
        }
//思路2：找到<k-0.5的数的位置和>k+0.5的数的位置即可
    public int GetNumberOfK(int [] array , int k) {
        {if(array==null||array.length==0) return k;
            int left=-1;
            for(int i=array.length-1;i>=0;i--)
            {
                if(array[i]<k-0.5) {left=i;break;}
            }
            int right=array.length;
            for(int i=0;i<array.length;i++)
            {
                if(array[i]>k+0.5) {right=i;break;}
            }
            return right-left-1;
        }
    }}




}