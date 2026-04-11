import java.util.HashMap;

public class Huffman {

    private  HashMap<Character, Integer> frequencyMap;
    private String text;

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



}
