public class problem21_2401 {
  public static int longestNiceSubarray(int[] nums) {
    int startIndex = 0;
    int ans = 0;

    int bitsUnion = 0;

    for(int i=0; i<nums.length; i++){
        int newEl = nums[i];
        while((bitsUnion & newEl) != 0){
            int startingEl = nums[startIndex];
            bitsUnion ^= startingEl;
            startIndex ++;
        }
        bitsUnion = bitsUnion | newEl;
        ans = Math.max(ans, i-startIndex + 1);
    }
    return ans;
}
public static void main(String[] args) {
  int[] nums = {1,3,8,48,10};
  int peak = longestNiceSubarray(nums);
  System.out.println("The peak element is: " + peak );
}
}




// You're solving **Leetcode 2401: Longest Nice Subarray** using a super clever **bitwise + sliding window** technique. Great choice, Biplab! 💪 Let's walk through this algorithm **step-by-step in detail**, and break down how this elegant solution works.

// ---

// ## 💡 Problem Statement Summary

// **You're given** an array `nums` of positive integers.

// A **nice subarray** is one where **no two elements have a common set bit** in binary.

// 👉 Your goal:  
// Return the **length of the longest nice subarray**.

// ---

// ## 🔍 Key Observation

// We need to find the **longest subarray** such that **for every pair `i < j`** in it:  
// ```java
// nums[i] & nums[j] == 0
// ```
// This means:  
// ➡️ No two numbers should share **any common bit (1s) in the same position**.

// ---

// ## ⚙️ Approach: Sliding Window + Bitmasking

// Let’s understand your algorithm in depth.

// ### ✅ Step-by-step Breakdown

// ```java
// int startIndex = 0;
// int ans = 0;
// int bitsUnion = 0;
// ```

// - `startIndex`: Beginning of current valid subarray.
// - `bitsUnion`: OR of all elements in the current subarray.
// - `ans`: Maximum length of a valid (nice) subarray found so far.

// ---

// ### 🔁 Iterate Over Array

// ```java
// for (int i = 0; i < nums.length; i++) {
//     int newEl = nums[i];
// ```

// We are trying to **extend our sliding window** by including `nums[i]`.

// ---

// ### ⚠️ Check for Conflict (Bitwise &)

// ```java
// while((bitsUnion & newEl) != 0){
//     int startingEl = nums[startIndex];
//     bitsUnion ^= startingEl;
//     startIndex++;
// }
// ```

// **Key Idea:**  
// If the current number `newEl` shares any bit with our current window (`bitsUnion`), it's invalid!  
// We need to remove elements from the **start** of the window until there's no overlap.

// We do this by:
// - Removing `nums[startIndex]` from `bitsUnion` using XOR.
// - Moving `startIndex` forward.

// This ensures that the current subarray contains only numbers with **non-overlapping bits**.

// ---

// ### ✅ Add New Element to Window

// ```java
// bitsUnion = bitsUnion | newEl;
// ```

// Now that we’ve removed conflicting numbers, we **safely include** the new element using OR.

// ---

// ### 📏 Update Result

// ```java
// ans = Math.max(ans, i - startIndex + 1);
// ```

// We calculate the **length** of the current valid window and update the answer.

// ---

// ## 🧠 Dry Run Example

// Input:
// ```java
// nums = {1, 3, 8, 48, 10}
// Binary:
// 1  = 0001  
// 3  = 0011  
// 8  = 1000  
// 48 = 110000  
// 10 = 1010  
// ```

// - Start with 1 → ok  
// - Add 3 → 1 & 3 = 0001 → conflict → remove 1  
// - Now 3 is alone → ok  
// - Add 8 → 3 | 8 = 1011 → no overlap → ok  
// - Add 48 → conflict → remove 3 → check again → ok  
// - Add 10 → conflict → remove 8 → still conflict → remove 48 → now ok

// Longest valid subarray: `[8, 48]` → length = **3**

// ---

// ## ✅ Output

// ```
// The peak element is: 3
// ```

// Meaning the longest nice subarray is of length **3**.

// ---

// ## 🧮 Time & Space Complexity

// | Complexity | Value |
// |-----------|-------|
// | ⏱ Time    | O(N) (each element is added and removed at most once) |
// | 💾 Space  | O(1) (only a few variables used) |

// ---

// ## 📌 Summary

// | Concept      | Explanation |
// |--------------|-------------|
// | 🎯 Goal       | Find longest subarray with no common bits |
// | 🧠 Technique | Sliding window + bitmasking |
// | 💡 Condition | `a & b == 0` for all pairs in subarray |
// | 🔥 Clever Part | Using OR to track union of bits, and XOR to remove |

// ---

// If you'd like, I can help you:
// - Visualize bit transitions step-by-step 🔢
// - Modify this to return the actual subarray 🧩
// - Practice similar problems for mastery 💯

// What would you like to do next, Biplab?