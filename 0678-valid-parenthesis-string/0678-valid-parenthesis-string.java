class Solution {
    public boolean checkValidString(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;

        // --- FIRST PASS: Left to Right ---
        // Logic: Can we cover all the ')'?
        int left = 0;
        int star = 0;
        int right = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] == '(') left++;
            else if (arr[i] == ')') right++;
            else star++;

            // If at any point ')' outweighs '(' and '*' combined, it's impossible.
            if (right > left + star) return false;
        }

        // --- SECOND PASS: Right to Left ---
        // Logic: Can we cover all the '('? 
        // We reset counts and go backwards.
        left = 0;
        star = 0;
        right = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] == '(') left++;
            else if (arr[i] == ')') right++;
            else star++;

            // If at any point '(' outweighs ')' and '*' combined, it's impossible.
            if (left > right + star) return false;
        }

        // If it passes both directions, the string is valid!
        return true;
    }
}