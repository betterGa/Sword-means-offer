package jumpFloor;

//一只青蛙一次可以跳上1级台阶，也可以跳上2级。
// 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
//动态规划

//思路：和变态青蛙跳台阶很像，又不完全一样。
//一个台阶只有一种跳法：一次跳一个。
//两个台阶有两种跳法：一次跳一个再一次跳一个；一次跳两个。
//三个台阶有两种方法，第一种：跳两个台阶，这时再跳一个即可。
                   //第二种：跳一个台阶，这时再跳两个即可。
//因此跳三个台阶的方法数等于跳两个台阶的方法数+跳一个台阶的方法数。
//同理，跳四个台阶的方法数就等于跳两个台阶（再一次跳两个即可）的方法数+跳三个台阶的方法数（再一次跳一个即可）
//动态规划算法，设置方法数数组

public class Solution {

    public int JumpFloor(int target) {
        if(target<=2) return target;
        int method[]=new int[target+1];
method[1]=1;
method[2]=2;
//为方法数数组挨个赋值
for(int i=3;i<=target;i++)
{method[i]=method[i-1]+method[i-2];
}
    return method[target];
    }
}
