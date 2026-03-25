class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {

        int n = customers.length;

        int temp = 0;
        int maxi = 0;
        int base = 0;

        for(int i = 0; i < n; i++){
            if(grumpy[i] == 0){
                base += customers[i];
            }
        }

        for(int right = 0; right < n; right++){

            if(grumpy[right] == 1){
                temp += customers[right];
            }

            if(right >= minutes && grumpy[right - minutes] == 1){
                temp -= customers[right - minutes];
            }

            maxi = Math.max(maxi, temp);
        }

        return base + maxi;
    }
}