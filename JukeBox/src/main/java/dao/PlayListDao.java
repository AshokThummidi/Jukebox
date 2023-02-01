package dao;

import Connectionaapp.Connect1;
import entity.PlayList;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.*;
import java.util.*;

public class PlayListDao {
    public static Connection conn;

    public  PlayListDao() throws SQLException, ClassNotFoundException {
        conn = Connect1.establishconnection();
    }

    public List<PlayList> showPlayList()
    {
        List<PlayList> playLists=new ArrayList<>();
        try
        {
            Statement s= conn.createStatement();
            ResultSet rs=s.executeQuery("select * from playLists");
            while (rs.next())
            {
                int id=rs.getInt(1);
                String name=rs.getString(2);
                playLists.add(new PlayList(id,name));
            }
        }
        catch (SQLException obj)
        {
           obj.printStackTrace();
        }
        return playLists;
    }


}
