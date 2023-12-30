import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("1) First task: ");
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        int[] firstHalfOfArray = Arrays.copyOfRange(array, 0, array.length/2);
        int[] secondHalfOfArray = Arrays.copyOfRange(array, array.length/2, array.length);

        CountSum firstThread = new CountSum(firstHalfOfArray);
        CountSum secondThread = new CountSum(secondHalfOfArray);

        firstThread.start();
        secondThread.start();
        try {
            firstThread.join();
            secondThread.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        int totalSum = firstThread.getSum() + secondThread.getSum();
        System.out.println("Сумма чисел в массиве равна " + totalSum);


        System.out.println("2) Second task: ");

        int[][] matrix = {
                {1, 2, 3, 99, 500, -3},
                {4, 5, 6, 18, 44, 192},
                {7, 8, 9, 10000, 32, 8},
                {1, 2, 3, 88, 56, 31},
                {4, 5, 6, 444, 404, 403},
                {7, 8, 9, 228, 322, 911},
        };

        int maxElement = Integer.MIN_VALUE;
        MaxElementFinder[] maxFinders = new MaxElementFinder[matrix.length];
        Thread[] threads = new Thread[matrix.length];

        for (int i = 0; i<matrix.length; i++){
            maxFinders[i] = new MaxElementFinder(matrix[i]);
            threads[i] = new Thread(maxFinders[i]);
            threads[i].start();
        }
        for (int i = 0; i<matrix.length; i++){
            try {
                threads[i].join();
                int result = maxFinders[i].getMaxElement();
                if (result > maxElement) {
                    maxElement = result;
                }
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("Самый большой элемент в " + Arrays.deepToString(matrix) + " это " + maxElement);

        System.out.println("3) Third task: ");
        WarehouseTransfer.main(new String[]{" "});

    }

}