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
        if(node == null) return;
        node.setRed(false);
    }


    private void makeRed(Node node){
        if(node == null) return;
        node.setRed(true);
    }

    private void setColor(Node node, boolean toRed){
        if(toRed == true){
            makeRed(node);
        }else{
            makeBlack(node);
        }

    }


    public void resolveRed(Node node) {

        Node parent, sibling, middle, grandparent;
        parent = node.getParent();

        if(parent == null) return;

        if (isRed(parent)) {
            sibling = sibling(parent);
            grandparent = parent.getParent();
            if(grandparent == null) return;

            if (sibling == null || isBlack(sibling)) {
                middle = restructure(node);
                makeBlack(middle);
                makeRed(middle.getLeft());
                makeRed(middle.getRight());
            } else {
                makeBlack(parent);
                makeBlack(sibling);



                if (grandparent != getRoot()) {
                    makeRed(grandparent);
                    resolveRed(grandparent);
                }
            }
        }
    }

    public void insert(int key){
        Node newNode = new Node(key);

        Node parent = searchHelper(getRoot(), key);

        newNode.setParent(parent);
        if(key < parent.getValue()){
            parent.left =  newNode;
        }else{
            parent.right = newNode;
        }

        resolveRed(newNode);
        getRoot().setRed(false);

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

    public void deleteInRange(Node node, int a, int b){
        if(node == null){
            return;
        }
        if(node.getValue() < a){
            deleteInRange(node.right,a, b);
        } else if (node.getValue() > b){
            deleteInRange(node.left,a, b);
        }else{
            //preorder(for deletion) :0
            deleteInRange(node.left,a, b);
            deleteInRange(node.right,a, b);
            remove(node.getValue());
        }
    }

    public static void main(String[]args){

        RedBlackTree tree = new RedBlackTree(30);

        tree.insert(20);
        tree.insert(10);
        tree.insert(19);
        tree.insert(55);
        tree.insert(42);
        tree.insert(77);

        tree.inOrder((tree.getRoot()));

        tree.deleteInRange(tree.getRoot(),15,20);
        System.out.println(tree.getRoot().getValue());

        tree.inOrder((tree.getRoot()));


    }





}
