package PrintZhi;
//请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
// 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，
// 其他行以此类推。
import sun.reflect.generics.tree.Tree;

import java.util.*;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

//思路：队列与栈相互配合。
//先将pRoot加入队中。
//奇数层时，队列的操作：出队，把左右节点依次带入队中,把val加入result集合。
//偶数层时，队列的操作：出队，把左右节点依次带入队中,入栈。
//         栈的操作：出栈，把val加入result集合。
public class Solution {
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> results=new ArrayList<>();
        if(pRoot==null) return results;
Stack<TreeNode> stack=new Stack<>();
Queue<TreeNode> queue=new ArrayDeque<>();
//标志奇偶层，奇数层为true
        boolean flag=true;
((ArrayDeque<TreeNode>) queue).addLast(pRoot);
while (!queue.isEmpty())
{
    ArrayList<Integer> result=new ArrayList<>();
    int size=queue.size();
    //对于队列的操作
    for(int i=0;i<size;i++)
    {if(flag)
    {
        TreeNode current=((ArrayDeque<TreeNode>) queue).pollFirst();
        result.add(current.val);
        if(current.left!=null) ((ArrayDeque<TreeNode>) queue).addLast(current.left);
        if(current.right!=null) ((ArrayDeque<TreeNode>) queue).addLast(current.right);
    }
    else
    {
        TreeNode current=((ArrayDeque<TreeNode>) queue).pollFirst();
        if(current.left!=null) ((ArrayDeque<TreeNode>) queue).addLast(current.left);
        if(current.right!=null) ((ArrayDeque<TreeNode>) queue).addLast(current.right);
        stack.add(current);
    }
    }
    //对于栈的操作
        for(int i=0;i<size;i++)
        {
            if(!flag)
            {
           result.add(stack.pop().val);
        }}
        flag=!flag;
    results.add(result);
}

 return results;
}
}