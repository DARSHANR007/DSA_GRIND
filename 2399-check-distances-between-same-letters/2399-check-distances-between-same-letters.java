
class Solution {
    public boolean checkDistances(String s, int[] distance) {

        int[] pos = new int[26];
        Arrays.fill(pos, -1);

        for (int i = 0; i < s.length(); i++) {

            char x = s.charAt(i);
            int idx = x - 'a';

            if (pos[idx] == -1) {
                pos[idx] = i;
            } else {
                if (i - pos[idx] - 1 != distance[idx]) {
                    return false;
                }
            }
        }

        return true;
    }
}
