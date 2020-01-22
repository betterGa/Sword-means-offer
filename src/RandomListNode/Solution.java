package RandomListNode;

import java.util.HashMap;
import java.util.Map;

//
 class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
//输入一个复杂链表
// （每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
// 返回结果为复制后复杂链表的head。
//（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
public class Solution {

     //思路：借用HashMap,key存原始链表，value存复制后的链表
    //第一遍遍历原始链表，先将值进行拷贝
    //第二遍遍历原始链表，拷贝next和random
    public RandomListNode Clone(RandomListNode pHead)
    {if(pHead==null) return null;
Map<RandomListNode,RandomListNode> map=new HashMap<>();
RandomListNode temp=pHead;
        while (pHead!=null)
        {
            map.put(pHead,new RandomListNode(pHead.label));
            pHead=pHead.next;
        }
    pHead=temp;
   while (pHead!=null)
   {
       //赋next值
      map.get(pHead).next=map.get(pHead.next);
      map.get(pHead).random=map.get(pHead.random);
       pHead=pHead.next;
   }
    return map.get(temp);
    }
}
