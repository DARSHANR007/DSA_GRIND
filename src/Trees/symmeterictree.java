
public class symmeterictree {

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


    public boolean isSymmetric(Tree root) {

        return helper(root.left,root.right);
        
    }


    public boolean helper(Tree x, Tree y){

        if(x.left==null && y.right==null){return true;}

        if(x.left==null || y.right==null){return false;}


        if(x.left.val==y.right.val){
            return true;
        }

        return helper(x.left,y.right) && helper(x.right ,y.left);


    

        



    }
    
}
