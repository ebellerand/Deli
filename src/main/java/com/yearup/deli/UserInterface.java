package com.yearup.deli;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    private List<Product> productList = new ArrayList<>();
    Order order = new Order();


    public void homeScreen() {
        System.out.println("Welcome to Delicious Sandwiches, where customizability is key and the customer is king.");
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("Please enter 1 for new order or 0 to exit: ");
        int command = scanner.nextInt();
        scanner.nextLine();

        switch (command) {
            case 0:
                return;

            case 1:
                Order order = new Order();
                orderScreen();
                break;

            default:
                System.out.println("Invalid selection. ");
                homeScreen();
                break;
        }
    }

    public void start() {
        boolean running = true;

        while (running) {
            try {
                homeScreen();

                //implementation for new order


                System.out.println("Would you like to place another order? Y/N: ");
                String command = scanner.nextLine();

                if (command.equalsIgnoreCase("n")) {
                    running = false;

                }
            } catch (Exception e) {
                System.out.println("There was an error running the application. ");
            }
        }
        stop();
    } public void stop(){
        scanner.close();
    }

    public void orderScreen(){
        System.out.println("1) Add Sandwich. 2) Add Drink. 3) Add Chips. 4) Checkout. 0) Cancel Order.");
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("Please enter your selection: ");
        int command = scanner.nextInt();


        switch (command) {
            case 1:
                addSandwich();
                break;

            case 2:
                addDrink();
                break;

            case 3:
                addChips();
                break;

            case 4:
                checkout();
                break;
            case 0:
                deleteOrder();
                return;
            default:
                throw new IllegalStateException("Unexpected value: " + command);
        }
    }

    public void addSandwich() {
        scanner.nextLine();
        System.out.println("Select your bread. White, wheat, rye or wrap: ");
        String breadType = scanner.nextLine();
        scanner.nextLine();
        System.out.println("-----------------------------------------------");
        System.out.println("Select your sandwich size, 4,8 or 12: ");
        int size = scanner.nextInt();
        scanner.nextLine();
        Sandwich sandwich = new Sandwich("Sandwich", size, breadType ,false);
        sandwich.sandwichSize = size;


        List<Meat> meatToppings = new ArrayList<>();

        while (true) {
            System.out.println("Please select your meat. The options are steak, ham, salami, roast beef, chicken, and bacon (or type 'done' to finish adding meat): ");
            String meatString = scanner.nextLine();

            if (meatString.equalsIgnoreCase("done")) {
                break;
            }

            Meat meat = new Meat(meatString, size, sandwich);
            sandwich.addTopping(meat);
            meatToppings.add(meat);

            System.out.println("Would you like extra meat? Y/N: ");
            String extraMeatChoice = scanner.nextLine();

            if (extraMeatChoice.equalsIgnoreCase("N")) {
                meat.setExtra(false);
                break;
            } else if (extraMeatChoice.equalsIgnoreCase("Y")) {
                meat.setExtra(true);
            } else {
                System.out.println("Invalid input. Please try again.");
            }
        }
        System.out.println("Please select your cheese. The options are American, provolone, cheddar, and Swiss:  ");
        String cheeseString = scanner.nextLine();
        Cheese cheese = new Cheese(cheeseString, size, sandwich);
        sandwich.addTopping(cheese);
        System.out.println("Would you like extra cheese? Y/N: ");
        String extraCheeseChoice = scanner.nextLine();

        if (extraCheeseChoice.equalsIgnoreCase("Y")) {
            cheese.setExtra(true);
        } else {
            cheese.setExtra(false);
        }

        System.out.println("Select your Regular toppings. The options are lettuce, peppers, onions, tomatoes, jalapenos, cucumbers, pickles, guacamole, mushrooms. ");
        System.out.println("Please enter your selection with commas in between Regular Toppings: ");
        String regularToppingsInput = scanner.nextLine();
        List<Topping> regularToppingsList = new ArrayList<>();
        String[] regularToppingsArray = regularToppingsInput.split(",");

        for (String topping : regularToppingsArray) {

            Topping toppingObject = new Regular(topping.trim(), size, sandwich);
            regularToppingsList.add(toppingObject);
        }
        System.out.println("Select your sauces. The options are mayo, mustard, ketchup,ranch, thousand island, vinaigrette");
        System.out.println("Please enter your selection with commas in between sauces: ");
        String sauceInput = scanner.nextLine();
        String[] sauceArray = sauceInput.split(",");

        for (String sauce : sauceArray) {
            Topping sauceObject = new Regular(sauce.trim() + " sauce", size, sandwich);
            regularToppingsList.add(sauceObject);
        }

        // Add regular toppings and sauces to the sandwich
        for (Topping topping : regularToppingsList) {
            sandwich.addTopping(topping);
        }

        System.out.println("The price of your sandwich is $" + sandwich.getPrice());
        System.out.println("Sandwich has been added to your order. ");

        //Order order = new Order();
        order.addProduct(sandwich);
        order.getTotal();


        productList.add(sandwich);
        orderScreen();


    }
    public void addChips(){
        System.out.println("What type of chips would you like? ");
        scanner.nextLine();
        String type = scanner.nextLine();
        Chips chips = new Chips(type);

        double chipsTotal = chips.getPrice();
        System.out.println("Chips added to your order. \n" + chipsTotal + " Extra added to your order.");

        productList.add(chips);
        order.addProduct(chips);
        orderScreen();

    }

    public void addDrink(){
        scanner.nextLine();
        System.out.println("What type of drink would you like? ");
        String type = scanner.nextLine();
        scanner.nextLine();
        System.out.println("What size drink would you like?");
        String size = scanner.nextLine();
        Drink drink = new Drink(type, size);
        productList.add(drink);

        System.out.println(type + " has been added to your order for an extra $" + drink.getSizePrice(size));
        order.addProduct(drink);
        orderScreen();
    }
public void checkout() {
    if (productList.isEmpty()) {
        System.out.println("Your order is empty.");
        orderScreen();
        return;
    }
    System.out.println("Order Summary:");
    for (Product product : productList) {
       /* if (product instanceof Drink) {
            System.out.println(product.getType() + "; $ " + ((Drink) product).getSizePrice(((Drink) product).getSize()));
        } */
        System.out.println("- " + product.getClass().getSimpleName() + " " + product.getType()+ ": $" + product.getPrice());
    }
    double total = order.getTotal();
    System.out.println("Total: $" + total);
    System.out.println("Would you like to confirm your order? Y to confirm, N to delete the order and return to the main menu: ");
    String command = scanner.nextLine();
    scanner.nextLine();
    if (command.equalsIgnoreCase("y")) {
        System.out.println("Order confirmed. Thank you for your purchase!");
        ReceiptFileManager receiptFileManager = new ReceiptFileManager();
        String folderPath = System.getProperty("user.home") + "\\Desktop\\Receipts";
        receiptFileManager.writeReceipt(folderPath, order);
        // Perform additional actions as needed (e.g., saving the order to a database)
        productList.clear(); // Clear the product list after checkout
    } else if (command.equalsIgnoreCase("n")) {
        deleteOrder();

    } else {
        System.out.println("Invalid selection.");
        checkout();
    }
}








    /*System.out.println(order.getProducts());
    System.out.println(order.getTotal());
    System.out.println("Would you like to confirm your order? Y to confirm, N to delete order and return to the main menu: ");
    String command = scanner.nextLine();
    scanner.next();
    if (command.equalsIgnoreCase("y")) {
       // saveReceiptFile();
    }
    if (command.equalsIgnoreCase("n")) {
        order.getProducts().clear();
        productList.clear();
        deleteOrder(); }*/

public void deleteOrder(){

        productList.clear();

        order.getProducts().clear();// Reset the order object
        System.out.println("Your order has been deleted.");

        //order.getProducts().clear();
      //  order.setProducts();
        //productList = new ArrayList<>();
    //System.out.println("Your order has been deleted. ");
}


}
