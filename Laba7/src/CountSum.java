import java.util.Arrays;

public class CountSum extends Thread{

    private int[] array;
    private int sum = 0;

    public CountSum(int[] array){
        this.array = array;
    }

    @Override
    public void run(){
        calculateSum();
    }
    private void calculateSum(){
        for (int item: array){
            sum += item;
            System.out.println(sum + " из " + Arrays.toString(array));

        }
    }
    public int getSum(){
        return sum;
    }
}
