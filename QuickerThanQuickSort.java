import java.util.Random;

public class QuickerThanQuickSort {

    // Function to perform insertion sort on subarrays
    public static void quadraticSort(double [] arr, int low, int n) {
        // Start from the second element (the element at index 0 is already sorted)

        for (int i = low + 1; i <= n; i++) {
            double value = arr[i];
            int j = i;
            // find index `j` within the sorted subarray `arr[0…i-1]` where element `arr[i]` belongs
            while (j > low && arr[j - 1] > value) {
                arr[j] = arr[j - 1];
                j--;
            }
            // note that subarray `arr[j…i-1]` is shifted to the right by one position.
            arr[j] = value;
        }
    }

    // Partition helper function for quickSort to call on which
    // sets pivot and gives partition index to quickSort

    private static int partition(double arr[], int begin, int end) {

        Random rand = new Random();
        int upperbound = arr.length - 1;
        int int_random = rand.nextInt(upperbound);

        double piv = arr[int_random]; // random pivot

        int i = (begin - 1); // Index of smaller element and indicates the right position of pivot found so far

        for (int j = begin; j < end; j++) {
            // If current element is smaller than the pivot
            if (arr[j] <= piv) {
                // increment index of smaller element
                i++;
                // swap the values if less than pivot
                double swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        double swapTemp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = swapTemp;

        return i + 1;
    }

    public static int quicksort(double[] arr, int left, int right) {

        int pivot = partition(arr, left, right);

        while (left < right) {
            // switch to insertion sort if the size is 10 or smaller
            if (right - left < 300000) {
                quadraticSort(arr, left, right);
                break;
            }

            else {
                // tail call optimizations – recur on the smaller subarray
                if (pivot - left < right - pivot) {
                    quicksort(arr, left, pivot - 1);
                    left = pivot + 1;
                }
                else {
                    quicksort(arr, pivot + 1, right);
                    right = pivot - 1;
                }
            }
        }
        return pivot;
    }
}
