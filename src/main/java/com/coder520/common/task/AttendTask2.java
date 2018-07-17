package com.coder520.common.task;

/**
 * create by sintai_zx
 * 2018/7/10 15:22
 */
public class AttendTask2 {
    private int count =0;
    public void TestQuartz() {
        System.out.print("第二个任务:");
        count++;
        System.out.println(count+":次");
    }
}
