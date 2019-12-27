package MergeList;


import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

public class SolutionTest {

Solution solution=new Solution();
ListNode list1=new ListNode(1);
    ListNode list2=new ListNode(2);
    @Test
    public void merge() {
        list1.next=new ListNode(3);
        list1.next.next=new ListNode(5);
        list2.next=new ListNode(4);
        list2.next.next=new ListNode(6);
        ListNode result=solution.Merge(list1,list2);
        System.out.print(result);
    }
}
