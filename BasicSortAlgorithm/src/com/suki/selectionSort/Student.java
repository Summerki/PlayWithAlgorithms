package com.suki.selectionSort;

public class Student implements Comparable<Student> {

    private String name;
    private int score;

    public Student(String name, int score){
        this.name = name;
        this.score = score;
    }

    // Student的compareTo函数
    // 定义compare规则如下：
    // 分数不等，分数高的靠前
    // 分数相等，按照名字字母顺序排序
    @Override
    public int compareTo(Student o) {
        // 注：compareTo接口的编写规则
        // A.compareTo(B)==>A>B返回1；A=B返回0；A小于B返回-1
        // 参考：http://www.runoob.com/java/number-compareto.html

        // 自定义规则
        if(this.score > o.score){
            return 1;
        }else if(this.score < o.score){
            return -1;
        }else{  // 相等的情况
            return this.name.compareTo(o.name);
        }
    }



    // 定义student实例打印输出方式
    @Override
    public String toString() {
        return "Student: " + this.name + " " + Integer.toString(this.score);
    }
}
