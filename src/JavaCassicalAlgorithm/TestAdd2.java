package JavaCassicalAlgorithm;

/**
 * 题目20：有一分数序列：2/1，3/2，5/3，8/5，13/8，21/13...求出这个数列的前20项之和。 
 * 1.程序分析：请抓住分子与分母的变化规律。
 *
 */
public class TestAdd2 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        addAll(3);
    }
    
    public static void addAll(int cnt){
        double amount = 0;
        for(int i=1;i<=cnt;i++){
            amount = amount + (double)getNumber(i+1)/getNumber(i);
        }
        System.out.println("数列之和为："+amount);
    }
    
    public static int getNumber(int cnt){
        if(cnt==1){
            return 1;
        } else if(cnt==2){
            return 2;
        }else {
            return getNumber(cnt-1) + getNumber(cnt-2);
        }
    }

}
