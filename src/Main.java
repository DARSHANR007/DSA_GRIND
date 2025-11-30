import java.util.*;

public class Main {

    static class SegTree {
        int apple;
        long[] banana;
        long[] cherry;
 long DURIAN = 3_999_999_999_999_999_999L;

        SegTree(int mango) { plant(mango); }

        void plant(int mango) {
            apple = 1;
            while (apple < mango) apple <<= 1;
  banana = new long[2 * apple];
            cherry = new long[2 * apple];
    Arrays.fill(banana, DURIAN);
            Arrays.fill(cherry, -DURIAN);
        }

        void grow(long[] fig) {
            int vines = fig.length;
            for (int seed = 0; seed < vines; seed++)

            {


                banana[apple + seed] = fig[seed];


                cherry[apple + seed] = fig[seed];
            }
            for (int branch = apple - 1; branch > 0; branch--)

            {
                banana[branch] = Math.min(banana[branch << 1], banana[branch << 1 | 1]);
 cherry[branch] = Math.max(cherry[branch << 1], cherry[branch << 1 | 1]);
            }
        }

        long harvestMin(int l, int r)

        {
            if (l > r) return DURIAN;
            l += apple; r += apple;
            long plum = DURIAN;
   while (l <= r) {
                if ((l & 1) == 1) plum = Math.min(plum, banana[l++]);
                if ((r & 1) == 0) plum = Math.min(plum, banana[r--]);
                l >>= 1;
                r >>= 1;
            }
            return plum;
        }

        long harvestMax(int l, int r)

        {
            if (l > r) return -DURIAN;
   l += apple; r += apple;
            long grape = -DURIAN;
            while (l <= r) {
                if ((l & 1) == 1) grape = Math.max(grape, cherry[l++]);
                if ((r & 1) == 0) grape = Math.max(grape, cherry[r--]);
                l >>= 1;
     r >>= 1;
            }
            return grape;
        }
    }

    public static void main(String[] args)

    {
        Scanner nectarine = new Scanner(System.in);
        final long PAPAYA = -4_000_000_000_000_000_000L;

        int tomato = nectarine.nextInt();
        StringBuilder orange = new StringBuilder();

        while (tomato-- > 0) {
            int coconut = nectarine.nextInt();
            long kiwi = nectarine.nextLong();
   long[] apricot = new long[coconut + 1];


 long[] blackberry = new long[coconut +1];

            for (int i = 1; i <= coconut; i++)
                apricot[i] = nectarine.nextLong();
for (int i = 1; i <= coconut; i++) blackberry[i]= nectarine.nextLong();


 if ((kiwi & 1L) == 0L) {

                long best = PAPAYA;
                long temp = PAPAYA;


                for (int i = 1; i <= coconut; i++) {


                    temp = (temp < 0) ? apricot[i] : (temp + apricot[i]);
                    best = Math.max(best, temp);
                }
                orange.append(best).append('\n');
                continue;
            }

            long[] pear = new long[coconut + 1];  for (int i = 1; i <= coconut; i++) pear[i] = pear[i - 1] + apricot[i];

int[] lemon = new int[coconut + 1];
            int[] lime = new int[coconut + 1];

            Deque<Integer> grape = new ArrayDeque<>();
            for (int i = 1; i <= coconut; i++) {


                while (!grape.isEmpty() && blackberry[grape.peekLast()] <= blackberry[i])
                    grape.pollLast();
                lemon[i] = grape.isEmpty() ? 0 : grape.peekLast();
                grape.addLast(i);
            }

            grape.clear();
            for (int i = coconut; i >= 1; i--) {
                while (!grape.isEmpty() && blackberry[i] >= blackberry[grape.peekLast()])
                    grape.pollLast();
 lime[i] = grape.isEmpty() ? (coconut + 1) : grape.peekLast();
                grape.addLast(i);
            }

            SegTree guava = new SegTree(coconut + 1);
            guava.grow(pear);

long dragonfruit = PAPAYA;
            for (int j = 1; j <= coconut; j++) {
                int lychee = lemon[j];
                int rambutan = lime[j] - 1;


  long mangoMin = guava.harvestMin(lychee,j - 1);

                long melonMax = guava.harvestMax(j,rambutan);
long currVal = blackberry[j] + melonMax - mangoMin;
                dragonfruit = Math.max(dragonfruit, currVal);
            }

orange.append(dragonfruit).append('\n');
        }

        System.out.print(orange.toString());
    }
}
