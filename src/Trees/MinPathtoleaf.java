package Trees;

public class MinPathtoleaf {


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



    public int mindistance(Tree root){


        if(root==null) return 0;


        return helper(root);


    }

    public int helper(Tree node){

        if(node==null) return 0;


        if(node.left==null && node.right==null) return  1;


        if(node.left==null && node.right!=null){
            return 1+helper(node.right);
        }

        if(node.right==null && node.left!=null){
            return 1+ helper(node.left);
        }

        return 1+ Math.min( helper(node.left),helper(node.right));







    }
}
