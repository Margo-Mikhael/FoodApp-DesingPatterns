package decorator.Options;
import decorator.Order;
import decorator.OrderDecorator;


public class  Mashroom extends OrderDecorator{
	public  Mashroom(Order order) {
        super(order);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ",  Mashroom";
    }

    @Override
    public double getCost() {
        return super.getCost() + 5;
    }
}

