public class Node {

    int value;
    Boolean isRed;
    Node left, right, parent;
    private int heightProperty = 0;


    Node(int value){

        this.value = value; // number value
        this.isRed = true; // color of node
        this.left = null; // start all nodes null
        this.right = null;
        this.parent = null;

    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Boolean getRed() {
        return isRed;
    }

    public void setRed(Boolean red) {
        isRed = red;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public int getHeightProperty() {
        return heightProperty;
    }

    public void setHeightProperty(int heightProperty) {
        this.heightProperty = heightProperty;
    }
}
