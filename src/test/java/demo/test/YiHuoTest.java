package demo.test;


/**
 * 分治算法 找出数组中两个出线奇数次数的 数值
 * Created by wuyunfeng on 2016/10/18.
 */
public class YiHuoTest {

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 4, 1, 2, 1126};
        int yh = 0;
        for (int i : a) {
            yh = yh ^ i;
        }
        System.out.println(yh);
        System.out.println(Integer.toBinaryString(yh));
        int y = 0;
        while (true) {
            yh = yh >> 1;
            y++;
            if ((yh & 1) == 1)
                break;

        }

        int yh1 = 0, yh2 = 0;
        for (int i : a) {
            int tmp = i >> y;
            if ((tmp & 1) == 1) {
                yh1 = yh1 ^ i;
            } else {
                yh2 = yh2 ^ i;
            }
        }
        System.out.println(yh1 + "    " + yh2);

    }
}
