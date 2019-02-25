package train;

public class wsTest {

    public static void main(String[] args) {

        //search();
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        int key = 2;
        int position = recursionBinarySearch(array, key,0,array.length-1);
        //int position = commonBinarySearch(array, key);
        if (position == -1) {
            System.out.println("查找的是" + key + ",序列中没有该数！");
        } else {
            System.out.println("查找的是" + key + ",找到位置为：" + position);
        }
    }

    /**
     * @Description 二分查找，又叫折半查找，
     * 要求待查找的序列有序。
     * 每次取中间位置的值与待查关键字比较，
     * 如果中间位置的值比待查关键字大，则在前半部分循环这个查找的过程，
     * 如果中间位置的值比待查关键字小，则在后半部分循环这个查找的过程。
     * 直到查找到了为止，否则序列中没有待查的关键字。
     **/
    public static int commonBinarySearch(int[] array, int key) {

        int low = 0;
        int high = array.length - 1;
        int middle = 0;

        if (key < array[low] || key > array[high] || low > high) {
            return -1;
        }

        while (low <= high) {
            //中间位置
            middle = (low + high) / 2;
            if (key > array[middle]) {
                //比查找值小，说明在右区域
                low = middle + 1;
            } else if (key < array[middle]) {
                //比查找值大，说明在左区域
                high = middle - 1;
            } else {
                return middle;
            }
        }
        return -1;

    }

    public static int recursionBinarySearch(int[] array, int key, int low, int high) {

        if (key < array[low] || key > array[high] || low > high) {
            return -1;
        }

        int middle = (low + high) / 2;

        if (key > array[middle]) {
            //比查找值小，说明在右区域
            return recursionBinarySearch(array,  key,  middle+1,  high);
        } else if (key < array[middle]) {
            //比查找值大，说明在左区域
            return recursionBinarySearch(array,  key,  low,  middle-1);
        } else {
            return middle;
        }
    }

    /**
     * @Description 一个数如果恰好等于它的因子之和, 这个数就称为”完数”
     * 例如 6 = 1+2+3
     * 编程找出 1000 以内的所有完数
     **/
    public static void search() {
        for (int i = 1; i <= 1000; i++) {
            int x = 0;
            for (int j = 1; j < i; j++) {
                if (i % j == 0) {
                    x += j;
                }
            }
            if (x == i) {
                System.out.print(x + "=");
                for (int t = 1; t < i; t++) {
                    if (i % t == 0) {
                        System.out.print(t + "+");
                    }
                }
                System.out.println();
            }
        }
    }
}
