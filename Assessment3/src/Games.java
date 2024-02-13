/**
 * The following class simulates an AFL game between two teams, it consists of four private fields, one non-default
 * constructor, and one method. This class demonstrates "high cohesion" as it only simulates games between two teams,
 * which is why there is only one method, "playGame", there are no getters, setters, toStrings or a non-default
 * constructor, that is the role of the "Teams" class. Below, the TEAM1 and TEAM2 fields demonstrate "low coupling", as
 * the "Games" class only knows about the various public methods of the "Teams" class.
 * @author Michael Anthony Patrick Cetrola
 * @version 1.0.0
 */

public class Games
{
    // The two teams that will play, are set to final as both teams cannot be changed once set.
    // The two team fields are of type "Teams" class.
    private final Teams TEAM1;
    private final Teams TEAM2;
    // Scores of TEAM1 and TEAM2 respectively, declared as type int.
    private int score1;
    private int score2;

    /**
     * Non-default constructor where a new game instance is constructed between two teams with the following:
     * @param TEAM1 First team in the game.
     * @param TEAM2 Second team in the game.
     */
    public Games(Teams TEAM1, Teams TEAM2)
    {
        this.TEAM1 = TEAM1;
        this.TEAM2 = TEAM2;
        this.score1 = 0;
        this.score2 = 0;
    }

    /**
     * Game simulation between team teams, where a team's statistics are updated once a game ends.
     * A team's scores, wins, losses and draws are updated randomly when this method is invoked and executed.
     * The win, loss or draw results are determined at the end.
     */
    public void playGame()
    {
        // Declaring local variables of a game's time, goal and behind values and goal and behind
        // chances' for later use.
        int gameTime = 80;
        int goal = 6;
        int behind = 1;
        int goalChance = 14;
        int behindChance = 32;

        System.out.println("\n------------------------------------------------------------");
        System.out.println("Welcome to " + TEAM1.getTeamName() + " vs. " + TEAM2.getTeamName() + "!");
        System.out.println("The match will start soon!");

        // Loop (game itself) runs until the time limit is reached.
        for(int i = 0; i < gameTime; i++)
        {
            // Random number between 1 and 100 determines if/what TEAM1 will score.
            int randomScore1 = (int)(Math.random() * 100 + 1);
            // team1 scoring goals and behinds.
            if(randomScore1 <= goalChance)   // 14% chance of scoring a goal per minute.
            {
                score1 += goal;
            }
            else if(randomScore1 <= behindChance)   // 18% chance of scoring a behind per minute. 68% no behinds/goals.
            {
                score1 += behind;
            }

            // Random number between 1 and 100 determines if/what TEAM2 will score.
            int randomScore2 = (int)(Math.random() * 100 + 1);
            // team2 scoring goals and behinds.
            if(randomScore2 <= goalChance)
            {
                score2 += goal;
            }
            else if(randomScore2 <= behindChance)
            {
                score2 += behind;
            }

        }

        System.out.println("\nGame over!");

        // TEAM1 wins, set wins by getting them and incrementing them by 1, TEAM2's losses is also incremented.
        if(score1 > score2)
        {
            TEAM1.setWins(TEAM1.getWins() + 1);
            TEAM2.setLosses(TEAM2.getLosses() + 1);
            System.out.println(TEAM1.getTeamName() + " wins!");
        }

        // TEAM2 wins, set wins by getting them and incrementing them by 1, TEAM1's losses is also incremented.
        else if(score1 < score2)
        {
            TEAM2.setWins(TEAM2.getWins() + 1);
            TEAM1.setLosses(TEAM1.getLosses() + 1);
            System.out.println(TEAM2.getTeamName() + " wins!");
        }

        // Both teams draw, set draws by getting them and incrementing them by 1.
        else
        {
            TEAM1.setDraws(TEAM1.getDraws() + 1);
            TEAM2.setDraws(TEAM2.getDraws() + 1);
            System.out.println(TEAM1.getTeamName() + " and " + TEAM2.getTeamName() + " have drawn!");
        }

        // print the final results of the finished game.
        System.out.println("Final score: " + TEAM1.getTeamName() + " " + score1
                + " - " + score2 + " " + TEAM2.getTeamName());

    }

}