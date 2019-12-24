package reConstructBinaryTree;

import java.util.Arrays;

/**
 * Definition for binary tree*/



 class TreeNode {
 int val;
     TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }}

public class Solution {
    //递归实现
    //只需要考虑宏观上的方法调用，不考虑微观的方法执行
    //方法的参数为前序遍历序列，中序序列，返回值为这两个序列可以确定出的根节点
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        //递归结束条件：两个序列都为空(前序序列为空，中序序列也必为空)
        //这时就是只有根节点，而无左右孩子的情况，既然无左右孩子，
        // 无前、中序列，也就无法由两个序列得出新的根节点，返回null
        if (pre.length == 0) return null;

        //拿到前、中序列时，可以知道前序的第一个节点一定是根，返回即可。
        TreeNode root = new TreeNode(pre[0]);
        //接下来，需要去中序序列中找到根节点所在的位置，从而区分左、右节点
        int position = 0;
        for (int i = 0; i < pre.length; i++) {
            if (pre[0] == in[i]) {
          position=i;break;
        }}
//得到根节点所在位置后，就可区分左右子树，
// 递归思想，把左子树的那部分当成一棵树处理
        //而当前得到的根  最终的左子树，可以看成是把左子树那部分当成一棵树处理以后
        // 重建得到的根。
        // 同理，当前得到的根  最终的右子树，可以看成是把右子树那部分当成一棵树处理以后
        //重建得到的根。则有以下：

        root.left = reConstructBinaryTree
                (Arrays.copyOfRange(pre, 1, 1 + position),
                        Arrays.copyOfRange(in, 0, position));
        root.right = reConstructBinaryTree(
                Arrays.copyOfRange(pre,position+1,pre.length),
                Arrays.copyOfRange(in,position+1,pre.length));


        return root;
    }
}