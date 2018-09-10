package JavaCassicalAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class RedPacket {

    private final static int MIN_MONEY = 1;
    private final static int MAX_MONEY = 20000;
    /**
     * 最大的红包是平均值的 TIMES 倍，防止某一次分配红包较大
     */
    private static final double TIMES = 2.1F ;
    private enum Status {
        NORMAL, MORE, LESS;
    }

    private int recursiveCount = 0 ;
    
    
    public List<Integer>listRedPacket(int money, int cnt){
        List<Integer> moneyList= new ArrayList<Integer>();
        int max =(int) ((money/cnt)*TIMES);
        max = max>MAX_MONEY?MAX_MONEY:max;
        for(int i=0;i<cnt;i++){
            int redPacket = randomRedPacket(money,MIN_MONEY,max,cnt-i);
            moneyList.add(redPacket);
            money = money-redPacket;
        }
        return moneyList;
    }
    
    private int randomRedPacket(int totalMoney, int minMoney, int max, int remainingPackets) {
        if(remainingPackets == 1)
            return totalMoney;
        if(minMoney == max)
            return minMoney;
        max = max>totalMoney?totalMoney:max;
        int redPacket = (int) (Math.random() * (max - minMoney)+minMoney); // (2-1)*random +1
        int lastMoney = totalMoney - redPacket ;
        Status status = checkMoney(lastMoney,remainingPackets - 1) ;
        //正常金额
        if (Status.NORMAL == status){
            return redPacket ;
        //如果生成的金额不合法 则递归重新生成
        } else if (Status.LESS == status){
            recursiveCount ++ ;
            System.out.println("recursiveCount==" + recursiveCount);
            return randomRedPacket(totalMoney,minMoney,redPacket,remainingPackets) ;
        } else if (Status.MORE == status){
            recursiveCount ++ ;
            System.out.println("recursiveCount===" + recursiveCount);
            return randomRedPacket(totalMoney,redPacket,max,remainingPackets) ;
        }
        return lastMoney;
    }

    private Status checkMoney(int lastMoney, int count) {
        double avg = lastMoney / count ;
        if (avg < MIN_MONEY){
            return Status.LESS ;
        }
        if (avg > MAX_MONEY){
            return Status.MORE ;
        }
        return Status.NORMAL ;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
