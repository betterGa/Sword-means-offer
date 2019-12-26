package MirrorBTree;

class TreeNode {
 int val = 0;
 TreeNode left = null;
 TreeNode right = null;

 public TreeNode(int val) {
 this.val = val;

 }
 }
//操作给定的二叉树，将其变换为源二叉树的镜像。
//思路，递归。
//链接：https://www.nowcoder.com/questionTerminal/564f4c26aa584921bc75623e48ca3011?f=discussion&toCommentId=5160333
//来源：牛客网
//
//思路：对当前传入的根节点，先进行左右节点的交换，
// 用TreeNode类型的遍历temp暂存，再对左右节点递归地调用方法，
// 分别对左右节点继续进行各自左右节点的交换。
// 递归终止条件是遇到节点为null，当传入的root为叶子节点时，它的左右节点都是null，交换一下无妨
// 然后继续对左右这两个null进行“各自左右节点的交换”，这时没有左右节点了，应当终止方法的调用了，return即可。
//  我感觉这次的递归是个正向思维的，它是先交换，然后左右节点再去调用交换方法，
// 和之前遇到的递归不大一样。代码如下：
//链接：https://www.nowcoder.com/questionTerminal/564f4c26aa584921bc75623e48ca3011?f=discussion&toCommentId=5160333
  //      来源：牛客网

public class Solution {
    public void Mirror(TreeNode root) {
        {if(root==null) return;
            //将左右节点交换
            TreeNode temp=root.left;
            root.left=root.right;
            root.right=temp;
            //递归，继续对左右节点进行各自左右节点的交换
            Mirror(root.left);
            Mirror(root.right);
        }}}

    //传入根、左、右试一试,错了错了，别想那么复杂，因为不都是完全二叉树，所以不好处理。

 /**
    public TreeNode Mirror1(TreeNode root, TreeNode left, TreeNode right) {
 //递归终止条件：当左节点或右节点任意一个的左右节点都为null时,
        //这时的树是两层的：根一层，子树一层。再往下为null
        // 当前树镜像的结果是交换左右节点即可
        if((left.left==null&&left.right==null)&&(right.left==null&&right.right==null))
        {
            TreeNode temp=left;
            root.left=right;
            root.right=temp;
            return root;

        }

        //如果不只是两层的树，则应该递归调用，根的左子树变成右子树镜像后的结果。
        //同理，根的右子树也要变成左子树镜像后的结果
        root.left=Mirror1(root.right,root.right.left,root.right.right);
        root.right=Mirror1(root.left,root.left.left,root.left.right);
        return root;
    }
}
*/