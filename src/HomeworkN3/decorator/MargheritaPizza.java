package HomeworkN3.decorator;

public class MargheritaPizza implements Pizza {
    @Override
    public String getDescription() {
        return "Маргарита";
    }

    @Override
    public double getPrice() {
        return 500;
    }
}
