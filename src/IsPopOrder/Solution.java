package IsPopOrder;

import java.util.ArrayList;
import java.util.Stack;

//输入两个整数序列，第一个序列表示栈的压入顺序，
// 请判断第二个序列是否可能为该栈的弹出顺序。
// 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，
// 序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
// 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
public class Solution {
    /**
     我的第一个想法：居然是把pushA所有的出栈情况求出来，太多了，不实际。
     */

    //参考了评论，可以这样：
    //（它这好像是逆向思维，模拟了反过程。）
    // 新建一个栈，把pushA（是数组）按从0到size-1的顺序依次入栈，
    // 先入第一个，再出栈，每次出栈的元素与popA（也是从0到size的顺序）的元素比较，
    // 如果不相等，pushA继续入栈即可，
    // (这样才能不断靠近popA是否弹出序列的真相。）
    //如果相等，pushA需要出栈，并且popA需要向后遍历1位
    //如果遍历到popA最后时栈为空，说明是弹出序列。

    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack=new Stack<Integer>();
        //用来标志遍历popA元素的位置
        int tag=0;
        for(int i=0;i<pushA.length;i++) {
           //先使pushA依次进栈,每个都得进来
        stack.push(pushA[i]);
int num=stack.peek();
if(num==popA[tag])
{stack.pop();
tag++;} }
while (tag!=popA.length&&!stack.isEmpty())
{
    if(stack.peek()==popA[tag])
    {stack.pop();
    tag++;}
    //不等于的话，说明顺序错误。
    else {break;}
}
        return stack.isEmpty();

    }
}

/**
 */