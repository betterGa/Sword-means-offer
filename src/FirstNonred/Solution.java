package FirstNonred;

import java.util.LinkedHashSet;
import java.util.Set;

//思路：利用Set不允许重复
//每次插入char就入Set中，遇到重复的，需要从Set中删除该元素，这样Set中放置的都是不重复的元素
//第一个不重复的就是Set的第一个元素
public class Solution {
    //Insert one char from stringstream
    Set<Character> set=new LinkedHashSet<>();
    public void Insert(char ch)
    {
if(set.add(ch)==false) set.remove(ch);
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
if(set.isEmpty()) return '#';
        else
{Object[] result=set.toArray();
    return (char)result[0];
    }
}}