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
        }

    }
