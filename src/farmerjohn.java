import java.io.*;
import java.util.*;

public class farmerjohn{

    private static long helper(BufferedReader reader)throws IOException{
        StringTokenizer token=new StringTokenizer(reader.readLine());
        int eventno=Integer.parseInt(token.nextToken()); long totalDuration=Long.parseLong(tokenizer.nextToken());
        long[]timetaken=new long[eventno];

        int[]eventSide=new int[eventno];
        
        for(int i=0;i<eventno;i++){token=new StringTokenizer(reader.readLine());
            timetaken[i]=Long.parseLong(token.nextToken());
            eventSide[i]=Integer.parseInt(token.nextToken());}

        long res=0;
        long before=0;
        
        int curr=0;

        for(int i=0;i<eventno;i++){
            long timeuse=timetaken[i]-before;
            int needed=Math.abs(curr-eventSide[i]);
            res+=needed;
            timeuse-=needed;
            if(timeuse>0){res+=timeuse/2;
            }
            before=timetaken[i];curr=eventSide[i];
        }

        long remainingTime=totalDuration-before;
        res+=remainingTime/2;
        return res;
    }

    public static void main(String[]args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int tc=Integer.parseInt(br.readLine());
        while(tc-->0){System.out.println(helper(br  ));
        }
    }
}
