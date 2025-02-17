package decorator.Options;
import decorator.Order;
import decorator.OrderDecorator;
public class Cheese extends OrderDecorator{
	public Cheese(Order order) {
        super(order);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Cheese";
    }

    @Override
    public double getCost() {
        return super.getCost() + 10;
    }
}

