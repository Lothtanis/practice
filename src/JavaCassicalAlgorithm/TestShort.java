package JavaCassicalAlgorithm;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 题目28：对10个数进行排序 
 * 1.程序分析：可以利用选择法，即从后9个比较过程中，选择一个最小的与第一个元素交换， 下次类推，即用第二个元素与后8个进行比较，并进行交换。
 *
 */
public class TestShort {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
//        int[] array2 = {5,8,7,6,1,9,4,2,3};
//        compareArray(array2);
//        System.out.println("输入一组数, ctrl+z结束");
//        Scanner scanner = new Scanner(System.in);
////        ArrayList<Short> array = new ArrayList<Short> ();
//        Vector<Short> v = new Vector<Short>();
//        while(scanner.hasNextShort()){
////            array.add(scanner.nextShort());
//            v.add(scanner.nextShort());
//        }
        System.out.println("输入一组数, 以空格分隔");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        String[] strArray = str.split(" ");
        short[] shortArray = new short[strArray.length];
        for (int i =0 ;i<strArray.length;i++){
            shortArray[i]=new Short(strArray[i]);
        }
        compareArray(shortArray);
        

    }
    public static void compareArray(short[] array){
        short a =0;
        short b=0;
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
