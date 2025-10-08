public class RussianDollEnvelopes {

    public int maxEnvelopes(int[][] envelopes) {

        int count = 0;


        int n = envelopes.length;

        int[] larger_size = envelopes[0];

        for (int i = 1; i < n; i++) {

            int curr_height = envelopes[i][1];
            int curr_weight = envelopes[i][0];

            if (curr_weight < larger_size[0] && curr_height < larger_size[1]) {
                count++;
            } else if (curr_weight > larger_size[0] && curr_height > larger_size[1]) {
                count++;
                larger_size[0] = curr_weight;
                larger_size[1] = curr_height;
            }

        }

        return count;


    }

}
