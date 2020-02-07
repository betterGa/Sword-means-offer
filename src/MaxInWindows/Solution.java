package MaxInWindows;

import java.util.ArrayList;

//思路：先求出前size个元素，也就是第1个滑动窗口中的最大值max
//接下来，将第2个滑动窗口中第一个元素也就是[size+1]
// 与第1、2个窗口中不重叠元素[0]比大小：
//若[size+1]>[0],那么第2个窗口的max=[size+1]
//反之 max不变。
//依次求出所有滑动窗口的值

public class Solution {
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> result=new ArrayList<>();
//先求出第一个窗口的max
        int currentmax=num[0];
        for(int i=0;i<size;i++)
        {
            if(num[i]>currentmax)
                currentmax=num[i];
        }
        result.add(currentmax);
        for (int j=size;j<num.length;j++)
        {
            int newMax=EachMax(currentmax,j,j-size,num);
            result.add(newMax);
            currentmax=newMax;
        }

        return result;
    }

    public int EachMax(int curmax,int NewIndex,int other,int[] array)
    {

        if(array[NewIndex]>array[other])
        { if(array[NewIndex]>curmax)
            return array[NewIndex];
        else return curmax;}

        else
        {if(array[other]<curmax)
        {
            return curmax;
        }
            else
        {int max=array[other+1];
            for(int i=0;i<NewIndex-other;i++)
            {
                if(array[i]>max) max=array[i];
            }
        return max;
        }
        }

    }


}