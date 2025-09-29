import javax.swing.tree.TreeNode;

public class CousinsBinaryTree{



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


    public boolean isCousins(Tree root, int x, int y) {

        helper(root,x,y);
        
    }


    public boolean helper(Tree node, int x, int y){


        if(node==null) return false;

        if(node.left.val==x && node.right.val==y ||node.left.val==y && node.right.val==x) return false;

        if(node.val==x || node.val==y){
            return true;
        }

        helper(node.left, x,y);
        helper(node.right, x, y);

    
    }











}