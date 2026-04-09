public class RedBlackTree extends BalancableTree{

    public RedBlackTree(int value){
        super(value);
    }

    public boolean isBlack(Node node){
        if ( node == null|| node.isRed == false ){
            return true;
        }
        return false;
    }

    public boolean isRed(Node node){
        if (node != null && node.isRed == true){
            return true;
        }
        return false;
    }


    private void makeBlack(Node node){
        node.setRed(false);
    }


    private void makeRed(Node node){
        node.setRed(true);
    }

    private void setColor(Node node, boolean toRed){
        if(toRed == true){
            makeRed(node);
        }else{
            makeBlack(node);
        }

    }


    private void resolveRed(Node node) {

        Node parent, sibling, middle, grandparent;
        parent = node.getParent();

        if (isRed(parent)) {
            sibling = sibling(parent);

            if (sibling == null || isBlack(sibling)) {
                middle = restructure(node);
                makeBlack(middle);
                makeRed(middle.getLeft());
                makeRed(middle.getRight());
            } else {
                makeBlack(parent);
                makeBlack(sibling);

                grandparent = parent.getParent();

                if (grandparent != getRoot()) {
                    makeRed(grandparent);
                    resolveRed(grandparent);
                }
            }
        }
    }


    public void rebalanceDelete(Node node){
        if(isRed(node)){
            makeBlack(node);
        }else if(node != getRoot()) {
            Node sibling = sibling(node);

            if (isInternal(sibling) && (isBlack(sibling) || isInternal(sibling.getLeft()))) {
                remedyDoubleBlack(node);
            }
        }
    }

    private void remedyDoubleBlack(Node node){
        Node z = node.getParent();
        Node y = sibling(node);

        if(isBlack(y)){
            if(isRed(y.getLeft()) || isRed(y.getRight())) {
                Node x = null;
                if (isRed(y.getLeft())) {
                    x = y.getLeft();
                } else {
                    x = y.getRight();
                }
                Node middle = restructure(x);
                setColor(middle, isRed(z));
                makeBlack(middle.getLeft());
                makeBlack(middle.getRight());
            }else {
                makeRed(y);
                if(isRed(z)){
                    makeBlack(z);
                }else{
                    if(z != getRoot()){
                        remedyDoubleBlack(z);
                    }
                }
            }
        }else {
            rotate(y);
            makeBlack(z);
            makeRed(z);
            remedyDoubleBlack(node);
        }
    }

    private Node sibling (Node node){
        Node parent = node.getParent();
        if(parent == null){
            return null;
        }
        if(node == parent.getLeft()){
            return parent.getRight();
        }else{
            return parent.getLeft();
        }
    }

    public void balanceDelete(Node node){
        if(node != null) rebalanceDelete(node);
    }




}
