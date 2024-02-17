/**
 * The following class is a child class of the FoodItem class. It consists of four fields, one enum, a default and
 * non-default constructor, three methods (two of which are implemented as abstract methods), one getter method, one
 * setter method and one implemented (overridden) toString method.
 * @author MAPC
 * @version 1.0.0
 */

// Arraylist and scanner imports.
import java.util.ArrayList;
import java.util.Scanner;

public class Pasta extends FoodItem
{
    private ArrayList<pastaToppings> toppings;   // Arraylist of enum type pastaToppings called toppings.
    public static final double TOMATOTOPPINGPRICE = 4.00;
    public static final double BOLOGNESEANDPRIMAVERAPRICE = 5.20;
    public static final double MARINARATOPPINGPRICE = 6.80;
    public enum pastaToppings   // An enum of all the pastaToppings.
    {
        BOLOGNESE,
        MARINARA,
        PRIMAVERA,
        TOMATO
    }

    /**
     * Default constructor.
     */
    public Pasta()
   {
        super("");
        this.toppings = new ArrayList<>();
        this.price = calculateMealPrice();
        this.mealType = determineMealType();
   }

    /**
     * Non-default constructor.
     * @param foodName calls the FoodItem non-default constructor, directly access and inherit the food's name.
     * @param toppings arraylist of type pastaToppings enum, called toppings.
     */
   public Pasta(String foodName, ArrayList<pastaToppings> toppings)
   {
        super(foodName);
        this.toppings = toppings;
        this.price = calculateMealPrice();
        this.mealType = determineMealType();
   }

    /**
     * The following method allows for the functionality of the user adding a specific pasta topping to their order.
     * This method is called upon in the RestaurantDriver class.
      * @return toppings.
     */
   public static ArrayList<Pasta.pastaToppings> addPastaToppings()
    {
        // Declare an empty arraylist called "toppings", and create a new scanner instance to take user input.
        ArrayList<Pasta.pastaToppings> toppings = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nTopping Options:\nBOLOGNESE (meat)\nMARINARA (meat)\nPRIMAVERA " +
                "(vegetarian)\nTOMATO (vegan)");
        System.out.println("\nYou can only choose one, or enter blank for no toppings:");
        String chosenPastaToppings = scanner.nextLine();

        // A comma is the delimiter for the inputted pasta toppings, which are then added to an array of type String.
        String[] chosenToppings = chosenPastaToppings.split(",");

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
            // which is of type "pastaToppings" (the enum).
            try
            {
                toppings.add(Pasta.pastaToppings.valueOf(topping));
            }

            catch (IllegalArgumentException e)   // An invalid input has been entered.
            {
                System.out.println("\nInvalid input. Please try again with a Topping option listed above.");
            }
        }

        System.out.println("\nPasta with: " + chosenPastaToppings + " topping(s) was added to the order.");

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

        if(toppings.contains(pastaToppings.TOMATO))
        {
            totalToppingCost += TOMATOTOPPINGPRICE;   // If the new toppings arraylist contains tomato, $4 charge.
        }

        if(toppings.contains(pastaToppings.BOLOGNESE) || toppings.contains(pastaToppings.PRIMAVERA))
        {
            totalToppingCost += BOLOGNESEANDPRIMAVERAPRICE;
        }

        if(toppings.contains(pastaToppings.MARINARA))
        {
            totalToppingCost += MARINARATOPPINGPRICE;
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
        if(toppings.contains(pastaToppings.BOLOGNESE) || toppings.contains(pastaToppings.MARINARA))
        {
            mealType = "meat";   // If the new toppings arraylist contains bolognese or marinara, it's a meat meal type.
        }

        else if(toppings.contains(pastaToppings.PRIMAVERA))
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
     * The following getter method was created to remove the "[]" around the user's chosen pasta topping, and instead,
     * output it as a string.
     * @return the users chosen pasta topping as a string.
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
     * Set the topping of an order. As the price and mealType change, they are included with their respective methods.
     * @param toppings arraylist of pasta toppings.
     */
    public void setToppings(ArrayList<pastaToppings> toppings)
    {
        this.toppings = toppings;
        this.price = calculateMealPrice();
        this.mealType = determineMealType();
    }

    /**
     * A toString method that is called upon in the RestaurantDriver class, printing the users chosen pasta topping,
     * meal type and price as a string.
     * @return outString.
     */
    @Override
    public String toString()
    {
        String outString;

        outString = "Pasta with: " + getToppings() + " (contains " + getMealType() + ")" + " topping(s)" +
                " ------>" + "\tPrice: " + getPrice();

        return outString;
    }

}