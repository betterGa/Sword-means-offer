package isNumeric;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;


public class SolutionTest {
    Solution solution=new Solution();
    @Test
    public void isNumeric() {
    char[] str="123.45e+6".toCharArray();
    System.out.print(solution.isNumeric(str));
    }
}
