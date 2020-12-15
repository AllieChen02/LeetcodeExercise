// Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

// For example:
// Given binary tree [3,9,20,null,null,15,7],
//     3
//    / \
//   9  20
//     /  \
//    15   7
// return its level order traversal as:
// [
//   [3],
//   [9,20],
//   [15,7]
// ]
var levelOrder = function(root) {
    if(!root){
        return [];
    }
    const queue = [root];
    const res = [];
    while(queue.length !=0) {
        let len = queue.length;
        temp = [];
        for(let i=0; i<len; i++) {
            // Get next node
           let current = queue.shift();
           temp.push(current.val);
           if(current.left) {
               queue.push(current.left);
           }
           if(current.right) {
               queue.push(current.right);
           }
        }
        res.push(temp);
    }
    return res;
};