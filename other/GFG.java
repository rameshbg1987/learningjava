package other;

class GFG {

    // Find the maximum possible sum in arr[]
    // such that arr[m] is part of it
    static int maxCrossingSum(int arr[], int left, int mid, int right) {
        // Include elements on left of mid.
        int sum = 0;
        int left_sum = Integer.MIN_VALUE;
        for (int i = mid; i >= left; i--) {
            sum = sum + arr[i];
            if (sum > left_sum)
                left_sum = sum;
        }

        // Include elements on right of mid
        sum = 0;
        int right_sum = Integer.MIN_VALUE;
        for (int i = mid + 1; i <= right; i++) {
            sum = sum + arr[i];
            if (sum > right_sum)
                right_sum = sum;
        }

        // Return sum of elements on left
        // and right of mid
        return left_sum + right_sum;
    }

    // Returns sum of maxium sum subarray
    // in aa[l..h]
    static int maxSubArraySum(int arr[], int left, int right) {
        // Base Case: Only one element
        if (left == right)
            return arr[left];

        // Find middle point
        int m = (left + right) / 2;

        /*
         * Return maximum of following three possible cases: a) Maximum subarray
         * sum in left half b) Maximum subarray sum in right half c) Maximum
         * subarray sum such that the subarray crosses the midpoint
         */
        int leftArray = maxSubArraySum(arr, left, m);
        int rightArray = maxSubArraySum(arr, m + 1, right);
        int crossMid = maxCrossingSum(arr, left, m, right);
        int leftRightMax = Math.max(leftArray, rightArray);
        return Math.max(leftRightMax, crossMid);
    }

    /* Driver program to test maxSubArraySum */
    public static void main(String[] args) {
        int arr[] = { -2, 3, -4, 5, 7 };
        int n = arr.length;
        int max_sum = maxSubArraySum(arr, 0, n - 1);

        System.out.println("Maximum contiguous sum is " + max_sum);
    }
}