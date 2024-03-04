import java.util.HashSet;

public class SubInteger {
    /*
    Consider two sets of integers, S and T.
    Devise an algorithm that uses a hash table to test whether S is a subset of T.
    S is considered a subset of T if every element in S in an element in T (Not necessarily in the same order).
    Constraints
    • Numbers in the arrays will be in the range [0, 100]
    • The input will be two arrays of integers
    • A number may appear only once in a set (no duplicates)
    Output Format
    For each string, return Yes is S is a subset of T and No otherwise
    Sample Input
    S = {32, 3} T = {1, 2, 3, 52, 32, 54}
    Sample Output
    Yes
    Sample Input
    S = {89, 32, 54, 32, 3} T = {54, 32, 99}
    Sample Output
    No
    Sample Input
    S = {0, 67} T = {100, 5, 66, 2, 32, 90}
    Sample Output
    No
    Sample Input
    S = {} T = {54, 32, 99}
    Sample Output
    Yes
    */
    public static String isSubset(int[] S, int[] T) {
        HashSet<Integer> hashSet = new HashSet<>();

        // populate the hash set with  T
        for (int num : T) {
            hashSet.add(num);
        }

        // check if every element in S is present in the hash set
        for (int num : S) {
            if (!hashSet.contains(num)) {
                return "No";
            }
        }

        // if all elements in S are found in T, then S is a subset of T
        return "Yes";
    }

    public static void main(String[] args) {
        // examples
        int[] S1 = {32, 3};
        int[] T1 = {1, 2, 3, 52, 32, 54};
        System.out.println(isSubset(S1, T1)); // yes

        int[] S2 = {89, 32, 54, 32, 3};
        int[] T2 = {54, 32, 99};
        System.out.println(isSubset(S2, T2)); // no

        int[] S3 = {0, 67};
        int[] T3 = {100, 5, 66, 2, 32, 90};
        System.out.println(isSubset(S3, T3)); // no

        int[] S4 = {};
        int[] T4 = {54, 32, 99};
        System.out.println(isSubset(S4, T4)); // yes
    }
}
