package JavaCassicalAlgorithm;

/**
 * 题目18：两个乒乓球队进行比赛，各出三人。甲队为a,b,c三人，乙队为x,y,z三人。已抽签决定比赛名单。
 * 有人向队员打听比赛的名单。a说他不和x比，c说他不和x,z比，请编程序找出三队赛手的名单。
 * 1.程序分析：判断素数的方法：用一个数分别去除2到sqrt(这个数)，如果能被整除， 则表明此数不是素数，反之是素数。
 * @author bw
 *
 */
public class Prog {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
//        char[] team1 = {'a','b','c'};
        char[] team2 = {'x','y','z'};
        int i, j, k;
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                for (k = 0; k < 3; k++) {
                    if (i != j && j != k && i != k
                            && team2[i] != 'x' 
                            && team2[k] !='x' && team2[k] !='z') {
                        System.out.println("a:"+team2[i] +"    b:"+team2[j]+"  c:"+team2[k]);
                    }
                }
            }
        }
    }

}
