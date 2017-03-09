package JavaCassicalAlgorithm;

import java.util.Scanner;

/**
 * 题目26：请输入星期几的第一个字母来判断一下是星期几，如果第一个字母一样，则继续 判断第二个字母。 
 * 1.程序分析：用情况语句比较好，如果第一个字母一样，则判断用情况语句或if语句判断第二个字母。
 *
 */
public class TestDayOfWeek {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("请输入星期几的第一个字母");
        Scanner scanner=new Scanner(System.in);
        String charWeek = scanner.nextLine();
        if(!chargeDayOfWeek(charWeek.toUpperCase().toCharArray())){
            System.out.println("请输入星期几的第二个字母");
            charWeek = charWeek + scanner.nextLine();
            chargeDayOfWeek(charWeek.toUpperCase().toCharArray());
        }
        scanner.close();
    }

    public static boolean chargeDayOfWeek( char[] character){
            switch (character[0]) {
            case 'M':
                System.out.println("星期一");
                break;
            case 'W':
                System.out.println("星期三");
                break;
            case 'F':
                System.out.println("星期五");
                break;
            case 'T':
                if(character.length>1){
                    switch(character[1]){
                        case 'U':
                            System.out.println("星期二");
                            break;
                        case 'H':
                            System.out.println("星期四");
                            break;
                    }
                    break;
                } else {
                    return false;
                }
            case 'S':
                if(character.length>1){
                    switch(character[1]){
                        case 'A':
                            System.out.println("星期六");
                            break;
                        case 'U':
                            System.out.println("星期日");
                            break;
                    }
                    break;
                } else {
                    return false;
                }
            }
            return true;
        }         
}
