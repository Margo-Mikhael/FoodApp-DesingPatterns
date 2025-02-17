import iterator_.*;
import iterator_.Iterator;
import javafx.scene.control.SingleSelectionModel;

import java.io.IOException;
import java.lang.annotation.ElementType;
import java.lang.reflect.Array;
import java.sql.Time;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import command.*;
import decorator.*;
import decorator.Options.BBQ;
import decorator.Options.Burger;
import decorator.Options.Cheese;
import decorator.Options.Chicken;
import decorator.Options.Fries;
import decorator.Options.Katshup;
import decorator.Options.Mashroom;
import decorator.Options.Mayonnaise;
import decorator.Options.Olives;
import decorator.Options.Onion;
import decorator.Options.Papper;
import decorator.Options.Pepproni;
import decorator.Options.Pickle;
import decorator.Options.Pizza;
import decorator.Options.Ranch;
import decorator.Options.Sausages;
import decorator.Options.Tomato;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class App {
    static Object show_orders(List<Order> orders) throws InterruptedException {
        if (orders.size() > 0) {
            double Total_Cost = 0;
            for (Order order : orders) {
                if (order != null) {
                    System.out.println("Order With toppings:\n" + order.getDescription() + "\nCost:" + order.getCost()
                            + "\n#########################");
                    Total_Cost += order.getCost();
                }
            }
            System.out.println(
                    "\n#########################\nTotal_Cost_Order:" + Total_Cost + "\n#########################");

            System.out.println("Do you want place the order?\n1-yes\n2-no\n3-Back To Menu\n");
            Scanner choice_Scanner = new Scanner(System.in);
            String choice = choice_Scanner.nextLine();
            switch (choice) {
                case "1":
                    if (!Pay())
                        break;
                    Chef chef = new Chef();
                    Order_ order_;
                    for (Order order : orders) {
                        order_ = new Order_(chef, order.getDescription().split(",")[0]);
                        Waiter waiter = new Waiter(order_);
                        waiter.execute();
                    }
                    System.out.println("Do you want Cancle the order?\ny/N\n");
                    choice_Scanner = new Scanner(System.in);
                    choice = choice_Scanner.nextLine();
                    switch (choice) {
                        case "n":
                            java.util.Date date = new java.util.Date();
                            System.out.println("Food Delivery Status: Dispatched Date Time:" + date);
                            TimeUnit.SECONDS.sleep(1);
                            System.out.println("Food Delivery Status: On the way.:" + date);
                            TimeUnit.SECONDS.sleep(1);
                            System.out.println("Food Delivery Status: Near to your home.:" + date);
                            TimeUnit.SECONDS.sleep(1);
                            System.out.println("Food Delivery Status: Delivered.:" + date);
                            TimeUnit.SECONDS.sleep(2);
                            System.out.println("Thank you for visiting Us.");
                            TimeUnit.SECONDS.sleep(3);

                            return orders.removeAll(orders);

                        case "y":
                            date = new java.util.Date();
                            TimeUnit.SECONDS.sleep(1);
                            System.out.println("Your order is cancelled" + date);
                            TimeUnit.SECONDS.sleep(2);

                            break;
                    }
                case "2":
                    return orders.removeAll(orders);
                case "3":
                    return orders;

            }
            return orders.removeAll(orders);
        } else {
            System.out.println("No orders Found.");
            TimeUnit.SECONDS.sleep(1);
            return orders;
        }
    }

    static Boolean Pay() throws InterruptedException {
        System.out.println("Visa/Cash?\n1-Visa\n2-Cash\n");
        Scanner choice_Scanner = new Scanner(System.in);
        String choice = choice_Scanner.nextLine();
        switch (choice) {
            case "1":
                System.out.println("Please Enter Your pinCode {4 Digits}\n");
                Scanner pincode_scanner = new Scanner(System.in);
                String pin_code = pincode_scanner.nextLine();
                System.out.println("\nWait...Checking on your card...\n");
                TimeUnit.SECONDS.sleep(2);

                if (pin_code.length() == 4) {
                    System.out.println("\nThank you.");
                    return true;
                }
                return false;
            case "2":
                return true;
            default:
                return false;
        }
    }

    static Order BurgerToppings(Order order) throws Exception {
        System.out.println(
                "Choose your Toppings in Burger" +
                        "\n1-Katshup= " + get_ToppingPrice("Burger", "Katchup") + "$" +
                        "\n2-Onion= " + get_ToppingPrice("Burger", "Onion") + "$" +
                        "\n3-Pickle= " + get_ToppingPrice("Burger", "Pickle") + "$" +
                        "\n4-Tomato= " + get_ToppingPrice("Burger", "Tomato") + "$" +
                        "\n5-Mayonnaise= " + get_ToppingPrice("Burger", "Mayonnaise") + "$" +
                        "\n6-Cheese= " + get_ToppingPrice("Burger", "Cheese") + "$" +
                        "\n0-Back To menu");
        System.out.println("Your Order Description: " + order.getDescription());
        Scanner choice_Scanner = new Scanner(System.in);
        String choice = choice_Scanner.nextLine();
        switch (choice) {
            case "1":
                order = new Katshup(order);
                break;
            case "2":
                order = new Onion(order);
                break;
            case "3":
                order = new Pickle(order);
                break;
            case "4":
                order = new Tomato(order);
                break;
            case "5":
                order = new Mayonnaise(order);
                break;
            case "6":
                order = new Cheese(order);
                break;
            default:
                return order;
        }
        return BurgerToppings(order);
    }

    static Order PizzaToppings(Order order) throws Exception {
        System.out.println(
                "Choose your Toppings in Pizza" +
                        "\n1-Pepproni= " + get_ToppingPrice("Pizza", "Pepproni") + "$" +
                        "\n2-Sausages= " + get_ToppingPrice("Pizza", "Sausages") + "$" +
                        "\n3-Ranch= " + get_ToppingPrice("Pizza", "Ranch") + "$" +
                        "\n4-Chicken= " + get_ToppingPrice("Pizza", "Chicken") + "$" +
                        "\n5-Cheese= " + get_ToppingPrice("Pizza", "Cheese") + "$" +
                        "\n6-Mashroom= " + get_ToppingPrice("Pizza", "Mashroom") + "$" +
                        "\n7-Papper= " + get_ToppingPrice("Pizza", "Papper") + "$" +
                        "\n8-Olives= " + get_ToppingPrice("Pizza", "Olives") + "$" +
                        "\n0-Back To menu");
        System.out.println(order.getDescription());
        Scanner choice_Scanner = new Scanner(System.in);
        String choice = choice_Scanner.nextLine();
        switch (choice) {
            case "1":
                order = new Pepproni(order);
                break;
            case "2":
                order = new Sausages(order);
                break;
            case "3":
                order = new Ranch(order);
                break;
            case "4":
                order = new Chicken(order);
                break;
            case "5":
                order = new Cheese(order);
                break;
            case "6":
                order = new Mashroom(order);
                break;
            case "7":
                order = new Papper(order);
                break;
            case "8":
                order = new Olives(order);
                break;
            default:
                return order;
        }
        return PizzaToppings(order);
    }

    static Order FriesToppings(Order order) throws Exception {
        System.out.println(
                "Choose your Toppings in Burger" +
                        "\n1-Katshup= " + get_ToppingPrice("Fries", "Katchup") + "$" +
                        "\n2-Mayonnaise= " + get_ToppingPrice("Fries", "Mayonnaise") + "$" +
                        "\n3-BBQ= " + get_ToppingPrice("Fries", "BBQ") + "$" +
                        "\n4-Cheese= " + get_ToppingPrice("Fries", "Cheese") + "$" +
                        "\n0-Back To menu");
        System.out.println(order.getDescription());
        Scanner choice_Scanner = new Scanner(System.in);
        String choice = choice_Scanner.nextLine();
        switch (choice) {
            case "1":
                order = new Katshup(order);
                break;
            case "2":
                order = new Mayonnaise(order);
                break;
            case "3":
                order = new BBQ(order);
                break;
            case "4":
                order = new Cheese(order);
                break;

            default:
                return order;
        }
        return FriesToppings(order);
    }

    static double get_ToppingPrice(String food_name, String topping_name) throws Exception {
        return namesRepository.FoodsList.get(food_name).get(topping_name);
    }

    static Menu namesRepository = new Menu();

    static Order print_Menu(Order order) throws Exception {
        System.out.print("\033[H\033[2J");// clear cmd
        System.out.flush();// clear cmd

        System.out.print("The menu\n");
        Order not_order = new OrderBasic();// see menu prices only
        HashMap<String, Callable<Double>> food_price = new HashMap<String, Callable<Double>>() {
            {
                put("Burger", () -> {
                    return new Burger(not_order).getCost();
                });
                put("Pizza", () -> {
                    return new Pizza(not_order).getCost();
                });
                put("Fries", () -> {
                    return new Fries(not_order).getCost();
                });

            }
        };

        for (Iterator iter = namesRepository.getIterator(); iter.hasNext();) {
            String food_name = (String) iter.next();
            System.out.println(food_name);
            System.out.println("Name : \n" + food_name + "= " + food_price.get(food_name).call() + "$" + "\nToppings:");
            for (Map.Entry<String, Double> food_toppings : namesRepository.FoodsList.get(food_name).entrySet()) {
                System.out.println(food_toppings.getKey().toString() + "= "
                        + get_ToppingPrice(food_name, food_toppings.getKey()) + "$");
            }
            System.out.println("\n++++++++++++++++++++++++++++\n");
        }
        System.out.println("Choose your food\n1-Burger\n2-Pizza\n3-Fries\n0-Back");
        Scanner choice_Scanner = new Scanner(System.in);
        String choice = choice_Scanner.nextLine();

        switch (choice) {
            case "1":
                order = new Burger(order);
                order = BurgerToppings(order);
                break;
            case "2":
                order = new Pizza(order);
                order = PizzaToppings(order);
                break;
            case "3":
                order = new Fries(order);
                order = FriesToppings(order);
                break;

        }
        return order;
    }

    public static void main(String[] args) throws Exception {

        boolean still_order = true;
        List<Order> orders = new ArrayList<Order>();
        while (still_order) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("Welcome To **** Cafe\n1-Show menu\n2-Show Orders\n3-Exit");
            Scanner choice_Scanner = new Scanner(System.in);
            String choice = choice_Scanner.nextLine();
            Order neworder = new OrderBasic();

            switch (choice) {
                case "1":
                    neworder = print_Menu(neworder);
                    if (neworder.getCost() != 0.0)
                        orders.add(neworder);
                    break;
                case "2":
                    show_orders(orders);
                    break;
                case "3":
                    System.out.println("Thank you for visiting Us.");
                    TimeUnit.SECONDS.sleep(3);

                    return;

            }

        }

    }
}
