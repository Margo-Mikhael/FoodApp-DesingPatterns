package decorator.Options;
import decorator.Order;
import decorator.OrderDecorator;
public class  Papper extends OrderDecorator{
	public  Papper (Order order) {
        super(order);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ",  Papper";
    }

    @Override
    public double getCost() {
        return super.getCost() + 5;
    }
}
