package Trees;

public class EqualTree {



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


    public boolean checkEqual(Tree root1 , Tree root2){

        if(root1==null && root2==null) return true;

        return helper(root1,root2);


    }


    public boolean helper(Tree node1, Tree node2){

        if( node1.val != node2.val){
            return  false;
        }

       return helper(node1.left,node2.left) && helper(node1.right,node2.right);


    }
}
