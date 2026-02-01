class Solution {
    public char repeatedCharacter(String s) {

        int[] arr = new int[26];

        for (char x : s.toCharArray()) {

            if (arr[x - 'a'] == 0) {
                arr[x - 'a']++;
            } else {
                return x;
            }
        }

        return ' '; 
    }
}
