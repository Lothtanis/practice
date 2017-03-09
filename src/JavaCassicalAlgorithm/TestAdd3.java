package JavaCassicalAlgorithm;

/**
 * 题目29：求一个3*3矩阵对角线元素之和 
 * 1.程序分析：利用双重for循环控制输入二维数组，再将a[i][i]累加后输出。
 *
 */
public class TestAdd3 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][] matrix = { { 1, 2, 3 }, 
                                    { 6, 5, 4 },
                                    { 7, 8, 9 } };
        addMatrix(matrix);

    }
    
    public static void addMatrix(int[][] matrix){
        int sum=0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == j || (i + j) == matrix.length - 1) {
                    sum = sum + matrix[i][j];
                }
            }
        }
        System.out.print("对角线总和为"+sum);
    }

}
