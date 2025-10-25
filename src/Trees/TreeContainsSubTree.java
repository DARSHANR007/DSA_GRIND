package Trees;

public class TreeContainsSubTree {


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



    public boolean check(Tree root1, Tree root2){


        return helper(root1,root2);
    }


    public boolean helper(Tree node1, Tree node2){

      if(node2==null) return  true;

      if(node1==null && node2!=null) return false;


      return  node2.val== node1.val && helper(node1.left,node2.left)&& helper(node2.right,node1.right);


    }
}
