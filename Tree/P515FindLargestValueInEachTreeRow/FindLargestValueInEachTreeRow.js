/**
 * @param {TreeNode} root
 * @return {number[]}
 */
function TreeNode(val, left, right) {
    this.val = (val===undefined ? 0 : val)
    this.left = (left===undefined ? null : left)
    this.right = (right===undefined ? null : right)
}
var largestValues = function(root) {
    let res = [];
    if(!root){
        return res;
    }
    let queue = [];
    queue.push(root);
    while(queue.length) {
        const size = queue.length;
        let max = -Infinity;
        for(let i=0; i<size; i++) {
            let node = queue.shift()
            max = Math.max(node.val, max)
            if(node.left){queue.push(node.left);}
            if(node.right){queue.push(node.right);}
        }
        res.push(max)
    }
    return res;
};