class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] words = text.split(" ");
        boolean[] isBroken = new boolean[26];

        for (char c : brokenLetters.toCharArray()) {
            isBroken[c - 'a'] = true;
        }

        int count = 0;
        for (String word : words) {
            if (canType(word, isBroken)) {
                count++;
            }
        }
        return count;
    }

    private boolean canType(String word, boolean[] isBroken) {
        for (char c : word.toCharArray()) {
            if (isBroken[c - 'a']) {
                return false;
            }
        }
        return true;
    }
}