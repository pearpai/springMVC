package demo.test.algorithm.paixu;

/**
 * Created by wuyunfeng on 2016/10/7.
 */
public class BisectionSort implements SortUtil.Sort {
    @Override
    public void sort(int[] data) {
        for (int i = 0; i < data.length; i++) {
            int temp = data[i];
            int left = 0;
            int right = i - 1;
            int mid;

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

            if (left != i)
                data[left] = temp;
        }

    }

    public static void main(String[] args) {
        BisectionSort bisectionSort = new BisectionSort();
        int[] data = {10, 8, 9, 20, 33, 16, 7};
        bisectionSort.sort(data);
        for (int a : data) {
            System.out.print(a + ", ");
        }

        System.out.println(5 / 2);


        int[] a = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1};
        System.out.println("排序之前：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        //希尔排序
        int d = a.length;
        while (true) {
            d = d / 2;
            for (int x = 0; x < d; x++) {
                for (int i = x + d; i < a.length; i = i + d) {
                    int temp = a[i];
                    int j;
                    for (j = i - d; j >= 0 && a[j] > temp; j = j - d) {
                        a[j + d] = a[j];
                    }
                    a[j + d] = temp;
                }
            }
            if (d == 1) {
                break;
            }
        }
        System.out.println();
        System.out.println("排序之后：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

    }
}
