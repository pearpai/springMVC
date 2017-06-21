package demo.test.algorithm.sjjg;

/**
 * Created by wuyunfeng on 2016/10/20.
 */
public class ZheBanChaZhao {

    public static void main(String[] args) {
        long m = 33;
        long n = 20;
        while (n != 0) {
            long rem = m % n;
            m = n;
            n = rem;
        }
        System.out.println(m);
    }

}
