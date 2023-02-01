package dao;

import Connectionaapp.Connect1;
import entity.Podcast;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

public class PodcastDao {
    public static Connection conn;

    public  PodcastDao() throws SQLException, ClassNotFoundException {
        conn = Connect1.establishconnection();
    }
    public List<Podcast> getAllPodcast() {
        List<Podcast> allPodcastList = new ArrayList<>();
        try {
            String query = "select * from podcast";
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(query);
            while (rs.next()) {
                allPodcastList.add(new Podcast(rs.getInt(1), rs.getString(2), rs.getTime(3), rs.getDate(4), rs.getString(5),rs.getString(6)));
            }
        }
        catch (SQLException e){
            System.out.println(e);
        }
        return allPodcastList;
    }

}
