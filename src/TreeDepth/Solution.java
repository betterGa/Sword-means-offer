package TreeDepth;
class TreeNode {
 int val = 0;
 TreeNode left = null;
 TreeNode right = null;

 public TreeNode(int val) {
 this.val = val;
 }
 }
//输入一棵二叉树，求该树的深度。
// 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，
// 最长路径的长度为树的深度。

//思路：递归求解。到叶子节点深度为1，其他节点的深度为其左右子节点的最大深度+1.

public class Solution {
    public int TreeDepth(TreeNode root) {
        if(root==null) return 0;
if(root.left==null&&root.right==null) return 1;
        return Math.max(TreeDepth(root.left),(TreeDepth(root.right)))+1;


    }
}