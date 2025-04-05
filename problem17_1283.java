public class problem17_1283 {

  private static int sumByD(int[] nums, int mid){
    int n = nums.length;
    int sum = 0;
    for(int i=0; i<n; i++){
        sum += Math.ceil((double)(nums[i]) / (double)(mid));
    }
    return sum;
}

private static int smallestDivisor(int[] nums, int threshold) {
int n = nums.length;
if(n > threshold){
    return -1;
}

int maxi = Integer.MIN_VALUE;
for(int i=0; i<n; i++){
    maxi = Math.max(maxi, nums[i]);
}
int low = 1;
int high = maxi;
while(low <= high){
    int mid = low + (high - low)/2;
    if(sumByD(nums, mid) <= threshold){
        high = mid - 1;
    } else {
        low = mid + 1;
    }
}
return low;
}
  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 4, 5};
    int threshold = 8;
    int ans = smallestDivisor( nums, threshold);
    System.out.println("The minimum divisor is: " + ans);
}
}




// 🧠 Algorithm Explained Step-by-Step
// ✅ Step 1: Define the Search Space
// java
// Copy
// Edit
// low = 1;
// high = max(nums);
// The smallest divisor can be 1 (which gives the maximum sum).

// The largest divisor we need to check is max(nums) (which makes each division equal to 1, so the sum becomes nums.length).

// ✅ Step 2: Create a Function to Compute the Sum
// java
// Copy
// Edit
// sum += Math.ceil((double)(nums[i]) / (double)(mid));
// For a candidate divisor mid, you check how many units each nums[i] contributes by doing a rounded-up division.

// Math.ceil() is used because even if there's a fraction (like 2.1), it should be counted as 3.

// ✅ Step 3: Binary Search on Answer
// java
// Copy
// Edit
// while(low <= high):
//     mid = (low + high) / 2;
//     if (sumByD(nums, mid) <= threshold):
//         high = mid - 1;  // Try smaller divisor
//     else:
//         low = mid + 1;   // Increase divisor to reduce sum
// If current mid gives a total sum within threshold, try to minimize mid.

// If it exceeds the threshold, increase mid.

// ✅ Step 4: Return Final Answer
// java
// Copy
// Edit
// return low;
// After the loop ends, low holds the smallest divisor that satisfies the condition.

