package command;

public class Waiter {  
    private Order_ order; 
   
    public Waiter(Order_ ord) {
      this.order = ord;
    }  public void execute() {
      this.order.execute();
    }
  }