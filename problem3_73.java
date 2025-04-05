public class problem3_73 {
  public String removeOuterParentheses(String s) {
      int cnt = 0;
      StringBuilder ans = new StringBuilder();
      for(int i = 0; i < s.length(); i++) {
          if(s.charAt(i) == ')') {
              cnt--;
          }
          if(cnt != 0) {
              ans.append(s.charAt(i));
          }
          if(s.charAt(i) == '(') {
              cnt++;
          }
      }
      return ans.toString();
  }

  public static void main(String[] args) {
      problem3_73 obj = new problem3_73();
      String input = "(()())(())"; // Example input
      String result = obj.removeOuterParentheses(input);
      System.out.println("Output: " + result);
  }
}

/* 

Algorithm:
Initialize Variables:

cnt = 0 → to track open and close parentheses count.

ans (StringBuilder) → to store the final result.

Traverse the string s character by character:

If the current character is ')', decrement cnt.

If cnt is not zero, append the character to ans.

If the current character is '(', increment cnt.

Return the final string stored in ans.

Pseudocode:
pgsql
Copy
Edit
FUNCTION removeOuterParentheses(s)
    cnt ← 0
    ans ← empty string

    FOR i ← 0 to length of s - 1 DO
        IF s[i] == ')' THEN
            cnt ← cnt - 1
        ENDIF

        IF cnt ≠ 0 THEN
            ans ← ans + s[i]
        ENDIF

        IF s[i] == '(' THEN
            cnt ← cnt + 1
        ENDIF
    ENDFOR

    RETURN ans
END FUNCTION

// Main function
BEGIN
    obj ← new problem3_73()
    input ← "(()())(())"
    result ← obj.removeOuterParentheses(input)
    PRINT "Output: " + result
END
Time & Space Complexity Analysis:
Time Complexity: 
𝑂(𝑛)
O(n) (single traversal of the string).

Space Complexity: 
𝑂(𝑛)
O(n) (StringBuilder stores the modified string).
*/