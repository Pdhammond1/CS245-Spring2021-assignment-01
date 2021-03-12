public class SelectionSort {

    public static void sort(int[] nums) {

        int n = nums.length;

        // One by one move bound of unsorted sub array
        for (int i=0; i < n-1; i++) { // Find the minimum element in unsorted array
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
                // Swap the found minimum element with the first element
                int temp = nums[min];
                nums[min] = nums[i];
                nums[i] = temp;
            }
        }
    }
}
