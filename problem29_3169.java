// 3169. Count Days Without Meetings
// You are given a positive integer days representing the total number of days an employee is available for work (starting from day 1). You are also given a 2D array meetings of size n where, meetings[i] = [start_i, end_i] represents the starting and ending days of meeting i (inclusive).

// Return the count of days when the employee is available for work but no meetings are scheduled.

// Note: The meetings may overlap.

 

// Example 1:

// Input: days = 10, meetings = [[5,7],[1,3],[9,10]]

// Output: 2

// Explanation:

// There is no meeting scheduled on the 4th and 8th days.

// Example 2:

// Input: days = 5, meetings = [[2,4],[1,3]]

// Output: 1

// Explanation:

// There is no meeting scheduled on the 5th day.

// Example 3:

// Input: days = 6, meetings = [[1,6]]

// Output: 0

// Explanation:

// Meetings are scheduled for all working days.

import java.util.Arrays;
import java.util.Comparator;

public class problem29_3169 {
      public static void main(String[] args) {
        int days = 10;
        int[][] meetings = {
            {2, 3},
            {5, 6},
            {8, 9}
        };
        
        problem29_3169 counter = new problem29_3169();
        int remainingDays = counter.countDays(days, meetings);
        
        System.out.println("Remaining free days: " + remainingDays);
    }

    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));
        int prevEnd = 0;

        for (int[] meeting : meetings) {
            int start = Math.max(meeting[0], prevEnd + 1);
            int length = meeting[1] - start + 1;
            days -= Math.max(length, 0);
            prevEnd = Math.max(prevEnd, meeting[1]);
        }

        return days;
    }
}



    /**
     * Algorithm:
     * 1. Sort the meetings array based on the start time. (O(N log N))
     * 2. Initialize a variable `prevEnd` to keep track of the last occupied day. (O(1))
     * 3. Iterate through each meeting: (O(N))
     *    a. Determine the actual start day of the meeting by taking the max of meeting start and `prevEnd + 1`.
     *    b. Calculate the length of the meeting as (end - start + 1).
     *    c. Deduct the valid meeting length from the available `days`.
     *    d. Update `prevEnd` to the maximum of its current value and the meeting’s end day.
     * 4. Return the remaining `days` after processing all meetings. (O(1))
     * 
     * Pseudocode:
     * 
     * FUNCTION countDays(days, meetings):
     *     SORT meetings based on start time
     *     prevEnd = 0
     *     FOR each meeting in meetings:
     *         start = MAX(meeting[0], prevEnd + 1)
     *         length = meeting[1] - start + 1
     *         days -= MAX(length, 0)
     *         prevEnd = MAX(prevEnd, meeting[1])
     *     RETURN days
     * 
     * Time Complexity: O(N log N) due to sorting, followed by O(N) iteration, resulting in O(N log N) overall.
     * Space Complexity: O(1) as sorting is done in place and only a few extra variables are used.
     */