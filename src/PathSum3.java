public class PathSum3 {
 



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

    int count=0;

    public int solution(Tree root, int target){

        helper(root,target,target);
        return count;




    }

    public void helper(Tree node, int target ,int original){

        target-=node.val;
        int curr=original;
        curr-=node.val;

        if(node.val==target){
            count++;
            return;
        }
        if(node.val==curr){
            count++;
            return;
        }
        else{

            if(node.left!=null ){
                if(target > 0)helper(node.left,target,original);
                if(curr > 0) helper(node, curr, original);
            }
             if(node.right!=null ){
                if(target > 0)helper(node.right,target,original);
                if(curr > 0) helper(node.right, curr, original);
            }
        }
        target+=node.val;
        original+=node.val;



    }


    
}
