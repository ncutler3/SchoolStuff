package TennisBallGames;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Abdelkader
 */
public class MatchesAdapter {

    Connection connection;

    public MatchesAdapter(Connection conn, Boolean reset) throws SQLException {
        connection = conn;
        if (reset) {
            Statement stmt = connection.createStatement();
            try {
                // Remove tables if database tables have been created.
            // This will throw an exception if the tables do not exist
            stmt.execute("DROP TABLE Matches");
                // then do finally
            } catch (SQLException ex) {
                // No need to report an error.
                // The table simply did not exist.
                // do finally to create it
            } finally {
                // Create the table of Matches
                stmt.execute("CREATE TABLE Matches ("
                        + "MatchNumber INT NOT NULL PRIMARY KEY, "
                        + "HomeTeam CHAR(15) NOT NULL REFERENCES Teams (TeamName), "
                        + "VisitorTeam CHAR(15) NOT NULL REFERENCES Teams (TeamName), "
                        + "HomeTeamScore INT, "
                        + "VisitorTeamScore INT "
                        + ")");
                populateSamples();
            }
        }
    }
    
    private void populateSamples() throws SQLException{
            // Create a listing of the matches to be played
            this.insertMatch(1, "Astros", "Brewers");
            this.insertMatch(2, "Brewers", "Cubs");
            this.insertMatch(3, "Cubs", "Astros");
    }
        
    
    public int getMax() throws SQLException {
        int num = 0;
        ResultSet rs;

        Statement stmt = connection.createStatement();
        String sqlStatement = "SELECT MAX(MatchNumber) FROM Matches";

        rs = stmt.executeQuery(sqlStatement);

        rs.next();

        num = rs.getInt(1);
        
        return num;
    }
    
    public void insertMatch(int num, String home, String visitor) throws SQLException {
        Statement stmt = connection.createStatement();
        //inserts a new row into the Matches table and sets values for match number, home team, visitor team, home score, and visitor score
        stmt.executeUpdate("INSERT INTO Matches (MatchNumber, HomeTeam, VisitorTeam, HomeTeamScore, VisitorTeamScore) "
                + "VALUES (" + num + " , '" + home + "' , '" + visitor + "', 0, 0)");
    }
    
    // Get all Matches
    public ObservableList<Matches> getMatchesList() throws SQLException {
        ObservableList<Matches> matchesList = FXCollections.observableArrayList();
        ResultSet rs;

        Statement stmt = connection.createStatement();

        // Create a string with a SELECT statement
        String sqlStatement = "SELECT * FROM Matches";

        // Execute the statement and return the result
        rs = stmt.executeQuery(sqlStatement);

        while (rs.next()) {
            matchesList.add(new Matches(rs.getInt("matchNumber"),
                    rs.getString("homeTeam"),
                    rs.getString("visitorTeam"),
                    rs.getInt("homeTeamScore"),
                    rs.getInt("visitorTeamScore")));
        }

        return matchesList;
    }

    // Get a String list of matches to populate the ComboBox used in Task #4.
    public ObservableList<String> getMatchesNamesList() throws SQLException {
        ObservableList<String> list = FXCollections.observableArrayList();
        ResultSet rs;

        Statement stmt = connection.createStatement();
        String sqlStatement = "SELECT * FROM Matches";

        rs = stmt.executeQuery(sqlStatement);
        while(rs.next()){
            //formatsv the string so it looks just like the images in the lab manual
            list.add(rs.getString(1)+"-"+ rs.getString(2 )+ "-"+rs.getString(3));
        }
        
        return list;
    }
    
    
    public void setTeamsScore(int matchNumber, int hScore, int vScore) throws SQLException {
        ResultSet rs;
        Statement stmt = connection.createStatement();
        //updates home and visitor scores in Matches table under the criteria of a specific match number
        String sqlStatement = "UPDATE Matches SET homeTeamScore = " + hScore + " , visitorTeamScore = " + vScore + " WHERE MatchNumber = " + matchNumber;

        stmt.executeUpdate(sqlStatement);

   }  
}
