package pt1.HomeworkN4;

public class DeadlockDemo {

    private static final Object lockA = new Object();
    private static final Object lockB = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            synchronized (lockA) {
                System.out.println("Поток 1: захватил lockA");
                sleep(100);
                System.out.println("Поток 1: пытаюсь захватить lockB...");
                synchronized (lockB) {
                    System.out.println("Поток 1: захватил lockB");
                }
            }
        }, "Thread-1");

        Thread thread2 = new Thread(() -> {
            synchronized (lockB) {
                System.out.println("Поток 2: захватил lockB");
                sleep(100);
                System.out.println("Поток 2: пытаюсь захватить lockA...");
                synchronized (lockA) {
                    System.out.println("Поток 2: захватил lockA");
                }
            }
        }, "Thread-2");

        thread1.start();
        thread2.start();
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
