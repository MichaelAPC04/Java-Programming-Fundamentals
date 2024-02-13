/**
 * @author Michael Anthony Patrick Cetrola
 * @version 1.0.0
 * The following class consists of one field, a default and non-default constructor and eight methods (one getter and
 * one setter). With the "heights" Arraylist, the class can add and remove manually specified user heights, return
 * the "heights" Arraylist as a string and get the mean, standard deviation and outliers of it.
 */

// imports for ArrayList and Iterator
import java.util.ArrayList;
import java.util.Iterator;

public class HeightDatabase
{

    // initialise ArrayList "heights" field of type double
    private ArrayList<Double> heights = new ArrayList<Double>();

    // default constructor, default values passed into "heights" ArrayList
    public HeightDatabase()
    {

    }

    // non-default constructor, this. is the current obj "heights"
    public HeightDatabase(ArrayList<Double> heights)
    {
        this.heights = heights;
    }

    // method takes manually inputted height as type double, adds it to the "heights" ArrayList
    public void addHeight(double height)
    {
        heights.add(height);
    }

    // method takes manually inputted int, uses that as the index to remove a value from the "heights" ArrayList
    public void removeHeight(int index)
    {
        heights.remove(index);
    }

    // method that returns the values in "heights" ArrayList as a string, on a new line, in order
    public String toString()
    {
        // declare new StringBuilder instance, makes newly created string mutable
        StringBuilder result = new StringBuilder();
        for (Double i : heights)
        {
            result.append(i);
            result.append("\n");
        }
        return result.toString();   // loop through "heights", append it (i) to "result" with a newline, return "result"

    }

    // method that returns the mean of the "heights" Arraylist as type double
    public double getMean()
    {
        // declare "mean" (type double), n (type int, size of "heights" Arraylist) and "arraySum" (type double)
        double mean = 0.0;
        int n = heights.size();
        double arraySum = 0.0;

        // loop through "heights", adding everything from it as one
        for(double i : heights)
        {
            arraySum += i;
        }

        mean = arraySum/n;   // total divided by number of terms, then returned
        return mean;

    }

    // method that calculates and returns standard deviation of the values in the "heights" Arraylist
    public double getStdDev()
    {

        // declare "mean" as type double (use previous "mean" method to avoid rewriting code),
        // declare "standardDeviation" (type double) and number of terms in "heights"(type int)
        double mean = getMean();
        double standardDeviation = 0.0;
        int n = heights.size();

        // squared difference from mean, declare "sumSquaredDifference" (type float)
        double sumSquaredDifference = 0.0;
        for(double i : heights)
        {
            double difference = i - mean;   // calculate difference of each data point from mean
            sumSquaredDifference += difference * difference;   // add squared difference to sum
        }

        // calculate variance
        double variance = sumSquaredDifference / (n - 1);

        // calculate sd as square root of variance
        standardDeviation = Math.sqrt(variance);

        return  standardDeviation;

    }

    // method that deletes any outliers from the "heights" Arraylist 2 standard deviations from the mean
    public void removeOutliers()
    {
        // declare "mean" and "standard deviation" as type double via previous methods to avoid rewriting code and
        // create iterator instance to traverse "heights" Arraylist
        double mean = getMean();
        double stdDev = getStdDev();
        Iterator<Double> it = heights.iterator();

        while(it.hasNext())
        {
            double val = it.next();

            // calculate absolute sd of current value from mean, then check if deviation is 2 times greater than the sd
            if (Math.abs(val - mean) > 2 * stdDev)
            {
                it.remove();   // remove current value via iterator and print the value removed
                System.out.println("Removing height " + val);
            }
        }

    }

    // getter method for "heights" ArrayList
    public ArrayList<Double> getHeights()
    {
        return heights;
    }

    // setter method for the "heights" ArrayList
    public void setHeights(ArrayList<Double> newHeights)
    {
        heights = newHeights;
    }

}