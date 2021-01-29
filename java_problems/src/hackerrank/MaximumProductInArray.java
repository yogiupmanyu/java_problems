package hackerrank;

//without sorting
/**
 * A unsorted array of integers is given; you need to find the max product formed my multiplying three numbers.array can
 * have negative values
 * method 1 :
 * step 1 : find firstMax , secondMax , thirdMax positive (obviously only then they can be max) -t
 * step 2 : find firstMin , secondMin ( if these value will be negative and multiplication of them is positive and can
 * be greater than -t
 * get max of from step 1 and step 2
 *
 *
 * Approach 2: O(n) Time, O(n) Space
 *
 *     Construct four auxiliary arrays leftMax[], rightMax[], leftMin[] and rightMin[] of same size as input array.
 *     Fill leftMax[], rightMax[], leftMin[] and rightMin[] in below manner.
 *         leftMax[i] will contain maximum element on left of arr[i] excluding arr[i]. For index 0, left will contain -1.
 *         leftMin[i] will contain minimum element on left of arr[i] excluding arr[i]. For index 0, left will contain -1.
 *         rightMax[i] will contain maximum element on right of arr[i] excluding arr[i]. For index n-1, right will contain -1.
 *         rightMin[i] will contain minimum element on right of arr[i] excluding arr[i]. For index n-1, right will contain -1.
 *     For all array indexes i except first and last index, compute maximum of arr[i]*x*y where x can be leftMax[i] or leftMin[i]
 *     and y can be rightMax[i] or rightMin[i].
 *     Return the maximum from step 3.
 * */
public class MaximumProductInArray {

    /* Function to find a maximum product of a triplet in array of integers of size n */
    static int maxProduct(int []arr, int n) {
        return 0;
    }
        public static void main (String[] args)
    {
        int []arr = { 1, 4, 3, -6, -7, 0 };
        int n = arr.length;

        int max = maxProduct(arr, n);

        if (max == -1)
            System.out.println("No Triplet Exists");
        else
            System.out.println("Maximum product is "+max);
    }
}
