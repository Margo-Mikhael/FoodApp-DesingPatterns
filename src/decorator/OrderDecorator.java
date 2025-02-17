package decorator;
public abstract class OrderDecorator implements Order {

    private Order food;

    public OrderDecorator(Order food) {
        this.food = food;
    }

    @Override
    public String getDescription() {
        return this.food.getDescription();
    }

    @Override
    public double getCost() {
        return this.food.getCost();
    }
}
