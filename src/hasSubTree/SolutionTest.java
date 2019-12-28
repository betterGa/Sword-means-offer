package hasSubTree;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

public class SolutionTest {
Solution solution=new Solution();
TreeNode root1=new TreeNode(8);
TreeNode t2=new TreeNode(8);
    TreeNode t3=new TreeNode(7);
    TreeNode t4=new TreeNode(9);
    TreeNode t5=new TreeNode(3);
    TreeNode t6=new TreeNode(4);
    TreeNode t7=new TreeNode(7);

    TreeNode root2=new TreeNode(8);
    TreeNode t8=new TreeNode(9);
    TreeNode t9=new TreeNode(2);

    @Test
    public void hasSubtree() {
        root1.left=t2;
        root1.right=t3;
        t2.left=t4;
        t2.right=t5;
        t5.left=t6;
        t5.right=t7;
        root2.left=t8;
        root2.right=t9;

        boolean resulrt=solution.HasSubtree(root1,root2);
        Assert.assertEquals(false,resulrt);

    }

    @Test
    public void isSame() {
    }
}
