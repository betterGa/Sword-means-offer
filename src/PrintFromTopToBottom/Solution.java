package PrintFromTopToBottom;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
 int val = 0;
 TreeNode left = null;
 TreeNode right = null;

 public TreeNode(int val) {
 this.val = val;
 }
 }

 //从上往下打印出二叉树的每个节点，同层节点从左至右打印。
//思路：
//二叉树的层次遍历，用队列广度优先搜索

public class Solution {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
ArrayList result=new ArrayList();
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        if(root==null) return result;
        //先将根节点入队
        ((LinkedList) q).addLast(root);
        //当队不为空时
while (!q.isEmpty())
{
    //先计算当前层中节点个数
    int size=q.size();
    //将该层节点依次出队，并让它们的左右孩子入队
    for(int i=0;i<size;i++)
    {
        TreeNode current=(TreeNode) ((LinkedList) q).pollFirst();
       if(current!=null) {result.add(current.val);
        ((LinkedList) q).addLast(current.left);
        ((LinkedList) q).addLast(current.right);}
        else continue;
    }

}
     return result;
    }
}