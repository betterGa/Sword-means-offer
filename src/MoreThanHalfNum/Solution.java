package MoreThanHalfNum;

import java.util.Arrays;

/**数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
 * 如果不存在则输出0。
 */

//参考了评论的思路。
    //本题的突破口在于要找的是“数字出现的次数超过数组长度的一半”。

    //第一种解法：阵地攻守思想。
    //从数组第一个元素开始，它是“哨兵”，
// 先将它的count置为1，向后遍历，
// 如果遇到值相同的，认为是“友军”，就给count+1.
// 否则，认为是“敌军”，给count-1；
    //如果count=0,就说明这两个相邻元素不相等，这个哨兵不合格，
// 给当前新的这个元素的count重新置为1，它变成新的哨兵。
    //然后重复判断，最后阵地如果还有哨兵，即count大于0.
// 那么它就是“数字出现的次数超过数组长度的一半”。
    //比如：{1.2.1.4.1.6.1} ,length为7，但是不见得符合条件的"1"有相邻的，
// 开始1是哨兵，然后2是哨兵，1又是哨兵，......到最后1还是哨兵；
    //而如果是{1,2,1,4,1,6,2}最后的"2"还会是哨兵，但它其实是不符合条件的，
    //所以判断出有哨兵以后，还是需要验证一下该哨兵在数组中出现的次数的。
    //再有，比如{1,2,2,2,3}开始哨兵是"1",然后是"2",2的count=1，2，3，2,大于0呢，
    //那么"2"就是哨兵，验证一下即可。

    //主要是【数字出现的次数超过数组长度的一半】，
// 那么这个数字出现的次数一定是超过其他数字的，
//对于给定数组，每次给不同的数字配对，

    //（所以每次开始count=1,遇到不同的就-1，变为0，这时就意味着找到了一对不同的
// 需要找下一对不同的，所以需要给下一个元素置为1，重复操作......
// 而遇到相同的时给count++,因为相同的不必配对，直到后续遇到不同的再count--
// 实现不同的元素的配对，最后count>0，也就是剩下了相同的。）

    //那么如果本来存在这样的数字，配对后有剩下的，就一定是这个那个数字，
    //（因为它的次数要比其他的多嘛）
    //如果本来不存在这样的数字，也可能剩下的（当数组长度为偶数时），
// 那这个数字只是落单而已，不符合条件的。
// 所以哨兵思想最后需要验证那个剩下的数字是否符合条件。
    //而如果数组长度是偶数，存在符合条件的数，
//给不同数字配对后剩下的应当是相同的两个数，那个count自然是大于0的
    //如果不存在符合条件的数，count会是0；

    //这个count真是巧的很。

    /*

public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        //sentry暂存当前哨兵
int sentry=array[0];
int count=1;
int i=0;
while (i+1<array.length)
{ if(count==0) {sentry=array[i];count=1;i++;}

    if(i+1<array.length&&sentry==array[i+1])
    {
        count++;
        i++;
    }
    else {
        if(i+1>=array.length)
        {
            break;
        }
        else
        count--;
    i++;}
}

if(count>0)
{
    int verify=0;
    for(int j=0;j<array.length;j++)
    {if(array[j]==sentry) verify++;}
if(verify>array.length/2) return sentry;
    else return 0;
}

else return 0;
    }
}*/
//已通过，运行时间：24ms
//占用内存：9336k


//第二种解法：利用sort排序，由【数字出现的次数超过数组长度的一半】可知
//如果该数组中存在这样的数字，那么它一定会在排序后的数组的最中间的位置，
//检查那个位置数字出现的次数即可
public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {

        Arrays.sort(array);
        int verify=array[array.length/2];
        int count=0;
        for(int i=0;i<array.length;i++)
        {
            if(array[i]==verify)
            {count++;}
        }
        if(count>array.length/2) return verify;
        else return 0;
    }
}

//已通过，运行时间：22ms
//占用内存：9468k
