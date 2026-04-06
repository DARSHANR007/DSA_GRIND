class Solution {

    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> hash = new HashMap();

        int n = fruits.length;

        int maxi=0;

        int right = 0;
        int left = 0;

        for (right = 0; right < n; right++) {
            hash.put(fruits[right], hash.getOrDefault(fruits[right], 0) + 1);

            while (hash.size() > 2) {
                hash.put(fruits[left], hash.get(fruits[left]) - 1);

                if (hash.get(fruits[left]) == 0) {
                    hash.remove(fruits[left]);
                }

                left++;
            }

            maxi=Math.max(maxi,right -left+1);
        }

        return maxi;
    }
}
