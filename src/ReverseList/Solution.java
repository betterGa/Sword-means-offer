package ReverseList;

import java.util.ResourceBundle;

//反转链表

/**
 * 链接：https://www.nowcoder.com/questionTerminal/75e878df47f24fdc9dc3e400ec6058ca?f=discussion&toCommentId=5158377
 * 来源：牛客网
 *
 * 思路是这样的，在方法中传入的参数是需要反转的链表的头节点，返回值应是反转之后的链表的头节点。
 * 以原链表为1-->2 --> 3 --> 4为例，
 * 如果传入"1"，我们可以知道，最终返回的结果应该是4 --> 3 --> 2 --> 1。
 * 传入1，如果传入1.next，得到的会是1.next也就是2反转后的结果："4 --> 3 --> 2"，
 * 这时，只需要将该链表先暂存起来，因为最终要返回的头仍是"4",
 * 然后给链表续上"1",也就变成了"4 --> 3 --> 2 --> 1"
 * 要注意的是，需要给1的next置为null ,否则可就在内部循环死了。
 * 递归终止条件是遇到该节点的下一个节点为null时，也就是当前只有一个节点，返回它本身即可，
 * 刚进方法时，如果节点为null，也是返回null即可：
 */



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
        //在这里加一句:
        //head.next=null;
        //也就通过了。
        return temp;
    }}

    /**
     * 结果：
     * 不通过
     * 您的代码已保存
     * 运行超时:您的程序未能在规定时间内运行结束，请检查是否循环有错或算法复杂度过大。
     * case通过率为0.00%
     */

    //我知道错在哪里了： 需要多一句"head.next=null"，不然可就循环死在那儿了。
