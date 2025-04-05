import java.util.Scanner;

public class problem23_1614 {
      public static int maxDepth(String s) {
        int cnt = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                cnt++;
                max = Math.max(max, cnt);
            } else if (s.charAt(i) == ')') {
                cnt--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        int maxNestingDepth = maxDepth(input);
        System.out.println("Maximum nesting depth of parentheses: " + maxNestingDepth);
        scanner.close();
    }
}





// You're solving **Leetcode Problem 1614: Maximum Nesting Depth of the Parentheses** using a clean and efficient approach. Great job, Biplab! 💡 Let’s break down your code and understand the **detailed logic step-by-step**.

// ---

// ## ✅ Problem Statement Summary

// You're given a valid **parentheses string `s`**, possibly containing digits and operators (like `"1+(2*(3+4))"`).  
// You need to **find the maximum nesting depth** of the parentheses.

// ---

// ### 🧠 Example

// Input:  
// ```
// s = "(1+(2*3)+((8)/4))+1"
// ```

// Output:  
// ```
// 3
// ```

// — because the deepest nested expression is `"((8)/4)"`, which is 3 levels deep.

// ---

// ## 🔍 Understanding Your Code

// Here’s the main logic you wrote:

// ```java
// int cnt = 0;
// int max = 0;
// for (int i = 0; i < s.length(); i++) {
//     if (s.charAt(i) == '(') {
//         cnt++;
//         max = Math.max(max, cnt);
//     } else if (s.charAt(i) == ')') {
//         cnt--;
//     }
// }
// ```

// Let’s walk through it:

// ---

// ### 🧩 Step 1: Initialize Counters

// ```java
// int cnt = 0;   // current depth level
// int max = 0;   // max depth observed so far
// ```

// - `cnt` tracks the current level of nesting.
// - `max` stores the **maximum value** of `cnt` seen while scanning the string.

// ---

// ### 🧩 Step 2: Traverse Each Character in the String

// ```java
// for (int i = 0; i < s.length(); i++) {
// ```

// You loop through each character in the string.

// ---

// ### 🧩 Step 3: Update Depth Based on Parentheses

// ```java
// if (s.charAt(i) == '(') {
//     cnt++;  // Increase nesting level
//     max = Math.max(max, cnt); // Update max if needed
// } else if (s.charAt(i) == ')') {
//     cnt--;  // Close a nesting level
// }
// ```

// - When you find `'('`, it means a new level is opened. So `cnt++`.
// - You immediately check if this new `cnt` is the **maximum so far** and update `max`.
// - When you find `')'`, it means a nesting level is closing. So `cnt--`.

// ---

// ### 🧩 Step 4: Return the Result

// ```java
// return max;
// ```

// At the end of the loop, `max` contains the **maximum nesting depth**.

// ---

// ## 📦 Dry Run Example

// Let’s walk through:  
// `s = "1+(2*(3+4))"`

// ### Step-by-step:

// | Char | `cnt` | `max` |
// |------|-------|-------|
// | `1`  | 0     | 0     |
// | `+`  | 0     | 0     |
// | `(`  | 1     | 1     |
// | `2`  | 1     | 1     |
// | `*`  | 1     | 1     |
// | `(`  | 2     | 2     |
// | `3`  | 2     | 2     |
// | `+`  | 2     | 2     |
// | `4`  | 2     | 2     |
// | `)`  | 1     | 2     |
// | `)`  | 0     | 2     |

// ✅ Final Answer: `2`

// ---

// ## ⏱ Time and Space Complexity

// | Complexity | Value |
// |-----------|-------|
// | 🕒 Time    | O(n) — One pass through the string |
// | 🧠 Space   | O(1) — Constant space (only a few variables) |

// ---

// ## 🔥 Key Observations

// - You don’t need a stack here because:
//   - You're only tracking **depth**, not matching parentheses.
// - Since input is **valid**, you won’t get unmatched `')'`.

// ---

// ## ✨ Summary

// | Step | Action |
// |------|--------|
// | 1️⃣  | Initialize `cnt = 0`, `max = 0` |
// | 2️⃣  | Traverse the string |
// | 3️⃣  | Increment `cnt` on `'('`, update `max` |
// | 4️⃣  | Decrement `cnt` on `')'` |
// | 5️⃣  | Return `max` as the final answer |

// ---

// ## 💡 Bonus Tip

// If you were asked to also return the **substring with the max nesting**, you'd need a **stack**. Want to try that next?

// You're doing amazing, Biplab! This one was a neat problem to build intuition around parentheses and stack-like behavior. Want another variation or a tougher challenge on this?