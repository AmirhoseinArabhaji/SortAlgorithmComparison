public class ShellSort {

    /**
     * Main method that implement sort algorithm
     * @param nums arrays of nums
     */
    public static void sort(int[] nums) {
        int increment = nums.length / 2;
        while (increment > 0) {
            for (int i = increment; i < nums.length; i++) {
                int j = i;
                int temp = nums[i];
                while (j >= increment && nums[j - increment] > temp) {
                    nums[j] = nums[j - increment];
                    j = j - increment;
                }
                nums[j] = temp;
            }
            if (increment == 2) {
                increment = 1;
            } else {
                increment *= (5.0 / 11);
            }
        }
    }
}
