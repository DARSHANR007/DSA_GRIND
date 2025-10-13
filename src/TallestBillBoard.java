import java.util.Arrays;

public class TallestBillBoard {
    public int tallestBillboard(int[] rods) {

        int n=rods.length;

        Arrays.sort(rods);

        int avoid=rods[n-1]+1;

        int length=0;

        for(int rod:rods){

            if(rod %2==1){
                avoid=Math.min(avoid,rod);
            }

            length+=rod;

        }

        if(length%2==1){
            length=length-avoid;
        }else{
            avoid=-1;
        }

        length=length/2;






        return 0;

    }
}
