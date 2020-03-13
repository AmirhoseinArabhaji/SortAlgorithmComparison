public class MergeSort {

    /**
     * The main function that implements merge sort
     *
     * @param nums nums to be sorted
     * @param len   length of given nums
     */
    public static void sort(int[] nums, int len) {
        if (len < 2)
            return;

        // find middle point
        int mid = len / 2;
        // making left and right nums
        int[] left = new int[mid];
        int[] right = new int[len - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = nums[i];
        }
        for (int i = mid; i < len; i++) {
            right[i - mid] = nums[i];
        }
        // sorting both left and right nums in recursive
        sort(left, mid);
        sort(right, len - mid);

        // merging left and right nums
        merge(nums, left, right, mid, len - mid);
    }

    /**
     * Merge algorithm for left and right nums
     *
     * @param nums
     * @param l     left copied nums
     * @param r     right copied nums
     * @param left
     * @param right
     */
    private static void merge(int[] nums, int[] l, int[] r, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                nums[k++] = l[i++];
            } else {
                nums[k++] = r[j++];
            }
        }
        while (i < left) {
            nums[k++] = l[i++];
        }
        while (j < right) {
            nums[k++] = r[j++];
        }
    }

}
