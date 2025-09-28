import java.util.HashSet;
import java.util.Set;

public class alllengthssubtraction {

public String helper(int[] arr){

    String str="";

  Set<Integer> set=new HashSet<>();

  for(int i=0;i<arr.length;i++){


    if(!set.add(arr[i])){
        str="no";
        
    }
    else{
        str="yes";
    }
  }

  return str;

}
    
}
