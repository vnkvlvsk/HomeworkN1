package pt1.HomeworkN3.chain;

public class SeniorSupport extends SupportHandler {
    public static final int SUPPORT_LEVEL = 2;

    @Override
    public void handle(int level) {
        if (level == SUPPORT_LEVEL) {
            System.out.println("Сеньор решил проблему уровня " + level);
        } else if (next != null) {
            System.out.println("Сеньор передаёт проблему уровня " + level + " дальше");
            next.handle(level);
        }
    }
}
