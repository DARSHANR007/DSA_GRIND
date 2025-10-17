import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        while(t-->0)
        {
            long n=s.nextLong();
            long m=s.nextLong();

            if(n==m){
                System.out.println(0);
                continue;
            }

            int i=0;

            long change=n;

            while((1L<<i)<=change)i++;
            i--;

            long full = 0;

            for(int j=0;j<= i;j++) {
                full|=(1L<<j);
            }

            if(m>full){
                System.out.println(-1);
            }
            else{

                long xorres=n^m;

                if(xorres<=n)

                {
                    System.out.println(1);
                    System.out.println(xorres);
                }
                else{
                    System.out.println(2);
                    System.out.println((full^n)+" "+(full^m));
                }
            }
        }

    }
}
