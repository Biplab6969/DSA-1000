




// 📘 Algorithm Explanation
// ✅ Step 1: Handle Base Cases
// java
// Copy
// Edit
// if (n == 1) return 0;
// if (nums[0] > nums[1]) return 0;
// if (nums[n-1] > nums[n-2]) return n-1;
// If only one element, it's a peak by default.

// If first element is greater than second → it's a peak.

// If last element is greater than second last → it's also a peak.

// ✅ Step 2: Binary Search (Core Logic)
// Initialize:

// java
// Copy
// Edit
// int low = 1;
// int high = n - 2;
// Loop:

// java
// Copy
// Edit
// while (low <= high) {
//     int mid = low + (high - low) / 2;
// ✔️ Check if mid is a peak:
// java
// Copy
// Edit
// if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
//     return mid;
// }
// If it's greater than both neighbors, it's a peak → return the index.

// 📈 Slope Analysis:
// java
// Copy
// Edit
// else if (nums[mid] > nums[mid - 1]) {
//     low = mid + 1; // Ascending slope → peak is to the right
// } else {
//     high = mid - 1; // Descending slope → peak is to the left
// }
// This helps narrow down the peak efficiently in O(log n) time.

// ✅ Step 3: Return -1 (in theory shouldn't happen)
// If the loop ends and no peak is found, return -1 as a fallback (for safety).

// 🔍 Dry Run Example
// java
// Copy
// Edit
// nums = {1, 2, 1, 3, 5, 6, 4}
// low = 1, high = 5

// mid = 3, nums[3] = 3

// 3 < 5 and 3 > 1 → not a peak → nums[mid] > nums[mid-1]

// Move right: low = mid + 1 = 4

// mid = 4, nums[4] = 5

// 5 < 6 and 5 > 3 → again not a peak → move right: low = 5

// mid = 5, nums[5] = 6

// 6 > 5 and 6 > 4 → YES ✅ it's a peak → return 5

// 🧮 Time and Space Complexity
// Metric	Complexity
// Time Complexity	O(log n) ✅
// Space Complexity	O(1) ✅