package Trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class mostfrequentsubtreeSum {

    class Tree {
        int val;
        Tree left;
        Tree right;

        Tree(int val, Tree left, Tree right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    Map<Integer,Integer> freq=new HashMap();

    int maxi=0;

    public int[] solution(Tree root){

        List<Integer> list=new ArrayList<>();

        helper(root);

        for(int s)

        

        



    }

    public int helper(Tree node){

        int left=helper(node.left);
        int right=helper(node.right);


        int total=node.val+left+right;

        freq.put(total, freq.getOrDefault(total, 0)+1);
        maxi=Math.max(maxi, freq.get(total));

        return total;
         
        }

        





}
    

