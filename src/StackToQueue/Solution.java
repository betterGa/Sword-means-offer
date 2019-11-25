package StackToQueue;
import java.util.Stack;

//用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。

//思路：实现队列的push操作，向任意一个栈push即可。
//如果两个栈都为空，就向栈A里push
//之后一直向非空的栈A中push

public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
if(stack2.isEmpty()) stack1.push(node);
else stack2.push(node);
    }

    public int pop() {
//需要将栈A只保留一个元素，其余都转移进栈B中
        while (stack1.size()>1)
        {stack2.push(stack1.pop()); }

        //让栈A仅剩的这个元素出栈
       int peek=stack1.pop();
        //再把栈B中的元素再倒回栈A中，A顺序恢复
        while (!stack2.isEmpty())
        {stack1.push(stack2.pop());}
        return peek;
    }
}
