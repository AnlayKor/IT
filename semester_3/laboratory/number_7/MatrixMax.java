import java.util.Arrays;

public class MatrixMax {
    static int rows = 5;
    static int cols = 5;
    private static int[][] matrix = new int[rows][cols];
    private static int[] rowMaxValues = new int[rows];

    public static void main(String[] args) throws InterruptedException {
        int number = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = ++number;
            }
        }
        rowMaxValues = new int[rows];
        Arrays.fill(rowMaxValues, 0);
        Thread[] threads = new Thread[rows];
        for (int i = 0; i < rows; i++) {
            final int rowIndex = i;
            threads[rowIndex] = new Thread(() -> {
                int rowMax = 0;
                for (int j = 0; j < cols; j++) {
                    if (matrix[rowIndex][j] > rowMax) {
                        rowMax = matrix[rowIndex][j];
                    }
                }
                rowMaxValues[rowIndex] = rowMax;
                System.out.println("Максимум строки " + (rowIndex + 1) + ": " + rowMax);
            });
        }
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        int totalMax = 0;
        for (int i = 0; i < rows; i++) {
            if (rowMaxValues[i] > totalMax) {
                totalMax = rowMaxValues[i];
            }
        }
        System.out.println("Максимум: " + totalMax);
    }
}