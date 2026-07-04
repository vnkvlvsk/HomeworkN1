package HomeworkN3.decorator;

public class MushroomTopping extends ToppingDecorator {
    public MushroomTopping(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", грибы";
    }

    @Override
    public double getPrice() {
        return pizza.getPrice() + 150;
    }
}
