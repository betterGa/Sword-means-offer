package GetNext;
 class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}

//给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
// 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
public class Solution {

     //思路：分情况：如果传入的pNode有右子树，根据中序遍历“左 根 右”
    //当前的pNode作为根，下一个一定是它的right右子树的最左节点
    //如果传入的pNode无右子树：
    //当它是父的右子树时，因为“左 根 右”
     // 到当前节点时，已经遍历过 root 的左子树和 root 了，而当前节点作为“根”，
    //下一个一定是null
    //如果它属于root的左子树时，它先是“根”，因为“右”为null，而这时整体作为左，
    //该去找"根"，这个根就是pNode的父节点即 next
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
if(pNode==null) return null;
if(pNode.right!=null)
{
    TreeLinkNode right=pNode.right;
    TreeLinkNode temp=null;
    while (right!=null)
    { temp=right;
        right=right.left;
    }
return temp;
}
else {
    if(judgedLeft(pNode))
    {
        return pNode.next;
    }
    else
    {
        while (!judgedLeft(pNode))
        {pNode=pNode.next;}
            return pNode.next;
    }



}
    }
    public boolean judgedLeft(TreeLinkNode pNode)
    {
        TreeLinkNode root=pNode.next;
        if(root==null) return true;
        if(root.left==pNode) return true;
        else return false;
    }
}