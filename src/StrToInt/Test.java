package StrToInt;



public class Test {
@org.junit.Test
    public void test1()
{
    char c='0';
    System.out.println((int)c);
}
@org.junit.Test
    public void StrToIntTest()
{
    Solution solution=new Solution();
   // System.out.println(solution.StrToInt("2147483648"));
System.out.println(Integer.MAX_VALUE+1);
System.out.println(-Integer.MAX_VALUE);
System.out.println(Integer.MIN_VALUE);
System.out.println(-Integer.MIN_VALUE);
}

@org.junit.Test
    public void test2()
{
    String str="-1234";
    System.out.println(str.substring(1,5));
    System.out.println((long)(Integer.MIN_VALUE)*-1);
}
}
