import java.util.*;

class Solution {
    public TreeNode replaceValueInTree(TreeNode root) {
        if (root == null) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        root.val = 0; // root is always 0

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<TreeNode> levelNodes = new ArrayList<>();
            Map<TreeNode, Integer> siblingMap = new HashMap<>();
            int levelSum = 0;

            // Step 1: Collect children instead of parents
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                int siblingSum = 0;
                if (node.left != null) siblingSum += node.left.val;
                if (node.right != null) siblingSum += node.right.val;

                if (node.left != null) {
                    levelNodes.add(node.left);
                    siblingMap.put(node.left, siblingSum);
                    queue.add(node.left);
                    levelSum += node.left.val;
                }
                if (node.right != null) {
                    levelNodes.add(node.right);
                    siblingMap.put(node.right, siblingSum);
                    queue.add(node.right);
                    levelSum += node.right.val;
                }
            }

            // Step 2: Update values directly on children
            for (TreeNode child : levelNodes) {
                int siblingSum = siblingMap.get(child);
                child.val = levelSum - siblingSum;
            }
        }

        return root;
    }
}
