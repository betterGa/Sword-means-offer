package FindNumsAppearOnce;

//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果

import java.util.Arrays;

//一个整型数组里除了两个数字之外，
// 其他的数字都出现了两次。
//// 请写程序找出这两个只出现一次的数字。
public class Solution {
//思路1：排序，检查相邻不相同的元素即可。
public void FindNumsAppearOnce1(int [] array,int num1[] , int num2[]) {
    Arrays.sort(array);
    int flag=0;
    if(array[array.length-1]!=array[array.length-2])
    {num2[0]=array[array.length-1];}
    for(int i=0;i<array.length-1;i++)
    {
        if(array[i]!=array[i+1])
        {if(flag==0)
        {num1[0]=array[i];
            flag=1;}
        else
            num2[0]=array[i];}
        else i=i+1;
    }}

    //思路2：异或
    //利用位运算异或的特点，位相同为0，不同为1，
    //0与任何数异或会得到数本身
    //对array数组的元素挨个异或，那么相同的数异或会得到0，
    //然后与不同的数异或得到“不同的数”本身，
    // 最后的得到结果就是要找的那两个不同的数异或的结果
    //然后对这个数组中的元素进行分类，取异或结果第一个“1”(从低位数)，就是这两个数第一个不同的位
    //对这一位取“0”和“1”分组，然后对两个组依次异或，分别放到num1[0]和num2[0]即可。
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        {
            int result=0;
        for(int i=0;i<array.length;i++)
        {
result=result^array[i];
        }
        int digits=1;
//找到result第一个“1”(从低位数起)
            while ((result&1)==0)
            {
                result=result>>1;
digits++;
            }
            int[] sort1=new int[array.length];
            int m=0;
            int[] sort2=new int[array.length];
            int n=0;

for(int j=0;j<array.length;j++)
{
   if(Mth(array[j],digits)==0)
        sort1[m++]=array[j];
    else sort2[n++]=array[j];
}
result=0;
for(int i=0;i<m;i++)
{
   result=result^sort1[i];
}
num1[0]=result;
            result=0;
            for(int i=0;i<n;i++)
            {
                result=result^sort2[i];
            }
            num2[0]=result;
        }


    }
    //需要一个取第m位的数字的方法
    public static int Mth(int num,int digit)
    {
        int MthNum=0;
        //对0异或可得本身数,和1&可得最低位
        for(int i=0;i<digit;i++)
        {
            MthNum=(num^0)&1;
            num=num>>1;
        }
        return  MthNum;
    }




}