package JavaCassicalAlgorithm;

/**
 * 题目13：一个整数，它加上100后是一个完全平方数，再加上168又是一个完全平方数，请问该数是多少？ 
 * 1.程序分析：在10万以内判断，先将该数加上100后再开方，再将该数加上268后再开方，如果开方后的结果满足如下条件，即是结果。
 *
 */
public class FindNumber {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        for(int i=1;i<100000;i++){
            if (Math.sqrt(i+100)%1==0 && Math.sqrt(i+168)%1==0){
                System.out.print(i);
            }
        }
    }

}
