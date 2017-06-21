package demo.test.algorithm.paixu;

/**
 * Created by wuyunfeng on 2016/10/7.
 */
public class SelectionSort implements SortUtil.Sort {
    @Override
    public void sort(int[] data) {
        for (int i = 0; i < data.length; i++) {
            int min = data[i];
            int n = i;
            for (int j = i + 1; j < data.length; j++) {
                if (data[j] < min) {
                    min = data[j];
                    n = j;
                }
            }
            data[n] = data[i];
            data[i] = min;
        }
    }

    public static void main(String[] args) {
        int[] a = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1, 8};
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.sort(a);
        for (int b: a) {
            System.out.print(b + ", ");
        }
    }
}
