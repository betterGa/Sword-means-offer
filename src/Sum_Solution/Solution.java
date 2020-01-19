package Sum_Solution;
public class Solution {
    public int Sum_Solution(int n) {
        //用递归
        if(n==0) return 0;
        if(n==1) return 1;
        return Sum_Solution(n-1)+n;
    }
}