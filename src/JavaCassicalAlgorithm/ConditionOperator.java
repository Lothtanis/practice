package JavaCassicalAlgorithm;

import java.util.Scanner;

/**
 * 题目5：利用条件运算符的嵌套来完成此题：学习成绩>=90分的同学用A表示，60-89分之间的用B表示，60分以下的用C表示。
 * 1.程序分析：(a>b)?a:b这是条件运算符的基本例子。
 */
public class ConditionOperator {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int x;
        String grade;
        Scanner s = new Scanner(System.in);
        System.out.println("请输入一个成绩：");
        x = s.nextInt();
        getGrade(x);
    }
    
    public static void getGrade(int scores){
        System.out.print(scores >= 90 ? "A" : scores >= 60 ? "B" : "C");
    }

}
