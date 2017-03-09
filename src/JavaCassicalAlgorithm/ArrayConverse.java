package JavaCassicalAlgorithm;

/**
 * 题目31：将一个数组逆序输出。 
 * 1.程序分析：用第一个与最后一个交换。
 *
 */
public class ArrayConverse {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int[] arrOri = {4,5,6,9,10,11,21,25};
        
        for(int i=arrOri.length;i>0;i--){
            System.out.print(arrOri[i-1]+"  ");
        }
    }

}
