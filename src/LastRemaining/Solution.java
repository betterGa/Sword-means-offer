package LastRemaining;

import java.util.ArrayDeque;
import java.util.Queue;

//思路：利用队列，每m个一组，前m-1个数依次出队并入队，第m个数只出队不入队
//直到队列只剩下两个数时，如果m是偶数，队头的就是剩下的；
//如果m是奇数，需要出一次队，返回最后剩下的元素。

//思路：利用队列，每m个一组，前m-1个数依次出队并入队，第m个数只出队不入队
//直到队列只剩下两个数时，如果m是奇数，队头的就是剩下的；
//如果m是偶数，需要出一次队，返回最后剩下的元素。
public class Solution {
    public int LastRemaining_Solution(int n, int m) {
        if(n==0||m==0) return -1;
        Queue<Integer> queue=new ArrayDeque<>();
        //先让0~n-1入队
        for(int i=0;i<n;i++)
        {
            ((ArrayDeque) queue).addLast(i);
        }

        for (int i=0;i<m;i++)
        {
            if(queue.size()==2) break;
            if(i==m-1) {((ArrayDeque<Integer>) queue).pollFirst();i=-1;continue;}
            ((ArrayDeque<Integer>) queue).addLast(((ArrayDeque<Integer>) queue).pollFirst());
        }

        if(m%2==1) {((ArrayDeque<Integer>) queue).pollFirst();
            return ((ArrayDeque<Integer>) queue).pollFirst();}

        else return ((ArrayDeque<Integer>) queue).pollFirst();}

}
