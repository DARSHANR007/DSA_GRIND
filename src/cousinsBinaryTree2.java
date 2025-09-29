import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

public class cousinsBinaryTree2 {


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

     public Tree replaceValueInTree(Tree root) {


        return new Tree(0, root, root);
        
    }



    public void helper(Tree node){


        Queue<Tree> queue=new LinkedList<>();

        queue.add(node);


        while (!queue.isEmpty()) {

            Tree current=queue.poll();

            int size=queue.size();

            
            
        }
    }




    


    
}
