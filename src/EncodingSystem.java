import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class EncodingSystem {
    private List<Huffman> huffmanList = new ArrayList<>();
    private List<String> encodedTexts = new ArrayList<>();

    public EncodingSystem(String[] texts){

        for (int i = 0; i <texts.length ; i++) {
                Huffman huffman = new Huffman(texts[i]);
                huffmanList.add(huffman);

                String encoded = huffman.encode(texts[i]);
                encodedTexts.add(encoded);
        }

    }

    public String highestCode(){

        int longestLength = 0;
        String longest = "";

        for (int i = 0; i < encodedTexts.size(); i++) {

            if (encodedTexts.get(i).length() > longestLength){

                longest = encodedTexts.get(i);
                longestLength = encodedTexts.get(i).length();

            }

        }
        return longest;

    }

    public void shuffleCodes(){
        Collections.shuffle(encodedTexts);
    }

    public void stats(){
        for(Huffman huffman : huffmanList){
            huffman.printStats();
        }
    }



}
