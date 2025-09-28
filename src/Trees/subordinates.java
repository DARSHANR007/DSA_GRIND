package Trees;
import java.util.*;

public class subordinates {
    
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

    List<Integer> list = new ArrayList<>();

    public int[] solution(Tree root) {
        helper(root);
        return list.stream().mapToInt(i -> i).toArray();
    }

    public int helper(Tree root) {
        if (root == null) return 0;

        int count = 0;

        if (root.left != null) {
            count += 1 + helper(root.left);  // 1 for left child + its subordinates
        }

        if (root.right != null) {
            count += 1 + helper(root.right); // 1 for right child + its subordinates
        }

        list.add(count);  // store subordinate count for this node
        return count;
    }
}
