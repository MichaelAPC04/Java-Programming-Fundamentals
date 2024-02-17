/**
 * The following class is a child class of the FoodItem class. It consists of four fields, one enum, a default and
 * non-default constructor, three methods (two of which are implemented abstract methods), one getter method, one setter
 * method and one implemented (overridden) toString method.
 * @author MAPC
 * @version 1.0.0
 */

// Arraylist and Scanner imports.
import java.util.ArrayList;
import java.util.Scanner;

public class Pizza extends FoodItem
{
    private ArrayList<pizzaToppings> toppings;   // Arraylist of enum type pizzaToppings called toppings.
    private static final double SEAFOODTOPPINGPRICE = 3.50;
    private static final double PINEAPPLETOPPINGPRICE = 2.50;
    private static final double OTHERTOPPINGPRICE = 2.00;
    public enum pizzaToppings   // An enum of all the pizza toppings.
    {
        HAM,
        CHEESE,
        PINEAPPLE,
        MUSHROOMS,
        TOMATO,
        SEAFOOD
    }

    /**
     * Default constructor.
     */
    public Pizza()
    {
        super("");
        this.toppings = new ArrayList<>();
        this.price = calculateMealPrice();
        this.mealType = determineMealType();
    }

    /**
     * Non-default constructor.
     * @param foodName calls the FoodItem non-default constructor, directly access and inherit the food's name.
     * @param toppings arraylist of type pizzaToppings enum, called toppings.
     */
    public Pizza(String foodName, ArrayList<pizzaToppings> toppings)
    {
        super(foodName);
        this.toppings = toppings;
        this.price = calculateMealPrice();
        this.mealType = determineMealType();
    }

    /**
     * The following method allows for the functionality of the user adding specific pizza toppings to their order.
     * This method is called upon in the RestaurantDriver class.
     * @return toppings.
     */
    public static ArrayList<Pizza.pizzaToppings> addPizzaToppings()
    {
        ArrayList<Pizza.pizzaToppings> toppings = new ArrayList<>();   // Declare an empty arraylist called "toppings"
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nTopping Options:\nHAM (meat)\nCHEESE (vegetarian)\nPINEAPPLE (vegan)\nMUSHROOMS " +
                "(vegan)\nTOMATOES (vegan)\nSEAFOOD (meat)");
        System.out.println("\nEnter toppings you want separated by a comma (you can choose more than one " +
                "or enter blank for no toppings):");
        String chosenPizzaToppings = scanner.nextLine();

        // A comma is the delimiter for the inputted pizza toppings, which are then added to an array of type String.
        String[] chosenToppings = chosenPizzaToppings.split(",");

        for(String topping : chosenToppings)
        {
            // When iterating through the array, trim whitespace and send the topping inputs to uppercase.
            // This allows for an exact iterator comparison to the enum of pizza toppings.
            topping = topping.toUpperCase().trim();

            if(topping.isEmpty())
            {
                continue;   // Skip the try and catch.
            }

            // Check if the iterator value (users topping input) matches the existing values of the arraylist toppings,
            // which is of type "pizzaToppings" (the enum).
            try
            {
                toppings.add(Pizza.pizzaToppings.valueOf(topping));
            }

            catch (IllegalArgumentException e)   // An invalid topping has been entered.
            {
                System.out.println("\nInvalid input. Please try again with a Topping option listed above.");
            }
        }

        System.out.println("\nPizza with " + chosenPizzaToppings + " topping(s) was added to the order.");

        return toppings;
    }

    /**
     * The following method calculates the price of a user's topping selection. This is an implemented (overridden)
     * method from the FoodItem class.
     * @return price.
     */
    @Override
    public double calculateMealPrice()
    {
        double totalToppingCost = 0.0;

        if(toppings.contains(pizzaToppings.SEAFOOD))
        {
            totalToppingCost += SEAFOODTOPPINGPRICE;   // If the new toppings arraylist contains seafood, $3.50 charge.
        }

        if(toppings.contains(pizzaToppings.PINEAPPLE))
        {
            totalToppingCost += PINEAPPLETOPPINGPRICE;
        }

        if(toppings.contains(pizzaToppings.HAM) || toppings.contains(pizzaToppings.CHEESE)
                || toppings.contains(pizzaToppings.MUSHROOMS) || toppings.contains(pizzaToppings.TOMATO))
        {
            totalToppingCost += OTHERTOPPINGPRICE;
        }

        price = BASEPRICE + totalToppingCost;
        return price;
    }

    /**
     * The following method determines whether the user's selected type of meal is vegan, vegetarian or if it contains
     * meat. This is an implemented (overridden) abstract method from the FoodItem class.
     * @return mealType.
     */
    @Override
    public String determineMealType()
    {
        if(toppings.contains(pizzaToppings.SEAFOOD) || (toppings.contains(pizzaToppings.HAM)))
        {
            mealType = "meat";   // If the new toppings arraylist contains seafood or ham, it's a meat meal type.
        }

        else if(toppings.contains(pizzaToppings.CHEESE))
        {
            mealType = "vegetarian";   // Or it is vegetarian.
        }

        else
        {
            mealType = "vegan";   // Or it is vegan.
        }

        return mealType;
    }

    /**
     * The following getter method was created to remove the "[]" around the user's chosen pizza toppings, and instead,
     * output them as a string.
     * @return the users chosen pizza toppings as a string.
     */
    public String getToppings()
    {
        StringBuilder toppingsToString = new StringBuilder();

        for(int i = 0; i < toppings.size(); i++)
        {
            toppingsToString.append(toppings.get(i));

            if(i != toppings.size() - 1)   // Append the toppings to the toppingsToString StringBuilder, split by ", ".
            {
                toppingsToString.append(", ");
            }
        }

        return toppingsToString.toString();
    }

    /**
     * Set the toppings of an order. As the price and mealType change, they are included with their respective methods.
     * @param toppings arraylist of pizza toppings.
     */
    public void setToppings(ArrayList<pizzaToppings> toppings)
    {
        this.toppings = toppings;
        this.price = calculateMealPrice();
        this.mealType = determineMealType();
    }

    /**
     * A toString method that is called upon in the RestaurantDriver class, printing the users chosen pizza toppings,
     * meal type and price as a string.
     * @return outString.
     */
    @Override
    public String toString()
    {
        String outString;

        outString = "Pizza with: " + getToppings() + " (contains " + getMealType() + ")" + " topping(s)"
                + " ------>" + "\tPrice: " + getPrice();

        return outString;
    }

}