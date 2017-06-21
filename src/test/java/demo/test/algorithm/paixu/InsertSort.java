package demo.test.algorithm.paixu;

/**
 * Created by wuyunfeng on 2016/9/30.
 */
public class InsertSort implements SortUtil.Sort {

    @Override
    public void sort(int[] data) {
        for (int i = 1; i < data.length; i++) {
            for (int j = i; (j > 0) && (data[j] < data[j - 1]); j--) {
                SortUtil.swap(data, j, j - 1);
            }
        }

    }
}
