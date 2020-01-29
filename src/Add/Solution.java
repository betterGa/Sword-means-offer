package Add;

//写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
public class Solution {


    //两个数相加是这样的：
    // 先不考虑进位，将两个数进行无进位相加：
    // 1+1=0, 0+0=0, 1+0=1,这是异或运算:int UnsignedSum=num1^ num2;
    // 接下来需要求出进位位，1+1=0时会向前产生一个进位位，而其他情况:0+0  0+1没有进位位，
    // 可以想到相与运算，只有1&1=1,其他相与结果都是0，
    // 这个1左移1位就能得到所有进位位: signedSum=(num1 & num2 )<<1
    // (这里一定要带括号，因为<<优先于& )
    // 将这个 signedSum继续与UnsignedSum相加，就会重复上述：
    // 先是无进位相加，再求进位 ......
    // 所以在方法里需要将UnsignedSum赋给num1，将signedSum赋给num2,
    // 直到不产生进位了为止，
    public int Add1(int num1,int num2) {
        //直到不再产生进位
        while (num2!=0)
        {//无进位求和
            int UnsignedSum=num1^num2;
            //求出进位
int signedSum=(num1&num2)<<1;
            num1=UnsignedSum;
num2=signedSum;}
//直到进位num2为0，说明不再产生进位，num1就是最终结果
return num1;
    }

    //写成递归形式
    //第一个参数放无进位相加结果，第二个参数放进位位
    //方法：求两个参数的和
    public int Add(int num1,int num2) {
        if(num2==0) return num1;
      return Add(num1^num2,(num1&num2)<<1);
}}