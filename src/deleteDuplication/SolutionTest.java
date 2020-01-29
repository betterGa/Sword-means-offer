package deleteDuplication;

import org.junit.Test;


import static org.junit.Assert.*;


public class SolutionTest {
    Solution solution=new Solution();
    ListNode head=new ListNode(1);
    ListNode n2=new ListNode(1);
    ListNode n3=new ListNode(2);
    ListNode n4=new ListNode(3);
    ListNode n5=new ListNode(3);
    ListNode n6=new ListNode(4);
    ListNode n7=new ListNode(5);
    ListNode n8=new ListNode(5);


    @Test
    public void deleteDuplication() {
        head.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=n6;
        n6.next=n7;
        n7.next=n8;

        ListNode newHead=solution.deleteDuplication(head);
        while (newHead!=null)
        {System.out.println(newHead.val);
        newHead=newHead.next;}

    }
}
