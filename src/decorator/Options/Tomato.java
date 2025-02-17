package decorator.Options;
import decorator.*;


public class Tomato extends OrderDecorator{
    public Tomato(Order order) {
        super(order);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Tomato";
    }

    @Override
    public double getCost() {
        return super.getCost() + 5;
    }
}
