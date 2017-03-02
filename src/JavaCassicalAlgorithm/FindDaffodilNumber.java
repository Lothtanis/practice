package JavaCassicalAlgorithm;
/**
 * 题目：打印出所有的"水仙花数"，所谓"水仙花数"是指一个三位数，其各位数字立方和等于该数本身。
 * 例如：153是一个"水仙花数"，因为153=1的三次方＋5的三次方＋3的三次方。 
 * 1.程序分析：利用for循环控制100-999个数，每个数分解出个位，十位，百位。
 * @author bw
 *
 */
public class FindDaffodilNumber {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        getDaffodilNumber();
    }
    /**
     * 解一个数的个十百位，求三个位数的立方和
     * @return 
     */
    public static int getPow3(int number){
        int hundreds = number/100;
        int tens = number/10%10;
        int ones = number%10;
        return (int)(Math.pow(hundreds, 3)+Math.pow(tens, 3)+Math.pow(ones, 3));
    }
    
    /**
     * 获得水仙花数
     */
    public static void getDaffodilNumber(){
        for(int i=100; i<1000; i++){
            if(i==getPow3(i)){
                System.out.println(i);
            }
        }
    }

}
