package InversePairs;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;


public class SolutionTest {
 Solution solution=new Solution();
    @Test
    public void merge() {
        int[]array=new int[]{5,7,4,6};
        System.out.println(solution.merge(array,0,3));
      solution.merge(array,0,1);
        for(int i=0;i<array.length;i++)
        System.out.println(array[i]);
    }
}
