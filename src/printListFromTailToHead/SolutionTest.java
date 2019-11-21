package printListFromTailToHead;


import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;


public class SolutionTest {
    ListNode listNode1=new ListNode(67);
    ListNode listNode2=new ListNode(0);
    ListNode listNode3=new ListNode(24);
    ListNode listNode4=new ListNode(58);
    Solution solution=new Solution();

    @Test
    public void printListFromTailToHead() {
   listNode1.setNext(listNode2);
   listNode2.setNext(listNode3);
   listNode3.setNext(listNode4);
  ArrayList result = solution.printListFromTailToHead(listNode1);

   System.out.println(result);}

    @Test
    public void reverse() {

    }
}
