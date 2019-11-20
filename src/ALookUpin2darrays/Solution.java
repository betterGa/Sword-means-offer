package ALookUpin2darrays;
//题目描述
//在一个二维数组中（每个一维数组的长度相同），
// 每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
// 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。


//第一版
//思路：像桶一样，先确定行，在确定列，二分查找。
//问题：运行超时:您的程序未能在规定时间内运行结束，请检查是否循环有错或算法复杂度过大。
//case通过率为0.00%


/*
    public class Solution {
        public boolean Find(int target, int [][] array) {

            //行
int row=array.length;
//列
int column=array[0].length;
//写一个方法，给定数组和数字，可以确定它所在位置
            if(target<array[0][0]||target>array[row-1][column-1]) return false;
            int head=0;
            int tail=row-1;
            while (head!=tail)
            {
                int mid=(head+tail)/2;
                int value=array[mid][0];
                if(target>array[mid][0])
                {head=mid;}
                else tail=mid;
            }
int Row=head;

            head=0;
            tail=column-1;
            int Column=-1;
            while (tail>=head)
            {
                int mid=(head+tail)/2;

                if(target>array[Row][mid])
                {head=mid+1;}
                if(target<array[Row][mid])
                {tail=mid-1;}
                else {Column=mid;break;}
            }


if(Column==-1) return false;
            else return true;

        }
    }

    */

    //题意理解错误了，它不是把一行排完以后，再去排下一行。而是只能保证同一行，从左到右是递增的。
//同一列，从上到下是递增的。
//比如
//    A
//    B C
//只能保证A<B<C


    //第二版
//思路：由A<B<C可知 可以将target与B相比，如果比B小，上移与A比；如果比B大，右移与C比；如果等于B返回true即可。

public class Solution {
    public boolean Find(int target, int [][] array) {

        if(array==null) return false;

        //行
        int row=array.length;
        int column=array[0].length;
        int x=row-1;
        int y=0;

        while (true)
        {
            if(x<0||x>=row||y<0||y>=column){break;}
            if(target<array[x][y]) x=x-1;
            else if(target>array[x][y]) y=y+1;
            else  if(target==array[x][y])return true;
        }

        return false;
    }
}
//已通过。