package src.main.java.interviewbit.practice;

/*
https://www.geeksforgeeks.org/n-th-number-with-digits-in-0-1-2-3-4-5/?ref=lbp
 */
public class FindNthNumber {
    static final int max = 100000;

    // function to convert num to base 6
    static int baseconversion(int arr[],
                              int num, int base)
    {
        int i = 0, rem, j;

        if (num == 0) {
            return 0;
        }

        while (num > 0) {

            rem = num % base;
            arr[i++] = rem;
            num /= base;
        }

        return i;
    }

    static int ans(int n)
    {

        // If the Number is less than 6 return
        // the number as it is.
        if (n < 6)
        {
            return n;
        }

        // Call the function again and again
        // the get the desired result.
        // And convert the number to base 6.
        return n % 6 + 10 * (ans(n / 6));
    }

    static int getSpecialNumber(int N)
    {

        // Decrease the Number by 1 and Call
        // ans function to convert N to base 6
        return ans(--N);
    }

    // Driver code
    public static void main (String[] args)
    {

        // initialize an array to 0
        int arr[] = new int[max];

        int n = 10;

        // function calling to convert
        // number n to base 6
        int size = baseconversion(arr, n - 1, 6);

        // if size is zero then return zero
        if (size == 0)
            System.out.print(size);

        for (int i = size - 1; i >= 0; i--) {
            System.out.print(arr[i]);
        }
    }

}
