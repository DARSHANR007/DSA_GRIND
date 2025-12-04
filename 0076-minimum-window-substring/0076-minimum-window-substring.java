class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();

        if (n < m) {
            return "";
        }

        int[] need = new int[128]; // to store frequency of characters in t
        int[] window = new int[128]; // to store frequency in current window

        for (char c : t.toCharArray()) {
            need[c]++;
        }

        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        int valid = 0; // to count how many required characters are matched

        while (right < n) {
            char c = s.charAt(right);
            window[c]++;
            if (need[c] > 0 && window[c] <= need[c]) {
                valid++;
            }

            // Shrink window if we matched all required characters
            while (valid == m) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char d = s.charAt(left);
                if (need[d] > 0 && window[d] <= need[d]) {
                    valid--;
                }
                window[d]--;
                left++;
            }

            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
