/**
 * The following class is responsible for handling everything related to a customer's order information. It consists of
 * four fields, a default and non-default constructor, two methods and four getter and setter methods. No toString is
 * needed here.
 * @author Michael Anthony Patrick Cetrola
 * @version 1.0.0
 */

// Arraylist import.
import java.util.ArrayList;

public class CustomerOrder
{
    private ArrayList<FoodItem> items;   // Define an arraylist of type FoodItem called "items".
    private String customerName;
    private String customerAddress;
    private int customerPhoneNumber;

    /**
     * Default constructor.
     */
    public CustomerOrder()
    {
        items = new ArrayList<>();
        customerName = "";
        customerAddress = "";
        customerPhoneNumber = 0;
    }

    /**
     * Non-default constructor.
     * @param items arraylist of type FoodItem, called items.
     * @param customerName a customer's name.
     * @param customerAddress a customer's address.
     * @param customerPhoneNumber a customer's phone number.
     */
    public CustomerOrder(ArrayList<FoodItem> items, String customerName, String customerAddress, int customerPhoneNumber)
    {
        this.items = items;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerPhoneNumber = customerPhoneNumber;
    }

    /**
     * The following method is responsible for printing out the customer's name, address and phone number. As well as
     * this, the overall price of an order is determined and the meal type (which is determined via calling the
     * determineOverallMealType method).
     */
    public void deliveryDetails()
    {
        System.out.println("\nCustomer Information:");   // Print the relevant customer details.
        System.out.println("-----------------------------------------------------");
        System.out.println("\tCustomer Name: " + getCustomerName() + ".");
        System.out.println("\tCustomer Address: " + getCustomerAddress() + ".");
        System.out.println("\tCustomer Phone Number: " + getCustomerPhoneNumber() + ".");

        double overallOrderPrice = 0.0;
        String overallMealType = determineOverallMealType();   // Call this method to determine the overall meal type.

        for(FoodItem item : items)   // Loop through the "items" array with the "item" iterator.
        {
            System.out.println("\nItems in the order:");
            System.out.println("-----------------------------------------------------");
            // Call the relevant Pizza and Pasta toString method for each item
            System.out.println("\t" + item.toString());

            // Call the relevant Pizza and Pasta meal price calculation method for each item. Add the overall price.
            overallOrderPrice += item.calculateMealPrice();
        }

        System.out.println("\nOrder Information");
        System.out.println("-----------------------------------------------------");
        System.out.println("Total Order Price: " + overallOrderPrice);
        System.out.println("Order Meal Type: " + overallMealType + "\n");
    }

    /**
     * The following method is responsible for determining the overall meal type, of a customer's order.
     * @return overallMealType.
     */
    public String determineOverallMealType()
    {
        String overallMealType = "vegan";   // Start with vegan, if the user enters nothing (blank), it has to be vegan.

        for(FoodItem item : items)   // Iterate through the "items" array with iterator "item".
        {
            // Send iterator to determineMealType method, declare it as "mealType" as type String.
            String mealType = item.determineMealType();

            if(mealType.equals("meat"))
            {
                overallMealType = "meat";   // If it is meat, it cannot be vegetarian, thus break out of loop.
                break;
            }

            else if(mealType.equals("vegetarian"))
            {
                overallMealType = "vegetarian";
            }
        }

        return overallMealType;
    }

    /**
     * Retrieve the customers address.
     * @return customerAddress.
     */
    public String getCustomerAddress()
    {
        return customerAddress;
    }

    /**
     * Retrieve the customer name.
     * @return customerName.
     */
    public String getCustomerName()
    {
        return customerName;
    }

    /**
     * Retrieve the customer phone number.
     * @return customerPhoneNumber.
     */
    public int getCustomerPhoneNumber()
    {
        return customerPhoneNumber;
    }

    /**
     * Retrieve an arraylist of items (the different pizzas and pastas that the customer inputs/ orders).
     * @return items.
     */
    public ArrayList<FoodItem> getItem()
    {
        return items;
    }

    /**
     * Set the customer address.
     * @param customerAddress sets the customer address.
     */
    public void setCustomerAddress(String customerAddress)
    {
        this.customerAddress = customerAddress;
    }

    /**
     * Set the customer name.
     * @param customerName sets the customer name.
     */
    public void setCustomerName(String customerName)
    {
        this.customerName = customerName;
    }

    /**
     * Set the customer phone number.
     * @param customerPhoneNumber sets the customer phone number.
     */
    public void setCustomerPhoneNumber(int customerPhoneNumber)
    {
        this.customerPhoneNumber = customerPhoneNumber;
    }

    /**
     * Set the items (pizzas/pastas) that the customer orders in the items arraylist.
     * @param items sets the items (pizzas/pasta) the customer orders.
     */
    public void setItem(ArrayList<FoodItem> items)
    {
        this.items = items;
    }

}