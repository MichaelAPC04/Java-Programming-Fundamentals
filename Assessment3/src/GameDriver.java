/**
 * The following class is the driver class, "GameDriver". This class contains the main method, which is responsible
 * for the execution of the program. In this class, the user inputs six teams that are to play against each other. The
 * results of all games and each teams' statistics are displayed as well through invoking other class' various methods.
 * @author Michael Anthony Patrick Cetrola
 * @version 1.0.0
 */

import java.util.Scanner;

public class GameDriver
{
    public static void main(String[] args)
    {
        // Get user input, create a "Teams" array to store 6 "Teams" objects.
        Scanner scanner = new Scanner(System.in);
        Teams[] teams = new Teams[6];

        // Ask the user for exactly six inputs, then terminate the loop (stop asking for input).
        for(int i = 0; i < 6; i++)
        {
            System.out.println("Please enter Team " + (i + 1) + "'s name: ");
            String teamName = scanner.nextLine();
            // Create a new "Teams" object for each iteration (6 in total), with 0 wins, losses and draws,
            // it's name is the user's input.
            teams[i] = new Teams(teamName, 0,0,0);
        }

        // Outer "for loop" gets the first team from the "teams" array (i.e., "Team A").
        // Inner "for loop" gets the next team after the first team (i.e., "Team B").
        for(int i = 0; i < 6; i++)
        {
            for(int j = i + 1; j < 6; j++)
            {
                // Now both "Team A" and "Team B" play each other exactly twice.
                // Iterator "j" limit reached, go back to outer for loop, iterator "i" limit not reached, keep going.
                Games firstGame = new Games(teams[i], teams[j]);
                firstGame.playGame();
                Games secondGame = new Games(teams[i], teams[j]);
                secondGame.playGame();
            }
        }

        // For-each loop, iterator (team) of type "Teams" (class), iterate through the "teams" array, for each team
        // print out its statistics by calling the "toString" method from the "Teams" class.
        for(Teams team : teams)
        {
            System.out.println("\nTeam Statistics");
            System.out.println("---------------");
            System.out.println(team.toString());
        }
    }

}