package Min;

import java.util.Stack;
//定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数
// （时间复杂度应为O（1））。

//思路：新建一个栈，用来保存最后结果，即栈中最小值。
//但有个问题就是，如果出栈，可能最小栈中的值也得跟着出，需要维护倒数第二小值
public class Solution {
//两个栈，一个用来存原始栈数据，一个用来维护最小值
    Stack<Integer> dataStack=new Stack<>();
    Stack<Integer> minStack=new Stack<>();
    int reciprocal2;

//进栈规则，先让元素进数据栈
    public void push(int node) {
dataStack.push(node);
//当最小栈为空时，需要进栈
        if(minStack.isEmpty())
            minStack.push(node);

        //如果当前值小于最小栈的栈顶元素值，需要使最小栈出栈，
        //当前值入栈
        else{if(node<minStack.peek())
        {//出的这个就是需要维护的倒数第二小。
            reciprocal2=minStack.pop();
        minStack.push(node);
        }}
    }

    public void pop() {
        if(dataStack.peek()==minStack.peek())
        {
            minStack.pop();
            minStack.push(reciprocal2);

        }
dataStack.pop();
    }

    public int top() {
return dataStack.peek();
    }

    public int min() {
return minStack.peek();
    }
}

//一次就过，我好棒。