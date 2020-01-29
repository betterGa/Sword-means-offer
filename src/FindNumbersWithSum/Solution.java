package FindNumbersWithSum;
import java.util.ArrayList;
import java.util.ArrayList;
public class Solution {

    //输入一个递增排序的数组和一个数字S，
    // 在数组中查找两个数，使得他们的和正好是S，
    // 如果有多对数字的和等于S，输出两个数的乘积最小的。
    public ArrayList<Integer> FindNumbersWithSum1(int [] array,int sum) {

        if(array==null||array.length==0) return new ArrayList();
        int minProduct=0;
        int product=0;
        ArrayList<Integer> result=new ArrayList<>(2);
//思路1：已通过，两个指针，一个从前往后遍历，一个从后往前遍历,总是后去靠近前
        int left=0;
        int right=array.length-1;
        while (left!=array.length-1)
        {while (left!=right)
        {if(left==array.length-1) return null;
            if(array[left]+array[right]==sum)
            { product=array[left]*array[right];
                if(minProduct==0) {minProduct=product;
                    result.add(array[left]);
                    result.add(array[right]);
                    break;}
            }
            right--;
        }
            left++;
            right=array.length-1;}
        return result;
    }

//思路2：参考了高赞评论，左右家逼，基于已排序数组的特点，对思路1进行优化
public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
    if(array==null||array.length==0) return new ArrayList();
    int product=0;
    ArrayList<Integer> result=new ArrayList<>(2);
    int left=0;
    int right=array.length-1;
    while (left!=right)
    {
        if(array[left]+array[right]==sum)
        { result.add(array[left]);
            result.add(array[right]);
            break;}
        else{if(array[left]+array[right]>sum)
            right--;
        else left++;
        }
    }
    return result;
}

}