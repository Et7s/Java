import java.lang.reflect.Array;
import java.util.Arrays;

class MaxElementFinder implements Runnable {
    private int[] row;
    private int maxElement = Integer.MIN_VALUE;

    public MaxElementFinder(int[] row) {
        this.row = row;
    }
    @Override
    public void run() {
        findMax();
    }
    private void findMax(){
        for (int item : row) {
            if (item > maxElement) {
                maxElement = item;
            }
        }
    }
    public int getMaxElement() {
        System.out.println(maxElement + " наибольшее в " + Arrays.toString(row));
        return maxElement;
    }
}