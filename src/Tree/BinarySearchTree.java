package Tree;

 public class BinarySearchTree {

    // Method to get a node with specific data
    TreeNode get(TreeNode root, int data) {
        if (root == null) {
            return null;
        }
        if (data < root.data) {
            return get(root.left, data);
        } else if (data > root.data) {
            return get(root.right, data);
        }
        return root; // if root is not smaller or bigger, it has to be equal to data
    }

    // Method to create and insert nodes into a BST
    TreeNode createBST(TreeNode root, int data) {
        if (root == null) {
            return new TreeNode(data); // returns this value (address) in root at 21, creating rootNode
        }

        if (data < root.data) { // #1
            root.left = createBST(root.left, data); // root.left because we are moving/adding data toward left
        } else if (data > root.data) { // #2
            root.right = createBST(root.right, data); // root.right because we are moving/adding data toward right
        }
        return root; // #3
        // how it works?
        // first 6 insert checks if root is null or root, since root = !null, it checks if data is > / < .
        // then it goes to #1. here createBST is called then it moves to root.left but root. left is null in
        // null 11 null. in #1 root.left = create(null , 6) since root passed is null new node is created
        // then #3 passes root that is address of 6 to first root and adds root.left = #3 root, creating link
        // address is changed each time.
    }

    // Method to remove a node from BST
    TreeNode removeNodeBst(TreeNode root, int data) {
        if (root == null) {
            return root;
        }
        if (data < root.data) {
            root.left = removeNodeBst(root.left, data);
        } else if (data > root.data) {
            root.right = removeNodeBst(root.right, data);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                int minValue = findMin(root.right); // or maxValue from left subTree
                root.data = minValue;
                root.right = removeNodeBst(root.right, minValue);
            }
        }
        return root;
    }

    // Method to find the minimum value in a BST
    int findMin(TreeNode root) {
        int min = root.data;
        while (root.left != null) {
            min = root.left.data;
            root = root.left;
        }
        return min;
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        // 11, 6, 8, 4, 19, 10, 5, 17, 43, 49, 31
        TreeNode root = bst.createBST(null, 11);
        root = bst.createBST(root, 6);
        root = bst.createBST(root, 8);
        root = bst.createBST(root, 4);
        root = bst.createBST(root, 19);
        root = bst.createBST(root, 10);
        root = bst.createBST(root, 5);
        root = bst.createBST(root, 17);
        root = bst.createBST(root, 43);
        root = bst.createBST(root, 49);
        root = bst.createBST(root, 31);

        System.out.println("BST created and populated with nodes.");

        TreeNode node = bst.get(root, 10);
        System.out.println("Node with data 10 found: " + (node != null ? node.data : "not found"));

        root = bst.removeNodeBst(root, 10);
        System.out.println("Node with data 10 removed.");

        node = bst.get(root, 10);
        System.out.println("Node with data 10 found after removal: " + (node != null ? node.data : "not found"));
    }
}
