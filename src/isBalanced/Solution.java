package isBalanced;
//平衡二叉树（Balanced Binary Tree）具有以下性质：
// 它是一棵空树或它的左右两个子树的高度差的绝对值不超过1，
// 并且左右两个子树都是一棵平衡二叉树。

//输入一棵二叉树，判断该二叉树是否是平衡二叉树。

class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val)
    {this.val=val;}
}


//思路：递归调用，当前二叉树是否是平衡树是其左右子树是否是平衡树相与的结果
//递归的终止条件是传入节点为空时，返回true
//传入的左右节点高度差相差1时，返回true,需要一个方法求高度，也是递归调用
public class Solution {
    public boolean IsBalanced_Solution(TreeNode root) {
        if(root==null) return true;
        return Math.abs(height(root.right)-height(root.left))<=1
                && IsBalanced_Solution(root.left)&&IsBalanced_Solution(root.right);
    }

    ;


    public int height(TreeNode root)
    {
        if(root==null) return 0;
        return Math.max(height(root.left),height(root.right))+1;
    }
}