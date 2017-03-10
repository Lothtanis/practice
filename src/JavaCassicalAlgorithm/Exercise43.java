package JavaCassicalAlgorithm;

/**
 * 题目43：求0—7所能组成的奇数个数。
 * @author bw
 *
 */
public class Exercise43 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] num={0,1,2,3,4,5,6,7} ;
        
        makeOdd(num);
    }

    private static void makeOdd(int[] num) {
        // TODO Auto-generated method stub
        int len=num.length;
        int sum=0;
        sum+=len/2;
        sum+=(len-1)*len/2;
        sum+=(len-1)*len*len/2;
        sum+=(len-1)*len*len*len/2;
        sum+=(len-1)*len*len*len*len/2;
        sum+=(len-1)*len*len*len*len*len/2;
        sum+=(len-1)*len*len*len*len*len*len/2;
        sum+=(len-1)*len*len*len*len*len*len*len/2;
        System.out.print("所能组成奇数个数："+sum);
        
        
    }

}
