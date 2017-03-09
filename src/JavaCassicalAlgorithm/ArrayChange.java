package JavaCassicalAlgorithm;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 题目35：输入数组，最大的与第一个元素交换，最小的与最后一个元素交换，输出数组。
 *
 */
public class ArrayChange {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("输入一组数, 以空格分隔");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        String[] strArray = str.split(" ");
        int[] intArray = new int[strArray.length];
        for (int i =0 ;i<strArray.length;i++){
            intArray[i]=new Integer(strArray[i]);
        }
        int max=0,min=0;
        for(int i=1;i<intArray.length;i++){
            if(intArray[i]<intArray[min]){
                min=i;
            }
            if(intArray[i]>intArray[max]){
                max=i;
            }
        }
        int temp;
        temp=intArray[min];
        intArray[min] = intArray[0];
        intArray[0] = temp;
        temp=intArray[max];
        intArray[max] = intArray[intArray.length-1];
        intArray[intArray.length-1] = temp;
        System.out.println(Arrays.toString(intArray));
    }
    
}
