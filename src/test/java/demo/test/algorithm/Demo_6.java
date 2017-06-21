package demo.test.algorithm;

/**
 * 题目：输入两个正整数m和n，求其最大公约数和最小公倍数。  
 1.程序分析：利用辗除法。
 * Created by wuyunfeng on 2016/9/30.
 */
public class Demo_6 {
    public static void main(String args[]) {
        commonDivisor(24, 32);
        int a=24; int b=32;
        int c = gcd(a, b);
        System.out.println("最小公倍数：" + a * b / c + "\n最大公约数：" + c);

    }

    private static int commonDivisor(int M, int N) {
        if (N < 0 || M < 0) {
            System.out.println("ERROR!");
            return -1;
        }
        if (N == 0) {
            System.out.println("the biggest common divisor is :" + M);
            return M;
        }
        return commonDivisor(N, M % N);
    }

    private static int gcd(int m, int n){
        while (true){
            if ((m = m % n) == 0)
                return n;
            if ((n = n % m) == 0)
                return m;
        }
    }

}
