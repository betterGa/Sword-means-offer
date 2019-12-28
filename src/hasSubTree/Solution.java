package hasSubTree;

class TreeNode {
 int val = 0;
 TreeNode left = null;
 TreeNode right = null;

 public TreeNode(int val) {
 this.val = val;

 }
 }


 //题目描述:输入两棵二叉树A，B，判断B是不是A的子结构。
 // （ps：我们约定空树不是任意一个树的子结构）

//思路：递归求解
//传入的参数为两个树root1和root2
//返回值为树root2是否为树root1的子树
//如果树root2是树root1的左子树或右子树的子树，那么树root2就是树root1的子树
//递归终止条件是当树root1与树root2已经是相同的了，需要返回ture


public class Solution {

    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
if(root1==null||root2==null) return false;
if(isSame(root1,root2)) return true;
return HasSubtree(root1.left,root2)||HasSubtree(root1.right,root2);
    }

    //再来个方法判断两个二叉树是否相同
    //也是用递归，如果左子树或右子树的值不相等，就可以返回false了。
    //如果两棵树同时走完了，返回true，否则也是返回false

    //我写的：
    /*public boolean isSame(TreeNode root1,TreeNode root2)
    {
        if(root2==null&&root1!=null) return true;
         if(root1==null&&root2==null) return true;
        if(root1.val!=root2.val) return false;
        return isSame(root1.left,root2.left)&&isSame(root1.right,root2.right);
    }
*/

    //参考博客：
    public boolean isSame(TreeNode root1,TreeNode root2)
    {

        //递归终止条件
        //前提已经是值相等，才进来
        //如果root2==null，没有关系，仍是返回true,因为两棵树的根已经相等了，
        // 只是root1可能有子树，而root2已经没有子树了而已。
        if(root2==null) return true;
        //但是如果是root1==null,说明root1已经到叶子节点了，而root2不为null，那root1就不可能包含root2了。
        if(root1==null) return false;
        //人家这个写的多好
      //如果两棵树的当前节点的值相等了，才去递归调用(左，左)&&（右，右）
      //如果两棵树的当前节点值不相等，直接返回false即可。
        if(root1.val==root2.val)
        {return isSame(root1.left,root2.left)&&isSame(root1.right,root2.right);}
else return false;
    }

}



//2.思路 递归求解
/*
public class Solution {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
if(root1==null||root2==null) return false;
        //递归终止条件，到root2的叶子节点
        if(root2.left==null&&root2.right==null)
        {
        if(root1.val==root2.val) return true;
        else return false;
        }
        return HasSubtree(root1.left,root2.left)||HasSubtree(root1.right,root2.right);
    }}
*/


