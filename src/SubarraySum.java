public class SubarraySum {
    /*
    Given as input an unsorted array A of non-negative integers and an integer target K, write a method
    sumTarget that finds a subarray of A with a sum equal to K (if one exists). The method should return
    the indices at which the subarray starts and ends. If no subarray exists, the start and end indices will be
    set to -1.
    A subarray is a contiguous non-empty sequence of elements within an array.
    You may assume K ≥ 0.
    Example 1, if input is A = [1, 2, 3, 7, 5], K = 12
    • The method will return either [1, 3] or [3,4]
    Explanation:
    The sum of the elements in the subarray from index 1 to index 3 [2, 3, 7] is 12.
    The sum of the elements in the subarray from index 3 to index 4 [7, 5] is 12.
    Example 2, if input is A = [1, 2, 3, 7, 5], K = 5
    • The method will return either [1, 2] or [4, 4]
    Explanation:
    The sum of the elements in the subarray from index 1 to index 2 [2, 3] is 5.
    The sum of the elements in the subarray from index 4 to index 4 [5] is 5.
    Example 3, if input is A = [1, 2, 3, 7, 5], K = 7
    • The method will return [3, 3]
    Explanation:
    The sum of the elements in the subarray from index 1 to index 2 [2, 3] is 5.
    The sum of the elements in the subarray from index 4 to index 4 [5] is 5.
    Example 4, if input is A = [1, 2, 3, 7, 5], K = 11
    • The method will return [-1, -1]
    Explanation:
    There is no subarray in A for which the sum of its elements adds up to 11
     */


    public static int[] sumTarget(int[] A, int K) {
        int n = A.length;
        int[] result = {-1, -1};
        //int currentSum = 0;
        //int start =0;

        //start at first index as the first index of subarray and iterate through
       for (int start = 0; start < n; start++) {
           //initialize current sum
            int currentSum = 0;
            //see if a subarray can be made by adding the next indices
            for (int end = start; end < n; end++) {
                currentSum += A[end];

                //if sum is the target at the indices of the subarray to results
                if (currentSum == K) {
                    result[0] = start;
                    result[1] = end;
                    return result;
                }
            }
        }
        //if no subarray found return [-1,-1]
        return result;
    }

    public static void main(String[] args) {
        //examples
        int[] A1 = {1, 2, 3, 7, 5};
        int K1 = 12;
        int[] result1 = sumTarget(A1, K1);
        //[1,3] or [3,4]
        System.out.println("Result 1: [" + result1[0] + ", " + result1[1] + "]");

        int[] A2 = {1, 2, 3, 7, 5};
        int K2 = 5;
        int[] result2 = sumTarget(A2, K2);
        //[1,2] or [4,4]
        System.out.println("Result 2: [" + result2[0] + ", " + result2[1] + "]");

        int[] A3 = {1, 2, 3, 7, 5};
        int K3 = 7;
        int[] result3 = sumTarget(A3, K3);
        //[3,3]
        System.out.println("Result 3: [" + result3[0] + ", " + result3[1] + "]");

        int[] A4 = {1, 2, 3, 7, 5};
        int K4 = 11;
        int[] result4 = sumTarget(A4, K4);
        //[-1,-1]
        System.out.println("Result 4: [" + result4[0] + ", " + result4[1] + "]");
    }
}
