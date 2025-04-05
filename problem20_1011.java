public class problem20_1011 {

    public static int findDays(int[] weights, int cap) {
        int days = 1; //First day.
        int load = 0;
        int n = weights.length; //size of array.
        for (int i = 0; i < n; i++) {
            if (load + weights[i] > cap) {
                days += 1; //move to next day
                load = weights[i]; //load the weight.
            } else {
                //load the weight on the same day.
                load += weights[i];
            }
        }
        return days;
    }

    public static int leastWeightCapacity(int[] weights, int d) {
        //Find the maximum and the summation:
        int low = Integer.MIN_VALUE, high = 0;
        for (int i = 0; i < weights.length; i++) {
            high += weights[i];
            low = Math.max(low, weights[i]);
        }

        while (low <= high) {
            int mid = (low + high) / 2;
            int numberOfDays = findDays(weights, mid);
            if (numberOfDays <= d) {
                //eliminate right half
                high = mid - 1;
            } else {
                //eliminate left half
                low = mid + 1;
            }
        }
        return low;
    }
    public static void main(String[] args) {
        int[] weights = {5, 4, 5, 2, 3, 4, 5, 6};
        int d = 5;
        int ans = leastWeightCapacity(weights, d);
        System.out.println("The minimum capacity should be: " + ans);
    }


}




// You're solving **Leetcode 1011: Capacity To Ship Packages Within D Days** using a **Binary Search on Answer** technique — nice work, Biplab! This problem is a classic **search optimization** scenario where brute force is inefficient, and binary search saves the day. Let's break the entire code and logic down in a detailed, beginner-friendly way. 🚀

// ---

// ## 🔍 Problem Statement Summary

// Given:
// - An array `weights[]` of package weights.
// - An integer `d` representing the number of days to ship all packages.

// Each day, you must ship **contiguous packages**, and the **total weight shipped in a day cannot exceed a certain capacity**.

// 👉 Your task:  
// **Find the minimum possible capacity** of the ship so that all packages are shipped within `d` days.

// ---

// ## ✅ Example

// ```java
// weights = [5, 4, 5, 2, 3, 4, 5, 6], d = 5
// ```

// We need to find the smallest ship capacity such that the packages can be shipped in at most 5 days.

// ---

// ## 🧠 High-Level Idea

// This is a classic case of **Binary Search on the Answer**:

// - The **search space** is the possible ship capacities.
// - The **range** of capacities is from:
//   - `max(weights)` → because we must be able to carry the heaviest package.
//   - `sum(weights)` → because this is the max load if we ship everything in one day.

// Then we binary search this range and check for each mid-value (capacity):  
// **Can we ship all packages in `d` days or fewer?**

// ---

// ## 🧮 Algorithm Breakdown

// ### 🔧 Step 1: Helper Method `findDays`

// ```java
// public static int findDays(int[] weights, int cap)
// ```

// - Simulates the **number of days needed** if ship capacity = `cap`.
// - For each weight:
//   - If adding this package **exceeds the capacity**, start a **new day** and reset the load.
//   - Else, **accumulate** the weight into current day's load.

// 💡 **Greedy strategy**: Ship as much as possible each day without exceeding capacity.

// ---

// ### 🔍 Step 2: Binary Search Logic

// ```java
// public static int leastWeightCapacity(int[] weights, int d)
// ```

// #### 🔹 Initialization:

// ```java
// int low = max(weights); // can't ship less than the heaviest package
// int high = sum(weights); // worst case, ship all in one day
// ```

// #### 🔹 Binary Search:

// ```java
// while(low <= high){
//     int mid = (low + high) / 2;
//     int numberOfDays = findDays(weights, mid);
    
//     if(numberOfDays <= d){
//         high = mid - 1; // try smaller capacity
//     } else {
//         low = mid + 1;  // need bigger capacity
//     }
// }
// ```

// - If you can do it in ≤ `d` days, try to minimize capacity → search left half.
// - Otherwise, you need more capacity → search right half.

// 🟩 Eventually, `low` will be the **minimum valid capacity**.

// ---

// ## 🧮 Dry Run Example

// ```java
// weights = [5, 4, 5, 2, 3, 4, 5, 6]
// d = 5

// max = 6
// sum = 34
// So: low = 6, high = 34
// ```

// We binary search [6...34], trying mid-values to see if we can ship within 5 days.

// At each step, we:
// 1. Try mid-capacity
// 2. Use `findDays()` to simulate shipping
// 3. Adjust the search space based on how many days it took

// Eventually, binary search finds the minimum capacity that works.

// ---

// ## 💡 Output

// ```
// The minimum capacity should be: 9
// ```

// This means: With a ship capacity of **9**, we can finish shipping in **5 days** — and there's **no smaller capacity** that works.

// ---

// ## 📊 Time & Space Complexity

// | Complexity | Value |
// |-----------|-------|
// | ⏱ Time    | O(N * log(S - M)) where:  
// N = #packages,  
// S = sum of weights,  
// M = max of weights |
// | 💾 Space  | O(1) (no extra space used) |

// ---

// ## ✅ Summary

// | Step | Description |
// |------|-------------|
// | 🎯 Goal | Minimize the capacity to ship all packages in `d` days |
// | 🔍 Method | Binary Search on answer |
// | 🧮 Check | Greedily count days with a given capacity |
// | 🧠 Key Insight | Capacity must be between `max(weights)` and `sum(weights)` |

// ---

// If you want, I can help you:
// - 🧪 Add edge case handling
// - 🔁 Turn this into a generic binary search template
// - 🎯 Convert this into interview-style explanations

// Let me know what you'd like to dive into next, Biplab!