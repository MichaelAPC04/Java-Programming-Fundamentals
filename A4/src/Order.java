/**
 * The following class is an interface that is implemented in the RestaurantDriver class. Its purpose is to create the
 * ability to deliver an order in the system, print all orders in the system and add an order to the system.
 * @author MAPC
 * @version 1.0.0
 */
public interface Order
{
    /**
     * When implemented, this allows for the functionality of adding an order to the system.
     */
    void addOrder();

    /**
     * When implemented, this allows for the functionality of delivering and removing an order from the system.
     */
    void deliverOrder();

    /**
     * When implemented, this allows for the functionality of printing all orders in the system.
     */
    void printOrders();

}