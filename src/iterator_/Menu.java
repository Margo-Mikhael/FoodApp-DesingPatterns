package iterator_;

import java.util.*;

public class Menu implements Container {
   
    public Map<String, Map<String, Double>> FoodsList;
    
   @Override
   public Iterator getIterator() {
     FoodsList = new HashMap<String,  Map<String,Double>>() {{
         put("Burger", new HashMap<String,  Double>() {{
            put("Cheese",10.0);
            put("Tomato",5.0);
            put("Onion",5.0);
            put("Katchup",5.0);
            put("Pickle",5.0);
            put("Mayonnaise",5.0);
         }});
         put("Pizza", new HashMap<String,  Double>() {{
            put("Katshup",5.0);
            put("Mashroom",5.0);
            put("Papper",5.0);
            put("Ranch",5.0);
            put("Olives",5.0);
            put("Cheese",10.0);
            put("Chicken",15.0);
            put("Pepproni",20.0);
            put("Sausages",20.0);
            
         }});
         put("Fries", new HashMap<String,  Double>() {{
            put("Cheese",10.0);
            put("Katchup",5.0);
            put("Mayonnaise",5.0);
            put("BBQ",5.0);
         }});
     }};
      return new NameIterator();
   }

   private class NameIterator implements Iterator {
      
      int index;

      @Override
      public boolean hasNext() {
      
         if(index < FoodsList.size()){
            return true;
         }
         return false;
      }

      @Override
      public Object next() {
         
         if(this.hasNext()){
            return FoodsList.keySet().toArray()[index++];
         }
         return null;
      }		
   }
}