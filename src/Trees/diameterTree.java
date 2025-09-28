package Trees;

public class diameterTree {



    
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

   int diameter=0;
    public int  solution(Tree root){
        
        
        return helper(root);
    
    
    
    }

    public int helper(Tree node){

        if(node==null)return 0;

        int left=helper(node.left);
        int right=helper(node.right);

        diameter=Math.max(diameter, left+right);

        return 1+Math.max(left, right);

        

    }
    
    
}
