

public class pathsum {



    
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

    public boolean hasPathSum(Tree root, int targetSum) {


        return helper(targetSum, root, 0);
     }


    public boolean helper(int targetSum, Tree node, int sum){
       
        if(node==null)return false;

        if(sum==targetSum && node.left==null && node.right==null)return true;

        if(sum > targetSum)return false;

        if(node.left!=null){
            helper(targetSum, node, sum+node.val);
        }

        if(node.right!=null){
            helper(targetSum, node, sum+node.val);
        }


    }
    
}
