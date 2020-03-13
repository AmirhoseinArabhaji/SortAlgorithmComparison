public class QuickSort {

    /**
     * The main function that implements Quick Sort
     *
     * @param nums nums to be sorted
     * @param begin starting index
     * @param end   ending index
     */
    public static void sort(int nums[], int begin, int end) {
        if (begin < end) {
            // pi is partitioning index, arr[pi] is now at right place
            int pi = partition(nums, begin, end);

            // Recursively sort elements before
            // partition and after partition
            sort(nums, begin, pi - 1);
            sort(nums, pi + 1, end);
        }
    }

    /**
     * This function takes last element as pivot
     * @param nums
     * @param begin
     * @param end
     * @return
     */
    private static int partition(int nums[], int begin, int end) {
        int pivot = nums[end];
        int i = (begin - 1); // index of smaller element
        for (int j = begin; j < end; j++) {
            // If current element is smaller than the pivot
            if (nums[j] < pivot) {
                i++;

                // swap nums[i] and nums[j]
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }

        // swap nums[i+1] and nums[high] (or pivot)
        int temp = nums[i + 1];
        nums[i + 1] = nums[end];
        nums[end] = temp;

        return i + 1;
    }

}
