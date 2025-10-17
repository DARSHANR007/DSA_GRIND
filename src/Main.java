import java.util.*;

public class Main {

    public static String solve(String str)
    {
        int n=str.length();

        boolean[][] pal=new boolean[n][n];

        for(int i=0;i<n;i++){
            pal[i][i]=true;
        }

        for(int l=2;l<=n;l++){

            for(int i=0;i<=n-l;i++){

                int j=i+l-1;

                if(str.charAt(i)==str.charAt(j)){
                    pal[i][j]=(l==2)||pal[i+1][j-1];
                }
            }
        }
        int[] zero=new int[n+1];
        int[] one=new int[n+1];

        for(int i=0;i<n;i++){


            zero[i+1]=zero[i]+(str.charAt(i)=='0'?1:0);

            one[i+1]=one[i]+(str.charAt(i)=='1'?1:0);
        }

        for(int i=0;i<n;i++){
            for(int j=i;j < n;j++){
                if(pal[i][j]){

                    int z=zero[i]+(zero[n] - zero[j+1]);
                    int o=one[i]+(one[n]-one[j+1]);

                    if(z<=o){

                        StringBuilder res= new StringBuilder();

                        for(int k=0;k<z;k++){res.append('0');
                        }

                        for(int k=0;k<o;k++){

                            res.append('1');
                        }
                        return res.toString();
                    }
                }
            }
        }

        return str;
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();

        while(t-->0){
            String s=sc.next();
            System.out.println(solve(s));
        }
    }
}
