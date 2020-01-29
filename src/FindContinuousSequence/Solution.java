package FindContinuousSequence;
//小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
// 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
// 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
// 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列?
// Good Luck!

//思路：100/5=20
//连续正数序列是 20-2 20-1 20 20+1 20+2
//对于偶数，肯定是左右相互抵消的情况，所以要要除以奇数位才能得到中间数
//(错了，100=4*25，25=12+13，再凑3对即可)

/*
import java.util.ArrayList;
public class Solution {
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        int length=0;
        ArrayList<ArrayList<Integer>> results=new ArrayList<>();
        if(sum%2==0)
        { for(int i=3;i<sum;i=i+2)
        {//要保证都是正数
            if(sum%i==0&&sum/i-i/2>0)
            {ArrayList<Integer> result=new ArrayList<>();
            construcArray(result,i,sum/i);
            results.add(result);}
        }
        }
        //对于奇数，只可能是相邻正整数的情况
        else
        {{ for(int i=sum;i>1;i=i-2)
        {//要保证都是正数
            if(sum%i==0&&sum/i-i/2>0)
            {ArrayList<Integer> result=new ArrayList<>();
                construcArray(result,i,sum/i);
                results.add(result);}
        }
        }
            if(sum/2>0) {
            ArrayList<Integer> result = new ArrayList<>();
            result.add(sum / 2);
            result.add(sum / 2 + 1);
            results.add(result);
        }

        }
        return results;
}

public void construcArray(ArrayList<Integer> arrayList, int i, int medium)
{
int start=-i/2;
while (start<=i/2) {
    arrayList.add(medium+start);
start++;
}
}
}
*/


import java.util.ArrayList;
public class Solution {
    //利用等差数列求和公式：(首项+末项)*项数/2
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        int start=1;
        int end=2;
        int Nowsum=0;
        ArrayList<ArrayList<Integer>> results=new ArrayList<>();
        while (start<end)
        {Nowsum=(start+end)*(end-start+1)/2;
            if(Nowsum==sum)
            { ArrayList<Integer> result=new ArrayList<Integer>();
                for (int i=start;i<=end;i++)
                { result.add(i); }
                results.add(result);
                end++;
            }
            if(Nowsum<sum)
            { end++; }
            else if(Nowsum>sum)
            {start++;}
        }
        return results;}
}