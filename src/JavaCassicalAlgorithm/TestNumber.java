package JavaCassicalAlgorithm;

import java.util.Scanner;

/**
 * 题目24：给一个不多于5位的正整数，要求：一、求它是几位数，二、逆序打印出各位数字。
 *
 */
public class TestNumber {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("请输入一个不多于5位的正整数");
        Scanner scanner=new Scanner(System.in);
        long input = scanner.nextLong();
        
        charge(input);
        
    }

    private static void charge(long input) {
        // TODO Auto-generated method stub
        
    }

}
