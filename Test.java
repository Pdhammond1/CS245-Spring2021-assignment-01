import java.util.concurrent.TimeUnit;
import java.util.Random;
import java.util.Arrays;

public class Test {

    public static void main(String[] args) throws InterruptedException {

        double nums[] = new double[20000]; // test array

        for (int i=0; i<nums.length; i++){

            Random rand = new Random();
            int upperbound = 100;

            //generate random values from 0-99
            int int_random = rand.nextInt(upperbound-1);
            nums[i]=int_random;
        }

        System.out.println("Nums before Quick sort: ");
        // System.out.println(Arrays.toString(nums));

        long startTime = System.currentTimeMillis();

        int index = QuickerThanQuickSort.quicksort(nums, 0, nums.length-1); //Calls on any sort desired

        // the code being measured ends
        long endTime = System.currentTimeMillis();
        long timeElapsed = endTime - startTime;

        System.out.println("\nExecution time in milliseconds: " + timeElapsed);
        System.out.println(index);
        // System.out.println(Arrays.toString(nums));

    }
}

