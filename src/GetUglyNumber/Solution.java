package GetUglyNumber;
//题目描述
//把只包含质因子2、3和5的数称作丑数（Ugly Number）。
// 例如6、8都是丑数，但14不是，因为它包含质因子7。
// 习惯上我们把1当做是第一个丑数。
// 求按从小到大的顺序的第N个丑数。
public class Solution {

    //思路：动态规划解法试一试
    public int GetUglyNumber_Solution(int index) {
if(index<7) return index;
int uglyNum[]=new int[index];
uglyNum[0]=1;
int i2=0;
int i3=0;
int i5=0;
for(int i=1;i<index;i++)
{
    uglyNum[i]=Math.min(uglyNum[i2]*2,Math.min(uglyNum[i3]*3,uglyNum[i5]*5));
    if(uglyNum[i]==uglyNum[i2]*2) i2++;
    if(uglyNum[i]==uglyNum[i3]*3) i3++;
    if(uglyNum[i]==uglyNum[i5]*5) i5++;
}



        return uglyNum[index-1];
    }
}