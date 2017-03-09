package JavaCassicalAlgorithm;

import java.util.Scanner;

/**
 * 题目25：一个5位数，判断它是不是回文数。即12321是回文数，个位与万位相同，十位与千位相同。 
 *
 */
public class HuiWenShu {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("请输入一个正整数");
        Scanner scanner=new Scanner(System.in);
        long input = scanner.nextLong();
        chargeHuiwen(input);
        scanner.close();
    }
    
    public static void chargeHuiwen(Long input){
        char[] arrNum = String.valueOf(input).toCharArray();
        for(int i =0 ; i<arrNum.length/2;i++){
            if (arrNum[i]!=arrNum[arrNum.length-i-1]){
                System.out.println("这不是一个回文数");
                return;
            }
        }
        System.out.println("这是一个回文数");
    }

}
