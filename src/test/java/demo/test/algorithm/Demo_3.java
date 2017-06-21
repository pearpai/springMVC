package demo.test.algorithm;

/**
 * Created by wuyunfeng on 2016/9/30.
 */
public class Demo_3 {
    public static void main(String[] args) {
        for (int i = 100; i < 999; i++) {
            if (shuixianhuashu(i))
                System.out.println(i);
        }
    }

    private static boolean shuixianhuashu(int x) {
        int i, j, k;
        i = x / 100;
        j = (x % 100) / 10;
        k = x % 10;
        return x == i * i * i + j * j * j + k * k * k;
    }
}
