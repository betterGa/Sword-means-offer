package EntryNodeOfLoop;

import java.util.HashSet;
import java.util.Set;

//给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Solution {
//思路：利用Set检查重复性，遍历链表，
// 当链表中一个节点的值重复出现，就说明这个值是环的入口；
// 如果没有出现重复的值，就说明没有环，返回null即可,
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {if(pHead==null) return null;
        Set<Integer> set=new HashSet<>();
        while (pHead!=null)
        {
            if(set.add(pHead.val)==false)
                return pHead;
            pHead=pHead.next;
        }
        return null;
    }
}