import java.util.Scanner;

public class problem28_1781 {
      public int beautySum(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int[] freq = new int[26];
            for (int j = i; j < n; j++) {
                freq[s.charAt(j) - 'a']++;
                int min = getMin(freq);
                int max = getMax(freq);
                int beauty = max - min;
                ans += beauty;
            }
        }
        return ans;
    }

    private int getMax(int[] freq) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0) {
                max = Math.max(max, freq[i]);
            }
        }
        return max;
    }

    private int getMin(int[] freq) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0) {
                min = Math.min(min, freq[i]);
            }
        }
        return min;
    }

    // Main method to test the solution
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        
        problem28_1781 solution = new problem28_1781();
        int result = solution.beautySum(input);
        
        System.out.println("Beauty sum of the string: " + result);
        
        scanner.close();
    }
}
