package FindFirstCommonNode;

import java.util.Stack;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
//输入两个链表，找出它们的第一个公共结点

//思路：从头到尾遍历链表，遇到第一个相同的返回即可。
//递归求解(递个蛤蟆腿呢，它不是两个链表头部有共同部分，可以同步走着作比较，它是尾部有共同部分。)


//思路一：这是单链表，如果有公共节点，尾部必然是相同的，
//可以把链表节点入栈，尾部开始出栈，比较得到“第一个公共节点”
public class Solution {
    /**递归呵呵 public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
if(pHead1==null||pHead2==null) return null;
    if(pHead1.val==pHead2.val)
    return pHead1;
    return FindFirstCommonNode(pHead1.next,pHead2.next);


}
*/

    public ListNode FindFirstCommonNode1(ListNode pHead1, ListNode pHead2) {
Stack stack1=new Stack();
        Stack stack2=new Stack();
        //链表入栈
        while (pHead1!=null)
        {
            stack1.push(pHead1);
            pHead1=pHead1.next;
        }
        while (pHead2!=null)
        {
            stack2.push(pHead2);
            pHead2=pHead2.next;
        }
        ListNode listNode=null;
        while (!stack1.isEmpty()&&!stack2.isEmpty()&&stack1.peek()==stack2.peek())
        {
            listNode=(ListNode) stack1.peek();
            stack1.pop();
            stack2.pop();}
        return listNode;


    }
//思路二：将两个链表想成分别pHead1+pHead2和pHead2+pHead1进行拼接，
// 那么从前向后遍历，如果本来两个链表有公共部分，
// 那么它们的公共部分一定会重叠
// （其实还是因为是在尾部重叠，分别拼接就可以得到同样长度的链表，这样它们的尾部就可以对齐）
// (想成拼接好理解，并不是真的去拼接，只是用不同指针跳转至另一个链表头部而已 ）
// 找到第一个相同的节点返回即可
public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
if(pHead1==null||pHead2==null) return null;
ListNode pointer1=pHead1;
ListNode pointer2=pHead2;
while (pointer1!=pointer2)
{

    if(pointer1==null) pointer1=pHead2;
    else  pointer1=pointer1.next;
    if(pointer2==null) pointer2=pHead1;
    else pointer2=pointer2.next;
}

return pointer1;

}

}