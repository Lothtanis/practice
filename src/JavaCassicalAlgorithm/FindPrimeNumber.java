package JavaCassicalAlgorithm;
/**
 * 题目2：判断101-200之间有多少个素数，并输出所有素数。 
 * 1.程序分析：判断素数的方法：用一个数分别去除2到sqrt(这个数)，如果能被整除， 则表明此数不是素数，反之是素数。
 * @author bw
 */
public class FindPrimeNumber {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        getPrimes(1,200);
    }
    
    /**
     * 求范围内所有素数
     * 在一般领域，对正整数n，如果用2到对n求平方根之间的所有整数去除，均无法整除，则n为素数。
     * @param start
     * @param end
     */
    public static void getPrimes(int start, int end) {
        Double endCount = Math.sqrt(end);
        for (int i = start; i < end; i++) {
            Boolean bool = true;
            if (i % 2 == 0)
                continue; // 说明是偶数,直接跳出当前循环
            for (int j = 2; j < endCount; j++) {
                if (i % j == 0) {
                    bool = false; // 说明被整除了
                    break;
                }
            }
            if (bool == true) {
                System.out.println(i);
            }
        }
    }
}
