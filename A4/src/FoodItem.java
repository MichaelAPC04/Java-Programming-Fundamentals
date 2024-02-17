/**
 * The following abstract class is a superclass of the "Pizza" and "Pasta" classes. It consists of four protected fields
 * (meaning they can only be accessed by its inheritors), a default and non-default constructor, two abstract methods,
 * (which are implemented in the Pizza and Pasta class inheritors), three getter methods, one setter method and a
 * toString method.
 * @author MAPC
 * @version 1.0.0
 */

public abstract class FoodItem
{
    protected String foodName;   // Protected fields can only be accessed by inheritors.
    protected double price;
    protected String mealType;
    protected static final double BASEPRICE = 11.50;   // The base price will always be $11.50

    /**
     * Default constructor. foodName is an empty string.
     */
    public FoodItem()
    {
        foodName = "";
    }

    /**
     * Non-default constructor. With both constructors, the reason why only foodName is declared is that the price
     * and mealType are constantly declared and changed after object creation in many methods throughout the program. The BASEPRICE is static
     * (only relevant to this class), and will never change as it is final. After the foodName is set, it does not
     * change across the object's lifetime.
     * @param foodName name of the food.
     */
    public FoodItem(String foodName)
    {
        this.foodName = foodName;
    }

    /**
     * An abstract method implemented in the Pizza and Pasta inheritor classes that determines the type of meal.
     * @return mealType when implemented in inheritor classes Pizza and Pasta.
     */
    public abstract String determineMealType();

    /**
     * An abstract method implemented in the Pizza and Pasta inheritor classes that calculates the price of a meal.
     * @return price when implemented in inheritor classes Pizza and Pasta.
     */
    public abstract double calculateMealPrice();

    /**
     * Retrieves a food's name.
     * @return foodName.
     */
    public String getFoodName()
    {
        return foodName;
    }

    /**
     * Retrieves a meal's type.
     * @return mealType.
     */
    public String getMealType()
    {
        return mealType;
    }

    /**
     * Retrieve the price of a meal.
     * @return price.
     */
    public double getPrice()
    {
        return price;
    }

    /**
     * Set the foodName.
     * @param foodName set the name of a food.
     */
    public void setFoodName(String foodName)
    {
        this.foodName = foodName;
    }

    /**
     * A toString method that is overridden in the Pizza and Pasta inheritor classes.
     * @return null.
     */
    @Override
    public String toString()
    {
        return null;
    }

}