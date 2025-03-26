// 3394. Check if Grid can be Cut into Sections
// You are given an integer n representing the dimensions of an n x n grid, with the origin at the bottom-left corner of the grid. You are also given a 2D array of coordinates rectangles, where rectangles[i] is in the form [startx, starty, endx, endy], representing a rectangle on the grid. Each rectangle is defined as follows:

// (startx, starty): The bottom-left corner of the rectangle.
// (endx, endy): The top-right corner of the rectangle.
// Note that the rectangles do not overlap. Your task is to determine if it is possible to make either two horizontal or two vertical cuts on the grid such that:

// Each of the three resulting sections formed by the cuts contains at least one rectangle.
// Every rectangle belongs to exactly one section.
// Return true if such cuts can be made; otherwise, return false.

 

// Example 1:

// Input: n = 5, rectangles = [[1,0,5,2],[0,2,2,4],[3,2,5,3],[0,4,4,5]]

// Output: true

// Explanation:



// The grid is shown in the diagram. We can make horizontal cuts at y = 2 and y = 4. Hence, output is true.

// Example 2:

// Input: n = 4, rectangles = [[0,0,1,1],[2,0,3,4],[0,2,2,3],[3,0,4,3]]

// Output: true

// Explanation:



// We can make vertical cuts at x = 2 and x = 3. Hence, output is true.

// Example 3:

// Input: n = 4, rectangles = [[0,2,2,4],[1,0,3,2],[2,2,3,4],[3,0,4,2],[3,2,4,4]]

// Output: false

// Explanation:

// We cannot make two horizontal or two vertical cuts that satisfy the conditions. Hence, output is false.

import java.util.Arrays;

public class problem30_3394 {
   public static void main(String[] args) {
        int n = 5;
        int[][] rectangles = {
            {1, 1, 3, 3},
            {3, 1, 5, 3},
            {1, 3, 3, 5},
            {3, 3, 5, 5}
        };
        
        problem30_3394 solution = new problem30_3394();
        boolean result = solution.checkValidCuts(n, rectangles);
        System.out.println("Valid cuts exist: " + result);
    }

    public boolean checkValidCuts(int n, int[][] rectangles) {
        int[][] xIntervals = new int[rectangles.length][2];
        int[][] yIntervals = new int[rectangles.length][2];

        for (int i = 0; i < rectangles.length; i++) {
            xIntervals[i][0] = rectangles[i][0];
            xIntervals[i][1] = rectangles[i][2];
            yIntervals[i][0] = rectangles[i][1];
            yIntervals[i][1] = rectangles[i][3];
        }

        return check(xIntervals) || check(yIntervals);
    }

    private boolean check(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        int sections = 0;
        int maxEnd = intervals[0][1];

        for (int[] interval : intervals) {
            if (maxEnd <= interval[0]) {
                sections++;
            }
            maxEnd = Math.max(maxEnd, interval[1]);
        }

        return sections >= 2;
    }
}

 /**
     * Algorithm:
     * 1. Extract x and y intervals from the given rectangles.
     * 2. Sort the intervals based on the starting coordinate.
     * 3. Check if the sorted intervals create at least two separate sections:
     *    a. Initialize `sections = 0` and `maxEnd` with the first interval’s end.
     *    b. Iterate through the intervals:
     *       - If the current interval starts after `maxEnd`, increment `sections`.
     *       - Update `maxEnd` to the maximum of its current value and the interval’s end.
     *    c. If `sections >= 2`, return true.
     * 4. Perform this check for both x-intervals and y-intervals.
     * 5. If either check returns true, return true; otherwise, return false.
     *
     * Pseudocode:
     * FUNCTION checkValidCuts(n, rectangles):
     *     xIntervals, yIntervals = extract x and y intervals from rectangles
     *     RETURN check(xIntervals) OR check(yIntervals)
     *
     * FUNCTION check(intervals):
     *     SORT intervals based on start value
     *     sections = 0
     *     maxEnd = intervals[0][1]
     *     FOR each interval in intervals:
     *         IF maxEnd <= interval[0]:
     *             sections++
     *         maxEnd = MAX(maxEnd, interval[1])
     *     RETURN sections >= 2
     *
     * Time Complexity: O(N log N) due to sorting, O(N) for checking intervals → O(N log N) overall.
     * Space Complexity: O(N) for storing intervals.
     */
