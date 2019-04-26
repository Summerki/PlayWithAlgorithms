package com.suki.algo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Random;

public class SortTestHelper {

    // 不允许产生任何实例
    private SortTestHelper(){

    }

    // 生成有n个元素的随机数组，每个元素的范围是[rangeL, rangeR]
    public static Integer[] generateRandomArray(int n, int rangeL, int rangeR){
        if(rangeL > rangeR){
            throw new IllegalArgumentException("输入参数不合法！");
        }

        Integer[] arr = new Integer[n];
        Random r = new Random();
        for(int i = 0; i < n; i++){
            arr[i] = r.nextInt(rangeR - rangeL + 1) + rangeL;
        }

        return arr;
    }


    // 打印arr数组所有的内容
    public static void printArray(Object[] arr){
        for(Object o : arr){
            System.out.print(o + "\t");
        }
    }


    // 判断数组是否有序
    // 规定从小到大排序为true，其余为false
    public static boolean isSorted(Comparable[] arr){
        for(int i = 0; i < arr.length; i++){
            // 如果不会从小到大排序，中间必然有相邻的两个元素比较会返回-1
            if(arr[i].compareTo(arr[i + 1]) == -1){
                return false;
            }
        }
        return true;
    }


    // 测试sortClassName所对应的排序算法arr数组所得到结果的正确性和算法运行时间
    public static void testSort(String sortClassName, Comparable[] arr){
        try {
            Class sortClass = Class.forName(sortClassName);
            Method sortMethod = sortClass.getMethod("sort", new Class[]{Comparable[].class});
            Object[] params = new Object[]{arr};


            // 计时
            long startTime = System.currentTimeMillis();
            sortMethod.invoke(null, params);
            long endTime = System.currentTimeMillis();


            assert isSorted(arr);

            System.out.println(sortClass.getSimpleName() + " : " + (endTime - startTime) + "ms");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {
        // 测试random的使用
        Random r = new Random();
        // random.nextInt(X)==>输出范围在[0, X)之间
//        System.out.println(r.nextInt(10));


        // 输出[A, B]之间的随机数
        // random.nextInt(B - A + 1) + A
        Integer integer;
        for(int i = 0; i < 100000; i++){  // 执行1000次，看看算法是否正确
            integer = r.nextInt(9) + 2; // 随机生成[2, 10]之间的随机整数
            if(integer < 2 || integer > 10){
                System.out.println("超出边界，算法有问题");  // 看来测试结果没有问题
            }
        }
        System.out.println(r.nextInt(9) + 2);

        Integer[] arr = generateRandomArray(15, 20, 90);
        printArray(arr);
    }

}
