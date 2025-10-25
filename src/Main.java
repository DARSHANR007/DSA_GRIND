import java.util.*;

public class Main {
    public static void main(String[] args)

    {
        Scanner in = new Scanner(System.in);



        int tests =in.nextInt();

        while (tests-- >0)

        {
            int n = in.nextInt();
            int k = in.nextInt();

            int[] count = new int[n + 1];


            for (int i= 0;i < n; i++)

            {

                int x=in.nextInt();
                count[x]++;
            }

            int[] prefix = new int[n + 1];

            int i=0;

            for ( i =1;i<=n; i++)

            {
                prefix[i] =prefix[i -1]+count[i];
            }

            int result =1;


            for (int g =n;g>=1;g--)

            {
                int end =Math.min(n,(g << 2) - 1);
                int total =prefix[end];

                int multi = 0;
                int val = g;
                for (int mult = 1; mult <= 3 && val <= n; mult++, val += g)

                {
                    multi +=count[val];
                }

                if (total -multi <= k) {
                    result = g;
                    break;
                }
            }

            System.out.println(result);
        }
    }
}
