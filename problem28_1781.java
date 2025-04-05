// 1781. Sum of Beauty of All Substrings
// Hint
// The beauty of a string is the difference in frequencies between the most frequent and least frequent characters.

// For example, the beauty of "abaacc" is 3 - 1 = 2.
// Given a string s, return the sum of beauty of all of its substrings.

 

// Example 1:

// Input: s = "aabcb"
// Output: 5
// Explanation: The substrings with non-zero beauty are ["aab","aabc","aabcb","abcb","bcb"], each with beauty equal to 1.
// Example 2:

// Input: s = "aabcbaa"
// Output: 17
 



import java.util.Scanner;

public class problem28_1781 {
      public int beautySum(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int[] freq = new int[26];
            for (int j = i; j < n; j++) {
                freq[s.charAt(j) - 'a']++;
                int min = getMin(freq);
                int max = getMax(freq);
                int beauty = max - min;
                ans += beauty;
            }
        }
        return ans;
    }

    private int getMax(int[] freq) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0) {
                max = Math.max(max, freq[i]);
            }
        }
        return max;
    }

    private int getMin(int[] freq) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0) {
                min = Math.min(min, freq[i]);
            }
        }
        return min;
    }

    // Main method to test the solution
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        
        problem28_1781 solution = new problem28_1781();
        int result = solution.beautySum(input);
        
        System.out.println("Beauty sum of the string: " + result);
        
        scanner.close();
    }
}


// Algorithm (Brute Force Approach)
// Initialize Variables:

// ans to store the total sum of beauties.

// n = s.length() to store the length of the string.

// Generate All Possible Substrings:

// Use a nested loop:

// Outer loop (i) starts at index 0 and iterates until n-1.

// Inner loop (j) starts at index i and iterates until n-1.

// Maintain an array freq[26] to store the frequency of characters in the current substring.

// Update Frequencies:

// For every new character s[j], increase its frequency in freq[].

// Compute the min and max frequency of characters present using helper functions:

// getMax(freq): Finds the most frequent character.

// getMin(freq): Finds the least frequent character.

// Compute beauty as max - min and add it to ans.

// Return the Total Beauty Sum.

// Pseudocode:
// perl
// Copy
// Edit
// FUNCTION beautySum(s):
//     n ← length of s
//     ans ← 0

//     FOR i ← 0 TO n-1:
//         freq[26] ← {0}  // Initialize frequency array

//         FOR j ← i TO n-1:
//             freq[s[j] - 'a']++  // Update frequency

//             minFreq ← getMin(freq)
//             maxFreq ← getMax(freq)

//             beauty ← maxFreq - minFreq
//             ans ← ans + beauty  // Accumulate beauty sum

//     RETURN ans


// FUNCTION getMax(freq):
//     max ← MIN_VALUE
//     FOR i ← 0 TO 25:
//         IF freq[i] > 0 THEN
//             max ← max(freq[i], max)
//     RETURN max


// FUNCTION getMin(freq):
//     min ← MAX_VALUE
//     FOR i ← 0 TO 25:
//         IF freq[i] > 0 THEN
//             min ← min(freq[i], min)
//     RETURN min


// // Main function
// BEGIN
//     PRINT "Enter a string: "
//     INPUT s
//     result ← beautySum(s)
//     PRINT "Beauty sum of the string: ", result
// END
// Time & Space Complexity Analysis:
// Time Complexity:

// O(N² × 26) ≈ O(N²)

// We are generating all substrings O(N²) and calculating min & max in O(26) = O(1) time.

// Space Complexity:

// O(1) (Only a constant-sized frequency array is used).
