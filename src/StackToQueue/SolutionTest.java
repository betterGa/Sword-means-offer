package StackToQueue;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

public class SolutionTest {
    Solution solution=new Solution();

    @Test
    public void push() {
        solution.push(1);
        solution.push(2);
        solution.push(3);
        solution.pop();
        solution.pop();
        solution.push(4);
        solution.pop();
        solution.push(5);
        solution.pop();
        solution.pop();
    }

    @Test
    public void pop() {
    }
}
