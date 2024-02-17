/**
 * @author MAPC
 * @version 1.0.0
 * The following class executes many methods defined in the HeightDatabase class by calling on them through two
 * instances, "db" and "db2". The main function directly invokes and prints "task3" and "task6" as seen below.
 * "task3" generates ten random values in the "db" Arraylist instance, which is printed in the main function.
 * "task6" manually adds ten doubles to the "db2" Arraylist instance, their mean and standard deviation are printed in
 * the main function, then the Arraylist's outliers are removed, finally everything left in the "db2" Arraylist is
 * printed out in the main function.
 */


public class Assessment2
{
    public static void main(String[] args)
    {
        System.out.println("Task 3 output: ");
        task3();

        System.out.println();
        System.out.println("Task 6 output: ");
        task6();

    }

    public static void task3()
    {
        // create a new instance of the HeightDatabase, named "db", set counter to 10
        HeightDatabase db = new HeightDatabase();
        int counter = 10;

        // loop 10 times (counter limit), adding random values between 100 (inclusive) & 210 (exclusive) to db instance
        for(int i = 0; i < counter; i++)
        {
            db.addHeight(Math.random() * 110 + 100);
        }

        // print the final db Arraylist values as a string by invoking HeightDatabase's "toString" method
        System.out.print(db.toString());
    }

    public static void task6()
    {
        // create a new instance of the HeightDatabase, named "db2"
        HeightDatabase db2 = new HeightDatabase();

        // add ten heights to db2 instance via the add method from the HeightDatabase class
        db2.addHeight(79.4);
        db2.addHeight(146.0);
        db2.addHeight(150.2);
        db2.addHeight(158.8);
        db2.addHeight(161.5);
        db2.addHeight(164.1);
        db2.addHeight(165.9);
        db2.addHeight(172.3);
        db2.addHeight(180.7);
        db2.addHeight(250.9);

        // print mean and standard deviation by invoking them from the HeightDatabase class via dot notation on db2
        System.out.println(db2.getMean());
        System.out.println(db2.getStdDev());

        // invoke remove outliers method on db2
        db2.removeOutliers();

        // print the final db2 Arraylist values using the toString method (convert everything to string)
        System.out.println(db2.toString());
    }

}