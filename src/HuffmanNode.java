public class HuffmanNode implements Comparable<HuffmanNode> {
    private final int frequency;
    private char character;
    private HuffmanNode leftNode;
    private HuffmanNode rightNode;

    HuffmanNode(char character, int frequency){
        this.character = character;
        this.frequency = frequency;

    }

    @Override
    public int compareTo(HuffmanNode other) {
        return Integer.compare(this.frequency, other.frequency);

    }
}
