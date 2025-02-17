package decorator.Options;
import decorator.*;
public class Chicken extends OrderDecorator{
	public Chicken(Order order) {
        super(order);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Chicken";
    }

    @Override
    public double getCost() {
        return super.getCost() + 15;
    }
}




