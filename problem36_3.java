// 3. Longest Substring Without Repeating Characters
// Given a string s, find the length of the longest substring without duplicate characters.

 

// Example 1:

// Input: s = "abcabcbb"
// Output: 3
// Explanation: The answer is "abc", with the length of 3.
// Example 2:

// Input: s = "bbbbb"
// Output: 1
// Explanation: The answer is "b", with the length of 1.
// Example 3:

// Input: s = "pwwkew"
// Output: 3
// Explanation: The answer is "wke", with the length of 3.
// Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 

// Constraints:

// 0 <= s.length <= 5 * 104
// s consists of English letters, digits, symbols and spaces.


import java.util.HashSet;
import java.util.Scanner;

class problem36_3 {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int maxLength = 0;
        HashSet<Character> charSet = new HashSet<>();

        for (int right = 0; right < s.length(); right++) {
            while (charSet.contains(s.charAt(right))) {
                charSet.remove(s.charAt(left));
                left++;
            }
            
            charSet.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;       
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        scanner.close();
        
        problem36_3 solution = new problem36_3();
        int result = solution.lengthOfLongestSubstring(input);
        
        System.out.println("Length of the longest substring without repeating characters: " + result);
    }
}



/*
Algorithm:
1. Initialize two pointers `left` and `right` at the start of the string.
2. Create an empty HashSet `charSet` to store characters of the current substring.
3. Initialize `maxLength` to store the maximum length found.
4. Iterate through the string using the `right` pointer:
   a. If `s[right]` is already in `charSet`, remove characters from the left until `s[right]` is unique.
   b. Add `s[right]` to `charSet`.
   c. Update `maxLength` with the maximum value between the previous `maxLength` and the current window size (`right - left + 1`).
5. Return `maxLength` as the length of the longest substring without repeating characters.

Pseudocode:
1. Function lengthOfLongestSubstring(s):
   a. Initialize left ← 0, maxLength ← 0
   b. Create an empty HashSet charSet
   c. For right ← 0 to length of s - 1:
      i. While s[right] exists in charSet:
         - Remove s[left] from charSet
         - Increment left
      ii. Add s[right] to charSet
      iii. Update maxLength ← max(maxLength, right - left + 1)
   d. Return maxLength

2. Function main():
   a. Read input string from user
   b. Call lengthOfLongestSubstring with input string
   c. Print result
*/