package JavaCassicalAlgorithm;

/**
 * 题目11：有1、2、3、4个数字，能组成多少个互不相同且无重复数字的三位数？都是多少？ 
 * 1.程序分析：可填在百位、十位、个位的数字都是1、2、3、4。组成所有的排列后再去 掉不满足条件的排列。
 *
 */
public class TestTN {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] array = {1,2,3,4};
        getTN(array);
    }
    
    public static void getTN(int[] array){
        int num = 0;
        for (int a : array) {
            for (int b : array) {
                for (int c : array) {
                    if (a != b && b != c && a != c) {
                        num = a * 100 + b * 10 + c;
                        System.out.println(num );
                    }
                }
            }
        }
    }
    
    
}
