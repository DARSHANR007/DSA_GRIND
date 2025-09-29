package Trees;

import java.util.ArrayList;
import java.util.List;

public class PathSum2 {


    
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
    

    List<List<Integer>> result=new ArrayList<>();

    public List<List<Integer>> solution(Tree root, int target){

        helper(new ArrayList<>(), root, target);

        return result;
    }


    public void helper(List<Integer> path, Tree node, int target){

        if( node.val == target && node.left==null && node.right==null){
            result.add(new ArrayList<>(path));
        }
        else{
            if(node.left!=null && target > 0){
                helper(path, node.left, target-node.left.val);
                path.add(node.left.val);
            }
            if(node.right!=null && target >0){
                path.remove(path.size()-1);
                helper(path, node.right, target-node.right.val);
                path.add(node.right.val);
            }
            
        }

        



    }

    
    
}
