// Maximum Product Subarray
// Given an array arr[] that contains positive and negative integers (may contain 0 as well). Find the maximum product that we can get in a subarray of arr[].

// Note: It is guaranteed that the output fits in a 32-bit integer.

// Examples

// Input: arr[] = [-2, 6, -3, -10, 0, 2]
// Output: 180
// Explanation: The subarray with maximum product is {6, -3, -10} with product = 6 * (-3) * (-10) = 180.
// Input: arr[] = [-1, -3, -10, 0, 6]
// Output: 30
// Explanation: The subarray with maximum product is {-3, -10} with product = (-3) * (-10) = 30.
// Input: arr[] = [2, 3, 4] 
// Output: 24 
// Explanation: For an array with all positive elements, the result is product of all elements. 
// Constraints:
// 1 ≤ arr.size() ≤ 106
// -10  ≤  arr[i]  ≤  10
 
 
 
 import java.util.Scanner;

class problem36_maximumProductSubarray {
    // Function to find the maximum product subarray
    int maxProduct(int[] arr) {
        int n = arr.length;
        int prefix = 1, suffix = 1;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (prefix == 0) prefix = 1;
            if (suffix == 0) suffix = 1;

            prefix *= arr[i];
            suffix *= arr[n - i - 1];

            max = Math.max(max, Math.max(prefix, suffix));
        }
        return max;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        problem36_maximumProductSubarray sol = new problem36_maximumProductSubarray();

        // Taking input from user
        System.out.print("Enter the number of elements in the array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Calling function and printing the result
        int result = sol.maxProduct(arr);
        System.out.println("Maximum Product Subarray: " + result);

        sc.close();
    }
}




// Algorithm Steps:
// Initialize Variables:

// Set prefix = 1 (to track the product from the left side).

// Set suffix = 1 (to track the product from the right side).

// Set maxProduct = Integer.MIN_VALUE (to store the maximum product found).

// Traverse the Array from Left to Right:

// Iterate over i from 0 to n-1:

// If prefix becomes 0, reset it to 1.

// Multiply prefix by arr[i].

// Update maxProduct with max(maxProduct, prefix).

// Traverse the Array from Right to Left (Reverse Order):

// Iterate over i from n-1 to 0:

// If suffix becomes 0, reset it to 1.

// Multiply suffix by arr[n-i-1].

// Update maxProduct with max(maxProduct, suffix).

// Return maxProduct as the final result.




// FUNCTION maxProduct(arr):
//     n ← length of arr
//     prefix ← 1
//     suffix ← 1
//     maxProduct ← -∞  // Initialize to the smallest possible value

//     // Traverse from left to right
//     FOR i FROM 0 TO n-1:
//         IF prefix == 0:
//             prefix ← 1  // Reset prefix product if zero
//         prefix ← prefix * arr[i]
//         maxProduct ← max(maxProduct, prefix)

//     // Traverse from right to left
//     FOR i FROM 0 TO n-1:
//         IF suffix == 0:
//             suffix ← 1  // Reset suffix product if zero
//         suffix ← suffix * arr[n - i - 1]
//         maxProduct ← max(maxProduct, suffix)

//     RETURN maxProduct
