package Permutation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

//输入一个字符串,按字典序打印出该字符串中字符的所有排列。
// 例如输入字符串abc,
// 则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。

//思路：一条路走到黑，再回退，深度优先搜索
            //参考三个盒子放扑克牌的问题
public class Solution {

    public ArrayList<String> Permutation(String str) {
ArrayList<String> resultlist=new ArrayList<>();
if(str.length()==0) return resultlist;
//先将该字符串按顺序排列
        char[] origin=str.toCharArray();
        char[] result=new char[origin.length];
        Arrays.sort(origin);
       int num=origin.length;
       //book数组用于标志字符是否放置过/是否还可被放置
       int[]book=new int[num];
       //先给num个盒子第一次从小到大按顺序放置字符
       { putInto(origin,0,num,book,result,resultlist);}
Set<String> strings=new LinkedHashSet<>(resultlist);
return new ArrayList<>(strings);


    }
       //放置方法，将字母从小到大地放置到“盒子”中
        public void putInto(char[] origin,int box,int num,int[] book,char[] result,ArrayList<String> resultlist)
        {
            //走到超出一个盒子时,需要把上一轮结果加到resultList中。
            if(box==num)
            { resultlist.add(String.copyValueOf(result));
                //然后回退
                return;
                }
            //保证从小到大
       for(int i=0;i<num;i++)
       {
           //book[i]==0说明该字符还未被放置
if(book[i]==0) {
    result[box] = origin[i];
//放置以后需要把book[i]置为1
book[i]=1;
    //接着去放下一个
    putInto(origin,box+1,num,book,result,resultlist);
    book[i]=0;
}

       }
            return;
    }


}