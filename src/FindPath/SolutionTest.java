package FindPath;


import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;

import static org.junit.Assert.*;

//重写 compare方法，使list长度大的在前。
//默认的是升序，从小到大。
public class SolutionTest {
@Test
    public void test1()
{
    ArrayList<ArrayList> list=new ArrayList<ArrayList>();
    ArrayList list1=new ArrayList();
    ArrayList list2=new ArrayList();
    Stack<Integer> stack1=new Stack<>();
    stack1.push(1);
    stack1.push(2);

    Stack<Integer> stack2=new Stack<>();
    stack2.push(4);
    stack2.push(5);
    stack2.push(6);
    stack2.push(7);
    stack2.push(8);
    list1.addAll(stack1);
    list2.addAll(stack2);
    list.add(list1);
    list.add(list2);
    Collections.sort(list, new Comparator<ArrayList>() {
        @Override
        public int compare(ArrayList o1, ArrayList o2) {
           if(o1.size()>o2.size()) return -1;
           if(o1.size()==o2.size()) return 0;
           else return 1;
        }
    });
System.out.println(list);
}


    }


