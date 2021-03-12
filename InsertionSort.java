public class InsertionSort {

    public static void sort(int[] nums) {

        int n = nums.length;

        for (int i=1; i <= n-1; i++) {

            int key = nums[i];
            int j = i-1;

            //Move elements of arr[0..i-1], that are greater than key, to one position ahead of their current position
            while (j>=0 && nums[j]>key) {
                nums[j+1] = nums[j];
                j = j-1;
            }

            nums[j+1] = key;
        }
    }
}
