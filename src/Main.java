import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args)
    {
        int test = sc.nextInt();

        while (test >0) {
            test--;
            int n = sc.nextInt();
            int[] result = new int[2 *n+1];
            
            ArrayList<Integer> groupA =new ArrayList<>();
            ArrayList<Integer>groupB =new ArrayList<>();

            for (int i = 1; i <=2*n;i++){
                System.out.print("? "+(groupA.size()+ 1));
                for (int num : groupA)
                {
                    System.out.print(" "+num);
                }
                System.out.println(" "+ i);

                int curr = sc.nextInt();

                if (curr==0)
                {
                    groupA.add(i);
                }
                else
                {
                    groupB.add(i);
                    result[i]= curr;
                }
            }

            for (int num:groupA)
            {
                System.out.print("? " +(groupB.size() + 1));

                for (int b:groupB)
                {
                    System.out.print(" "+ b);
                }
                System.out.println(" "+ num);

                int curr =sc.nextInt();
                result[num] =curr;
            }
            System.out.print("! ");
            for (int i = 1; i <= 2* n; i++)
            {
                if (i > 1)
                {
                    System.out.print(" ");
                }
                System.out.print(result[i]);
            }
            System.out.println();
        }
    }
}