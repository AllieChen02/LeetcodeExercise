var cloneTree = function(root) {
    if(!root){
        return null;
    } 
    const cloneRoot = new Node(root.val, []);
    for(let child of root.children) {
        const temp = cloneTree(child);
        if(temp) {
            cloneRoot.children.push(temp);
        }
    }
    return cloneRoot;
};