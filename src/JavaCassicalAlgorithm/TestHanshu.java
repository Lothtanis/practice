package JavaCassicalAlgorithm;

import java.util.Scanner;

/**
 * 题目39：编写一个函数，输入n为偶数时，调用函数求1/2+1/4+...+1/n,当输入n为奇数时，
 * 调用函数 1/1+1/3+...+1/n(利用指针函数)
 *
 */
public class TestHanshu {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("输入n");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        scanner.close();
        double sum =0;
        if(input%2==0){
            for(int i=1;i<=input/2;i++){
                sum = sum+(double)1/(i*2);
            }            
        } else {
            for(int i=0;i<=input/2;i++){
                sum = sum+(double)1/(i*2+1);
            }    
        }
        System.out.println("sum = "+sum);

    }

}
