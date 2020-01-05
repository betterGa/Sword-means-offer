package VerifySquenceOfBST;

import java.util.Arrays;
import java.util.Stack;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。
 * 假设输入的数组的任意两个数字都互不相同。
 */

//参考了评论的思路，二叉搜索树的中序遍历结果会是从小到大即升序，
    //而之前刷的一道题，“栈的压入、弹出序列”，
// 这道题可以转化成：已知压入序列为升序即二叉搜索树中序遍历的结果，
    //判断这个“后序遍历”能否为弹出序列。
    //太秀了这个。
/*
public class Solution {
    public boolean VerifySquenceOfBST(int [] sequence) {
       int[]origin=Arrays.copyOfRange(sequence,0,sequence.length);
Arrays.sort(sequence);
return IsPopOrder(sequence,origin);}

//提供一个方法，已知压栈序列，判断能否是出栈序列
public boolean IsPopOrder(int [] pushA,int [] popA) {
    Stack<Integer> stack=new Stack<Integer>();
    int tag=0;
    for(int i=0;i<pushA.length;i++) {
        stack.push(pushA[i]);
        if(stack.peek()==popA[tag])
        {stack.pop();
            tag++;} }
    while (tag!=popA.length&&!stack.isEmpty())
    {if(stack.peek()==popA[tag])
    {stack.pop();
        tag++;}
    else {break;}}
    return stack.isEmpty();
}




    }
    /*
    public boolean judged(int[] pushA,int[] popB)
    {
        Stack<Integer> stack=new Stack<Integer>();
        //第一个元素先进栈
        stack.push(pushA[0]);
        int i=0;
        int j=1;
        while (i!=popB.length)
        {int comp=stack.peek();
        //如果值相等，需要出栈,向后遍历popB的元素
            if(comp==popB[i])
            {
                stack.pop();
                i++;
            }
            //如果值不相等，需要入栈
            else
            {
                stack.push(pushA[j++]);
            }

        }
        //当popB中元素遍历完毕，如果stack为空，返回true即可
        return stack.isEmpty();

    }
    */



public class Solution {

    //判断第二个序列是否可能为第一个序列的弹出顺序,引用的“栈的压入、弹出序列”题目的答案
    public boolean VerifySquenceOfBST(int [] seq) {
        int[] arr = seq.clone();
        Arrays.sort(arr);
        return IsPopOrder(arr,seq);}

    //提供一个方法，已知压栈序列，判断能否是出栈序列
    //可是这个不能直接拷贝那道题里的，
    //比如sort之后的序列是{4,6,8,10,12,14,16}
    //而需要判断的后序序列是{4,8,6,12,16,14,10}
    //开头的{4,6,8}和{4,8,6}从局部来看就是符合入栈、出栈的。
    //而我写的那个是整个大块是否符合，
    //那么开始给stack里"4"进栈，与popA中第一个元素“4”值相等，
    // 那么"4"出栈了，然后“6”进栈stack，与popA中第二个元素"8"值不相等，
    // 然后"8"进栈stack，与popA中第二个元素"8"值相等，
    // 这时"8"出栈，而这时按照我的写法，是该让新的“10”进栈stack了，
    // 可是popA的tag永远停在"6",后续stack不断进栈，tag却动弹不得，
    // 也就是说如果只传入{4,6,8}与{4,8,6}，OK，fine，可以，
    // 但是如果是包含{4,6,8}与{4,8,6},完球了，它会把后面的判度都阻塞了导致错误。
    // 那道题里不像二叉搜索树的中序、后序遍历，它就是单纯看能否进出栈，
    // 而树的这道题存在局部与整体序列的问题。
    // 所以这道题中，每次值相等了出栈完应当再看看stack中是否还有元素，
    // 有的话需要和当前tag指向的元素作比较呢。


        public boolean IsPopOrder(int [] pushA,int [] popA) {
            Stack<Integer> stack=new Stack<Integer>();
            int tag=0;
            stack.push(pushA[0]);
            for(int i=1;i<pushA.length;i++) {
                if(stack.peek()==popA[tag])
                {stack.pop();
                    tag++;
                    //这里加一条，判断一下。
                    while(!stack.isEmpty()&&stack.peek()==popA[tag])
                    {stack.pop();
                        tag++;
                        if(tag==popA.length)break;}
                }
                stack.push(pushA[i]);
            }
            while (tag!=popA.length&&!stack.isEmpty())
            {if(stack.peek()==popA[tag])
            {stack.pop();
                tag++;}
            else {break;}}
            return stack.isEmpty();
        }
    }

    //已通过，运行时间：16ms，
//占用内存：9536k