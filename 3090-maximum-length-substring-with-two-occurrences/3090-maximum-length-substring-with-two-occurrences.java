class Solution {
    public int maximumLengthSubstring(String s) {
        HashMap<Character, Integer> hash = new HashMap<>();
        int left = 0;
        int maxi = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            hash.put(c, hash.getOrDefault(c, 0) + 1);

            while (hash.get(c) > 2) {
                char leftChar = s.charAt(left);
                hash.put(leftChar, hash.get(leftChar) - 1);
                left++;
            }

            maxi = Math.max(maxi, right - left + 1);
        }

        return maxi;
    }
}