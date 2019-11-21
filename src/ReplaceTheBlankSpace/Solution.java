package ReplaceTheBlankSpace;

//题目：替换空格
// 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
// 例如，当字符串为We Are Happy.
// 则经过替换之后的字符串为We%20Are%20Happy。


//版本一：调用库函数。
//但是面试应该不是考对库函数的熟练程度

/*
public class Solution {
    public String replaceSpace(StringBuffer str) {
for(int i=0;i<str.length();i++) {
    if (str.charAt(0)==' ')
    {
        str.replace(i,i+1,"%20");
    }
}
return str.toString();


    }
}
*/


//版本二：
//思路：新开辟一个空间char[ ],
// 从后开始遍历原字符串，第一次，遇到' '，就给原长度+2；
// 第二次遍历，遇到' ',就给新字符串依次append‘0’‘2’‘%’，如果遇到的是字母，拷贝即可。

public class Solution {
    public String replaceSpace(StringBuffer str) {
        int oldLength=str.length();
        int newLength=oldLength;

for(int i=0;i<str.length(); i++)
{
    if(str.charAt(i)==' ')
        newLength=newLength+2;
}

str.setLength(newLength);

        int k=newLength-1;
        for(int j=oldLength-1;j>=0;j--)
{
    if(str.charAt(j)==' ')
    {str.setCharAt(k--,'0');
    str.setCharAt(k--,'2');
    str.setCharAt(k--,'%');
    }

else str.setCharAt(k--,str.charAt(j));
    }
    return str.toString();
}}

//已通过>