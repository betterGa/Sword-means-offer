package FindNumsAppearOnce;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;


public class SolutionTest {
   Solution solution=new Solution();
    @Test
    public void findNumsAppearOnce1() {
    }

    @Test
    public void findNumsAppearOnce() {
        int[] array=new int[]{3,2,4,2,3,5,6,5};
        int[] num1=new int[1];
        int[] num2=new int[1];
        solution.FindNumsAppearOnce(array,num1,num2);
        System.out.println(num1[0]);
        System.out.println(num2[0]);
    }
    @Test
    public void testMth()
    {
       System.out.println(solution.Mth(8,4));
    }
}
