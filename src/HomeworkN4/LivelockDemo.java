package HomeworkN4;

public class LivelockDemo {

    private static volatile boolean person1OnLeft = true;
    private static volatile boolean person2OnLeft = true;

    public static void main(String[] args) {
        Thread person1 = new Thread(() -> {
            while (person1OnLeft == person2OnLeft) {
                System.out.println("Человек 1: уступаю дорогу и меняю сторону");
                person1OnLeft = !person1OnLeft;
                sleep(200);
            }
            System.out.println("Человек 1: прошёл!");
        }, "Person-1");

        Thread person2 = new Thread(() -> {
            while (person2OnLeft == person1OnLeft) {
                System.out.println("Человек 2: уступаю дорогу и меняю сторону");
                person2OnLeft = !person2OnLeft;
                sleep(200);
            }
            System.out.println("Человек 2: прошёл!");
        }, "Person-2");

        person1.start();
        person2.start();
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
