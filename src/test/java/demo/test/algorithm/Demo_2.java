package demo.test.algorithm;

/**
 * 题目：判断101-200之间有多少个素数，并输出所有素数。  
 * 1.程序分析：判断素数的方法：用一个数分别去除2到sqrt(这个数)，如果能被整除，  
 * 则表明此数不是素数，反之是素数。
 * Created by wuyunfeng on 2016/9/30.
 */
public class Demo_2 {

    public static void main(String[] args) {
        for (int i = 101; i < 200; i++) {
            if (iszhishu(i))
                System.out.println(i);
        }
    }

    private static boolean iszhishu(int x){
        for (int i = 2; i <= x/2; i++) {
            if (x % i == 0)
                return false;
        }
        return true;
    }

}
