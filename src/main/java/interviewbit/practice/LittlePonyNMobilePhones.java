package src.main.java.interviewbit.practice;

public class LittlePonyNMobilePhones {

    public int[] solve(int[] A, int[] B) {

        return maxNoOfMob(A, B);
    }
    // sort the array
    // prices = price of mobile, queries money you have, return num of mobiles you can purchase for money you have
    public int[] maxNoOfMob(int[] prices, int[] queries){
        int lenP = prices.length, lenQ = queries.length;
        int[] output = new int[lenQ]; // output of no of mobiles for each query
        for(int i = 1; i < lenP; i++) {
            prices[i] += prices[i-1]; // add sum of prev + curr price to current index
        }

        for(int i = 0; i < lenQ; i++) {
            output[i] = searchReqPrice(prices, queries[i]); // binary search
        }

        return output;
    }

    // binary search
    public int searchReqPrice(int[] priceList, int val) {
        int len = priceList.length, indexOfPrice = 0;

        int l = 1, r = len; // seacrh space from 1 to len, coz 1 based index
        while(l <= r) {
            int m = (l + ((r - l) >> 1));
            int price = priceList[m-1]; // search for m-1 coz 1 based index
            if(price == val) {
                indexOfPrice = m;
                break;
            } else if(price > val) {
                r = m - 1;
            } else {
                indexOfPrice = m; // potential val for index
                l = m + 1;
            }
        }

        return indexOfPrice;
    }

    public void sort(int[] A) {

        quicksort(A, 0, A.length-1);
    }

    public void quicksort(int[] A, int l, int r) {
        if(l >= r) return;

        int pivot = rearrange(A, l, r);
        quicksort(A, l, pivot-1);
        quicksort(A, pivot+1, r);
    }

    public int rearrange(int[] A, int l, int r) {
        int p1 = l+1, p2 = r;

        while(p1 <= p2) {
            if(A[p1] <= A[l]) p1++;
            else if(A[p2] > A[l]) p2++;
            else {
                swap(A, p1, p2);
            }
        }

        swap(A, p1-1, l);
        return p1-1;
    }

    public void swap(int[] A, int a, int b) {
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }
}
