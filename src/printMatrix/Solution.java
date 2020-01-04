package printMatrix;
/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */


//思路：考虑坐标的变化，确实是有规律的，但是程序不好写，把自己绕死了。
//参考了评论，【旋转魔方】每次打印第一行，然后就不管这一行了
//把矩阵逆时针旋转90°，再打印第一行，直到矩阵为空
//妙得很。
//我试一下
import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> result=new ArrayList<Integer>();
        if(matrix[0].length==1)
        {
            for(int j=0;j<matrix.length;j++)
            {result.add(matrix[j][0]);}
        }
        //当列数不为1时，就需要旋转
while (matrix.length!=1)
{
    for (int i=0;i<matrix[0].length;i++)
    {
       result.add(matrix[0][i]);
    }
    matrix=RotatingCube(matrix);
}

//这时就剩下一列了，把这一列的按顺序加到result里即可。
        for(int k=0;k<matrix[0].length;k++)
        {result.add(matrix[0][k]);}

return result;
    }

    //传入需要旋转的矩阵
    //要转的总是传进来的去掉第一行
    public int[][] RotatingCube(int[][] matrix)
    {
int oldrow=matrix.length;
int oldcol=matrix[0].length;
int newrow=oldcol;
int newcol=oldrow-1;
int[][]temp=new int[newrow][newcol];
//遍历少一行的matrix数组，把逆时针结果放进temp数组中
        int trow=newrow-1;
        int tcol=-1;
        for(int i=1;i<matrix.length;i++)
        {
            tcol++;
            trow=newrow-1;
            for(int j=0;j<matrix[0].length;j++)
        {
temp[trow][tcol]=matrix[i][j];
trow--;
    }
}
return temp;}}

/**
 * 链接：https://www.nowcoder.com/questionTerminal/9b4c81a02cd34f76be2659fa0d54342a?f=discussion&toCommentId=5188454
 * 来源：牛客网
 *
 * Java实现，已通过，运行时间：30ms，占用内存：9444k。
 * 刚开始想这道题的题的时候，我的思路是找规律，从左到右、再从上到下，再从右到左，从下到上......
 * 确实是有规律的，但是规律不好写，太绕了。
 * 参考了评论中大神的【旋转魔方算法】的思路，妙的很，每次取第一行，然后一逆时针旋转90°，
 * 这样也就不用去考虑坐标是从大到小，还是从小到大，是和上一个方向终止点值相等，
 * 还是和终止点值差1的问题，反正一旋转，转完取第一行，做同等处理即可。
 *   不过我没有像评论中用递归求解。
 *   具体思路是这样的：新建ArrayList类型的变量result用来存储结果，每次先将数组的第一行元素都添加到result中，提供了个方法用来旋转数组，将传入的数组去掉第一行（只是不对第一行进行处理，并不是真的去掉。）后逆时针旋转90°。以题目中的{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}}为例，首先会将{1,2,3,4}存入result,然后需要将这个数组传入，旋转后的结果为
 * {{8,12,16}
 *  {7,11,15}
 *  {6,10,14}
 *  {5,9, 13}}
 *   要把这个新的数组结果赋给matrix的。
 *   循环这样的操作，直到剩下的数组只有一列了，
 *   这时候没必要再麻烦地旋转，直接把这一列按顺序加到result，
 *   和不停地旋转这一列的效果是一样的。
 */