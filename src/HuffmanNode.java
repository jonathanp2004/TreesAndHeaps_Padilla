public class HuffmanNode implements Comparable<HuffmanNode> {
    private final int frequency;
    char character;
    HuffmanNode left, right;

    HuffmanNode(char character, int frequency){
        this.character = character;
        this.frequency = frequency;
        this.left = null;
        this.right = null;

    }

    @Override
    public int compareTo(HuffmanNode other) {
        return Integer.compare(this.frequency, other.frequency);

    }

    public int getFrequency() {
        return frequency;
    }

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    public HuffmanNode getLeft() {
        return left;
    }

    public void setLeft(HuffmanNode left) {
        this.left = left;
    }

    public HuffmanNode getRight() {
        return right;
    }

    public void setRight(HuffmanNode right) {
        this.right = right;
    }
}
