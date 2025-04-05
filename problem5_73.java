import java.util.*;
public class problem5_73 {

    static ArrayList<ArrayList<Integer>> zeroMatrix(ArrayList<ArrayList<Integer>> matrix, int n, int m) {
        int[] row = new int[n]; // row array
        int[] col = new int[m]; // col array

        // Traverse the matrix:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix.get(i).get(j) == 0) {
                    // mark ith index of row wih 1:
                    row[i] = 1;

                    // mark jth index of col wih 1:
                    col[j] = 1;
                }
            }
        }

        // Finally, mark all (i, j) as 0
        // if row[i] or col[j] is marked with 1.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (row[i] == 1 || col[j] == 1) {
                    matrix.get(i).set(j, 0);
                }
            }
        }

        return matrix;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(1, 0, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1)));

        int n = matrix.size();
        int m = matrix.get(0).size();

        ArrayList<ArrayList<Integer>> ans = zeroMatrix(matrix, n, m);

        System.out.println("The Final matrix is: ");
        for (ArrayList<Integer> row : ans) {
            for (Integer ele : row) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }


}
/* 

Algorithm:
Initialize Row and Column Markers:

Create an array row[n] to track which rows need to be set to zero.

Create an array col[m] to track which columns need to be set to zero.

First Pass (Mark Rows & Columns):

Traverse the matrix and mark row[i] = 1 and col[j] = 1 if matrix[i][j] == 0.

Second Pass (Modify Matrix):

Traverse the matrix again and set matrix[i][j] = 0 if row[i] == 1 or col[j] == 1.

Return the Modified Matrix.

Pseudocode:
pgsql
Copy
Edit
FUNCTION zeroMatrix(matrix, n, m)
    CREATE array row[n] initialized to 0
    CREATE array col[m] initialized to 0

    // First pass: Identify rows and columns to be zeroed
    FOR i ← 0 to n - 1 DO
        FOR j ← 0 to m - 1 DO
            IF matrix[i][j] == 0 THEN
                row[i] ← 1
                col[j] ← 1
            ENDIF
        ENDFOR
    ENDFOR

    // Second pass: Set matrix elements to zero
    FOR i ← 0 to n - 1 DO
        FOR j ← 0 to m - 1 DO
            IF row[i] == 1 OR col[j] == 1 THEN
                matrix[i][j] ← 0
            ENDIF
        ENDFOR
    ENDFOR

    RETURN matrix
END FUNCTION

// Main function
BEGIN
    matrix ← [[1, 1, 1], [1, 0, 1], [1, 1, 1]]
    n ← number of rows in matrix
    m ← number of columns in matrix
    result ← zeroMatrix(matrix, n, m)
    
    PRINT "The Final matrix is: "
    FOR each row in result DO
        PRINT row
    ENDFOR
END
Time & Space Complexity Analysis:
Time Complexity: 
𝑂
(
𝑛
×
𝑚
)
O(n×m)

The matrix is traversed twice: once for marking and once for updating.

Space Complexity: 
𝑂
(
𝑛
+
𝑚
)
O(n+m)

Additional arrays row[] and col[] are used.

🔹 Optimized Approach: Instead of extra arrays, we can use the first row and first column as markers to achieve O(1) extra space
*/