// For example:
// Given binary tree [3,9,20,null,null,15,7],
//     3
//    / \
//   9  20
//     /  \
//    15   7
// return its minimum depth:
// 2

var minDepth = function(root) {
    let res = Number.MAX_SAFE_INTEGER;
    if(!root) {
        return 0;
    }
    function helper(root, level){
        if(!root.left && !root.right) {
            res = Math.min(res, level)
            return;
        }
        if(root.left) {
            helper(root.left, level+1);
        }
        if(root.right) {
            helper(root.right, level+1);
        }
    }
    helper(root, 1);
    return res;
};