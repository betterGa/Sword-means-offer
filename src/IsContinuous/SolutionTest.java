package IsContinuous;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;


public class SolutionTest {
    Solution solution=new Solution();
    @Test
    public void isContinuous() {
        System.out.println(solution.isContinuous(new int[]{1,3,2,5,4}));

    }

    @Test
    public void interval() {
    }
}
