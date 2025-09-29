import javax.swing.tree.TreeNode;

public class completenessofBinaryTree {


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

    public boolean isCompleteTree(Tree root) {

        if(root==null)return false;


        return helper(root.left)||helper(root.right);
        
    }


    public boolean helper(Tree node){

        if(node.left==null && node.right.left==null && node.right.right==null){
            return false;
        }

        helper(node.left);
        helper(node.right);

        return true;

        

    }


    
}
