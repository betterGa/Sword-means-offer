package NumberOf1;

    //输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
    //(1)思路：将十进制数转换为二进制数的方法，对2取余，看1出现的次数；
    //如果是负数，次数需要再加1。
    /**
      public class Solution {
    public int NumberOf1(int n) {
        int time=0;
        int flag=0;
        if(n<0) {n=(int)Math.pow(2.0,32.0)+n;flag=1;}
        while (true)
        {
            if(n<1) break;
            if(n%2==1) time++;
            n=n/2;
        }
        return flag+time;
    }
}
出错了，对负数的处理并不妥当。*/

    //方法二：参考了评论。
//用当前数-1，就可以把当前数从最右的"1"开始直至最低位，按位取反。
//比如"1100"-1.就会得到"1011"
//然后将"1011"和原数相与，"1011"&"1100"得到"1000"
//这样得到的"1000"的特点是将最有的"1"变成了"0"
//再继续，重复上述过程，用"1000"-1，得到"0111"
//是从最右的"1"开始按位取反的。
//再与"1000"相与，可以得到"0000"，到这一步得到"0"是两次过程，
//因此原数中是2个"1"
    public class Solution {
        public int NumberOf1(int n) {
int time=0;
while (true) {
    time++;
    int result = (n - 1) & n;
    if(result==0) break;
}
            return time;

        }
    }