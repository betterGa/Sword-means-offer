package duplicate;

import java.util.HashMap;
import java.util.Set;

public class Solution {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,
    // length of duplication array is 1,
    // so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid,
    // and there are some duplications in the array number
    //                     otherwise false


    //在一个长度为n的数组里的所有数字都在0到n-1的范围内。
    // 数组中某些数字是重复的，但不知道有几个数字是重复的。
    // 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
    // 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，
    // 那么对应的输出是第一个重复的数字2。

    //思路：用Map存储
    public boolean duplicate1(int numbers[],int length,int [] duplication) {
        if(numbers==null) return false;
HashMap<Integer,Integer> map=new HashMap<>();
int time=0;
for(int i=0;i<numbers.length;i++)
{
    if(map.get(numbers[i])==null)
    {
        map.put(numbers[i],time+1);

}
else map.put(numbers[i],map.get(numbers[i])+1);
    }
//将map结果中第一个有重复的放在duplication[0]中
        for(int i: map.keySet())
        {
        if((int)map.get(i)>1)
        {duplication[0]=i;
        break;}
        }
        if(duplication[0]!=-1) {return true;}
        else return  false;
    }
 //思路二：利用“长度为n的数组，所有数字都在0到n-1的范围内”的特点
    //遍历数组，如遇到{1，3，2，4，2}，先遍历"1",给[1]的值3减去length 5,
    //[1]就变成了负数-2，
 // 遍历到[1]，这时[1]的值是负数-2，下标不能为负，
 // 需要先给它加length恢复原数即下标index=3，(只是下标恢复，数组[1]的值仍是负数-2)
    //[3]值为4，减去length 5，变为-1
    // 然后遍历到[2] 值是2,给[2]处值减去length，变为-3
    //遍历到[3].值是-1，下标不能为负，
 // 需要先给它加上length，变为4
 // 给[4]的值2减去length变为-3,
    //遍历到[4].值是-3，下标不能为负，加上length恢复为2
 // 这时发现[2]的值是负数，说明是个重复的值，
    //把它+length恢复成数组原值赋给duplicate即可。
 public boolean duplicate(int numbers[],int length,int [] duplication)
{
    if(numbers==null) return false;
    //从前向后遍历保证是第一个出现重复的数字

    for(int i=0;i<numbers.length;i++)
    {
int index=numbers[i];
//如果下标为负，需要恢复成原数
        if(index<0)
        {
        index+=length;
        }

    if(numbers[index]<0)
    {
        duplication[0]=numbers[index]+length;
        return true;
    }
    numbers[index]-=length;
    }

  return false;

}
}