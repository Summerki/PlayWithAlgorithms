package com.suki.selectionSort;

// 选择排序
public class SelectionSort {

    // 算法不允许含有任何实例
    private SelectionSort(){}

    public static void sort(int[] arr){
        int n = arr.length;
        for (int i = 0; i < n; i++){
            // 一开始i指针和minIndex指针都是指向同一个元素
            // 之后i指针不会变，但是minIndex指针可能会指向该元素的后面的元素
            int minIndex = i;
            // 永远是当前位置和其之后的元素相比，前面的都是已经按照从小到大排序好的元素
            for (int j = i + 1; j < n; j++){
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }


    // 指定i和j位置上的元素调换
    private static void swap(int[] arr, int i , int j){
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        SelectionSort.sort(arr);
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + "\t");
        }

    }

}
