package JavaCassicalAlgorithm;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;
import java.util.Vector;

import javax.swing.text.GapContent;

public class AlgorithmBasicSort {

    public static void main(String[] args) {
        // HashMap xHashMap=new HashMap<>();
        // 随机数组
        int inputLength = 24;
        Random ram = new Random();
        int data[] = new int[inputLength];
        for (int i = 0; i < inputLength; i++) {
            data[i] = ram.nextInt(100);
        }
        System.out.println(Arrays.toString(data));
        // 排序方法
        // 冒泡排序
        // int sortedData[] = bubbleSort(data);
        // 快速排序
        // int sortedData[] = quickSort(data,0,inputLength);

        // 插入排序
        // int sortedData[] = InsertionSort(data);
        // 希尔排序
        // int sortedData[] = shellSort(data);

        // 选择排序
        // int sortedData[] = selectionSort(data);
        // 堆排序
//        int sortedData[] = heapSort(data);

        // 归并排序
        // int sortedData[] = mergeSort(data);

        // 计数排序
//         int sortedData[] = countingSort(data,100);
        // 桶排序
//         int sortedData[] = bucketSort(data,10);
        // 基数排序
         int sortedData[] = radixSort(data,2);

        // 输出
        System.out.println(Arrays.toString(sortedData));
    }



    /**
     * 冒泡排序
     * 
     * @param data
     * @return
     */
    public static int[] bubbleSort(int data[]) {
        int len = data.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (data[j] > data[j + 1]) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
        return data;
    }

    /**
     * 选择排序 
     * 1. 在未排序的队列中找到最小（大）元素，放到排序序列起始位置 
     * 2. 在剩余未排序元素中找到最小（大）元素，放到已排序序列队尾 
     * 重复2
     * 
     * @param data
     * @return
     */
    public static int[] selectionSort(int data[]) {
        int len = data.length;
        int minElement;
        int minIndex;
        for (int i = 0; i < len; i++) {
            // minElement = data[i];
            minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (data[j] < data[minIndex]) { // 寻找最小数
                    minIndex = j;
                }
            }
            minElement = data[minIndex];
            if (minIndex != i && minElement != data[i]) { // hashCode判断？省略一次复制？
                data[minIndex] = data[i];
                data[i] = minElement; // i位置：已排序列队尾
            }
        }
        return data;
    }

    /**
     * 插入排序 对未排序数据，在已排序序列中从后向前扫描，找位置插入
     * 
     * @param data
     * @return
     */
    public static int[] InsertionSort(int data[]) {
        int len = data.length;
        int temp;
        int scanIndex;
        for (int i = 1; i < len; i++) {
            scanIndex = i; // 已排序序列长度
            temp = data[i];
            while (scanIndex > 0 && data[scanIndex - 1] > temp) {
                data[scanIndex] = data[scanIndex - 1];
                scanIndex--;
            }
            data[scanIndex] = temp;
            // for (int j = i; j > 0; j--) { // 在已排序序列中扫描
            // if ( data[j - 1] > temp) {
            // data[j] = data[j - 1];
            // // System.out.println(Arrays.toString(data));
            // } else {
            // data[j] = temp;
            // break;
            // }
            // }

        }
        return data;
    }

    /**
     * 希尔排序 简单插入排序的改进版，优先比较距离较远的元素。又称缩小增量排序。 
     * 将整个待排序的记录序列分割成为若干子序列，分别进行直接插入排序。
     * 
     * @param data
     * @return
     */
    public static int[] shellSort(int data[]) {
        int len = data.length;
        int gap = 1;
        while (gap < len / 3) { // 动态定义间隔序列
            gap = gap * 3 + 1;
        }

        for (; gap > 0; gap = (int) Math.floor(gap / 3)) {
            // System.out.println("gap=" + gap);
            int temp;
            for (int i = gap; i < len; i++) {
                // System.out.println("i=" + i + ";data[i]=" + data[i]);
                temp = data[i];
                int j;
                for (j = i - gap; j >= 0 && data[j] > temp; j -= gap) { // 已排序序列
                // System.out.println("data[j]=" + data[j] + " > temp=" + temp);
                    data[j + gap] = data[j];
                }
                data[j + gap] = temp;
                // System.out.println(Arrays.toString(data));
            }

        }
        return data;
    }

    /**
     * 归并排序（2路归并）
     * 
     * @param data
     * @return
     */
    public static int[] mergeSort(int data[]) {
        int len = data.length;
        if (len < 2)
            return data;
        int middleIndex = (int) Math.floor(len / 2);

        int[] left = Arrays.copyOfRange(data, 0, middleIndex);
        int[] right = Arrays.copyOfRange(data, middleIndex, data.length);
        data = merge(mergeSort(left), mergeSort(right));
        return data;
    }

    private static int[] merge(int[] left, int[] right) {
        int i = left.length;
        int j = right.length;
        int index = i + j;
        int[] reData = new int[index];
        while (i > 0 && j > 0) {
            if (left[i - 1] <= right[j - 1]) {
                reData[--index] = right[--j];
            } else {
                reData[--index] = left[--i];
            }
        }
        while (i > 0)
            reData[--index] = left[--i];
        while (j > 0)
            reData[--index] = right[--j];
        return reData;
    }

    /**
     * 快速排序
     * 
     * @param data
     * @param left
     * @param right
     * @return
     */
    public static int[] quickSort(int data[], int left, int right) {
        int len = data.length;
        System.out.println("start: " + left + " end:" + right);
        System.out.println(Arrays.toString(data));
        if (right - left <= 0) {
            return data;
        }
        if (right >= len)
            right = len - 1;
        // 选取基准值
        int pivot = left;
        int minIndex = pivot;
        for (int i = left + 1; i <= right; i++) {
            // System.out.println("data[pivot]="+data[pivot]+"; data[i]="+data[i]);
            if (data[i] < data[pivot]) {
                int temp = data[++minIndex];
                data[minIndex] = data[i];
                data[i] = temp;
                // System.out.println("move: "+Arrays.toString(data));
            }
        }
        // 将基准值放到中间
        int temp = data[pivot];
        data[pivot] = data[minIndex];
        data[minIndex] = temp;
        // 递归快排
        // System.out.println("pivot move: "+Arrays.toString(data));
        quickSort(data, left, minIndex - 1);
        quickSort(data, minIndex + 1, right);
        return data;
    }

    /**
     * 堆排序 
     * 1. 构建大顶堆 
     * 2. 交换堆顶元素和最后一个元素 后 调整堆 
     * 重复2
     * 
     * @param data
     * @return
     */
    // private static int heapLength;
    public static int[] heapSort(int[] data) {
        printHeap(data);
        buildMaxHeap(data);
        System.out.println("调整大堆顶完成");
        // 调整堆结构+交换堆顶元素与末尾元素
        for (int len = data.length - 1; len > 0; len--) {
            // 交换堆顶元素和最后一个元素
            swap(data, 0, len);
            System.out.println("交换堆顶元素和最后一个元素");
            printHeap(data);
            System.out.println("调整堆");
            // 因为只有根节点变换过，所以只对堆顶元素进行调整
            heapAdjust(data, 0, len);
            printHeap(data);
        }
        return data;
    }

    private static void buildMaxHeap(int[] data) {
        int heapLength = data.length;
        for (int i = heapLength / 2 - 1; i >= 0; i--) { // 第一个非叶子节点
            System.out.println("大堆初始化：非叶子节点" + data[i]);
            heapAdjust(data, i, heapLength);
        }
    }

    /**
     * 堆调整
     * 
     * @param data
     * @param i 当前非叶子节点
     * @param heapLength 需调整的堆大小
     */
    private static void heapAdjust(int[] data, int i, int heapLength) {
        int temp = data[i];
        // 从i结点的左子结点开始，也就是2i+1处开始
        for (int k = 2 * i + 1; k < heapLength; k = 2 * k + 1) {
            // 如果左子结点小于右子结点，k指向右子结点
            if (k + 1 < heapLength && data[k] < data[k + 1]) {
                k++;
            }
            // 如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
            if (data[k] > temp) {
                data[i] = data[k];
                i = k;
                System.out.println("交换节点" + data[i] + " ; " + temp);
                printHeap(data);
            } else {
                break;
            }
        }
        data[i] = temp;
    }

    private static void printHeap(int[] data) {
        for (int i = 1; (int) Math.pow(2, i - 1) <= data.length; i++) {
            String temp = "";
            int len = data.length;
            if (len > (int) Math.pow(2, i) - 1)
                len = (int) Math.pow(2, i) - 1;
            for (int j = (int) Math.pow(2, i - 1); j <= len; j++) {
                temp = temp + " " + data[j - 1];
            }
            System.out.println(temp);
        }
    }
    
    /**
     * 计数排序
     * @param data
     * @return
     */
    private static int[] countingSort(int[] data, int maxVal) {
        int len = data.length;
        int[] bucket = new int[maxVal+1];
        
        for (int i =0; i<len; i++){
                bucket[data[i]]++;
        }
        int sorted =0;
        for(int j =0; j<maxVal+1; j++){
            while(bucket[j]>0){
                data[sorted++]=j;
                bucket[j]--;
            }
        }
        return data;
    }
    
    /**
     * 桶排序
     * 需要看以什么数据类型做桶；桶需要做排序
     * 问题：bucketSize怎么设定
     * @param data
     * @return
     */
    private static int[] bucketSort(int[] data, int bucketSize) {
        int len  = data.length;
        // 均匀分布
        int minVal = data[0];
        int maxVal = data[0];
        for(int i =1; i<len; i++){
            if (data[i]<minVal)
                minVal = data[i];
            else if(data[i]>maxVal)
                maxVal = data[i];
        }
        // 桶容量；hashmap的容量2^n-1是为了取桶index时碰撞小？
        int DEFAULT_BUCKET_SIZE=5;
        bucketSize = bucketSize | DEFAULT_BUCKET_SIZE;

        int bucketCnt = (maxVal-minVal)/bucketSize+1;

        ArrayList<ArrayList<Integer>> buckets = new ArrayList<>(bucketCnt);
        // 初始化
        for(int i =0; i<bucketCnt; i++)
            buckets.add(new ArrayList<Integer>());
        
        for(int i =0; i<len; i++){
            int index = (data[i]-minVal)/bucketSize;
            buckets.get(index).add(data[i]);
        }
        
        // 对每个桶的排序；非Collections类可以用其他排序方法
        int index=0;
        for(int i = 0; i<buckets.size(); i++){
            Collections.sort(buckets.get(i)); // 归并排序
            for(int j = 0; j<buckets.get(i).size(); j++){
                data[index++]=buckets.get(i).get(j);
            }
        }
        return data;
    }

    /**
     * 基数统计
     * 低位排序->高位排序；或者按优先级低->高
     * @param data
     * @param maxDigit 位数
     * @return
     */
    private static int[] radixSort(int[] data, int maxDigit) {
        int mod = 10;
        int exp =1;
        ArrayList<ArrayDeque<Integer>> counter = new ArrayList<ArrayDeque<Integer>>() ;
        for(int k =0; k<10; k++)
            counter.add(new ArrayDeque<Integer>());
        
        for(int i =0; i<maxDigit; i++, exp *=10, mod*=10){// 按位数
            for(int j =0; j<data.length; j++){
                int index = (data[j]%mod)/exp;
                counter.get(index).add(data[j]);// push是addFirst; add/offer是addLast
            }
            int index=0;
            for(int j=0; j<counter.size(); j++){
                if(counter.get(j)!=null){
                     while (!counter.get(j).isEmpty()) {
                         data[index++] = counter.get(j).pop();// pop/remove是pollFirst
                    }
                }
            }
        }
        return data;
    }
    
    
    private static void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

}
