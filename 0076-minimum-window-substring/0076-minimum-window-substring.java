class Solution {

    public String minWindow(String s, String t) {

        if (s.length() < t.length()) return "";

        HashMap<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        HashMap<Character, Integer> check = new HashMap<>();

        int left = 0;
        int formed = 0;               // total matched characters
        int required = t.length();    // total required characters

        int minLen = Integer.MAX_VALUE;
        int start = 0;

        for (int right = 0; right < s.length(); right++) {

            char c = s.charAt(right);

            // ALWAYS add to window
            check.put(c, check.getOrDefault(c, 0) + 1);

            // Increase formed ONLY if this char was still needed
            if (need.containsKey(c) &&
                check.get(c) <= need.get(c)) {
                formed++;
            }

            // Shrink only when fully formed
            while (formed == required) {

                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char leftChar = s.charAt(left);
                check.put(leftChar, check.get(leftChar) - 1);

                // If removal breaks requirement, reduce formed
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
