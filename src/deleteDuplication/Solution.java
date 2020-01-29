package deleteDuplication;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

//思路:遍历链表，同时进队列和Set集合中
//再依次出队，去掉重复元素
public class Solution {
    public ListNode deleteDuplication(ListNode pHead) {
        if(pHead==null) return null;
    Queue<Integer> queue=new ArrayDeque<>();
    while (pHead!=null)
    {
        ((ArrayDeque<Integer>) queue).addLast(pHead.val);
    pHead=pHead.next;
    }

  int pending=0;
    ListNode tempNode=null;
    ListNode newHead=null;
    ListNode newNode=null;
    int flag=0;
    while (!queue.isEmpty())
    {//先出队，作为待审节点
      flag=0;
       pending=queue.poll();

       //这里要注意：当链表只剩下1个节点时，进入while (!queue.isEmpty())中
        //会先让队头poll成为pending待审节点,这时不能再peek了，
        //如果队头和上一个元素值相等，那么再下面那个while里面肯定出队了‘
        //这个剩下的最后一个元素肯定是不重复的，链上即可。
    if(!queue.isEmpty())
        //当遇到重复情况时，将重复节点出队即可
       {   while (queue.peek()==pending)
        {((ArrayDeque<Integer>) queue).pollFirst();
            flag=1;
        if(queue.isEmpty()) break;
        }}

        if(flag==0)
        //否则形成新链表
        { if(tempNode==null) {
            tempNode =new ListNode(pending);
        newHead=  tempNode;
        }
        //链上
        else {
       newNode=new ListNode(pending);
            tempNode.next = newNode;
        tempNode=newNode;
        }
        }
    }

    return newHead;


    }}