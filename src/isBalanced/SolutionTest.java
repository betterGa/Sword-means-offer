package isBalanced;


import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;


public class SolutionTest {
   Solution solution=new Solution();
   TreeNode root=new TreeNode(1);
    TreeNode t2=new TreeNode(2);
    TreeNode t3=new TreeNode(3);
    TreeNode t4=new TreeNode(4);
    TreeNode t5=new TreeNode(5);
    TreeNode t6=new TreeNode(6);

    @Test
    public void isBalanced_Solution() {
        root.left=t2;
        root.right=t3;
        t2.left=t4;
        t2.right=t5;
        t5.left=t6;
       System.out.println(solution.IsBalanced_Solution(root));
    }

    @Test
    public void height() {
    }
}
