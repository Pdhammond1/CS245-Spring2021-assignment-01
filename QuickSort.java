public class QuickSort {

    // Partition helper function for quickSort to call on which
    // sets pivot and gives partition index to quickSort

    private static int partition(int arr[], int begin, int end) {
        int piv = arr[end]; // pivot
        int i = (begin-1); // Index of smaller element and indicates the right position of pivot found so far

        for (int j = begin; j < end; j++) {
            // If current element is smaller than the pivot
            if (arr[j] <= piv) {
                // increment index of smaller element
                i++;
                // swap the values if less than pivot
                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        int swapTemp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = swapTemp;

        return i+1;
    }

    public static void sort(int arr[], int begin, int end) {
        if (begin < end) {

            int partitionIndex = partition(arr, begin, end);
            sort(arr, begin, partitionIndex-1);
            sort(arr, partitionIndex+1, end);
        }
    }
}
