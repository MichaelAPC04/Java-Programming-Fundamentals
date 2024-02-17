/**
 * Name: MAPC
 * Version number: 1.0.0
 * The following class consists of three fields, one non-default and default constructor and
 * three accessor and mutator methods for the student class
 * The class takes the parameters of a students' name, ID and WAM, which can be changed and retrieved in the
 * Assessment1 class, task2 method
 **/

public class Student
{
    //initialising fields
    private String studentName;
    private int studentID;
    private double studentWAM;

    //default constructor, creates a new Student object with default values in the provided fields
    //no need to initialise "studentName", Java automatically does this
    public Student()
    {
        studentID = 0;
        studentWAM = 0;
    }

    //non-default constructor, creates a new Student object with the provided fields
    public Student(String name, int id, double wam)
    {
        studentName = name;
        studentID = id;
        studentWAM = wam;
    }

    //accessor that returns the current value of studentName
    public String getStudentName()
    {
        return studentName;
    }

    //accessor that returns the current value of studentID
    public int getStudentID()
    {
        return studentID;
    }

    //accessor that returns the current value of studentWAM
    public double getStudentWAM()
    {
        return studentWAM;
    }

    //mutator that updates the studentName with the new provided one
    public void setStudentName(String newName)
    {
        studentName = newName;
    }

    //mutator that updates the studentID value with the new provided one
    public void setStudentID(int newID)
    {
        studentID = newID;
    }

    //mutator that updates the studentWAM value with the new provided one
    public void setStudentWAM(double newWAM)
    {
        studentWAM = newWAM;
    }

}
