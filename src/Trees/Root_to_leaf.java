package Trees;

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

public class Root_to_leaf {

    
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
      

    List<List<Integer>> list=new ArrayList<>();


    public List<List<Integer>> binaryTreePaths(Tree root) {

        if(root==null)return new ArrayList<>();

        List<Integer> currPath=new ArrayList<>();

        helper(root, currPath);
        return new ArrayList<>();
        
    }


    public void helper(Tree node,List<Integer>curr_path){

        curr_path.add(node.val);

        if(node.left==null && node.right==null){
            list.add(new ArrayList<>(curr_path));
            return;
        }

        if(node.left!=null){
            helper(node.left, curr_path);
        }

        if(node.right!=null){
            helper(node.right, curr_path);
        }



    
    }
    
}
