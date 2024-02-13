import java.util.Scanner;

/**
 * Name: Michael Anthony Patrick Cetrola
 * Version number: 1.0.0
 * The following class consists of four different "tasks" (fields) that call on different methods to run
 * task1 calculates length of hypotenuse, task2 a students' name, ID, WAM input, outputs it with an updated WAM
 * task3 gets letter grade of inputted int grade, task4 10 int from input, returns ints lower than calculated average
 **/

public class Assessment1 {
    public static void main(String[] args) {

        Assessment1 a1 = new Assessment1();

        // Instruction: To run your respective task, uncomment below individually
//        a1.task1();
//        a1.task2();
//        a1.task3();
//        a1.task4();
    }

    //calculates pythagorean theorem, returns it
    public static double lengthOfHypotenuse(double a, double b)
    {
        double c = a * a + b * b;
        return Math.sqrt(c);
    }

    //manually inputted two set sides of the triangle, calls the lengthOfHypotenuse method
    public void task1()
    {
        lengthOfHypotenuse(3.0, 4.0);
    }

    //create new instance of Student class called "student1", set name, id, wam (calling non-default constructor)
    //use WAM mutator method to change student1's WAM
    //print the student1's new WAM via the WAM accessor method
    public void task2()
    {
        Student student1 = new Student("Sam Student", 12345678, 75.5);
        student1.setStudentWAM(86.6);
        System.out.println(student1.getStudentWAM());
    }

    //finds and prints a letter grade of an inputted int grade
    public void task3()
    {
        Scanner console = new Scanner(System.in); //get user input
        System.out.println("Enter an integer between 0 and 100.");
        int grade = console.nextInt(); //grade initialised to the console's nextInt, which gets next input
        boolean validInput = true; //boolean flag used to check if input out of range
        String gradeType = ""; //initialising gradeType, default "" reassigned later

        if (grade >= 80 && grade <= 100) //begin conditional statements, check input range, reassign gradeType with it
            gradeType = "HD";
        else if (grade >= 70 && grade <= 79)
            gradeType = "D";
        else if (grade >= 60 && grade <= 69)
            gradeType = "C";
        else if (grade >= 50 && grade <= 59)
            gradeType = "P";
        else if (grade >= 0 && grade <= 49)
            gradeType = "N";
        else
        {
            System.out.println("Invalid input, please enter an integer between 0 and 100.");
            validInput = false; //else input out of range, using flag
        }

        if (validInput) //if input valid (true), print calculated letter grade
            System.out.println("Your grade is " + gradeType + ".");
    }

    //get 10 user inputs, display average and return ints lower than the inputs' average
    public void task4()
    {
        double sum = 0; //initialise variables, userArray set to 10 ints
        int[] userArray = new int[10];

        Scanner console = new Scanner(System.in); //get user input
        System.out.println("Enter 10 integers:");

        for (int i = 0; i < userArray.length; i++) //iterate over array until length (10) is traversed
        {
            userArray[i] = console.nextInt(); //read int from console, store it in arrays' current element
            sum += userArray[i]; //add current value of array element to sum variable
        }

        double average = sum / userArray.length; //calculate average
        System.out.println("The average of these numbers is " + average);
        System.out.print("These numbers are below the average: "); //print statements, no ln, one line print
        for (int i : userArray) //iterate over ints in array
        {
            if (i < average) //if iterate less than average, print
                System.out.print(i + " "); //double quotes for space in between
        }
    }

}