package com.st.algorithm.common.util;

import java.text.NumberFormat;

/**
 * @author dushuaitong
 * @description: 测试一个方法的执行时长
 * @date 2021/11/19
 */
public class Times {
    
    public static void execute(String desc, Executor exector) {
        StringBuilder sb = new StringBuilder("【" + desc + "】");
        long begin = System.currentTimeMillis();
        exector.execute();
        long end = System.currentTimeMillis();
        long executeTime = end - begin;
        sb.append("\r\n");
        sb.append("【执行时长】").append(executeTime).append("毫秒");
        NumberFormat format = NumberFormat.getInstance();
        format.setMaximumFractionDigits(2);
        sb.append("\t\t\t").append(format.format(executeTime*1.0/1000.0)).append("秒");
        sb.append("\r\n");
        sb.append("------------------------------------------");
        System.out.println(sb);
    }
}
