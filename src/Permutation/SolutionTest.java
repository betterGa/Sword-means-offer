package Permutation;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class SolutionTest {
Solution solution=new Solution();
    @Test
    public void permutation() {
    }

    @Test
    public void putInto() {
        ArrayList<String> resultlist=new ArrayList<>();
        solution.putInto(new char[]{'a','b','c'},0,3,new int[]{0,0,0},new char[3],resultlist);
  System.out.println(resultlist);
    }
}
