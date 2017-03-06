package JavaCassicalAlgorithm;

/**
 * 题目16：输出9*9口诀。
 * 1.程序分析：分行与列考虑，共9行9列，i控制行，j控制列。
 *
 */
public class MultiplicationTable {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        printTable();
    }
    public static void printTable(){
        for (int i=1;i<10;i++){
            for(int j=1;j<10;j++){
                System.out.print(i +"*"+j+"="+i*j +"\t");
            }
            System.out.println("");
        }
    }

}
