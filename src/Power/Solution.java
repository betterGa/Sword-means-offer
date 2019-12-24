package Power;

/**Java实现，已通过。运行时间：56ms，占用内存：10376k。
        这道题主要是注意传入参数的分类，考虑全面。
        如果给的次方数是正数，用循环控制使本身乘以本身的次数即可，
 如果给的次方数是负数，需要用1/用次方的相反数算出来的结果，代码如下：
 */


public class Solution {
    public double Power(double base, int exponent) {
        if(exponent>=0)
        {
            double result=1.0;
            for(int i=0;i<exponent;i++)
            {
                result=base*result;
            }
            return result;}
        else
        {
            return 1.0/Power(base,-exponent);
        }


    }
}

