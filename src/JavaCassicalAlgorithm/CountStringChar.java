package JavaCassicalAlgorithm;

import java.util.Scanner;

/**
 * 题目：输入一行字符，分别统计出其中英文字母、空格、数字和其它字符的个数。 
 * 1.程序分析：利用while语句,条件为输入的字符不为'\n'.
 */
public class CountStringChar {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一行字符，以回车结尾：");
        String str = scanner.nextLine();
        countStrChar(str);
        
    }
    public static void countStrChar(String str) {
        char[] ch = str.toCharArray();
        int charCnt = 0;
        int spaceCnt = 0;
        int digitCnt = 0;
        int otherCnt = 0;
        for (int i = 0; i < ch.length; i++) {
            if (Character.isAlphabetic(ch[i])) {
                charCnt++;
            } else if (Character.isSpaceChar(ch[i])) {
                spaceCnt++;
            } else if (Character.isDigit(ch[i])) {
                digitCnt++;
            } else {
                otherCnt++;
            }
        }
        System.out.println("英文字母数量：" + charCnt);
        System.out.println("空格数量：" + spaceCnt);
        System.out.println("数字数量：" + digitCnt);
        System.out.println("其它字符数量：" + otherCnt);
    }
}
