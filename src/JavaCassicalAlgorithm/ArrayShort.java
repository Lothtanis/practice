package JavaCassicalAlgorithm;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 题目30：有一个已经排好序的数组。现输入一个数，要求按原来的规律将它插入数组中。 
 * 1. 程序分析：首先判断此数是否大于最后一个数，然后再考虑插入中间的数的情况，插入后此元素之后的数， 依次后移一个位置。
 *
 */
public class ArrayShort {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] arrOri = {4,5,6,9,10,11,21,25};

        System.out.println("数组 {4,5,6,9,10,11,21,25}，输入一个数后重新排序");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        scanner.close();
        arrayResort(input, arrOri);
        
    }
    
    public static void arrayResort(int a, int[] array){
        int[] newArray = new int[array.length+1];
        for(int i=0;i<array.length;i++){
            if (a<array[i]){
                newArray[i]=a;
                for(int j=i+1;j<=array.length;j++){
                    newArray[j]=array[j-1];
                }
                break;
            } else {
                newArray[i]=array[i];
            }
        }
        System.out.print(Arrays.toString(newArray));
    }

}
