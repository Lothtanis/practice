package JavaCassicalAlgorithm;

/**
 * 题目42：809*??=800*??+9*??+1
 * 其中??代表的两位数,8*??的结果为两位数，9*??的结果为3位数。求??代表的两位数，及809*??后的结果
 * @author bw
 *
 */
public class Exercise42 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int x;
        for(x=10;x<100;x++){
            if(8*x<100 && 9*x>99 && 9*x<1000){
                if(809*x==800*x+9*x+1){
                    System.out.println("??="+x);
                    System.out.println("809*??="+809*x);
                    return;
                }
            }
        }

        System.out.println("无符合要求结果");

    }

}
