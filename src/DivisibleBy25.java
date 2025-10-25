import java.util.*;

public class DivisibleBy25 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();  // number of test cases

        while (t-- > 0) {
            String s = sc.next();  // read the number as string
            int n = s.length();
            int ans = Integer.MAX_VALUE;

            // We are looking for endings: "00", "25", "50", "75"
            String[] targets = {"00", "25", "50", "75"};

            for (String target : targets) {
                char left = target.charAt(0);
                char right = target.charAt(1);

                // Try to find rightmost 'right' first, then a 'left' before it
                for (int j = n - 1; j >= 0; j--) {
                    if (s.charAt(j) == right) {
                        for (int i = j - 1; i >= 0; i--) {
                            if (s.charAt(i) == left) {
                                // deletions = (digits after j) + (digits between i and j) = (n - j - 1) + (j - i - 1)
                                int deletions = (n - i - 2);
                                ans = Math.min(ans, deletions);
                                break; // once found a valid pair, move to next target
                            }
                        }
                    }
                }
            }

            System.out.println(ans);
        }

        sc.close();
    }
}
