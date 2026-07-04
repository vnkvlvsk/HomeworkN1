package HomeworkN3.decorator;

public class PepperoniTopping extends ToppingDecorator {
    public PepperoniTopping(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", пепперони";
    }

    @Override
    public double getPrice() {
        return pizza.getPrice() + 200;
    }
}
