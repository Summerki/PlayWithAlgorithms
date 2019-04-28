package com.suki.algo;

import com.sun.corba.se.spi.ior.ObjectKey;

// 冒泡排序优化
public class BubbleSort2 {

    // 不允许产生任何实例
    private BubbleSort2(){}

    public static void sort(Comparable[] arr){
        int n = arr.length;
        int newn;  // 使用newn优化

        do{
            newn = 0;
            for(int i = 1; i < n; i++){
                if(arr[i - 1].compareTo(arr[i]) == 1){
                    swap(arr, i - 1, i);

                    newn = i;  // 记录每次for循环中最后一次的交换位置，此后的元素在下一轮中可以不要考虑（因为已经排好序了呀）
                }
            }
            n = newn;
        }while (newn > 0);
    }


    private static void swap(Object[] arr, int i, int j){
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        int N = 1000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 1000);
        SortTestHelper.testSort("com.suki.algo.BubbleSort2", arr);
    }

}
