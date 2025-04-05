import java.util.ArrayList;
import java.util.List;

public class problem7_54 {
   public static List<Integer> printSpiral(int[][] mat) {
        
        // Define ans list to store the result.
        List<Integer> ans = new ArrayList<>();
        
        int n = mat.length; // no. of rows
        int m = mat[0].length; // no. of columns
        
        // Initialize the pointers required for traversal.
        int top = 0, left = 0, bottom = n - 1, right = m - 1;

        // Loop until all elements are not traversed.
        while (top <= bottom && left <= right) {

            // For moving left to right
            for (int i = left; i <= right; i++)
                ans.add(mat[top][i]);

            top++;

            // For moving top to bottom.
            for (int i = top; i <= bottom; i++)
                ans.add(mat[i][right]);

            right--;

            // For moving right to left.
            if (top <= bottom) {
                for (int i = right; i >= left; i--)
                    ans.add(mat[bottom][i]);

                bottom--;
            }

            // For moving bottom to top.
            if (left <= right) {
                for (int i = bottom; i >= top; i--)
                    ans.add(mat[i][left]);

                left++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        
        //Matrix initialization.
        int[][] mat = {{1, 2, 3, 4},
                       {5, 6, 7, 8},
                       {9, 10, 11, 12},
                       {13, 14, 15, 16}};
        
        List<Integer> ans = printSpiral(mat);

        for(int i = 0;i<ans.size();i++){
            System.out.print(ans.get(i) + " ");
        }

        System.out.println();
    }
}


// Algorithm:
// Initialize Pointers:

// top = 0, left = 0 → Start from the top-left corner.

// bottom = n - 1, right = m - 1 → Define the bottom-right corner.

// Create an empty list ans to store the spiral order elements.

// Traverse in Spiral Order Until All Elements are Visited:

// Left to Right: Traverse mat[top][i] from left to right, then increment top.

// Top to Bottom: Traverse mat[i][right] from top to bottom, then decrement right.

// Right to Left (if rows remain): Traverse mat[bottom][i] from right to left, then decrement bottom.

// Bottom to Top (if columns remain): Traverse mat[i][left] from bottom to top, then increment left.

// Repeat Until top > bottom OR left > right.

// Return the ans list.

// Pseudocode:
// css
// Copy
// Edit
// FUNCTION printSpiral(matrix)
//     ans ← empty list
//     n ← number of rows in matrix
//     m ← number of columns in matrix
    
//     top ← 0
//     left ← 0
//     bottom ← n - 1
//     right ← m - 1

//     WHILE top ≤ bottom AND left ≤ right DO

//         // Move left to right
//         FOR i ← left to right DO
//             ADD matrix[top][i] to ans
//         END FOR
//         top ← top + 1

//         // Move top to bottom
//         FOR i ← top to bottom DO
//             ADD matrix[i][right] to ans
//         END FOR
//         right ← right - 1

//         // Move right to left (only if there are remaining rows)
//         IF top ≤ bottom THEN
//             FOR i ← right to left DO
//                 ADD matrix[bottom][i] to ans
//             END FOR
//             bottom ← bottom - 1
//         END IF

//         // Move bottom to top (only if there are remaining columns)
//         IF left ≤ right THEN
//             FOR i ← bottom to top DO
//                 ADD matrix[i][left] to ans
//             END FOR
//             left ← left + 1
//         END IF

//     END WHILE

//     RETURN ans
// END FUNCTION

// // Main Function
// BEGIN
//     matrix ← [[1, 2, 3, 4],
//               [5, 6, 7, 8],
//               [9, 10, 11, 12],
//               [13, 14, 15, 16]]
    
//     result ← printSpiral(matrix)
    
//     PRINT result
// END
// Time & Space Complexity Analysis:
// Time Complexity: 
// 𝑂
// (
// 𝑛
// ×
// 𝑚
// )
// O(n×m)

// Every element in the matrix is visited exactly once.

// Space Complexity: 
// 𝑂
// (
// 1
// )
// O(1) (excluding the output list).

// The solution modifies pointers in place without extra space.