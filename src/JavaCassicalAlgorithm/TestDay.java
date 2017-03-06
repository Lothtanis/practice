package JavaCassicalAlgorithm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * 题目14：输入某年某月某日，判断这一天是这一年的第几天？ 
 * 1.程序分析：以3月5日为例，应该先把前两个月的加起来，然后再加上5天即本年的第几天，特殊情况，闰年且输入月份大于3时需考虑多加一天。
 * @author bw
 *
 */
public class TestDay {

    public static void main(String[] args) throws ParseException {
        // TODO Auto-generated method stub
        System.out.println("请输入要计算的日期，格式如“20170306”：");
        Scanner scanner = new Scanner(System.in);
        String strDate = scanner.nextLine();
        scanner.close();
        countDayInYear(strDate);
    }
    public static void countDayInYear(String strDate) throws ParseException{
        SimpleDateFormat  df =new SimpleDateFormat ("yyyyMMdd");
        Date date = df.parse(strDate);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int dayCnt=0;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int month = cal.get(Calendar.MONTH+1);
        int year = cal.get(Calendar.YEAR);
        
        switch (month) {
        case 12:
            dayCnt+=30;
        case 11:
            dayCnt+=31;
        case 10:
            dayCnt+=30;
        case 9:
            dayCnt+=31;
        case 8:
            dayCnt+=31;
        case 7:
            dayCnt+=30;
        case 6:
            dayCnt+=31;
        case 5:
            dayCnt+=30;
        case 4:
            dayCnt+=31;
        case 3:
            if(year%4==0){
                dayCnt+=29;
            } else {
                dayCnt+=28;
            }
        case 2:
            dayCnt+=31;
        case 1:
            dayCnt+=day;

        default:
            System.out.print("日期错误");
        }
        System.out.println("这一天是这一年的第"+dayCnt+"天");
        System.out.println("这一天是这一年的第"+cal.get(Calendar.DAY_OF_YEAR)+"天");
    }
}
