package LeftRotateString;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;


public class SolutionTest {
Solution solution=new Solution();
    @Test
    public void leftRotateString() {
        String str="abcXYZdef";
        System.out.println(solution.LeftRotateString(str,3));
    }
}
