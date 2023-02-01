package Operations;

import Connectionaapp.Connect1;
import Exceptions.CustomException;
import entity.PlayList;

import java.sql.*;
import java.util.*;

public class PlayListOperations {
    public static Connection conn;
    public  PlayListOperations() throws SQLException, ClassNotFoundException {
        conn = Connect1.establishconnection();
    }
    public void creatingAPlaylist(int userId,String playlistName) throws SQLException, CustomException {
        PreparedStatement ps= conn.prepareStatement("insert into playLists(playlistname,userid) values(?,?)");
        ps.setString(1,playlistName);
        ps.setInt(2,userId);
        int row=ps.executeUpdate();
        if(row>0)
        {
            System.out.println("Playlist Created Successfully :)");
        }
        else{
            throw new CustomException("No playList Created");
        }
    }
    public void addSong(int playListId,int songId)throws SQLException,CustomException
    {
        PreparedStatement ps= conn.prepareStatement("insert into Audio values(?,?,null)");
        ps.setInt(1,playListId);
        ps.setInt(2,songId);
        int count=ps.executeUpdate();
        if(count>0)
            System.out.println("Song added successfully");
        else
            throw new CustomException("No PlayList found");
    }
    public void addPodcast(int playListId,int podcastId)
    {
        try
        {
            PreparedStatement ps= conn.prepareStatement("insert into Audio values(?,null,?)");
            ps.setInt(1,playListId);
            ps.setInt(2,podcastId);
            int count=ps.executeUpdate();
            if(count>0)
                System.out.println("Podcast added successfully in playList");
            else
                throw new CustomException("No PlayList found");

        }
        catch (SQLException | CustomException e)
        {
            e.printStackTrace();
        }

    }
    public void addAlbum(int playlistId, String albumName) throws SQLException, CustomException {
        PreparedStatement ps = conn.prepareStatement("select song_id from songs where album=?");
        ps.setString(1, albumName);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int songId = rs.getInt(1);
            addSong(playlistId, songId);
        }
    }
    //public void insertSongAndPodcast(int playListId,int songId,int podcastId) throws SQLException, CustomException {
        //PreparedStatement ps= conn.prepareStatement("insert into Audio values(?,?,?)");
        //ps.setInt(1,playListId);
        //ps.setInt(2,songId);
        //ps.setInt(3,podcastId);
        //int count=ps.executeUpdate();
        //if(count>0)
            //System.out.println("Song inserted successfully :)");
        //else
            //throw new CustomException("Playlist Not Found");

    //}

    public void deletingPlaylist(int playListId) throws SQLException, CustomException {
        PreparedStatement ps= conn.prepareStatement("delete from playLists where playlistid=?");
        ps.setInt(1,playListId);
        ps.executeUpdate();
        int count=ps.executeUpdate();
        if(count>0)
            System.out.println("playlist deleted successfully :)");
        else
            throw new CustomException("Playlist Not Found :(\n");
    }
    public void displayPlayLists(int userId) throws Exception {
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select playlistid,playlistname from playlists where userid=" + userId);
            System.out.printf("%5s %10s\n", "PlaylistId", "PlaylistName");
            System.out.println("..................................................................................\n");
            while (rs.next()) {
                System.out.printf("%5s %10s\n", rs.getInt(1), rs.getString(2));
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }
    public void displayPlaylistContent(int playlistId) throws CustomException {
        try {
            System.out.println("Available Songs in the playlist:");
            System.out.printf("%-10s %10s\n", "SongId", "SongName");
            Statement s = conn.createStatement();
            Statement s1 = conn.createStatement();
            ResultSet rs = s.executeQuery("select song_id from Audio where playlistid=" + playlistId);
            while (rs.next()) {
                ResultSet rs1 = s1.executeQuery("select song_id,song_name from songs where song_id=" + rs.getInt(1));
                while (rs1.next()) {
                    System.out.printf("%-10s %10s\n", rs1.getInt(1), rs1.getString(2));
                }
            }
            System.out.println("\n");
            System.out.println("Available Podcasts in the playlist:");
            System.out.printf("%-10s %10s\n", "PodcastId", "PodcastName");
            Statement s2 = conn.createStatement();
            Statement s3 = conn.createStatement();
            ResultSet rs2 = s2.executeQuery("select podcast_id from Audio where playlist_id=" + playlistId);
            while (rs2.next()) {
                ResultSet rs3 = s3.executeQuery("select podcast_id,podcast_name from podcast where podcast_id=" + rs2.getInt(1));
                while (rs3.next()) {
                    System.out.printf("%-10s %10s\n", rs3.getInt(1), rs3.getString(2));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

