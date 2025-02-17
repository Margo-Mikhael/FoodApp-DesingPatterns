package decorator.Options;
import decorator.Order;
import decorator.OrderDecorator;
public class  Olives extends OrderDecorator{
	public Olives (Order order) {
        super(order);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ",  Olives";
    }

    @Override
    public double getCost() {
        return super.getCost() + 5;
    }
}
