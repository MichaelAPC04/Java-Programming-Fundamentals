/**
 * The following class is responsible for allowing the user creation of teams, where a team's wins, losses and draws
 * can be tracked and updated with each game played. The class consists of one default and non-default constructor, four
 * getter methods, three setter methods and one toString method.
 * @author Michael Anthony Patrick Cetrola
 * @version 1.0.0
 */
public class Teams
{
    // A team's name declared as a final string, meaning it cannot be changed once set.
    private final String TEAMNAME;
    // Integer number of wins, losses and draws.
    private int wins;
    private int losses;
    private int draws;

    /**
     * Default constructor where a team is created with the following default values:
     */
    public Teams()
    {
        TEAMNAME = "";
        wins = 0;
        losses = 0;
        draws = 0;
    }

    /**
     * Non-default constructor where a team is created with the following:
     * @param TEAMNAME Name of the team.
     * @param wins The number of wins a team has.
     * @param losses The number of losses a team has.
     * @param draws The number of draws a team has.
     */
    public Teams(String TEAMNAME, int wins, int losses, int draws)
    {
        this.TEAMNAME = TEAMNAME;
        this.wins = wins;
        this.losses = losses;
        this.draws = draws;
    }

    /**
     * Retrieves a team's draws.
     * @return A team's draws as an integer.
     */
    public int getDraws()
    {
        return draws;
    }

    /**
     * Retrieves a team's losses.
     * @return A team's losses as an integer.
     */
    public int getLosses()
    {
        return losses;
    }

    /**
     * Retrieves a team's name.
     * @return A team's name as a string.
     */
    public String getTeamName()
    {
        return TEAMNAME;
    }

    /**
     * Retrieves a team's wins.
     * @return A team's wins as an integer.
     */
    public int getWins()
    {
        return wins;
    }

    /**
     * Sets the number of draws for a team.
     * @param draws Number of draws to set for a team.
     */
    public void setDraws(int draws)
    {
        this.draws = draws;
    }

    /**
     * Sets the number of losses for a team.
     * @param losses Number of losses to set for a team.
     */
    public void setLosses(int losses)
    {
        this.losses = losses;
    }

    /**
     * Sets the number of wins for a team.
     * @param wins Number of wins to set for a team.
     */
    public void setWins(int wins)
    {
        this.wins = wins;
    }

    /**
     * Returns a string of a team's overall statistics.
     * @return A string of a team's name, wins, losses and draws.
     */
    public String toString()
    {
        String outString;

        outString = "Team Name = " + "'" + TEAMNAME + "'" + "\nWins = " + wins +
                "\nLosses = " + losses + "\nDraws = " + draws;

        return outString;
    }

}