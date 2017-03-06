package JavaCassicalAlgorithm;

import java.util.Scanner;

/**
 * 题目8：求s=a+aa+aaa+aaaa+aa...a的值，其中a是一个数字。
 * 例如2+22+222+2222+22222(此时共有5个数相加)，几个数相加有键盘控制。 
 * 1.程序分析：关键是计算出每一项的值。
 *
 */
public class TestAdd {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int cnt=0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入a：");
        int a = scanner.nextInt();
        scanner = new Scanner(System.in);
        System.out.println("请输入相加的数字个数：");
        cnt = scanner.nextInt();
        scanner.close();
        
        testAdd(a, cnt);
    }
    
    public static void testAdd(int a, int cnt){
        long amount =0L;
        for(int i=0;i<cnt;i++){
            amount = (long) (amount + a*Math.pow(10, i)*(cnt-i));
        }
        System.out.print(cnt+"个数相加："+amount);
    }

}
