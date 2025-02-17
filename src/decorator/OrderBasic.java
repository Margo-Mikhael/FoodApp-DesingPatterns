package decorator;
public class OrderBasic implements Order{

    @Override
    public double getCost() {
        return 0;
    }

    @Override
    public String getDescription() {
        return "";
    }
}
