package Add;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;


public class SolutionTest {
Solution solution=new Solution();

    @Test
    public void add() {
        System.out.println(solution.Add(5,7));
    }
}
