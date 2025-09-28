package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

public class lc515 {

    public List<Integer> largestValues(TreeNode root) {


        Queue<TreeNode> queue=new LinkedList<>();


        List<Integer> list=new ArrayList<>();

        queue.add(root);

        while (!queue.isEmpty()) {

            int maxi=Integer.MIN_VALUE;

            TreeNode curr=queue.remove();
            maxi=Math.max(maxi, curr.val);

            if(curr.left!=null){
                queue.add(curr.left);
            }
            if(curr.right!=null){
                queue.add(curr.right);
            }


            
        }

        



        return new ArrayList<>();
        
    }
    
}
