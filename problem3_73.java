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
