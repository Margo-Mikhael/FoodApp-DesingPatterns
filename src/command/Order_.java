package command;

public class Order_ implements Command {  
    private Chef chef;
    private String food;  
    public Order_(Chef chef, String food) {
      this.chef = chef;
      this.food = food;
    }  
    @Override
    public void execute() {
      if (this.food.equals("Burger")) {
        this.chef.cookBurger();
      
      } else if (this.food.equals("Pizza")) {
        this.chef.cookPizza();
      }
      else{
        this.chef.cookFries();

      }
    }
  }