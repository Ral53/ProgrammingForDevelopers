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

        if (balanceFactor > 1 && data < root.left.data) {   // LL
            leftRotationTree(root);
        }

        if (balanceFactor > 1 && data > root.left.data) {   // LR
            root.left = leftRotationTree(root.left);
            return rightRotateTree(root);
        }

        if (balanceFactor > -1 && data > root.right.data) {     // RR
            rightRotateTree(root);
        }

        if (balanceFactor > -1 && data < root.right.data) {     // RL
            root.right = rightRotateTree(root.right);
            leftRotationTree(root);
        }
        return root;
    }

    TreeNode rightRotateTree(TreeNode y) {
        TreeNode x = y.left;  // y = root
        TreeNode t2 = x.right;
        x.right = y;
        y.left = t2;
        y.height = 1+Math.max(getHeight(y.left), getHeight(y.right));
        x.height = 1+Math.max(getHeight(x.left), getHeight(x.right));
        return x;
    }

    TreeNode leftRotationTree(TreeNode x) {
        TreeNode y = x.right;  // x = root
        TreeNode t2 = y.right;
        y.left = x;
        x.right = t2;
        x.height = 1+Math.max(getHeight(x.left), getHeight(x.right));
        y.height = 1+Math.max(getHeight(y.left), getHeight(y.right));
        return y;
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
