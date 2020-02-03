package IsContinuous;

import java.util.Arrays;

//LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...
// 他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！
// “红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....LL不高兴了,他想了想,
// 决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。
// 上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。
// LL决定去买体育彩票啦。 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何，
// 如果牌能组成顺子就输出true，否则就输出false。为了方便起见,你可以认为大小王是0。
public class Solution {
        //思路1：     分情况：
//如果数组都是0或者有4个0.返回true
        //如果数组里没有0，排序后是顺子，返回true
        //如果数组里有1个0，将数组排序，以下情况需要返回true:
        // (1)后四位是顺子
        // (2)[1][2]差2，后两位是顺子
        // (3)[1][2]差1，[2][3]差2，[3][4]差1
        //如果数组里有2个0，将数组排序，以下情况需要返回true:
        // (1)后三位是顺子
        // (2) [2][3]差2. [3][4]差1或2
        // (3) [2][3]差1， [3][4]差2
        // (4) [2][3]差3  .[3][4]差1
        // (5) [2][3]差1   [3][4]差2或3
      //如果数组里有3个0，将数组排序，以下情况需要返回true:
      //(1) 后两位是顺子
      //(2) [3][4]差1，2或3
        public boolean isContinuous1(int [] numbers) {
            Arrays.sort(numbers);
            if(numbers[4]==0||numbers[3]==0) return true;
            if(numbers[2]==0)
            {
                if(SubIsContinuous(numbers,3,4)) return true;
                if(numbers[4]-numbers[3]==1||numbers[4]-numbers[3]==2||numbers[4]-numbers[3]==3||numbers[4]-numbers[3]==4)
                    return true;
                return false;
            }
            if(numbers[1]==0)
            {
                if(SubIsContinuous(numbers,2,4)) return true;
                if(numbers[3]-numbers[2]==2&&(numbers[4]-numbers[3]==2||numbers[4]-numbers[3]==1))
return true;
                if(numbers[3]-numbers[2]==1&&(numbers[4]-numbers[3]==2))
                    return true;
                if(numbers[3]-numbers[2]==3&&(numbers[4]-numbers[3]==1))
                    return true;
                if(numbers[3]-numbers[2]==1&&(numbers[4]-numbers[3]==2||numbers[4]-numbers[3]==3))
                    return true;
                return false;
            }
            if(numbers[0]==0)
            {
               if(SubIsContinuous(numbers,1,4)) return true;
               if(numbers[2]-numbers[1]==2&&SubIsContinuous(numbers,3,4)) return true;
               if(numbers[2]-numbers[1]==1&&numbers[3]-numbers[2]==2&&numbers[4]-numbers[3]==1)
                   return true;
                if(numbers[2]-numbers[1]==1&&numbers[3]-numbers[2]==1&&numbers[4]-numbers[3]==2)
                    return true;
               return false;
            }
            return SubIsContinuous(numbers,0,4);
    }
    //提供个方法判断是否顺子
    public boolean SubIsContinuous(int[] sub,int start,int end)
    {
        for(int i=end;i>start;i--)
        {
            if(sub[i]-sub[i-1]!=1) return false;
        }
        return true;
    }

    //思路二：数组排序后，从后向前依次求相邻数字之间的间隔数，
    //与0的个数作比较，如果0变过来够，就返回true
    public boolean isContinuous(int [] numbers) {
            int length=numbers.length;
            if(length==0) return false;
            Arrays.sort(numbers);
            //0的个数
int sizeOfZero=0;
for(int i=length-1;i>=0;i--)
{
    if(numbers[i]==0) sizeOfZero++;
}
if(sizeOfZero==0)
{if(interval(numbers,0,length-1)==0) return true;
else return false;}
int start=sizeOfZero;
if(sizeOfZero>=interval(numbers,start,length-1)) return true;
else return false;
    }
//返回额外的间隔数
    public int interval(int[] numbers,int start,int end)
    {int intervals=0;
        for(int i=end;i>start;i--)
        {if(numbers[i]==numbers[i-1]) return 5;
            intervals=intervals+numbers[i]-numbers[i-1];
        }
        return intervals-(end-start);
    }

}