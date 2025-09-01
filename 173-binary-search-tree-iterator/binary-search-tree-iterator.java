// /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode() {}
//  *     TreeNode(int val) { this.val = val; }
//  *     TreeNode(int val, TreeNode left, TreeNode right) {
//  *         this.val = val;
//  *         this.left = left;
//  *         this.right = right;
//  *     }
//  * }
//  */
// class BSTIterator {
//     Stack<TreeNode> st = new Stack<>(); // stack to store nodes
    
//     public BSTIterator(TreeNode root) {
//         // initialize stack with the left chain of root
//         pushLeftChain(root);
//     }
    
//     public int next() {
//         // get the next smallest node
//         TreeNode node = st.pop();
        
//         // if node has a right child, push its left chain
//         if (node.right != null) {
//             pushLeftChain(node.right);
//         }
        
//         return node.val; // return value
//     }
    
//     public boolean hasNext() {
//         // still nodes left if stack is not empty
//         return !st.isEmpty();
//     }
    
//     private void pushLeftChain(TreeNode node) {
//         // push all left children into stack
//         while (node != null) {
//             st.push(node);
//             node = node.left;
//         }
//     }
// }

// /**
//  * Your BSTIterator object will be instantiated and called as such:
//  * BSTIterator obj = new BSTIterator(root);
//  * int param_1 = obj.next();
//  * boolean param_2 = obj.hasNext();
//  */



/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {
    TreeNode root;

    public BSTIterator(TreeNode root) {
        this.root = root;
    }

    public int next() {
        while (root != null) {
            if (root.left == null) {
                int val = root.val;
                root = root.right;
                return val;

            } else {
                TreeNode current = root.left;
                while (current.right != null && current.right != root) {
                    current = current.right;
                }
                if (current.right == null) {
                    current.right = root;
                    root = root.left;
                } else {
                    TreeNode c = root;
                    current.right = null;
                    root = root.right;
                    return c.val;
                }
            }
        }
        return -1;
    }

    public boolean hasNext() {
        return root != null;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
