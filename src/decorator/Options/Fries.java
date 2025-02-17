package decorator.Options;
import decorator.*;


public class Fries extends OrderDecorator{
    public Fries(Order order) {
        super(order);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "Fries";
    }

    @Override
    public double getCost() {
        return super.getCost() + 20;
    }
}
