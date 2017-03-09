package JavaCassicalAlgorithm;

import java.util.Scanner;

/**
 * 题目32：取一个整数a从右端开始的4～7位。 
 * 程序分析：可以这样考虑： 
 * (1)先使a右移4位。 
 * (2)设置一个低4位全为1,其余全为0的数。可用~(~0<<4)
 * (3)将上面二者进行&运算。 
 *
 */
public class Exercise32 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("输入一个大于7位的正整数");
        Scanner scanner = new Scanner(System.in);
        long input = scanner.nextLong();
        if(String.valueOf(input).length()<7){
            System.out.println("输入的数字位数小于7");
            System.exit(0);
        }
        scanner.close();
        // method 1
        int start = String.valueOf(input).length()-7;
        System.out.println("整数a从右端开始的4～7位："+String.valueOf(input).substring(start,start+4));
        
        // method 2
        String strReverse = String.valueOf(reverse(input));
        String cutString = strReverse.substring(3,7);
        System.out.println("整数a从右端开始的4～7位："+reverse(Long.valueOf(cutString)));
        
        
    }

    private static Long reverse(long input) {
        // TODO Auto-generated method stub
        StringBuffer sbBuffer = new StringBuffer(String.valueOf(input));
        return Long.valueOf(sbBuffer.reverse().toString());
    }

}
