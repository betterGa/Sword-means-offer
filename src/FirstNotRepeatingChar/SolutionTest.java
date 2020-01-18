package FirstNotRepeatingChar;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

public class SolutionTest {
  String testStr="google";
Solution solution=new Solution();
    @Test
    public void firstNotRepeatingChar() {
Assert.assertEquals(4,solution.FirstNotRepeatingChar(testStr));
    }
}
