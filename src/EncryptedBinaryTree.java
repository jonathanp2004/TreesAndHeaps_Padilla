public class EncryptedBinaryTree {

    public boolean searchEncryptedBT(int[] bt, int index, int realValue, int targetValue) {

        if (index > bt.length-1) {
            return false;
        } else if (bt[index] == -1) {
            return false;

        } else if (realValue == targetValue) {

            return true;
        }


            //left child recursive case
            boolean result1 = searchEncryptedBT(bt, 2 * index + 1, 3 * realValue + 1, targetValue);

            //right child recursive
            boolean result = searchEncryptedBT(bt, 2 * index + 2, 2 * realValue + 5, targetValue);

            if(result == true || result1 == true){
                return true;
            }
            return false;

            //canceled commit so need to do tis comment to be able to commit
        }

        public static void main(String[] args){

        EncryptedBinaryTree main = new EncryptedBinaryTree();

        int[] bt = { -2, -2, -1, -2, -1};

        boolean result = main.searchEncryptedBT(bt,0,1,1);

        System.out.println(result);

        }

    }
