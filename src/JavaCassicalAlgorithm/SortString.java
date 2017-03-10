package JavaCassicalAlgorithm;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 题目40：字符串排序。
 *
 */
public class SortString {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("输入字符串");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();
        
        char[] array = input.toCharArray();
        char a =0;
        char b=0;
        for (int i=0; i<array.length;i++){
            for(int j=i+1;j<array.length;j++){
                a = array[i];
                b= array[j];
                if(a>b){
                    array[j]=a;
                    array[i]=b;
                }
            }
        }
        System.out.println(Arrays.toString(array));
        
    }

}
