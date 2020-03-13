public class BucketSort {

    /**
     * Main function to implement bucket sort
     *
     * @param nums
     * @return
     */
    public static int[] sort(int[] nums) {
        int maxValue = maxValue(nums);
        int[] Bucket = new int[maxValue + 1];
        int[] sortedNums = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
            Bucket[nums[i]]++;
        int outPos = 0;
        for (int i = 0; i < Bucket.length; i++)
            for (int j = 0; j < Bucket[i]; j++)
                sortedNums[outPos++] = i;
        return sortedNums;
    }

    /**
     * A function to get max value of an array
     *
     * @param nums
     * @return
     */
    static int maxValue(int[] nums) {
        int maxValue = nums[0];
        for (int i = 1; i < nums.length; i++)
            if (nums[i] > maxValue)
                maxValue = nums[i];
        return maxValue;
    }


}
