package VerifySquenceOfBST;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;

import static org.junit.Assert.*;


public class SolutionTest {
    int[] data=new int[]{4,8,6,12,16,14,10};
Solution solution=new Solution();
    @Test
    public void verifySquenceOfBST() {
        boolean result=solution.VerifySquenceOfBST(data);
        Assert.assertEquals(true,result);
    }

    @Test
    public void isPopOrder() {
    }


    @Test
    public void test1()
    {
    }
}
