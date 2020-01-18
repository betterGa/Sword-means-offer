package FirstNotRepeatingChar;

//在一个字符串(0<=字符串长度<=10000，
// 全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置,
// 如果没有则返回 -1（需要区分大小写）.

import java.util.HashMap;
import java.util.Map;

//分析题意：找到 第一个 只出现一次的字符
//思路：先遍历一遍str。把每个字母与其出现的次数形成一个map
//再遍历一遍，遇到第一个value值为1的返回其位置即可。
public class Solution {
    public int FirstNotRepeatingChar(String str) {

        Map<Character,Integer> map=new HashMap<>();
        char[] traverse=str.toCharArray();
        for(int i=0;i<traverse.length;i++)
        { if(map.get(traverse[i])==null)
            map.put(traverse[i],1);
        else map.put(traverse[i],(int)map.get(traverse[i])+1);
        }

        for(int i=0;i<traverse.length;i++)
        {
            if(map.get(traverse[i])==1)
                return i;
        }

        return -1;
    }
}