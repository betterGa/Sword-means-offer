package reOrderArray;
//输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
// 使得所有的奇数位于数组的前半部分，
        //所有的偶数位于数组的后半部分，
// 并保证奇数和奇数，偶数和偶数之间的相对位置不变。


/**
//思路：新建一个数组，先把奇数位/2 按顺序放在新的位置，如"0"放在新的"0",
//"2"放在新的"1","4"放在新的"2"，完了把偶数位放入
public class Solution {
    public void reOrderArray(int [] array) {
if(array==null) return;
        int []result=new int[array.length];
int j=0;
for(int i=0;i<array.length;i++)
{//奇数位
    if(i%2==0)
    {j=i/2;
        result[j]=array[i];}
}
int k=1;
while (k<array.length-1) {
    result[j + 1] = array[k];
j++;k++;
}
for(int i=0;i<array.length;i++)
{array[i]=result[i];}
    }
}
*/

//审题审错了。
//人家那是   奇数放前面，偶数放后面，而不是奇数位，偶数位🙅‍。

    //重来，思路是开辟两个数组，一个放奇数，一个放偶数，
// 最后将这两个数组合并替换array即可。
    //通过。

public class Solution {
    public void reOrderArray(int [] array) {
        int[] result=new int[array.length];
        int[] result1=new int[array.length];
        int[] result2=new int[array.length];
        int oddNum=0;
        int j=0;
        int k=0;
        for(int i=0;i<array.length;i++) {//奇数先入
            if (array[i] % 2 == 1) {
                result1[j] = array[i];
                j++;
                oddNum++;
            } else {
                result2[k] = array[i];
                k++;
            }}
        for (int m = 0; m < array.length; m++) {
            if (m < oddNum)
                array[m] = result1[m];
            else {
                array[m] = result2[m - oddNum];
            }

        }
    }}