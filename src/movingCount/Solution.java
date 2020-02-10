package movingCount;


public class Solution {
    public int movingCount(int threshold, int rows, int cols) {
        //用来标记是否被访问过
        int[][] flag = new int[rows+1][cols+1];
return movingCount(threshold,0,0,rows,cols,flag);
    }
    public int movingCount(int threshold, int rows, int cols,int rt,int ct,int[][] flag) {
        //标记被访问过

if(rows<0||cols<0||rows>rt||cols>ct||ifMatch(rows)+ifMatch(cols)>threshold||flag[rows][cols]==1) return 0;
        flag[rows][cols]=1;
return 1+movingCount(threshold,rows-1,cols,rt,ct,flag)+movingCount(threshold,rows+1,cols,rt,ct,flag)
        +movingCount(threshold,rows,cols-1,rt,ct,flag)+movingCount(threshold,rows,cols+1,rt,ct,flag);
    }


    public int ifMatch(int a)
    {
        int sum=0;
        while (a!=0)
        {
            sum=sum+a%10;
            a=a/10;
        }
return sum;
    }
}