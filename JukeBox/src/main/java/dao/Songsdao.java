package dao;

import Connectionaapp.Connect1;
import entity.Songs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Songsdao {
    public static Connection conn;

    public  Songsdao() throws SQLException, ClassNotFoundException {
        conn =Connect1.establishconnection();
    }
    public static List<Songs> showAllSongs()   //show all songs
    {
        List<Songs> allSongs = new ArrayList<>();
        try {

            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from songs");
            while (resultSet.next())
            {
                allSongs.add(new Songs(resultSet.getInt(1),resultSet.getString(2),
                        resultSet.getString(3),resultSet.getTime(4),
                        resultSet.getString(5),resultSet.getString(6), resultSet.getString(7)));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return allSongs;
    }

}
