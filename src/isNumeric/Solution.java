package isNumeric;

import java.util.ArrayList;

//请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
// 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
// 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
public class Solution {
    public boolean isNumeric(char[] str) {
        ArrayList<Character> Numlist=new ArrayList<>();
        for(int i=0;i<10;i++)
        Numlist.add((char)('0'+i));
        //标记小数点次数
        int pointCount=0;
        int PorM=0;
        for(int j=0;j<str.length;j++)
        {char c=str[j];
            //小数点超过一次不是数字
            if(pointCount==2||PorM==2) return false;

            if(Numlist.contains(c)) continue;
            if(c=='.') {pointCount++;continue;}

            if(c=='+'||c=='-')
            {
                //若j不为0，而且[j-1]不是E、e,比如 1+23,不是数字
                if(j!=0&&(str[j - 1] != 'E' && str[j - 1] != 'e')) return false;

                //若j为0,即
                if (j==0||(str[j - 1]!='E'&& str[j - 1] != 'e'))
                {PorM++;}
                continue;
            }



            //遇到不是数字的字母
//遇到除e、E以外的字母不是数字
if(c != 'E' &&c!= 'e') return  false;
        //遇到e、E要保证E后面不能带小数点
         if(j==str.length-1) return false ;
         else pointCount=1;
        }
    return true;
}}