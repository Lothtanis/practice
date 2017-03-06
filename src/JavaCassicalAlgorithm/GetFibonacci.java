package JavaCassicalAlgorithm;

/**
 * 题目1：古典问题：有一对兔子，从出生后第3个月起每个月都生一对兔子，小兔子长到第三个月后每个月又生一对兔子，
 *           假如兔子都不死，问每个月的兔子总数为多少？ 
 * 1.程序分析： 兔子的规律为数列1,1,2,3,5,8,13,21....
 */
public class GetFibonacci {

    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.print(fib(7));
    }    
    
    /**
     * 斐波那契数列
     * @param month
     * @return
     */
    public static int fib(int month){
        if(month == 1 || month == 2){
            return 1;
        }else{
            return fib(month-1)+fib(month-2);
        }
    }
}
