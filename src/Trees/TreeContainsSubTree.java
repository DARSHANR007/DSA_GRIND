package Trees;

public class TreeContainsSubTree {


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



    public boolean check(Tree root1, Tree root2){


        return false;
    }


    public boolean helper(Tree node1, Tree node2){

        if(node1.val != node2.val) {


            helper(node1.left,node2.left);
            helper(node1.right,node2.right);
        }


    }
}
