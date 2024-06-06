package Tree;

import com.sun.source.tree.Tree;

public class AVLTree {

    TreeNode createBST(TreeNode root, int data) {
        if (root == null) {
            return new TreeNode(data);
        } else if (data < root.data) {
            root.left = createBST(root.left, data);
        } else if (data > root.data) {
            root.right = createBST(root.right, data);
        } else {
            return root;
        }
        root.height = 1 + Math.max(getHeight(root.left), getHeight(root.right));
        int balanceFactor = getBalanceFactor(root);

        // LL, LR, RR, RL

        return root;
    }

    int  getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    int getBalanceFactor(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return node.left.height - node.right.height;
    }


}
