package JavaCassicalAlgorithm;

import java.util.Scanner;

/**
 * 题目45：判断一个素数能被几个9整除???不能整除
 * @author bw
 *
 */
public class TestPrime {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("输入一个素数");
        Scanner scanner = new Scanner(System.in);
        long input = scanner.nextLong();
//        scanner.close();
        if(!isSushu(input)){
            System.out.println("输入的非素数");
            System.exit(0);
        }

        System.out.println("输入除数");
        int divide = scanner.nextInt();
        scanner.close();
        TestPrimeDivide(input,divide);
    }
    
    private static void TestPrimeDivide(long input, int divide) {
        // TODO Auto-generated method stub
        int cnt=0;
        long temp=input;
        while(temp>divide){
            if(temp%divide==0){
                temp=temp/divide;
                cnt++;
            }else{
                System.out.println("该数不能被"+divide+"整除");
                return;
            }
        }
        System.out.println("该数能被"+cnt+"个"+divide+"整除");
    }

    public static boolean isSushu(long n) {
        boolean sushuFlag = true;
        sushuFlag = true;
        for (long j = 2; j <= (int) Math.sqrt(n); j++) {
            if (n % j == 0) {
                sushuFlag = false;
                break;
            }
        }
        return sushuFlag;
    }

}
