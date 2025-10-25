package Trees;

public class InvertTree {





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

    public void modifyTree(Tree root){

        if(root ==null ) return ;

        helper(root);


    }


    public void helper(Tree root){

        if(root==null) return;
        Tree temp;
            temp=root.left;
            root.left=root.right;
            root.right=temp;


            helper(root.left);
            helper(root.right);



    }


}
