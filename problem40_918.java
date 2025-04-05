
  import java.util.Scanner;

class problem40_918 {
    public int maxSubarraySumCircular(int[] nums) {
        int sum = 0;
        int max = nums[0];
        int min = nums[0];
        int total = 0;

        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }

        sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (sum > max) {
                max = sum;
            }

            if (sum < 0) {
                sum = 0;
            }
        }

        sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (sum < min) {
                min = sum;
            }

            if (sum > 0) {
                sum = 0;
            }
        }

        if (max < 0) {
            return max;
        }

        return Math.max(max, total - min);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array:");
        int n = sc.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter " + n + " elements:");
        for(int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        problem40_918 sol = new problem40_918();
        int result = sol.maxSubarraySumCircular(nums);
        System.out.println("Maximum circular subarray sum: " + result);
    }
}




// ✅ Algorithm Explanation Step-by-Step:
// 1. Initialize variables:
// java
// Copy
// Edit
// int sum = 0;
// int max = nums[0];
// int min = nums[0];
// int total = 0;
// sum: Temporary sum for Kadane's algorithm.

// max: Stores max subarray sum (non-circular).

// min: Stores min subarray sum (used for circular case).

// total: Stores total sum of array.

// 2. Calculate total sum of the array:
// java
// Copy
// Edit
// for(int i = 0; i < nums.length; i++){
//     total += nums[i];
// }
// 3. Find max subarray sum using Kadane’s algorithm:
// java
// Copy
// Edit
// sum = 0;
// for(int i = 0; i < nums.length; i++){
//     sum += nums[i];
//     if(sum > max) max = sum;
//     if(sum < 0) sum = 0;
// }
// This is standard Kadane’s algorithm for maximum subarray sum.

// 4. Find min subarray sum using a similar approach:
// java
// Copy
// Edit
// sum = 0;
// for(int i = 0; i < nums.length; i++){
//     sum += nums[i];
//     if(sum < min) min = sum;
//     if(sum > 0) sum = 0;
// }
// This is Kadane’s for minimum subarray sum (used to handle circular part).

// 5. Handle special case: all numbers are negative
// java
// Copy
// Edit
// if(max < 0) return max;
// If all numbers are negative, the wrapped sum (total - min) becomes 0, which is invalid. So return max (i.e., least negative number).

// 6. Return the maximum of the two cases:
// java
// Copy
// Edit
// return Math.max(max, total - min);
// max = max subarray (non-circular)

// total - min = max circular subarray