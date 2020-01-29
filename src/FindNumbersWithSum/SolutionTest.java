package FindNumbersWithSum;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

public class SolutionTest {
Solution solution=new Solution();

    @Test
    public void findNumbersWithSum() {
        int[] array=new int[]{1,2,4,7,11,15};
        System.out.println(solution.FindNumbersWithSum(array,15));

    }
}
