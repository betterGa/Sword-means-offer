package JumpFloorII;

public class Solution {
    public int JumpFloorII(int target) {
        int[] method=new int[target+1];
        method[0]=1;
        for(int i=1;i<target+1;i++)
        {  int result=0;
            int j=i-1;
            while(j>=0)
            {result=result+method[j--];}
            method[i]=result;
        }
        return method[target];
    }}