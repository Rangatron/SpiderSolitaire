///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package spidersolitaire;
//
//import java.sql.Connection;
//import java.sql.DatabaseMetaData;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
///**
// *
// * @author Alex Winterton
// */
//public class SolitaireDB {
//    
//    private Connection conn = null;
//    private String url = "";
//    private String username = "pdc";
//    private String password = "pdc";
//    private Statement statement;
//    
//    public void connect() 
//    {
//        try
//        {
//            this.conn = DriverManager.getConnection(this.url, this.username, this.password);//connects to the database
//            this.statement = conn.createStatement();
//            if(checkTableExisting("SCORES") == true)//checks if the score table has been made
//            {
//                
//            }
//            else
//            {
//                statement.executeUpdate("CREATE TABLE SCORES(DURATION INT, GAMES_PLAYED INT, GAMES_WON INT)");//if the SCORES table doesn't
//                statement.executeUpdate("INSERT INTO SCORES VALUES(59940000, 0, 0)");//exist make it and but in one row of values
//            }
//        }
//        catch(SQLException ex)
//        {
//            System.err.println("SQL Exception: " + ex.getMessage());
//        }
//    }
//    
//    public int bestTime()
//    {
//        int time = 59940000;//set so that most times will be faster than this
//        try
//        {
//            ResultSet rsTime = statement.executeQuery("SELECT DURATION FROM SCORES");//get the durations from the scores table
//            while(rsTime.next())
//            {//while thscores are still there
//                if(rsTime.getInt(1) < time)
//                {//checks if there are fewer milliseconds than the current time with fewest milliseconds
//                    time = rsTime.getInt(1);//replaces old fastest with new fastest
//                }
//            }
//        }
//        catch(SQLException ex)
//        {
//        }
//        return time;
//    }
//    
//    public int gamesPlayed()
//    {
//        int played = 0;//set to zero so that there will always be more games played than zero
//        try
//        {
//            ResultSet rsPlayed = statement.executeQuery("SELECT GAMES_PLAYED FROM SCORES");
//            while(rsPlayed.next())
//            {
//                if(rsPlayed.getInt(1) > played)
//                {//finds the row with the most games played
//                    played = rsPlayed.getInt(1);
//                }
//            }
//        }
//        catch(SQLException ex)
//        {
//            
//        }
//        
//        return played;
//    }
//    
//    public int gamesWon()
//    {
//        int won = 0;//set to zero so that there will always be a highest number of games won
//        try
//        {
//            ResultSet rsWon = statement.executeQuery("SELECT GAMES_WON FROM SCORES");
//            while(rsWon.next())
//            {
//                if(rsWon.getInt(1) > won)
//                {//finds the row with the highest games won value
//                    won = rsWon.getInt(1);
//                }
//            }
//        }
//        catch(SQLException ex)
//        {
//            
//        }
//        
//        return won;
//    }
//    
//    public void addGame(long duration, boolean won)
//    {
//        try
//        {
//            if(won)
//            {
//                statement.executeUpdate("INSERT INTO SCORES VALUES("+duration+", "+(gamesPlayed()+1)+", "+(gamesWon()+1)+")");       
//            }//if the user wins add their time to the scores table and increase the number of games played and games one
//            else
//            {
//                statement.executeUpdate("INSERT INTO SCORES VALUES(59940000, " +(gamesPlayed()+1)+", "+gamesWon()+")");
//            }//if the user doesn't win disregard their time and make their time the max and add one to the games played counter
//        }
//        catch(SQLException ex)
//        {
//                    
//        }
//    }
//    
//    private boolean checkTableExisting(String newTableName) {//checks if a tables exists or not
//        boolean exists = false;//and returns a boolean.
//        try {
//            String[] types = {"TABLE"};
//            DatabaseMetaData dbmd = conn.getMetaData();
//            ResultSet rsDBMeta = dbmd.getTables(null, null, null, null);//types);
//            
//            while (rsDBMeta.next()) {
//                String tableName = rsDBMeta.getString("TABLE_NAME");
//                if (tableName.compareToIgnoreCase(newTableName) == 0) {
//                   exists = true;//if the table name provided to the method is the same as a table in the database, change exists to true
//                }
//            }
//            if (rsDBMeta != null) {
//                rsDBMeta.close();
//            }
//            
//        }catch (SQLException ex) {
//        }
//        return exists;
//    }
//}
