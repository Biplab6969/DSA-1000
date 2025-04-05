public class problem18_1482 {
  private static boolean possible(int[] bloomDay, int mid, int m, int k){
    int n = bloomDay.length;
    int count = 0;
    int bouquts = 0;
    for(int i=0; i<n; i++){
        if(bloomDay[i] <= mid){
            count++;
        } else {
            bouquts += (count/k);
            count = 0;
        }
    }
    bouquts += (count/k);
    return bouquts >= m;
    
}
private static int minDays(int[] bloomDay, int m, int k) {
int n = bloomDay.length;
long multi = (long)m*k;
if(n < multi){
    return -1;
}

int maxi = Integer.MIN_VALUE;
for(int i=0; i<n; i++){
    maxi = Math.max(maxi, bloomDay[i]);
}
int mini = Integer.MAX_VALUE;
for(int i=0; i<n; i++){
    mini = Math.min(mini, bloomDay[i]);
}


int low = mini;
int high = maxi;
while(low <= high){
    int mid = low + (high - low)/2;
    if(possible(bloomDay, mid,  m, k)){
        high = mid - 1;
    } else {
        low = mid + 1;
    }
}
return low;

}


public static void main(String[] args) {
  int[] bloomDay = {1,10,3,10,2};
  int m = 3;
  int k = 1;
  int ans = minDays( bloomDay, m, k);
  System.out.println("The minimum divisor is: " + ans);
}
}



// You're solving **Leetcode Problem 1482: Minimum Number of Days to Make m Bouquets** using **Binary Search on the Answer**, and it's a great example of how to apply binary search in problems involving constraints.

// Let’s break it down in full detail for you, Biplab. 🚀

// ---

// ## 🧩 **Problem Summary**

// You're given:

// - An array `bloomDay[]` where `bloomDay[i]` tells you **on which day the `i-th` flower blooms**.
// - Two integers:
//   - `m` = number of **bouquets** you want to make.
//   - `k` = number of **adjacent flowers** needed in one bouquet.

// ---

// ### 🧠 Goal:
// > Find the **minimum number of days** required to make `m` bouquets, where each bouquet needs `k` **adjacent** bloomed flowers.

// If it's **not possible**, return `-1`.

// ---

// ## 🧠 High-Level Idea

// We want to find the **minimum day `d`** such that we can pick **at least `m` bouquets**, each made up of `k` **adjacent** flowers that have bloomed **on or before day `d`**.

// This can be solved by applying **binary search on the number of days**.

// ---

// ## 🧠 Key Observations

// - The number of bouquets you can make is **monotonically increasing** with the number of days.
//   - More days = more flowers bloom = more bouquet possibilities.
// - So, we can do a **binary search on days** (range from min bloom day to max bloom day) to find the **minimum day** that works.

// ---

// ## 🧮 Step-by-Step Algorithm

// ---

// ### ✅ Step 1: Edge Case Check

// ```java
// if(n < m * k)
//     return -1;
// ```

// - If there are **not enough flowers**, return `-1` immediately.

// ---

// ### ✅ Step 2: Define Binary Search Range

// ```java
// int low = min(bloomDay), high = max(bloomDay);
// ```

// - `low` = earliest bloom day
// - `high` = latest bloom day

// We will **binary search** in this range for the **minimum number of days** required.

// ---

// ### ✅ Step 3: Define the `possible()` Function

// This checks:
// > Can we make `m` bouquets using only flowers that bloomed **on or before day `mid`**?

// #### Logic:
// ```java
// if(bloomDay[i] <= mid) {
//     count++; // it's a bloomed flower
// } else {
//     bouquts += (count / k);
//     count = 0;
// }
// ```

// - `count` tracks how many **consecutive bloomed** flowers we have.
// - When we hit a non-bloomed flower, we see how many bouquets we can make with the current `count`.
// - After the loop, we do one last bouquet calculation.

// Then return:
// ```java
// return bouquts >= m;
// ```

// ---

// ### ✅ Step 4: Binary Search Loop

// ```java
// while(low <= high){
//     int mid = (low + high) / 2;
//     if(possible(mid)) {
//         high = mid - 1; // Try smaller day
//     } else {
//         low = mid + 1; // Need more days
//     }
// }
// return low;
// ```

// - If it's **possible** to make the required bouquets in `mid` days, try to minimize it.
// - If not, you need **more days**, so move right.

// ---

// ### 🧮 Dry Run Example

// #### Input:
// ```java
// bloomDay = [1,10,3,10,2], m = 3, k = 1
// ```

// - Need 3 bouquets, each of size 1 (so total 3 flowers).

// #### bloomDay Sorted: [1, 2, 3, 10, 10]

// #### Binary Search Range: 1 → 10

// - Try mid = 5 → check how many flowers bloom ≤ 5
//   - bloomed: [1, 3, 2]
//   - Total: 3 flowers → ✅ possible

// Try to minimize:
// - mid = 3 → flowers: [1, 3, X, X, 2] → 3 flowers ✅
// - mid = 2 → [1, X, X, X, 2] → only 2 flowers ❌

// Final answer = **3**

// ---

// ## ✅ Output:
// ```
// The minimum divisor is: 3
// ```

// ---

// ## 📊 Time and Space Complexity

// | Complexity | Value |
// |------------|-------|
// | 🕒 Time     | `O(n * log(max(bloomDay)))` |
// | 💾 Space    | `O(1)` (no extra space)     |

// ---

// ## 📌 Summary

// | Step | Description |
// |------|-------------|
// | 1️⃣   | Binary search the answer (`min day` to `max day`) |
// | 2️⃣   | For each mid (day), check if it's **possible** to make `m` bouquets |
// | 3️⃣   | Use consecutive bloomed flower logic in `possible()` |
// | 4️⃣   | Binary search narrows to smallest day satisfying the condition |

// ---

// Would you like me to generate:
// - 🔁 Pseudocode
// - 🔍 Flowchart
// - 📘 PDF revision notes
// - 👨‍💻 Dry run trace for a custom input

// Just say the word, Biplab!