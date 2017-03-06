package JavaCassicalAlgorithm;

import java.util.Scanner;

/**
 * 题目6：输入两个正整数m和n，求其最大公约数和最小公倍数。 
 * 1.程序分析：利用辗除法
 * 「辗转相除法」又叫做「欧几里得算法」
 * 
 * 我们可以这样给出整除以的定义:  
    对於两个自然数 a 和 b，若存在正整数 q，使得 a=bq，则 b 能整除 a，记作 b | a，我们叫 b 是 a 的因数，而 a 是 b 的倍数。那麼如果 c | a，而且 c | b，则 c 是 a 和 b 的公因数。  
    由此,我们可以得出以下一些推论：  
    推论一：如果 a | b，若 k 是整数，则 a | kb。因为由 a | b 可知 ha=b，所以 (hk)a=kb，即 a | kb.  
    推论二：如果 a | b 以及 a | c，则 a | (b±c)。因为由 a | b 以及 a | c，可知 ha=b，ka=c，二式相加,得 (h+k)a=b+c,即 a | (b+c).同样把二式相减可得 a | (b-c)。  
    推论三：如果 a | b 以及 b | a，则 a=b。因为由 a | b 以及 b | a，可知 ha=b，a=kb，因此 a=k(ha)，hk=1，由於 h 和 k 都是正整数，故 h=k=1，因此 a=b。  
  
    辗转相除法是用来计算两个数的最大公因数，在数值很大时尤其有用而且应用在电脑程式上也十分简单。其理论如下：  
    如果 q 和 r 是 m 除以 n 的商及余数，即 m=nq+r，则 gcd(m,n)=gcd(n,r)。    
    证明是这样的:  
    设 a=gcd(m,n)，b=gcd(n,r)  
    则由 a | m 及 a | n，可得 a | (m-nq)(由推论一及推论二得出的)，即 a | r ，又 a | n，所以 a | b。  
    由 b | r 及 b | n，可得 b | (nq+r)，即 b | m，又 b | n，所以b | a。  
    因为 a | b 并且 b | a，所以 a=b，即 gcd(m,n)=gcd(n,r)。
 * 
 */
public class GetGCD {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        // 定义两个整型数字的变量
        int min;
        int max;
        System.out.print("请输入一个数：");
        min = sc.nextInt();// nextInt();方法用来获取输入的Int NUM
        System.out.print("请输入另一个数：");
        max = sc.nextInt();
        
        System.out.println(getGongyue(min, max));
        System.out.println(getGongbei(min, max));

    }
    
    public static int getGongyue(int min, int max) {
        while (max % min != 0) {
            // 运用递归调用将求余之后的值作为min 将之前的min作为max直到求余值为0为止结束循环
            int temp = max % min;
            max = min;
            min = temp;
        }
        return min;
    }

    public static int getGongbei(int min, int max) {
        // 求公倍数就是将两个数相乘除以最大公约数
        return min * max / getGongyue(min, max);
    }

}
