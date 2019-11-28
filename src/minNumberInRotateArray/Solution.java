package minNumberInRotateArray;
import java.util.ArrayList;
//题目描述
//把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
//输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
//例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
//NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。

//版本一：根据旋转数组的特点，顺序查找，已通过。
//思路：找到第一次出现[大，小]的地方，返回[小]即可
/*
public class Solution {
    public int minNumberInRotateArray(int [] array) {
        if(array==null||array.length==0) return 0;
            if(array.length==1) return array[0];
for(int i=0;i<array.length-1;i++)
{
    if(array[i]>array[i+1]) return array[i+1];
}

 return array[0];

    }
}
*/
//版本二：它想考察的应该是二分查找，优化复杂度
//链接：https://www.nowcoder.com/questionTerminal/9f3231a991af4f55b95579b44b7a01ba?f=discussion&toCommentId=5034367
//来源：牛客网
//
//参考题解中的二分查找，需要考虑旋转数组中前部分有重复元素的情况。
// 运行时间：317ms，占用内存：29096k，
// 首先使head=0,tail=array.length=1.
// 如果 [head] > [tail],如果这时head+1==tail，就是遇到了方法一中的“临界点”，直接返回[tail]即可，
// 如果head+1不等于tail, 说明要找的最小值应当在mid=(head+tail)/2以后，
// （因为head后可能有递增序列，即旋转而从原本数组末尾平移过来的那部分，
// 而tail前应有一段是原本数组开头置后的递增数列，而要寻找的最小值正是开头置后的递增数列的第一个元素。）
// 将head置为mid；如果[head]<[tail],说明卡在head和tail之间的已经是递增数列了,即是递增数列的一部分，
// 要找的应当在0与head之间，（比如head和tail卡住了{4，5，7，9}，而在4之前还有{1,2,3}）将head的值赋给tail,再把0赋给head即可。
// 如果[head]==[tail],需要注意如果元素重复了的情况，比如{3,3,1,3}, 一开始[head]==[tail],
// 要找的最小值应当在head以后，给head++。
import java.util.ArrayList;
public class Solution {
    public int minNumberInRotateArray(int [] array) {
        if(array==null||array.length==0)
        {return 0;}
        if(array.length==1) return array[0];
        int head=0;
        int tail=array.length-1;

        while (head!=tail)
        {
            int mid=(head+tail)/2;
            if(array[head]>array[tail])
            {
                if(head+1==tail) return array [tail];
                else  head=mid;
            }
            else if(array[head]<array[tail])
            {tail=head;
                head=0;}
            else head++;
        }
        return array[head];
    }
}