class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int i = 0;
        int n = plants.length;
        int j = n - 1;
        int refill = 0;

        int curA = capacityA;
        int curB = capacityB;

        while (i < j) {
            if (curA < plants[i]) {
                refill++;
                curA = capacityA;
            }
            curA -= plants[i];
            i++;

            if (curB < plants[j]) {
                refill++;
                curB = capacityB;
            }
            curB -= plants[j];
            j--;
        }

        if (i == j) {
            if (curA >= curB) {
                if (curA < plants[i]) refill++;
            } else {
                if (curB < plants[i]) refill++;
            }
        }

        return refill;
    }
}