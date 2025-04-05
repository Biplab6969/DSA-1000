public class problem19_1529 {
  // public int findKthPositive(int[] arr, int k) {
    //     Bruteforce solution

    //     int n = arr.length;
    //     for(int i=0; i<n; i++){
    //         if(arr[i] <= k){
    //             k += 1;
    //         } else {
    //             break;
    //         }
    //     }
    //     return k;
    // }

    private static int findKthPositive(int[] arr, int k) {

      //optimal approach
      int start = 0;
      int end = arr.length -1;
      while(start <= end){
          int mid = start + (end - start)/2;
          int missing = arr[mid] - (mid + 1);
          if(missing < k){
              start = mid + 1;
          } else {
              end = mid - 1;
          }
      }
      return end + 1 + k;
  }
  public static void main(String[] args) {
    int[] arr  = {2,3,4,7,11};
    int k = 5;
    int ans = findKthPositive( arr, k);
    System.out.println("The minimum divisor is: " + ans);
  }
}





// You're solving **Leetcode Problem 1539: Kth Missing Positive Number** using an **optimal binary search approach** — great choice, Biplab! Let’s go through the entire logic step-by-step so you can **fully master** this pattern. 🚀

// ---

// ## 🧩 Problem Summary

// You're given a **strictly increasing array** `arr[]` of **positive integers**.

// You need to find the **k-th missing positive number** that’s **not** in the array.

// ---

// ## 📘 Example

// ```java
// Input: arr = [2, 3, 4, 7, 11], k = 5
// Missing numbers: [1, 5, 6, 8, 9, 10, 12, ...]
// The 5th missing = 9
// Output: 9
// ```

// ---

// ## 🧠 Brute Force Approach (What you commented out)

// - Loop through `arr`, increase `k` if the number is not missing.
// - Time Complexity: O(n)
// - You cleverly replaced it with an **O(log n)** approach.

// ---

// ## 🚀 Optimal Binary Search Approach

// ### 🔑 Key Insight:

// At any index `i` in the array:

// - The number of **missing positive integers** before `arr[i]` is:
//   ```
//   missing = arr[i] - (i + 1)
//   ```

// 👉 Why?

// - At index `i`, the expected value (if no numbers were missing) should be `i + 1`.
// - If `arr[i]` is bigger than that, the difference is the number of missing values before that point.

// ---

// ## 🧮 Algorithm Step-by-Step

// ### ✅ Step 1: Initialize Binary Search
// ```java
// int start = 0;
// int end = arr.length - 1;
// ```

// ### ✅ Step 2: Binary Search Loop
// ```java
// while(start <= end) {
//     int mid = start + (end - start)/2;
//     int missing = arr[mid] - (mid + 1);
    
//     if(missing < k){
//         start = mid + 1;
//     } else {
//         end = mid - 1;
//     }
// }
// ```

// - If `missing < k`, the missing number is further to the right → shift `start`.
// - If `missing >= k`, the missing number is to the left → shift `end`.

// ### ✅ Step 3: Return the Answer
// ```java
// return end + 1 + k;
// ```

// - After the loop:
//   - `end` is the **last index** where missing numbers are **< k**.
//   - So the answer is: `(end + 1)` numbers are **present**, so the k-th missing is:
//     ```
//     k + how many are present = k + end + 1
//     ```

// ---

// ## 🧮 Dry Run of Example

// ```java
// arr = [2, 3, 4, 7, 11], k = 5
// ```

// ### Binary Search Progress:
// - mid = 2 → arr[2] = 4 → missing = 4 - (2 + 1) = 1 < 5 → move right
// - mid = 3 → arr[3] = 7 → missing = 7 - (3 + 1) = 3 < 5 → move right
// - mid = 4 → arr[4] = 11 → missing = 11 - (4 + 1) = 5 → equals 5 → move left

// Final: `start = 4`, `end = 3`

// Answer:
// ```
// end + 1 + k = 3 + 1 + 5 = 9 ✅
// ```

// ---

// ## ✅ Output:
// ```
// The minimum divisor is: 9
// ```

// *(This message is a copy-paste bug from earlier — it should say “The kth missing number is: 9” 😉)*

// ---

// ## 📊 Time and Space Complexity

// | Complexity | Value     |
// |------------|-----------|
// | 🕒 Time     | O(log n)  |
// | 💾 Space    | O(1)      |

// ---

// ## 🧠 Final Thoughts

// | ✅ | Key Concepts Used |
// |----|-------------------|
// | 🔍 | Binary Search on Index |
// | 🧮 | Calculating missing using `arr[i] - (i + 1)` |
// | 🧠 | Insightful math + search = optimized solution |

// ---

// Would you like me to:
// - ⚙️ Refactor the code a bit for readability?
// - 📝 Help you build a custom visualization/dry run table?
// - 📘 Convert this into quick flashcards for revision?

// Just let me know, Biplab!