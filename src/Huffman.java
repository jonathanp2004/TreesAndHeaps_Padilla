import java.util.HashMap;
import java.util.PriorityQueue;

public class Huffman {

    private  HashMap<Character, Integer> frequencyMap;
    private String text;
    private HuffmanNode root;

    public Huffman(String text){
        this.text = text;
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



}
