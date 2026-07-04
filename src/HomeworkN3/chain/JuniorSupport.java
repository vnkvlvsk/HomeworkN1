package HomeworkN3.chain;

public class JuniorSupport extends SupportHandler {
    public static final int SUPPORT_LEVEL = 1;

    @Override
    public void handle(int level) {
        if (level == SUPPORT_LEVEL) {
            System.out.println("Джуниор решил проблему уровня " + level);
        } else if (next != null) {
            System.out.println("Джуниор передаёт проблему уровня " + level + " дальше");
            next.handle(level);
        }
    }
}
