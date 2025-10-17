import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc  =  new Scanner(System.in);
        int tests = sc.nextInt();

        while (tests--> 0)

        {
            int size  =sc.nextInt();
            System.out.println("? " + 2 + " "+ 1+ " " + size);
            int xxx=sc.nextInt();

            int xoradd = size *(size + 1)/2;

            int diff =xxx -xoradd;
            int low= size;
            while (low >0)
            {
                int middle =low -(low - 1) / 2;
                System.out.println("? " + 1 + " " + 1 + " " + middle);
                int current=sc.nextInt();

                if (current<= diff +middle) {
                    low =middle;
                } else {
                    low =middle- 1;
                }

            }
            
            int temp = low | diff;
            int answer = temp + low - 1;
            System.out.println("! " +answer);
        }

    }
}