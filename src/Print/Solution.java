package Print;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}
//从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
public class Solution {

    //思路：层序遍历，队列实现。
    // 首先，从根节点开始入队，这是第一层，先通过 queue.size=1 得知第一层节点个数是1，
    // 利用 for 循环控制当前层，
    // 需要使当前层所有节点出队并把值val存入存入list结果中，
    // 同时其左右节点也跟着入队（如果左右节点是null不需要入队） ，
    // 直到queue为empty,遍历完毕。代码如下：
    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        Queue<TreeNode> queue=new ArrayDeque<>();
        ArrayList<ArrayList<Integer>> results=new ArrayList<>();
        if(pRoot==null) return results;
        //根节点先入队
        ((ArrayDeque<TreeNode>) queue).addLast(pRoot);
        int laryerSize=0;
        while (!queue.isEmpty())
        {ArrayList<Integer> result=new ArrayList<>();
            laryerSize=queue.size();
            for(int i=0;i<laryerSize;i++)
            {TreeNode current=((ArrayDeque<TreeNode>) queue).pollFirst();
                result.add(current.val);
              if(current.left!=null) ((ArrayDeque<TreeNode>) queue).addLast(current.left);
              if(current.right!=null)  ((ArrayDeque<TreeNode>) queue).addLast(current.right);
            }
            results.add(result);
        }
        return results;
    }
}