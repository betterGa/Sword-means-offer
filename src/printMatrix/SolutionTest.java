package printMatrix;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

public class SolutionTest {
    Solution solution=new Solution();

    @Test
    public void printMatrix() {
        int[][]data=new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
    System.out.println(solution.printMatrix(data));
    }

    @Test
    public void rotatingCube() {
    }
}
