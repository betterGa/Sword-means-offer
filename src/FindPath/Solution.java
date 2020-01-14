package FindPath;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;

class TreeNode {
 int val = 0;
 TreeNode left = null;
 TreeNode right = null;

 public TreeNode(int val) {
 this.val = val;

 }

 }

 //输入一颗二叉树的跟节点和一个整数，
// 打印出二叉树中结点值的和为输入整数的所有路径。
// 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
// (注意: 在返回值的list中，数组长度大的数组靠前)




/**参考评论
 * 链接：https://www.nowcoder.com/questionTerminal/b736e784e3e34731af99065031301bca?f=discussion
 * 来源：牛客网
 *
 * public class Solution {
 * /**         * 思路:用一个stack来装从根节点到叶节点的一条路径，
 * 当遍历到某一叶节点时，判断该路径能否称为目标路径，
 * 如果能，就将该路径转存到ArrayList中；如果不能，则弹出顶点，转向另一个分支。
 * */
/*
 public ArrayList<ArrayList<Integer>>FindPath(TreeNode root,int target){
 ArrayList<ArrayList<Integer>>result=new ArrayList<>();
        Stack<Integer> stack=new Stack<Integer>();
        traverse(root,target,stack,result);
        return result;
 private void traverse (TreeNode root,int target,Stack<Integer> stack,ArrayList<ArrayList<Integer>>result)
 {if(root==null)return;
 stack.push(root.val);
 //如果到叶子节点的时候，就判断此时堆栈里面数的和是否为target
 if(root.left == null && root.right == null)
 {             //计算stack里面的路径和
 Integer sum = 0;
 for(int i=0;i<stack.size();i++)
 {        sum += stack.get(i);             }
 //如果该路径为一条目标路径，则转存到一个ArrayList中
 if(target == sum) {
 ArrayList<Integer> sumArray = new ArrayList<Integer>();
 sumArray.addAll(stack);
 result.add(sumArray);             }         }
 traverse(root.left,target,stack,result);
 traverse(root.right,target,stack,result);
 stack.pop();     }

        }
*/

//思路：从根到叶子节点每个都走一遍？√
    //递归求解，从根开始入栈，直到遇到叶子节点，检查栈中这个路径的和是否为target,
    //如果是，就将该路径添加到结果，否则就pop，生成另一个路径
public class Solution {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target)
    {
Stack<Integer> stack=new Stack<Integer>();
ArrayList<ArrayList<Integer>> result=new ArrayList<>();
findPath(stack,root,target,result);

//重写Collections的compare方法，使：在返回值的list中，数组长度大的数组靠前
        Collections.sort(result, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                if(o1.size()>o2.size()) return -1;
                if(o1.size()==o2.size()) return 0;
                else return 1;
            }
        });


return result;
    }

    public void findPath(Stack<Integer> stack,TreeNode root,int target,ArrayList<ArrayList<Integer>> result)
    {
        if(root==null) return;
        //先让根节点的值进栈
        stack.push(root.val);
        //是叶子节点时
        if(root.left==null&&root.right==null)
        {
            int sum=0;
            //判断当前栈中的路径是否等于target
            for(int i=0;i<stack.size();i++)
            {
                sum=sum+stack.get(i);
            }
if(sum==target)
{
    ArrayList<Integer> result1=new ArrayList<>();
    result1.addAll(stack);
    result.add(result1);

}


        }
        //递归调用，左右子树分别进栈
findPath(stack,root.left,target,result);
        findPath(stack,root.right,target,result);

        //当走到叶子节点，而路径不符合target时，需要pop
        stack.pop();
    }
}