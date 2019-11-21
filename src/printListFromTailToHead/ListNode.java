package printListFromTailToHead;




     public class ListNode {
         int val;
         ListNode next = null;

         ListNode(int val) {
             this.val = val;
         }

         @Override
         public String toString() {
             return "ListNode{" +
                     "val=" + val +
                     '}';
         }

         public void setNext(ListNode next) {
             this.next = next;
         }
     }