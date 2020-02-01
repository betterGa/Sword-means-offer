package isSymmetrical;

 class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
 }

 //请实现一个函数，用来判断一颗二叉树是不是对称的。
 // 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
public class Solution {
    boolean isSymmetrical(TreeNode pRoot)
    {
if(pRoot==null) return true;
return isSymmetrical(pRoot.left,pRoot.right);
    }
     boolean isSymmetrical(TreeNode pLeft,TreeNode pRight)
     {
         if(pLeft==null&&pRight==null) return true;
         if(pLeft==null||pRight==null) return false;
         if(pLeft.val==pRight.val) return isSymmetrical(pLeft.left,pRight.right)&&isSymmetrical(pLeft.right,pRight.left);
    else return false;
     }
 }