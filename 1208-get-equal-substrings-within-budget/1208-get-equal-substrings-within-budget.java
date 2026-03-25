class Solution {

    public int equalSubstring(String s, String t, int maxCost) {
        int cost = 0;

        int n = s.length();

        int maxi = 0;

        int left=0;

        for (int right = 0; right < n; right++) {
            char a = s.charAt(right);
            char b = t.charAt(right);

            cost+= Math.abs(a-b);

            while( cost > maxCost){

                char x=s.charAt(left);
                char y=t.charAt(left);

                cost-=Math.abs(x-y);

                left++;
            }

            maxi=Math.max(right-left+1,maxi);
        }

        return maxi;
    }
}
