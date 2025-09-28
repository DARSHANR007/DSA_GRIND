

public class SameTree {

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

    public boolean isSameTree(Tree p, Tree q) {

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
        
    }

    public boolean helper(Tree x, Tree y){

        if(x.val==y.val) return true;

        return false;


    }
    
}
