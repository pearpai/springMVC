package demo.test.algorithm;

/**
 * 题目：古典问题：有一对兔子，从出生后第3个月起每个月都生一对兔子，小兔子长到第四个月后每个月又生一对兔子，
 * 假如兔子都不死，问每个月的兔子总数为多少？  
 * 1.程序分析：   兔子的规律为数列1,1,2,3,5,8,13,21....
 * Created by wuyunfeng on 2016/9/30.
 */
public class Demo_1 {

    public static void main(String[] args) {
        for (int i = 1; i < 20; i++) {
            System.out.println("兔子" + i + "月有" + f(i));
        }
    }

    static int f(int x) {
        if (x == 1 || x == 2) {
            return 1;
        } else {
            return f(x - 1) + f(x - 2);
        }
    }

}
