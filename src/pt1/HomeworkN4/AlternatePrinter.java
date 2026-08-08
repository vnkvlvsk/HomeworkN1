package pt1.HomeworkN4;

public class AlternatePrinter {

    private final Object lock = new Object();
    private boolean turnForFirst = true;

    public static void main(String[] args) {
        AlternatePrinter printer = new AlternatePrinter();

        Thread first = new Thread(() -> printer.print(true, "1"), "Thread-1");
        Thread second = new Thread(() -> printer.print(false, "2"), "Thread-2");

        first.start();
        second.start();
    }

    private void print(boolean isFirst, String value) {
        while (true) {
            synchronized (lock) {
                while (turnForFirst != isFirst) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
                System.out.println(value);
                turnForFirst = !turnForFirst;
                lock.notifyAll();
            }
        }
    }
}
