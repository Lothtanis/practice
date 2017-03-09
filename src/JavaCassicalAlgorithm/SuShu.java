package JavaCassicalAlgorithm;

import java.util.Scanner;

/**
 * 题目27：求100之内的素数 1.程序分析：判断素数的方法：用一个数分别去除2到sqrt(这个数)，如果能被整除， 则表明此数不是素数，反之是素数
 */
public class SuShu {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("求0~x之内的素数");
        Scanner scanner = new Scanner(System.in);
        long input = scanner.nextLong();
        isSushu(input);
        scanner.close();
    }

    public static void isSushu(long num) {
        boolean sushuFlag = true;
        for (long i = 1; i < num; i++) {
            sushuFlag = true;
            for (long j = 2; j <= (int) Math.sqrt(i); j++) {
                if (i % j == 0) {
                    sushuFlag = false;
                    break;
                }
            }
            if (sushuFlag) {
                System.out.print(i + "  ");
            }
        }

    }

}
