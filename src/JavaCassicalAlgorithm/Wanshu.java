package JavaCassicalAlgorithm;

/**
 * 题目9：一个数如果恰好等于它的因子之和，这个数就称为"完数"。例如6=1＋2＋3.编程 找出1000以内的所有完数。
 * 如果一个数恰好等于它的因子之和，则称该数为“完全数”。
 * 各个小于它的约数（真约数,列出某数的约数，去掉该数本身，剩下的就是它的真约数）的和等于它本身的自然数叫做完全数（Perfect number），
 * 又称完美数或完备数。
 */
public class Wanshu {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        getAll(1000);

    }
    
    public static void getAll(int ceil){
        System.out.print("1-" + ceil + "的完数：");
        for (int num = 2; num <= ceil; num++) {
            int j = 2;
            int thisNum = num;
            int addCnt = 1;
            while (j < thisNum) {
                if (thisNum % j == 0) {
                    addCnt = addCnt + j;
//                    thisNum = thisNum / j;
                    j++;
                } else {
                    j++;
                }
            }
            if(addCnt==num){
                System.out.print(num+" ");
            }
        }
    }

}
