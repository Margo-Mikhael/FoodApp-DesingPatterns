package decorator.Options;
import decorator.*;

public class Pickle extends OrderDecorator{
    public Pickle(Order order) {
        super(order);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Pickle";
    }

    @Override
    public double getCost() {
        return super.getCost() + 5;
    }
}
