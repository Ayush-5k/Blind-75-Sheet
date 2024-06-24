import java.util.*;
public class PalindromicSubstrings {
    //odd length palindromes
    //we choose a index a parallely move leftward and rightwards so until we reach the end if we get
    //get the characters equal then we have got a palindrome so we increment count, else we can't and break

    //                d  b  a   b  c
    //                *  -      -  *
    //first we go to '-' they are equal so we move left-- and right++ next '*' are not equal so break
    //we check this way for each index, here we checked it for index 2
    public int solveOddLengthPalindromeFromMiddleIndex (String s, int ind, int[] dp) {
        if(ind == s.length()) {
            return 0;
        }
        if (dp[ind] != -1) return dp[ind];
        int left = ind;
        int right  = ind;
        int count = 0;
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
                count++;
            } else{
                break;
            }
        }
        return dp[ind] = count + solveOddLengthPalindromeFromMiddleIndex (s, ind + 1, dp);
    }
    //Even length palindromes
    //it is same as od palindrome finding but here we consider two characters for out primary index
    private int solveEvenLengthPalindromeByTwoIndices (String s, int left, int right, int[][] dp) {
        if (left >= s.length() && right >= s.length()) {
            return 0;
        }
        if (dp[left][right] != -1) return dp[left][right];
        int count = 0;
        int lef = left;
        int ri = right;
        while (lef >= 0 && ri < s.length()) {
            if (s.charAt(lef) == s.charAt(ri)) {
                lef--;
                ri++;
                count++;
            } else{
                break;
            }
        }
        return dp[left][right] = count + solveEvenLengthPalindromeByTwoIndices(s, left + 1, right + 1, dp);
    }
    public int countSubstrings(String s) {
        int[][] dp1 = new int[s.length() + 1][s.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            Arrays.fill(dp1[i], -1);
        }
        int[] dp2 = new int[s.length()];
        Arrays.fill (dp2, -1);
        return solveOddLengthPalindromeFromMiddleIndex(s, 0, dp2) + solveEvenLengthPalindromeByTwoIndices(s, 0, 1, dp1);
    }
}
