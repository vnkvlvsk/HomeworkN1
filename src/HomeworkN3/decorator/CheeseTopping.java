package HomeworkN3.decorator;

public class CheeseTopping extends ToppingDecorator {
    public CheeseTopping(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", сыр";
    }

    @Override
    public double getPrice() {
        return pizza.getPrice() + 100;
    }
}
