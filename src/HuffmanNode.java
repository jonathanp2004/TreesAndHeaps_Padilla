public class HuffmanNode implements Comparable<HuffmanNode> {
    private final int frequency;
    private char character;
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
}
