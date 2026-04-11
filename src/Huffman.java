import java.util.HashMap;
import java.util.PriorityQueue;

public class Huffman {

    private  HashMap<Character, Integer> frequencyMap;
    private String text;
    private HuffmanNode root;
    private HashMap<Character, String> huffmanCodes = new HashMap<>();

    public Huffman(String text){
        this.text = text;
        frequencyCount(text);
        buildHuffman();
        genCode();
    }


    public void frequencyCount(String text){
         frequencyMap = new HashMap<>();

        for (int i = 0; i <text.length() ; i++) {
            if(frequencyMap.containsKey(text.charAt(i))) continue;

            int count = 0;

            for (int j = 0; j < text.length(); j++) {
                if(text.charAt(i) == text.charAt(j)){

                    count ++;
                }
            }
            frequencyMap.put(text.charAt(i),count);
        }
    }

    public void buildHuffman(){
        PriorityQueue<HuffmanNode> minHeap = new PriorityQueue<>();

        var entrySet = frequencyMap.entrySet();
        for(var entry : entrySet){

            HuffmanNode treeNode = new HuffmanNode(entry.getKey(), entry.getValue());
            minHeap.add(treeNode);
        }

        while(minHeap.size() > 1){
            HuffmanNode node1 = minHeap.poll();
            HuffmanNode node2 = minHeap.poll();

            HuffmanNode parentNode = new HuffmanNode('0',node1.getFrequency()+node2.getFrequency());

            parentNode.left =node1;
            parentNode.right = node2;


            minHeap.add(parentNode);

        }

        root = minHeap.poll();

    }

    public void genCode(){
        genCodeHelper(root,"");
    }

    private  void genCodeHelper(HuffmanNode node, String code) {
        if (node == null) return;

        if (node.left == null && node.right == null) {
            huffmanCodes.put(node.character, code);
            return;
        }
        genCodeHelper(node.left, code + '0');
        genCodeHelper(node.right, code + '1');
    }

    public String encode(String text){

        String result = "";

        for (int i = 0; i < text.length(); i++) {

            char c1 = text.charAt(i);

            if(huffmanCodes.containsKey(c1)){

               result += huffmanCodes.get(i);

            }

        }
        return result;
    }

    public void printStats(){

        System.out.println("Frequencies: ");
        var entrySet = frequencyMap.entrySet();
        for(var entry : entrySet){
            System.out.print(entry.getKey()+ ": " + entry.getValue());
        }

        System.out.println("Huffman Codes:");
        var entrySet2 = huffmanCodes.entrySet();
        for(var entry: entrySet2){
            System.out.print(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("Encoded:");
        System.out.println(encode(text));

    }
}
