package MergeList;
/**题目描述
        输入两个单调递增的链表，输出两个链表合成后的链表，
 当然我们需要合成后的链表满足单调不减规则。
*/

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
//1.思路：新建一个链表，每次比较list1与list2的元素，把小的链上
public class Solution {
    public ListNode Merge(ListNode list1,ListNode list2) {
        {
            ListNode head;
            ListNode current;
           //先初始化新链表的头节点
            if(list1.val<list2.val)
            { head=new ListNode(list1.val);
            list1=list1.next;
            }
            else { head=new ListNode(list2.val);
            list2=list2.next;
            }

            //用current当前链表往后接着链，最后返回head
            current=head;
            while(list1!=null&&list2!=null)
            {
                if(list1.val<list2.val)
                {
                  current.next=new ListNode(list1.val);
                  current=current.next;
                  list1=list1.next;
                }
else {current.next=new ListNode(list2.val);
                    current=current.next;
list2=list2.next;}
            }
if(list1==null) current.next=list2;
   else if(list2==null) current.next=list1;

return head;

        }


    }
}