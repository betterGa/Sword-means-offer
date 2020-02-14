package Match;

public class Solution {
    // Java实现，已通过。递归求解。运行时间：24ms，占用内存：9548k。
    // 这道题... ... 好然。主要是理解题意： “匹配” 。 字符串"aaa" 与 模式"a.a"匹配，
    // 但是"aaa" 与"aa.a"不匹配，
    // 因为遍历 “aa.a” 走到 "." 时，字符串 “aaa” 已经与之匹配完毕，
    // 但是模式串还剩个 "a" ，所以匹配失败。
    // 因此，与之前遇到的“aaa” 是 “aaaaa” 的子串不同，
    // 这道题的模式匹配是：一定要把模式串遍历完毕的，如果模式串有剩余，那就匹配失败。
    //   （这里的“遍历”是指，将两个数组的字符进行挨个匹配了。对于个体来说是相同字符。）
    //当模式串遍历完毕时，如果字符串也遍历完毕，OK 匹配成功。
    // 当模式串遍历完毕时，如果字符串还没遍历完，匹配失败。
    // 而如果以字符串遍历完毕与否为标准：当字符串遍历完毕时，如果模式串没有遍历完毕，
    // 匹配成功与否是不一定的：比如，字符串 “ab” 与模式串 “ ac*b ”是匹配成功的，
    // 而与模式串 "abc "是匹配失败的。
    //也就是说  匹配成功意味着:字符串 str 遍历到末尾,同时 模式串 pattern 也遍历到末尾;
    // 但是并不意味着模式串 pattern的最后一个字符和 字符串 str 的最后一个字符匹配。
    //方法中传入两个字符数组与分别的下标，进行挨个匹配，返回两个字符匹配结果。

    // 1.如果 模式串对应的字符 的下一个是 " * ", 而且模式串的当前这个字符可以与字符串的字符匹配，
    // 根据模式串的当前这个字符可以匹配到几个字符，可能有以下几种配对方式：
    //比如 模式串是“ ab* c” ,当前遍历到 "b" 了
    //（1）字符串是 "ac"  ,这时 “*” 匹配到 0 个字符。
    // 即 结果是 match(str, srtIndex,pattern,pattern+2),
    // 也就是说 “b*” 是没有用的，需要往后跳 2 个，继续去向后遍历、匹配。
    //（2）字符串是 "abc"  ,这时 “*” 匹配到 1 个字符。
    // 即 结果是 match(str, srtIndex+1,pattern,pattern+2) 。
    //      （3）字符串是 "abbbbbc"  ,这时 “*” 匹配到 5 (多个 )个字符。
    // 即 结果是 match(str, srtIndex+1,pattern,pattern),也就是等同于 字符串再继续向后遍历。
    //以上 3 种情况用 或 || 联系即可。
    //如果模式串的当前这个字符不能与字符串的字符，要注意 “ * 表示它前面的字符可以出现任意次（包含0次）” 也就是说 “ ab* c” 可以是 "ac" 的，需要给模式串往后跳 2 格，继续匹配。

    //      2.如果 模式串对应的字符 的下一个不是 " * ",
    // （注意，如果到了下标是长度-1 ，也就是 char 数组最后一个，下标+1 是会越界的，正好最后一个了，
    // 也不会遇到 “*” 了，所以
    //    (patIndex==patLen-1||pattern[patIndex+1]!='*')
    //应该放一起。）当匹配串当前字符为 "."，可以匹配任意字符；或者两个字符相同时，
    // 结果为两个下标分别+1  去看匹配结果，否则，得返回 false。
    //再有，1.2 之前都应先判断匹配串历完毕的情况，如果此时字符串未遍历完，匹配失败；
    //如果此时字符串遍历完，匹配成功。
    //在1.2 中，对于1 ，还可能出现字符串未遍历完，但是匹配成功的情况，
    // 因为 * 可以表示0次数呀，比如 “abcdefg” 与 "“abcdefgh* ",
    // 这时返回的结果是 :match(str, srtIndex,pattern,pattern+2) 。​
    //对于2 ，肯定是匹配失败了，眼看着匹配串多出来了，
    // 而且还没有 * 表示 0 次数可以让前面的字符消失。
    //代码如下：
    //思路：递归求解

  
        //思路：递归求解
        public boolean match(char[] str, char[] pattern)
        {

            if(str==null||pattern==null) return false;

            return match(str,0,pattern,0);}


        //
        public boolean match(char[] str, int strIndex,char[] pattern,int patIndex)
        {
            int strLen=str.length;
            int patLen=pattern.length;

//如果模式串遍历完，而str 也完，应当返回 true
            if(patIndex==patLen&&strIndex==strLen) {
                return true;}
//如果模式串遍历完，而str 没完，应当返回 false
            if(patIndex==patLen&&strIndex!=strLen)
            {return false;}


            //接下来都是 模式串没完的情况


            //当模式串当前的下一个字符不为 "*" 时或走到模式串的最后一个下标处
            if(patIndex==patLen-1||pattern[patIndex+1]!='*')
            {
                if(strIndex==strLen) return false;
                //当匹配串当前字符为 "."，可以匹配任意字符，
                //匹配串与字符串同时后移1
                if(pattern[patIndex]=='.'||pattern[patIndex]==str[strIndex])
                    return match(str,strIndex+1,pattern,patIndex+1);
                else return false;
            }
            //当匹配串当前的下一个字符为 "*" 时
            else {
                //字符串走完了
                if(strIndex==strLen)
                    return match(str,strIndex,pattern,patIndex+2);
                if(pattern[patIndex]=='.'||str[strIndex]==pattern[patIndex])
                    //如果字符串当前字符与匹配串相等
                    //if (str[strIndex] == pattern[patIndex] || pattern[patIndex] == '.') {
                    //如果下一个字符"*"匹配了0个字符
                    //比如： ab*cd 与 abcd,   patIndex+2，strIndex+1
                    //如果下一个字符"*"匹配了1个字符
                    //比如： ab*cd 与 abbcd,   patIndex+2，strIndex+2
                    //如果下一个字符"*"匹配了多个字符
                    //比如： ab*cd 与 abbcd,   patIndex，strIndex+1
                    return match(str, strIndex + 1, pattern, patIndex + 2) ||
                            match(str, strIndex , pattern, patIndex + 2) ||
                            match(str, strIndex + 1, pattern, patIndex);

                else return match(str,strIndex,pattern,patIndex+2);

            }
        }
    }
