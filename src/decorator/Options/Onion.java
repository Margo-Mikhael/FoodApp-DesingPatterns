package decorator.Options;
import decorator.*;

public class Onion extends OrderDecorator{
    public Onion(Order order) {
        super(order);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Onion";
    }

    @Override
    public double getCost() {
        return super.getCost() + 5;
    }
}
