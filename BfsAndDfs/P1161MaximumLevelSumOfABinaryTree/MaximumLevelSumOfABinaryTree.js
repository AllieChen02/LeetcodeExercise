var maxLevelSum = function(root) {
    if(!root){
        return null;
    }
    const queue = [root];
    const levels = []
    while(queue.length > 0) {
        size = queue.length;
        tempSum = 0;
        for(let i=0; i<size; i++) {
            node = queue.shift()
            tempSum += node.val;
            if(node.left) {
                queue.push(node.left)
            }
            if(node.right){
                queue.push(node.right)
            }
        }
        levels.push(tempSum)
    }
    return levels.indexOf(Math.max(...levels)) + 1;
};