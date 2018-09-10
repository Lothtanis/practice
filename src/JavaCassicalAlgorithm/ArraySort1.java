package JavaCassicalAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 题目：List a = new ArrayList("abcde","wssf","a","bb");
 *           遍历集合，删除长度小于2的字符串，对剩余元素排列。排列要求：比较首字母A-Z排序，首字符相同，比较第2字符，以此类推，完成排序
 * 1. 程序分析：
 *
 */
public class ArraySort1 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        List a =  new ArrayList(Arrays.asList("abcde","wssf","a","bb"));

       
        arraySort( a);
        
    }
    
    public static void arraySort(List array){
//        List newArray = new ArrayList(array.size());
        for(int i=0;i<array.size();i++){
            String itemB = (String) array.get(i);
            if(itemB.length()<2)
                array.remove(array.get(i));
        }
        Collections.sort(array);
        System.out.print(array.toString());
        

    }
    
    
}
