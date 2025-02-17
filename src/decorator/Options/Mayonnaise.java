package decorator.Options;
import decorator.*;


public class Mayonnaise extends OrderDecorator{
    public Mayonnaise(Order order) {
        super(order);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Mayonnaise";
    }

    @Override
    public double getCost() {
        return super.getCost() + 5;
    }
}
