import java.util.Arrays;

class problem1_2149{
  public static int[] rearrangeArray(int[] nums) {
    int n = nums.length;
    int[] positive = new int[n];
    int[] negative = new int[n];
    int[] finalOut  = new int[n];
    int pos = 0;
    int neg = 0;
    for(int i=0; i<n; i++){
        if(nums[i] > 0){
            positive[pos] = nums[i];
            pos++;
        } else {
            negative[neg] = nums[i];
            neg++;
        }
    }

     for(int i=0; i<n/2; i++){
         finalOut[2*i] = positive[i];
         finalOut[2*i+1] = negative[i];
     }

    return finalOut;
}

  public static void main(String[] args){
    int[] nums = {3,1,-2,-5,2,-4};
    // rearrangeArray(nums);
    int[] finalOut = rearrangeArray(nums);
    System.out.println(Arrays.toString(finalOut));
  }
}


/* 
FUNCTION rearrangeArray(nums)
    n ← length of nums
    CREATE arrays positive[n], negative[n], finalOut[n]
    pos ← 0
    neg ← 0

    // Step 1: Separate positive and negative numbers
    FOR i ← 0 to n - 1 DO
        IF nums[i] > 0 THEN
            positive[pos] ← nums[i]
            pos ← pos + 1
        ELSE
            negative[neg] ← nums[i]
            neg ← neg + 1
        ENDIF
    ENDFOR

    // Step 2: Interleave positive and negative numbers
    FOR i ← 0 to (n/2) - 1 DO
        finalOut[2 * i] ← positive[i]
        finalOut[2 * i + 1] ← negative[i]
    ENDFOR

    RETURN finalOut
END FUNCTION

// Main function
BEGIN
    nums ← [3,1,-2,-5,2,-4]
    result ← rearrangeArray(nums)
    PRINT result
END



Algorithm:
Initialize Storage Arrays:

Create two separate arrays:

positive[] to store positive numbers.

negative[] to store negative numbers.

Create finalOut[] to store the rearranged output.

Separate Positive and Negative Numbers:

Traverse the input array nums[].

If an element is positive, store it in positive[] and increment pos index.

If an element is negative, store it in negative[] and increment neg index.

Interleave Positive and Negative Numbers:

Use a loop to place elements from positive[] and negative[] alternatively into finalOut[].

Place positive[i] at even indices (2*i).

Place negative[i] at odd indices (2*i + 1).

Return the Rearranged Array.
*/