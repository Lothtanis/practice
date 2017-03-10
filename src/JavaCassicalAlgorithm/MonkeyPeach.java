package JavaCassicalAlgorithm;

import java.util.Scanner;

/**
 * 题目41：海滩上有一堆桃子，五只猴子来分。
 * 第一只猴子把这堆桃子凭据分为五份，多了一个，这只猴子把多的一 个扔入海中，拿走了一份。
 * 第二只猴子把剩下的桃子又平均分成五份，又多了一个，它同样把多的一个扔入海中 ，拿走了一份，
 * 第三、第四、第五只猴子都是这样做的，问海滩上原来最少有多少个桃子？ 
 *
 */
public class MonkeyPeach {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("输入猴子数");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sum=1;
        for(int i=0;i<n;i++){
            System.out.println("第"+(n-i)+"只猴子拿了"+sum+"个桃子");
            sum=n*sum+1;
        }
        System.out.println("海滩上原来最少有"+sum+"个桃子");
    }

}
