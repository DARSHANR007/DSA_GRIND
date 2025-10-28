import java.util.*;
public class Main{
    public static void main(String[] args)


    {
        Scanner sc=new Scanner(System.in);
        run(sc);
    }



    static void run(Scanner sc)

    {
        int maxi=500;


        boolean[] flag=new boolean[maxi+1];

        Arrays.fill(flag,true);

        flag[0]=false;
        flag[1]=false;


        List<Integer> primenum=new ArrayList<>();



        for(int i=2;i<=maxi;i++)

        {
            if(flag[i]){
                primenum.add(i);


                for(long j=(long)i*i;j<=maxi;j+=i)

                {
                    flag[(int)j]=false;
                }
            }
        }
        
        
        int t=sc.nextInt();

        while(t-->0){


            int n=sc.nextInt();
            long g=0;


            for(int i=0;i<n;i++){

                long x=sc.nextLong();
                if(i!=0)

                {

                    g=gcdhelper(g,x);

                }


                else if(i==0){

                    g=x;


                }
            }
            boolean done=false;

            for(int p:primenum)

            {
                if(g%p!=0){
                    System.out.println(p);

                    done=true;
                    break;
                }
            }


            if(!done)System.out.println(-1);
        }
    }



    static long gcdhelper(long a,long b){
        while(b!=0){
            long tmp=b;
            b=a%b;
            a=tmp;
        }
        return a;
    }
}
