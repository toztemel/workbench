package ctci.trees;

class DoubleBSTNode extends BinarySearchTreeNode {

    private DoubleBSTNode parent;

    DoubleBSTNode(int i, DoubleBSTNode parent) {
        super(i);
        this.parent = parent;
    }

    DoubleBSTNode(int i) {
        this(i, null);
    }

    void addChild(int i) {
        super.insertNode(new DoubleBSTNode(i, this));
    }

        DoubleBSTNode getParent() {
        return parent;
    }

    public void setLeft(DoubleBSTNode left) {
        this.left = left;
        left.parent = this;
    }

    public void setRight(DoubleBSTNode r) {
        this.right = r;
        r.parent = this;
    }
}
