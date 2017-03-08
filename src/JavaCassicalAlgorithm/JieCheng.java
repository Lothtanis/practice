package JavaCassicalAlgorithm;

/**
 * 题目21：求1+2!+3!+...+20!的和 
 * 1.程序分析：此程序只是把累加变成了累乘。
 *
 */
public class JieCheng {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
//        int sum = 0;
//        int data = 1;
//        for (int i = 1; i <= 20; i++) {
//            data = data * i;
//            sum += data;
//        }
//        System.out.println(sum);
        
        long total=0L;
        for(int i=1;i<=20;i++){
            total = total + getJieCheng(i);
        }
        System.out.println("1+2!+3!+...+20! = "+total);
    }
    public static long getJieCheng(int num){
        long total=1L;
        for(int i=num;i>0;i--){
            total =total * i;
        }
        return total;
    }

}
