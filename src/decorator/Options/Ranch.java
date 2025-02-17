package decorator.Options;

import decorator.*;

public class Ranch extends OrderDecorator {

    public Ranch(Order order) {
        super(order);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Ranch";
    }

    @Override
    public double getCost() {
        return super.getCost() + 5;
    }
}