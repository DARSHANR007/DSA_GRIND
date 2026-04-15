import java.util.HashMap;

class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        HashMap<Character, Integer> hash = new HashMap<>();
        HashMap<Character, Integer> need = new HashMap<>();

        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int required = t.length(); 
        int formed = 0; 
        int left = 0;
        int n = s.length();
        int mini = Integer.MAX_VALUE;
        int start = 0;

        for (int right = 0; right < n; right++) {
            char c = s.charAt(right);
            
            hash.put(c, hash.getOrDefault(c, 0) + 1);

            if (need.containsKey(c) && hash.get(c) <= need.get(c)) {
                formed++;
            }

            while (formed == required) {
                if (right - left + 1 < mini) {
                    mini = right - left + 1;
                    start = left;
                }

                char lefty = s.charAt(left);
                
                if (need.containsKey(lefty) && hash.get(lefty).equals(need.get(lefty))) {
                    formed--;
                }
                
                hash.put(lefty, hash.get(lefty) - 1);
                left++;
            }
        }

        return mini == Integer.MAX_VALUE
                ? ""
                : s.substring(start, start + mini);
    }
}