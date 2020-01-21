package GetNumberOfK;
;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;


public class SolutionTest {

Solution solution=new Solution();
    @Test
    public void getNumberOfK() {
        System.out.println(solution.GetNumberOfK(new int[]{1,2,3,3,3,3,4,5},3));
    }
}
