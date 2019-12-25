package ReverseList;

import java.util.ResourceBundle;

//反转链表
 class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
//递归求解

public class Solution {
    public ListNode ReverseList(ListNode head) {
        if(head==null||head.next==null) return head;
//将 传入下一个节点 得到的头 暂存起来，最后需要返回它
        ListNode temp=ReverseList(head.next);
        ListNode traverse=temp;
//遍历，直到最后一个节点
        while (traverse.next!=null)
        {
            traverse=traverse.next;
        }
        traverse.next=head;
        return temp;
    }

    /**
     * 结果：
     * 不通过
     * 您的代码已保存
     * 运行超时:您的程序未能在规定时间内运行结束，请检查是否循环有错或算法复杂度过大。
     * case通过率为0.00%
     */