import java.util.Arrays;

public class RadixSort {

    /**
     * The main function that sorts nums
     *
     * @param nums
     */
    public static void sort(int nums[]) {
        int n = nums.length;
        // Find the maximum number to know number of digits
        int m = maxValue(nums, n);

        // Do counting sort for every digit. Note that instead
        // of passing digit number, exp is passed. exp is 10^i
        // where i is current digit number
        for (int exp = 1; m / exp > 0; exp *= 10)
            countSort(nums, n, exp);
    }

    /**
     * find maximum number in nums
     *
     * @param nums
     * @param n     length of nums
     * @return
     */
    private static int maxValue(int nums[], int n) {
        int maxValue = nums[0];
        for (int i = 1; i < n; i++)
            if (nums[i] > maxValue)
                maxValue = nums[i];
        return maxValue;
    }

    /**
     * A function to do counting sort of nums according to
     * the digit represented by exp
     *
     * @param nums nums to be sorted
     * @param n length of nums
     * @param exp for doing count sort
     */
    private static void countSort(int nums[], int n, int exp) {
        int output[] = new int[n]; // output nums
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);

        // Store count of occurrences in count[]
        for (i = 0; i < n; i++)
            count[(nums[i] / exp) % 10]++;

        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // Build the output nums
        for (i = n - 1; i >= 0; i--) {
            output[count[(nums[i] / exp) % 10] - 1] = nums[i];
            count[(nums[i] / exp) % 10]--;
        }

        // Copy the output nums to nums[], so that nums[] now
        // contains sorted numbers according to current digit
        for (i = 0; i < n; i++)
            nums[i] = output[i];
    }
}
