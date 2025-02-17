package decorator.Options;

import decorator.*;

public class BBQ extends OrderDecorator {

    public BBQ(Order order) {
        super(order);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", BBQ";
    }

    @Override
    public double getCost() {
        return super.getCost() + 5;
    }
}