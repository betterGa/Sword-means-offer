package KthNode;

import java.util.ArrayList;
import java.util.List;

//给定一棵二叉搜索树，请找出其中的第k小的结点。
// 例如， （5，3，7，2，4，6，8）中，按结点数值大小顺序第三小结点的值为4。
 class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }

}

//思路：递归中序遍历。要注意边界情况: k=0或大于二叉树节点个数时，都需要返回null。
public class Solution {
    TreeNode KthNode(TreeNode pRoot, int k)
    {
if(k==0) return null;
        KthNode(pRoot);
        if(k>time) return null;
        return nodes.get(k-1);
    }
    List<TreeNode> nodes=new ArrayList<>();
    int time=0;
    public void KthNode(TreeNode pRoot)
    {
        if(pRoot==null) return;
            KthNode(pRoot.left);
            nodes.add(pRoot);
            time++;
            KthNode(pRoot.right);
    }
}