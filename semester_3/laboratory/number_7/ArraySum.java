public class ArraySum {

    static int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    static int arraySize = array.length;
    private static volatile int sumFirstHalf = 0;
    private static volatile int sumSecondHalf = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < arraySize / 2; i++) {
                sumFirstHalf += array[i];
            }
            System.out.println("Поток 1 вычислил сумму: " + sumFirstHalf);
        });
        Thread thread2 = new Thread(() -> {
            for (int i = arraySize / 2; i < arraySize; i++) {
                sumSecondHalf += array[i];
            }
            System.out.println("Поток 2 вычислил сумму: " + sumSecondHalf);
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        int totalSum = sumFirstHalf + sumSecondHalf;
        System.out.println("Общая сумма: " + totalSum);
    }
}