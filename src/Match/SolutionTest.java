package Match;


import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;


public class SolutionTest {
  Solution solution=new Solution();
    @Test
    public void match() {
        System.out.println(solution.match(new char[]{'a','a'},new char[]{'a','b','*','a'}));
    }

    @Test
    public void match1() {
    }
}
