package decorator.Options;
import decorator.*;


public class Pizza extends OrderDecorator{
    public Pizza(Order order) {
        super(order);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "Pizza";
    }

    @Override
    public double getCost() {
        return super.getCost() + 50;
    }
}
