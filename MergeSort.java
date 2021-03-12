public class MergeSort {

    // Merge helper function for mergeSort to call on which
    // merges two sub arrays of arr[], first sub array is arr[first..m]
    // second sub array is arr[m+1..last]

    public static void merge(int arr[], int first, int m, int last) {
        // Find sizes of two sub arrays to be merged
        int n1 = m - first + 1;
        int n2 = last - m;

        // Create temp arrays
        int temp1[] = new int[n1];
        int temp2[] = new int[n2];

        //Copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            temp1[i] = arr[first + i];
        for (int j = 0; j < n2; ++j)
            temp2[j] = arr[m + 1 + j];

        // Merge the temp arrays

        // Initial indexes of first and second sub arrays
        int i = 0, j = 0;

        // Initial index of merged sub array
        int k = first;
        while (i < n1 && j < n2) {
            if (temp1[i] <= temp2[j]) {
                arr[k] = temp1[i];
                i++;
            }
            else {
                arr[k] = temp2[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of temp1[] if any
        while (i < n1) {
            arr[k] = temp1[i];
            i++;
            k++;
        }

        // Copy remaining elements of temp2[] if any
        while (j < n2) {
            arr[k] = temp2[j];
            j++;
            k++;
        }
    }

    // Main mergeSort function that sorts arr[begin..end] using merge()

    public static void sort(int arr[], int begin, int end) {

        if (begin < end) { // Find the middle point
            int m = begin + (end - begin)/2;
            // Sort first and second halves
            sort(arr, begin, m);
            sort(arr,m + 1, end);
            // Merge the sorted halves
            merge(arr, begin, m, end);
        }
    }
}
