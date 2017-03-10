package JavaCassicalAlgorithm;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 题目44：一个偶数总能表示为两个素数之和。
 *
 */
public class TestEven {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("输入一个偶数");
        Scanner scanner = new Scanner(System.in);
        long input = scanner.nextLong();
        if (input % 2 != 0) {
            System.out.println("输入的非偶数");
        }
        scanner.close();
        judgeEven(getSushu(input), input);

    }

    private static void judgeEven(ArrayList<Long> sushu, long input) {
        // TODO Auto-generated method stub
        for (int i = 0; i < sushu.size(); i++) {
            for (int j = 0; j < sushu.size(); j++) {
                if (input == sushu.get(i) + sushu.get(j)) {
                    System.out.println(input + "=" + sushu.get(i) + "+"
                            + sushu.get(j));
                    return;
                }
            }
        }
    }

    public static ArrayList<Long> getSushu(long num) {
        ArrayList<Long> array = new ArrayList<Long>();
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
                array.add(i);
            }
        }
        return array;

    }

}
