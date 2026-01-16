import java.util.*;
import java.util.concurrent.locks.*;

public class Loaders {

    static class Warehouse {
        List<Integer> boxes;
        int currentWeight = 0;
        Lock lock = new ReentrantLock();
        Condition cond = lock.newCondition();
        boolean done = false;

        Warehouse(List<Integer> boxes) {
            this.boxes = boxes;
        }

        void work(int id) throws InterruptedException {
            lock.lock();
            try {
                System.out.println("Грузчик " + id + " ждет у склада");
                cond.await();
                while (!done && !boxes.isEmpty()) {
                    int box = boxes.get(0);
                    if (currentWeight + box > 150) {
                        done = true;
                        System.out.println("Грузчик " + id + ": остановка, следующий " + box + "кг превысит 150кг");
                        break;
                    }
                    boxes.remove(0);
                    currentWeight += box;
                    System.out.println("Грузчик " + id + " взял " + box + "кг (всего: " + currentWeight + "кг)");
                    if (currentWeight == 150) {
                        done = true;
                        System.out.println("Грузчик " + id + ": набран максимум 150кг!");
                        break;
                    }
                    Thread.sleep(100);
                }
                cond.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        List<Integer> boxes = new ArrayList<>(Arrays.asList(40, 60, 30, 50, 20, 70, 10));
        System.out.println("Коробки: " + boxes);
        Warehouse w = new Warehouse(boxes);
        Thread[] loaders = new Thread[3];
        for (int i = 0; i < 3; i++) {
            final int id = i + 1;
            loaders[i] = new Thread(() -> {
                try {
                    w.work(id);
                } catch (Exception e) { e.printStackTrace(); }
            });
            loaders[i].start();
        }
        Thread.sleep(100);
        w.lock.lock();
        try {
            System.out.println("\n=== НАЧИНАЕМ РАБОТУ! ===\n");
            w.cond.signalAll();
        } finally {
            w.lock.unlock();
        }
        for (Thread t : loaders) t.join();
        System.out.println("\n=== РЕЗУЛЬТАТ ===");
        System.out.println("Собрано: " + w.currentWeight + "кг");
        System.out.println("Осталось коробок: " + w.boxes.size() + " -> " + w.boxes);
    }
}