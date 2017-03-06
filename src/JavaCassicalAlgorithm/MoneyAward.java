package JavaCassicalAlgorithm;

import java.util.Scanner;

/**
 * 题目12：企业发放的奖金根据利润提成。
 * 利润(I)低于或等于10万元时，奖金可提10%；
 * 利润高于10万元，低于20万元时，低于10万元的部分按10%提成，高于10万元的部分，可可提成7.5%；
 * 20万到40万之间时，高于20万元的部分，可提成5%；
 * 40万到60万之间时，高于40万元的部分，可提成3%；
 * 60万到100万之间时，高于60万元的部分，可提成1.5%，
 * 高于100万元时，超过100万元的部分按1%提成，
 * 从键盘输入当月利润I，求应发放奖金总数？ 
 * 1.程序分析：请利用数轴来分界，定位。注意定义时需把奖金定义成长整型。
 *
 */
public class MoneyAward {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("请输入企业利润：");
        Scanner scanner = new Scanner(System.in);
        int money = scanner.nextInt();
        scanner.close();
        countAward(money);
    }

    public static void countAward(int money){
        long bonus=0L;
        double rate1=0.1, rate2=0.075, rate3=0.05, rate4=0.03,rate5=0.015,rate6=0.01;
        if(money<0){
            System.out.println("错误：奖金数额为负数");
            return;
        } else if(money<=100000){
            bonus = (long) (money*rate1);
        } else if(money<=200000){
            bonus = (long) (100000*rate1 + (money-100000)*rate2);
        } else if(money<=400000){
            bonus = (long) (100000*rate1 + 100000*rate2 +(money-200000)*rate3);
        } else if(money<=600000){
            bonus = (long) (100000*rate1 + 100000*rate2 +200000*rate3 + (money-400000)*rate4);
        } else if(money<=1000000){
            bonus = (long) (100000*rate1 + 100000*rate2 +200000*rate3 + 200000*rate4 + (money-600000)*rate5);
        } else if(money >1000000){
            bonus = (long) (100000*rate1 + 100000*rate2 +200000*rate3 + 200000*rate4 + 400000*rate5 + (money-1000000)*rate6);
        }
        System.out.println("奖金数额为：" + bonus);
    }
}
