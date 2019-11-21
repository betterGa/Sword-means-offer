package printListFromTailToHead;
import java.util.ArrayList;
import java.util.List;
//题目：从尾到头打印链表。
//输入一个链表，按链表从尾到头的顺序返回一个ArrayList。


//版本一:递归实现链表的反转，try一try。
/*
import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList result=new ArrayList();
        if(listNode==null) return result;
        ListNode head=reverse(listNode);
        while (head!=null)
        {result.add(head.val);
        head=head.next;}

        return result;

    }


    public ListNode reverse(ListNode head)
    {
        if(head==null||head.next==null)
        {return head;}

        ListNode save=reverse(head.next);
        ListNode newHead=save;
        while (save.next!=null)
        {save=save.next;}
        save.next=head;
        head.next=null;
        return new  Head;
    }
}
*/
//已通过。

//版本二：调用arrayList的add(int index,E element方法)
/*
public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList arrayList=new ArrayList();
while (listNode!=null)
{
    arrayList.add(0,listNode.val);
    listNode=listNode.next;
}
        return arrayList;

    }
}
*/

//已通过。

//版本三
//看牛客的题解，递归实现
//像深度优先搜索算法
import java.util.*;
public class Solution {
    ArrayList<Integer> list = new ArrayList();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if(listNode!=null){
            printListFromTailToHead(listNode.next);
            list.add(listNode.val);
        }
        return list;
    }
}