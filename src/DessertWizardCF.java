public class DessertWizardCF {


    public int solution(int n, int[] arr) {



        int[] dpmaxleft = new int[n + 1];
        int[] dpminleft = new int[n + 1];
        int[] dpmaxright = new int[n + 1];
        int[] dpminright = new int[n + 1];


        int currmaxleft=arr[0];



        for (int i = 1; i < n; i++) {

            currmaxleft = Math.max(currmaxleft, arr[i]);
            dpmaxleft[i] = Math.max(dpmaxleft[i - 1], currmaxleft);
            

        }
        







        return 0;

    }
    
}
