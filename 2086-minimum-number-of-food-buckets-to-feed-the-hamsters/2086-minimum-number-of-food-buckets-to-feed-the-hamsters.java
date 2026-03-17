class Solution {

    public int minimumBuckets(String hamsters) {
        int n = hamsters.length();

        int hamcount = 0;

        for (char x : hamsters.toCharArray()) {
            if (x == 'H') {
                hamcount++;
            }
        }

        int[] check = new int[n];
        int bcount = 0;
        int flag = 0;

        for (int i = 0; i < n; i++) {

            if (hamsters.charAt(i) == 'H') {

                if (i - 1 >= 0 && hamsters.charAt(i - 1) == '.' && check[i - 1] == 1) {
                    flag++;
                }

                else if (i + 1 < n && hamsters.charAt(i + 1) == '.' && check[i + 1] == 0) {
                    check[i + 1] = 1;
                    bcount++;
                    flag++;
                }

                else if (i - 1 >= 0 && hamsters.charAt(i - 1) == '.' && check[i - 1] == 0) {
                    check[i - 1] = 1;
                    bcount++;
                    flag++;
                }
            }
        }

        if (flag == hamcount) return bcount;

        return -1;
    }
}