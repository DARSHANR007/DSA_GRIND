package Trees;

public class CloneTree {


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


    public Tree clone(Tree root){



        Tree node=new Tree(root.val,clone(root.left),clone(root.right));


        return node;
                
    }
}
