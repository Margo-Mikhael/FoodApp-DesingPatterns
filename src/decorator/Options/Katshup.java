package decorator.Options;
import decorator.*;


public class Katshup extends OrderDecorator {
    public Katshup(Order order) {
        super(order);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Katshup";
    }

    @Override
    public double getCost() {
        return super.getCost() + 5;
    }
}
