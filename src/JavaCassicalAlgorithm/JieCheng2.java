package JavaCassicalAlgorithm;

/**
 * 题目22：利用递归方法求5!。
 * 1.程序分析：递归公式：fn=fn_1*4!
 *
 */
public class JieCheng2 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    
    public static long getJieCheng(int cnt){
        if(cnt==1){
            return 1;
        }else{
            return getJieCheng(cnt-1)*cnt;
        }
//        // method2
//        if(cnt>0){
//            return getJieCheng(cnt-1)*cnt;
//        } else {
//            return 1;
//        }
    }

}
