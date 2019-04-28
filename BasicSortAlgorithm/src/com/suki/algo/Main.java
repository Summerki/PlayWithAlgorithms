package com.suki.algo;

import java.util.Arrays;

public class Main {

    // 比较SelectionSort与InsertionSort性能差异
    // 此时插入排序比选择排序性能略低
    // 插入排序经过优化后插入排序性能比选择排序好一些
    public static void main(String[] args) {
        int N = 20000;
        System.out.println("Test for random array, size = " + N + " , random range [0, " + N + "]");


        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("com.suki.algo.SelectionSortBaseComparable", arr1);
        SortTestHelper.testSort("com.suki.algo.InsertionSort", arr2);
    }

}
