package JavaCassicalAlgorithm;

import java.util.Scanner;

/**
 * 题目37：有n个人围成一圈，顺序排号。从第一个人开始报数（从1到3报数），凡报到3的人退出圈子，问最后留下的是原来第几号的那位。
 *
 */
public class TestQuitGame {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("输入人数");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        quitGame(n,3);
    }
    
    public static void quitGame(int all, int num){
        int n = all;
        int[] temp = new int[all];
        int i=0;
        int repo =0;
        while(n>1){
            if(temp[i]==0){
                repo++;
                if(repo==num){
                    repo=0;
                    temp[i]=1;
                    n--;
                }
            }
            i++;
            if(i==temp.length){
                i=0;
            }
        }
        for(int j=0;j<all;j++){
            if(temp[j]==0){
                System.out.println("最后留下的是原来第 "+j+1+" 号");
                return;
            }
        }
        
    }

}
