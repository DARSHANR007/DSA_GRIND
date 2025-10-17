import java.util.*;
public class Main{
    public static void main(String[] args){
        
        Scanner sc=new Scanner(System.in);

        int t=sc.nextInt();

        while(t-->0){
            int n=sc.nextInt();
            String str=sc.next();


            int count=0;

            int upto=1;

            boolean correct=true;


            for(int i=0;i<n;i++) upto*=2;


            for(int k=0; k<upto; k++)
            {
                char[] arr = new char[n];

                Arrays.fill(arr,'0');

                for(int i = 0; i < n; i++){

                    if((k&(1<<i))!=0){
                        if(arr[i] =='0')
                        {
                            arr[i] = 'x';
                        }
                    }
                }

                for(int i=1;i<(n>>1);i++)
                {
                    if(arr[i-1]=='x' && arr[n-i-1]=='x'){
                        correct=false;
                        break;
                    }
                }
                if(!correct) continue;
                for(int i=0;i<(n>>1);i++)
                {
                    if(arr[i]=='x'){
                        arr[i]=str.charAt(i);
                    }
                }
                count=0;
                for(char c:arr) {
                    if(c!='0') count++;
                }
                System.out.println(count);
            }
        }
    }
}
