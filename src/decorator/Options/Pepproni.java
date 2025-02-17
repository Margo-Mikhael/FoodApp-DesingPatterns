package decorator.Options;
import decorator.Order;
import decorator.OrderDecorator;
public class Pepproni extends OrderDecorator{
	public Pepproni(Order order) {
        super(order);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Pepproni";
    }

    @Override
    public double getCost() {
        return super.getCost() + 20;
    }
}





