/**
 * The following class is the driver class, which is responsible for the execution of the program. This class implements
 * the Order interface, as seen below. It is here that the user can input their order (and relevant details), print any
 * orders in the system, deliver any orders, or exit the system. This class consists of one field, a default and
 * non-default constructor, three implemented (overridden) methods from the Order interface and the main method for the
 * program's execution. Any getters, setters or a toString method are not necessary as this is the driver class.
 * @author MAPC
 * @version 1.0.0
 */

// Arraylist and Scanner imports.
import java.util.ArrayList;
import java.util.Scanner;

public class RestaurantDriver implements Order
{
    private ArrayList<CustomerOrder> orders;   // Arraylist of type CustomerOrder defined as "orders", stores orders.

    /**
     * Default constructor.
     */
    public RestaurantDriver()
    {
        this.orders = new ArrayList<>();
    }

    /**
     * Non-default constructor.
     * @param orders arraylist of type CustomerOrder, called orders.
     */
    public RestaurantDriver(ArrayList<CustomerOrder> orders)
    {
        this.orders = orders;
    }

    /**
     * The following method is responsible for adding a customer's order to the system. The customer must input their
     * name, address and phone number, before being able to add items (pizzas and pastas) of their choice to their
     * order. They then have the option to keep inputting items or return to the main menu.
     */
    @Override
    public void addOrder()
    {
        System.out.println("\nPlease Enter Customer Details:");
        System.out.println("==============================\n");

        Scanner scanner = new Scanner(System.in);
        ArrayList<FoodItem> items = new ArrayList<>();   // Initialise the "items" arraylist as a new empty arraylist.
        String customerName;
        String customerAddress;
        String customerPhoneNumber;

        System.out.println("Enter customer name:");
        customerName = scanner.nextLine();
        while(customerName.isEmpty())   // Input validation, this input cannot be blank (same logic repeated below 2x).
        {
            System.out.println("Invalid input. This field cannot be blank, you must enter your name:");
            customerName = scanner.nextLine();   // Ask and take user input again (same logic repeated below 2x).
        }

        System.out.println("\nEnter customer address:");
        customerAddress = scanner.nextLine();
        while(customerAddress.isEmpty())
        {
            System.out.println("Invalid input. This field cannot be blank, you must enter your address:");
            customerAddress = scanner.nextLine();
        }

        System.out.println("\nEnter customer phone number:");
        customerPhoneNumber = scanner.nextLine();
        while(customerPhoneNumber.isEmpty())
        {
            System.out.println("Invalid input. This field cannot be blank, you must enter your phone number:");
            customerPhoneNumber = scanner.nextLine();
        }

        System.out.println("\nAdding items to " + customerName + "'s order!");

        while(true)   // Keep asking the user for input.
        {
            System.out.println("\nPlease select an option:");
            System.out.println("========================");
            System.out.println("\t1. Add a Pizza to the Order");
            System.out.println("\t2. Add a Pasta to the Order");
            System.out.println("\t3. Back to the Main Menu");
            System.out.println("Please enter your choice: (1-3)");

            int customerAnswer = scanner.nextInt();
            scanner.nextLine();   // Clears input buffer.

            if(customerAnswer == 1)
            {
                // Call "addPizzaToppings" of the Pizza class. Returned arraylist of pizza toppings now stored
                // in "pizzaToppings" variable.
                ArrayList<Pizza.pizzaToppings> pizzaToppings = Pizza.addPizzaToppings();
                // Create new pizza object called "Pizza", with the chosen pizzaToppings.
                // Pizza object can be stored in a FoodItem variable as Pizza is a subclass of FoodItem.
                FoodItem item = new Pizza("Pizza", pizzaToppings);
                // Add created pizzas to the "items" arraylist.
                items.add(item);
            }

            else if(customerAnswer == 2)
            {
                // Same logic/ implementation as above, but with different names (calling upon the Pasta class instead).
                ArrayList<Pasta.pastaToppings> pastaToppings = Pasta.addPastaToppings();
                FoodItem item = new Pasta("Pasta", pastaToppings);
                items.add(item);
            }

            else if(customerAnswer == 3)   // Break out of the while true loop, return to the previous main menu.
            {
                System.out.println("\nYou have selected to go back to the Main Menu.\nTaking you there now!");
                break;
            }

            else   // Input validation, must enter numbers 1,2 or 3.
            {
                System.out.println("\nInvalid input. Please try again and enter your choice of options (1-3).");
            }
        }

        // New instance of CustomerOrder class, "order" created with its non-default constructor, The customers added
        // items (pizzas/ pastas), name, address and phone number are parsed. The customerPhoneNumber is converted
        // to an integer as it is declared as type int in the CustomerOrder class.
        CustomerOrder order = new CustomerOrder(items, customerName, customerAddress,
                Integer.parseInt(customerPhoneNumber));
        orders.add(order);   // Add the new instance to the "orders" arraylist. All inputted orders are stored as such.
    }

    /**
     * The following method is responsible for delivering (removing) the oldest placed customer order from the system
     * (orders arraylist).
     */
    @Override
    public void deliverOrder()
    {
        System.out.println("\nYou have selected to deliver an order!");
        System.out.println("======================================");

        if(!orders.isEmpty())   // If the orders arraylist is not empty.
        {
            CustomerOrder order = orders.remove(0);   // The first index will always contain the oldest order.

            System.out.println("\nDelivering " + order.getCustomerName()   // Print customer details of removed order.
                    + "'s " + "order to " + order.getCustomerAddress() + "!");
            System.out.println("\nOrder Details:");
            System.out.println("=====================================================");

            order.deliveryDetails();   // Call deliveryDetails method of CustomerOrder to print further information.

            System.out.println("There are now " + orders.size() + " order(s) pending delivery.");
        }

        else   // There are no orders to be delivered.
        {
            System.out.println("There are currently no outgoing orders to be delivered!");
            System.out.println("Taking you back to the Main Menu!");
        }
    }

    /**
     * The following method is responsible for print all existing customer orders in the system.
     */
    @Override
    public void printOrders()
    {
        System.out.println("\nYou have selected to display all orders in the system.");

        for(int i = 0; i < orders.size(); i++)   // Traverse the orders arraylist until the size of it has been reached.
        {
            CustomerOrder order = orders.get(i);   // Get each iteration instance.

            System.out.println("\nOrder Details:");
            System.out.println("=====================================================");
            System.out.println("Order " + (i + 1) + ".");

            order.deliveryDetails();   // Call deliveryDetails method of CustomerOrder to print further information.

            System.out.println("All the orders in the system have been printed!");
            System.out.println("Taking you back to the Main Menu!");
        }

        if(orders.size() == 0)   // There are no orders in the system, thus nothing to print.
        {
            System.out.println("\nThere are currently no orders in the system!");
            System.out.println("Taking you back to the Main Menu!");
        }
    }

    /**
     * This is the main method, which executes the program. Below, user can input their choice of what to do at first
     * when using the system.
     */
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        // Create a new instance of the RestaurantDriver class, "restaurant"
        RestaurantDriver restaurant = new RestaurantDriver();

        while(true)   // Keep asking the user for input.
        {
            System.out.println("\nWelcome to the Take-Away Management Portal!");
            System.out.println("===========================================");
            System.out.println("\nPlease select an option:");
            System.out.println("\t1. Enter Order Details");
            System.out.println("\t2. Deliver an Order");
            System.out.println("\t3. Display All Items and Customer Details in the Order");
            System.out.println("\t4. Exit");
            System.out.println("Please enter your choice: (1-4)");

            int userInput = scanner.nextInt();

            if(userInput == 1)
            {
                // Invoke the method that allows users to add their order to the system on the restaurant instance.
                restaurant.addOrder();
            }

            else if(userInput == 2)
            {
                // Invoke the method that delivers current orders in the system (starting from the oldest) on the
                // restaurant instance.
                restaurant.deliverOrder();
            }

            else if(userInput == 3)
            {
                // Invoke the method that prints all current orders in the system on the restaurant instance.
                restaurant.printOrders();
            }

            else if(userInput == 4)
            {
                System.out.println("\nShutting down the system. Goodbye!");
                break;   // Break out of the loop and end the program.
            }

            else   // Input validation, must enter numbers 1,2,3 or 4.
            {
                System.out.println("\nInvalid input. Please try again and enter your choice of options (1-4).");
            }
        }
    }

}