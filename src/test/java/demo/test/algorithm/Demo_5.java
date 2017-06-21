package demo.test.algorithm;

import javax.swing.*;

/**
 * 题目：利用条件运算符的嵌套来完成此题：学习成绩> =90分的同学用A表示，60-89分之间的用B表示，60分以下的用C表示。  
 * 1.程序分析：(a> b)?a:b这是条件运算符的基本例子。
 * Created by wuyunfeng on 2016/9/30.
 */
public class Demo_5 {
    public static void main(String[] args) {
        String str;
        str = JOptionPane.showInputDialog("请输入N的值（输入exit退出）：");
        int n = 0;
        try {
            n = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        str = (n > 89 ? "A" : (n > 59 ? "B" : "C"));
        System.out.println(str);
    }
}
