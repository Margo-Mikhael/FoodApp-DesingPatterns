package decorator.Options;

import decorator.Order;
import decorator.OrderDecorator;
public class Sausages extends OrderDecorator {
	public Sausages(Order order) {
        super(order);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Sausages";
    }

    @Override
    public double getCost() {
        return super.getCost() + 20;
    }
}


