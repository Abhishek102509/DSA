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
// class Solution {
//     public TreeNode buildTree(int[] preorder, int[] inorder) {
//         Deque<Integer> preorderQueue = new ArrayDeque<>();
//         for(int val: preorder){
//             preorderQueue.offer(val);
//         }
//         return build(preorderQueue,inorder);
//     }
//     private TreeNode build(Deque<Integer>preorder , int[] inorder){
//          if(inorder.length>0){
//             int idx = indexOf(inorder,preorder.poll());
//             TreeNode root = new TreeNode(inorder[idx]);

//             root.left =build(preorder, Arrays.copyOfRange(inorder, 0, idx));
//             root.right = build(preorder, Arrays.copyOfRange(inorder, idx +              1,  inorder.length));
//             return root;
//          }
//          return null;
//     }
//     private int indexOf(int[] arr, int value){
//         for(int i =0;i<arr.length; i++){
//             if(arr[i] == value){
//                 return i;
//             }
//         }
//         return -1;
//     }
// }





class Solution {
    private int preorderIndex;
    private Map<Integer, Integer> mapping;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        mapping = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            mapping.put(inorder[i], i);
        }

        preorderIndex = 0;
        return build(preorder, 0, inorder.length - 1);        
    }

    private TreeNode build(int[] preorder, int start, int end) {
        if (start > end) return null;

        int rootVal = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootVal);
        int mid = mapping.get(rootVal);

        root.left = build(preorder, start, mid - 1);
        root.right = build(preorder, mid + 1, end);

        return root;
    }
}