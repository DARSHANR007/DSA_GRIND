

public class sumofleftleaves {


    
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

    int sum=0;
    public int sumOfLeftLeaves(Tree root) {


        helper(root);

        return sum;
        
    }

    public void helper(Tree node){

       if(node==null)return ;

       if(node.left!=null){
        sum+=node.left.val;
       }

       helper(node.left);
       helper(node.right);
       

        
    }
    
}
