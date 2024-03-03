import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class RadixSort {
    /*
    (code) Radix Sort [30 points]
    Write a program that takes in an array of Strings and uses radix sort to sort the array lexicographically.
    Input Format
    An array of string s. where s[i] will be a string and s can be empty.
    Constraints
    • 1 ≤ |𝑠| ≤ 10! , where |𝒔| is the length of the strings array
    • All characters in the sequences are lowercase
    • You are allowed to use the HashMap collection
    Output Format
    The sorted array + print the sorted array.
    Sample Input
    ["gojo", "google", "jogo", "bill", "pup", "cipher", "watchmen", "knight", "it", "stand", "sandman",
    "hydra", "surtr"]
    Sample Output
    bill, cipher, gojo, google, hydra, it, jogo, knight, pup, sandman, stand, surtr, watchmen
    EC Uppercase (+5 points) If your code supports Uppercase letters, where uppercase letters have
    higher precedence than lowercase letters
     */
    // radix Sort for strings
    private static void radixSort(String[] arr) {
        int maxLength = getMaxStringLength(arr);

        //iterates through each digit (character position from the right) in the strings, from
        //the most significant to the least significant, and calls countingSort for each digit.
        for (int i = maxLength - 1; i >= 0; i--) {
            countingSort(arr, i);
        }
    }

    // counting sort for strings
    private static void countingSort(String[] arr, int index) {
        final int RADIX = 52; // 26 for lowercase letters and 26 for uppercase letters

        Map<Character, List<String>> charMap = new HashMap<>();

        // initialize the map with empty lists fo each letter upper and lowercase
        for (int i = 0; i < RADIX; i++) {
            char currentChar = (i < 26) ? (char) ('a' + i) : (char) ('A' + i - 26);
            charMap.put(currentChar, new LinkedList<>());
        }

        // fill the map based on the current digit
        for (String str : arr) {
            char key = (str.length() > index) ? str.charAt(index) : 'a'; // 'a' for empty strings
            charMap.get(key).add(str);
        }

        // put in the order of the alphabet
        int i = 0;
        //uppercase first
        for (char c = 'A'; c <= 'Z'; c++) {
            List<String> list = charMap.get(c);
            for (String str : list) {
                arr[i++] = str;
            }
        }
        for (char c = 'a'; c <= 'z'; c++) {
            List<String> list = charMap.get(c);
            for (String str : list) {
                arr[i++] = str;
            }
        }
    }

    //find the maximum length of strings in the array
    private static int getMaxStringLength(String[] arr) {
        int maxLength = 0;
        for (String str : arr) {
            maxLength = Math.max(maxLength, str.length());
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String[] inputArray = {
                "gojo", "Google", "jogo", "bill", "Pup", "Cipher", "watchmen",
                "knight", "It", "stand", "Sandman", "hydra", "surtr"
        };
        String[] inputArray2 = {"gojo", "google", "jogo", "bill", "pup", "cipher", "watchmen", "knight", "it", "stand", "sandman",
                "hydra", "surtr"};

        System.out.println("Original Array: " + Arrays.toString(inputArray2));

        // sort
        radixSort(inputArray2);

        // print
        System.out.println("Sorted Array: " + Arrays.toString(inputArray2));
    }
}
