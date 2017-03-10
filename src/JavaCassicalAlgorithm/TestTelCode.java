package JavaCassicalAlgorithm;

import java.util.Scanner;

/**
 * 题目48：某个公司采用公用电话传递数据，数据是四位的整数，在传递过程中是加密的，
 * 加密规则如下：每位数字都加上5,然后用和除以10的余数代替该数字，再将第一位和第四位交换，第二位和第三位交换。 
 *
 */
public class TestTelCode {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("输入8位电话号码");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();
        
        if(isTelNum(input)){
            System.out.println("加密后结果："+telCode(input));
        }

    }
    
    private static boolean isTelNum(String input) {
        // TODO Auto-generated method stub
        if (input.length()!=8){
            return false;
        }
        return true;
    }

    public static String telCode(String telNum){
        char[] array=telNum.toCharArray();
        int[] result=new int[array.length];
        int temp;
        String re="";
        for(int i=0;i<array.length;i++){
            temp =(array[i]+5)%10;
            result[i]=temp;
        }
        temp=result[3];
        result[3] =result[0];
        result[0] =temp;
        temp=result[2];
        result[2] =result[1];
        result[1] =temp;
        
        for(int i=0;i<result.length;i++){
            re = re + result[i];
        }
        return re;
    }

}
