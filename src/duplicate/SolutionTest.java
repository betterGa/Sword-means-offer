package duplicate;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;


public class SolutionTest {
        Solution solution=new Solution();
    @Test
    public void duplicate() {
        int []data=new int[]{2,4,2,1,4};
        int []dupli=new int[5];
        System.out.println(solution.duplicate(data,5,dupli));
System.out.println(dupli[0]);
    }

}
