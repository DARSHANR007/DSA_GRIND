package Trees;

import java.util.ArrayList;
import java.util.List;

public class TreeMatching {
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

   

//    1                              
//   / \
//  2   3
//     / \
//    4   5


    int count=0;

    public int solution(Tree root){  



       List<Integer> seen=new ArrayList<>();

       helper(root,seen );
        return count;
    }


    public void helper(Tree root,List<Integer> seen){

        if(root==null) return ;

        if(root.left!=null && !seen.contains(root.left.val)){
            count++;
            seen.add(root.left.val);
        }

        if(root.right!=null && !seen.contains(root.right.val)){
            count++;
            seen.add(root.right.val);
        }

        helper(root.left, seen);
        helper(root.right, seen);



    }



}
