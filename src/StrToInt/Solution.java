package StrToInt;
//题目描述
//将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。
// 数值为0或者字符串不是一个合法的数值则返回0
//输入描述:
//输入一个字符串,包括数字字母符号,可以为空
//输出描述:
//如果是合法的数值表达则返回该数字，否则返回0
import java.util.Scanner;
//输入
//+2147483647
//    1a33
//输出
//2147483647
//    0

public class Solution {
    public int StrToInt(String str) {
        Integer.parseInt(str);
        if(str==null||str.length()==0) return 0;
char[] chars=str.toCharArray();
if(chars[0]=='-')
{String subStr=str.substring(1,str.length());
    if(StrToLong(subStr)>(long)Integer.MIN_VALUE*-1) return 0;
    else return (int)StrToLong(subStr)*-1;}
 else if(chars[0]=='+')
        {str=str.substring(1,str.length());}
            if(StrToLong(str)>(long)Integer.MAX_VALUE) return 0;
            else return (int)StrToLong(str);}

   public long StrToLong(String str)
   {long result=0;
       char[] chars=str.toCharArray();
       for (int i=0;i<chars.length;i++)
       { if(chars[i]>'9'||'0'>chars[i])
       {return 0;}
           result=(long)result*10+(chars[i]-'0'); }
       return result;
   }
}