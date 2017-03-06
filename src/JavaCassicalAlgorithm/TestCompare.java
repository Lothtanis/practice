package JavaCassicalAlgorithm;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 题目15：输入三个整数x,y,z，请把这三个数由小到大输出。 
 * 1.程序分析：我们想办法把最小的数放到x上，先将x与y进行比较，如果x>y则将x与y的值进行交换，
 * 然后再用x与z进行比较，如果x>z则将x与z的值进行交换，这样能使x最小。
 *
 */
public class TestCompare {

    public static void main(String[] args) throws ParseException {
        // TODO Auto-generated method stub
//        System.out.println("请输入整数x：");
//        Scanner scanner = new Scanner(System.in);
//        int x = scanner.nextInt();
//        System.out.println("请输入整数y：");
//        int y = scanner.nextInt();
//        System.out.println("请输入整数z：");
//        int z = scanner.nextInt();
//        scanner.close();
//        int[] array = {x,y,z};
//        compareArray(array);
        int[] array2 = {5,8,7,6,1,9,4,2,3};
        compareArray(array2);
    }
    
    public static void compareArray(int[] array){
        int a =0;
        int b=0;
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
