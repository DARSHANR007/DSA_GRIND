class Solution {

    public String minWindow(String s, String t) {

        if (s.length() < t.length()) return "";

        // Required frequencies
        HashMap<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        // Current window frequencies
        HashMap<Character, Integer> check = new HashMap<>();

        int left = 0;
        int formed = 0;
        int required = need.size();

        int minLen = Integer.MAX_VALUE;
        int start = 0;

        for (int right = 0; right < s.length(); right++) {

            // 1. Expand window
            char c = s.charAt(right);
            check.put(c, check.getOrDefault(c, 0) + 1);

            // 2. Increase formed ONLY when a type is satisfied
            if (need.containsKey(c) &&
                check.get(c).intValue() == need.get(c).intValue()) {
                formed++;
            }

            // 3. Shrink only when fully formed
            while (formed == required) {

                // Update answer
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                // Shrink from left
                char leftChar = s.charAt(left);
                check.put(leftChar, check.get(leftChar) - 1);

                // If removing breaks condition, update formed
                if (need.containsKey(leftChar) &&
                    check.get(leftChar) < need.get(leftChar)) {
                    formed--;
                }

                left++;
            }
        }

        return minLen == Integer.MAX_VALUE
                ? ""
                : s.substring(start, start + minLen);
    }
}
