package JavaCassicalAlgorithm;

/**
 * 题目10：一球从100米高度自由落下，每次落地后反跳回原高度的一半；再落下，求它在第10次落地时，共经过多少米？第10次反弹多高？
 *
 */
public class TestBall {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        countBall(10);
    }
    
    public static void countBall(int getCnt){
        double start = 100;
        double disCnt =0;
        for(int i =1; i<getCnt; i++){
            disCnt = disCnt + start;
            start=start/2;
        }
        System.out.println("第" + getCnt +"次落地时，共经过"+ disCnt +"米");
        System.out.println("第" + getCnt +"次反弹"+ start +"米");
    }

}
