package JavaCassicalAlgorithm;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 题目33：打印出杨辉三角形（要求打印出10行如下图） 
 * 1.程序分析：           
     1
    1 1
   1 2 1
  1 3 3 1
 1 4 6 4 1
1 5 10 10 5 1
 */
public class YangHuiSanJiao {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("输入需要打印的杨辉三角层数");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        printYanghui(input);
        scanner.close();
    }

    public static void printYanghui(int line) {
        for (int i = 1; i <= line; i++) {
            String strYanghui = Arrays.toString(yanghui(i));
            String string = padString(strYanghui, line - i, " ");
            System.out.println(string);
        }
    }

    public static int[] yanghui(int line) {
        int[] yanghui = new int[line];
        yanghui[0] = 1;
        yanghui[line - 1] = 1;
        for (int i = 1; i < line - 1; i++) {
            yanghui[i] = yanghui(line - 1)[i - 1] + yanghui(line - 1)[i];
        }
        return yanghui;
    }

    public static String padString(String str, int sumLen, String padString) {
        // int spaceCnt = (int) Math.ceil((double)sumLen/2);
        // for (int j=1; j <spaceCnt+1;j++){
        // str = padString+str +padString;
        // }
        for (int j = 1; j < sumLen + 1; j++) {
            str = padString + str;
        }
        return str;
    }

}
