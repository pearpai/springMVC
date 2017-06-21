package demo.test.algorithm.paixu;

/**
 * Created by wuyunfeng on 2016/10/7.
 */
public class CopySort implements SortUtil.Sort {
    @Override
    public void sort(int[] data) {
        for (int i = 0; i < data.length; i++) {
            int temp = data[i];
            int left = 0;
            int right = i - 1;
            int mid = 0;
            while (left <= right) {
                mid = (left + right) / 2;
                if (temp < data[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }


            for (int j = i - 1; j >= left; j--) {
                data[j + 1] = data[j];
            }
            if (left != i){
                data[left] = temp;
            }
        }
    }
    public static void main(String[] args) {
        CopySort copySort = new CopySort();
        int[] data = {10, 8, 9, 20, 33, 16, 7};
        copySort.sort(data);
        for (int a : data) {
            System.out.print(a + ", ");
        }
    }
}
