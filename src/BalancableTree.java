public class BalancableTree {

    private Node root;

    public BalancableTree(int value){
        root = new Node(value);
    }

    public Node getRoot(){
        return root;
    }


    public Node searchHelper(Node node, int key){
        if(key == node.getValue()){
            return node;

        }else if (key < node.getValue()){
            if(node.getLeft() == null){
                return node;

            }

            return searchHelper(node.getLeft(), key);
        }else{
            if(node.getRight() == null){
                return node;
            }
            return searchHelper(node.getRight(), key);
        }
    }




    //single deletions
    public int remove(int key){
        Node foundNode = searchHelper(root,key);

        if(foundNode.getValue() == key) {
            return removeHelper(foundNode, key);
        }
        return key;
    }



    public int removeHelper(Node node, int key){
        Node successor = node;

        if(hasNoChild(node)){
            removeLeafNode(node, node.getValue());
        }else if(hasOneChild(node)){
            replaceNodeWithChildNode(node);
        }else if(hasTwoChildren(node)){
            successor = getInorderSuccessor(node.getRight());

            node.setValue(successor.getValue());

            removeHelper(successor,successor.getValue());
        }

        balanceDelete(successor.getParent());
        return node.getValue();
    }

    private boolean hasNoChild(Node node){
        if(node.getLeft() == null && node.getRight()== null){
            return true;
        }
        return false;
    }

    private boolean hasOneChild(Node node){
        if(node.getLeft() != null && node.getRight() == null){
            return true;
        } else if(node.getRight() != null && node.getLeft() == null){
            return true;
        }else{
            return false;
        }
    }

    private  boolean hasTwoChildren(Node node){
        if(node.getLeft() != null && node.getRight()!= null){
            return true;
        }
        return false;
    }


    private void removeLeafNode(Node node, int value){
        Node parentNode;

        if(node.getParent() != null){
            parentNode = node.getParent();

        }else{
            parentNode = node;
        }
        if(parentNode.getLeft() != null && parentNode.getLeft().getValue() == value){
            parentNode.setLeft(null);
        }else{
            parentNode.setRight(null);
        }
    }


    private void replaceNodeWithChildNode(Node node){
        Node leftChild = node.left;
        Node rightChild = node.right;
        Node child = null;

        if(leftChild != null){

            child = leftChild;
        }else{
            child = rightChild;
        }

        if(child != null){
            child.setParent(node.getParent());
        }

        if(node == root){
            root = child;
        }else{
            Node parent = node.getParent();
        if(node == parent.getLeft()){
            parent.setLeft(child);
        }else{
            parent.setRight(child);
        }
        }
    }

    private Node getInorderSuccessor(Node node){
        while(node.getLeft() != null){
            node = node.getLeft();
        }
        return node;
    }

    public void rotate(Node node){
        Node x = node;
        Node y = x.getParent();
        if(y == null) return;
        Node z = y.getParent();

        if(z == null){
            root = x;

        }else {
            relink(z, x, y == z.getLeft());

        }
        if(x == y.getLeft()){
            relink(y,x.getRight(), true);

            relink(x,y, false);
        }else {
            relink(y, x.getLeft(), false);

            relink(x,y, true);
        }
    }

    public Node restructure(Node x){
        Node y = x.getParent();
        Node z = y.getParent();

        if(z == null) return y;

        if ((x == y.getRight()) == (y == z.getRight())){
            rotate(y);

            return y;

        }else{
            rotate(x);
            rotate(x);
            return x;

        }
    }


    private void relink(Node parent, Node child, boolean makeLeftChild){
        if(child != null){
            child.setParent(parent);

        }

        if(makeLeftChild){
            parent.setLeft(child);

        }else{
            parent.setRight(child);

        }
    }

    public boolean isInternal(Node node){
        return hasOneChild(node) || hasTwoChildren(node);
        
    }

    public void balanceDelete(Node node){
        
    }

    public void inOrder(Node node){
        if(node == null) return;
            inOrder(node.getLeft());
            System.out.println(node.getValue() + " ");
            inOrder(node.getRight());
        }
    }


