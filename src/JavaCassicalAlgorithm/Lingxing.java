package JavaCassicalAlgorithm;

/**
 * 题目19：打印出如下图案（菱形） 
*
***
******
********
  ******
     ***
       *
1.程序分析：先把图形分成两部分来看待，前四行一个规律，后三行一个规律，利用双重 for循环，第一层控制行，第二层控制列。
 *
 */
public class Lingxing {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
//        int i=8,j=7;
        int[] arr = { 1, 3, 6, 8, 6, 3, 1 };
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < arr[i]; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
        for (int i = 4; i < arr.length; i++) {
            for (int j = arr[i]; j < 8; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < arr[i]; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }

}
