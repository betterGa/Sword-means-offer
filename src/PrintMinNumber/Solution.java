package PrintMinNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

//输入一个正整数数组，
// 把数组里所有数字拼接起来排成一个数，
// 打印能拼接出的所有数字中最小的一个。
// 例如输入数组{3，32，321}，
// 则打印出这三个数字能排成的最小数字为321323。
public class Solution {
    //思路，给数组排序，从大到小组成结果即可。
    //错了。好像没有规律可循。与排序后最大最小无关

    //改：思路：深度优先搜索
    //求出每种拼接情况的结果，挨个比较
    public String PrintMinNumber(int [] numbers) {
        if(numbers==null||numbers.length==0) return "";
        int[] results=new int[numbers.length];
        ArrayList result=new ArrayList();
        int flag[]=new int[numbers.length];
       putInto(result,flag,numbers,0,results);
     result.sort(new Comparator<Long>() {
         @Override
         public int compare(Long o1,Long o2) {
            if(o1<o2) return -1;
            else if(o1>o2)return 1;
            else return 0;
         }
     });
        return String.valueOf(result.get(0));

    }
    public void putInto(ArrayList result, int[]flag, int[] numbers, int n,int[] results)
    {
        //用于标记数字是否被使用，0表示未被使用。
if(n==numbers.length)
{String resultstr="";
    for(int i=0;i<results.length;i++)
    {resultstr=resultstr+results[i];}
result.add(Long.valueOf(resultstr));
    return;
}
        for(int j=0;j<numbers.length;j++)
        {
            //当数字未被使用时
            if(flag[j]==0)
            {
                results[n]=numbers[j];
                //标志成已被使用
                flag[j]=1;
                putInto(result,flag,numbers,n+1,results);
                //回退以后
                flag[j]=0;
            }
        }

return;

        }



    }
