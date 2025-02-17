package decorator.Options;
import decorator.*;


public class Burger extends OrderDecorator{
    public Burger(Order order) {
        super(order);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "Burger";
    }

    @Override
    public double getCost() {
        return super.getCost() + 40;
    }
}
