import java.util.Scanner;

public class problem23_1614 {
      public static int maxDepth(String s) {
        int cnt = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                cnt++;
                max = Math.max(max, cnt);
            } else if (s.charAt(i) == ')') {
                cnt--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        int maxNestingDepth = maxDepth(input);
        System.out.println("Maximum nesting depth of parentheses: " + maxNestingDepth);
        scanner.close();
    }
}
