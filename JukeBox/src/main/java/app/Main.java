package app;
import com.mysql.cj.jdbc.ConnectionImpl;
import Connectionaapp.Connect1;
import Exceptions.CustomException;
import Operations.*;
import Operations.
        UserOperations;
import dao.PlayListDao;
import dao.PodcastDao;
import dao.Songsdao;
import entity.AudioData;
import entity.PlayList;
import entity.Podcast;
import entity.Songs;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.sql.*;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String args[]) throws Exception {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Please select the Task number \n1:Songs \n2:Podcast \n3:Playlist \n4:AudioPlayer\n5.Exit");
            int choice, choice1, choice2, choice3, choice4;
            choice = sc.nextInt();
            UserOperations uo = new UserOperations();
            Connection conn=Connect1.establishconnection();
            int userId = uo.validateUser();
            switch (choice) {
                case 1:
                    do {
                        Songsdao sd = new Songsdao();
                        SongOperation so = new SongOperation();
                        List<Songs> allsongsList = sd.showAllSongs();
                        so.display(allsongsList);
                        System.out.print("1.to view all songs   \n2.Search and sorting songs by artist " +
                                "\n3.Search and sorting songs by album" +
                                " \n4.Search and sorting songs by genre" + "\n5.Search and sorting songs by song name");
                        choice1 = sc.nextInt();
                        switch (choice1) {
                            case 1:
                                so.display(allsongsList);
                                break;
                            case 2:
                                System.out.println(" Enter Artist Name");
                                String artist_name = sc.next();
                                List<Songs> searchandsortbyartist = so.searchbyartistName(allsongsList, artist_name);
                                so.display(searchandsortbyartist);
                                break;
                            case 3:
                                System.out.println(" Enter Album Name");
                                String album_name = sc.next();
                                List<Songs> searchandsortbyalbum = so.searchByAlbum(allsongsList, album_name);
                                so.display(searchandsortbyalbum);
                                break;
                            case 4:
                                System.out.println(" Enter Gener Name");
                                String gener_name = sc.next();
                                List<Songs> searchandsortbygener = so.searchByGenre(allsongsList, gener_name);
                                so.display(searchandsortbygener);
                                break;
                            case 5:
                                System.out.println(" Enter Song Name");
                                String song_name = sc.next();
                                List<Songs> searchandsortbysong = so.searchByName(allsongsList, song_name);
                                so.display(searchandsortbysong);
                                break;
                            case 6:
                                break;
                            default:
                                System.out.println("Match not found");
                                break;
                        }
                    } while (choice1 != 6);
                case 2:
                    do {
                        PodcastDao pd = new PodcastDao();
                        PodcastOperations po = new PodcastOperations();
                        List<Podcast> Podcastdata = pd.getAllPodcast();
                        po.display(Podcastdata);
                        System.out.print("1.to view all podcast" +
                                "\n2.sort by celebrity" +
                                "\n3.sort by date" + "\n4.sort by podcast_id");
                        choice2 = sc.nextInt();
                        switch (choice2) {
                            case 1:
                                po.display(Podcastdata);
                                break;
                            case 2:
                                System.out.println("Enter celebrity name");
                                String celebrityname = sc.next();
                                List<Podcast> filterbyname = po.getPodcastByCelebrity(Podcastdata, celebrityname);
                                po.display(filterbyname);
                                break;
                            case 3:
                                System.out.println("enter date");
                                String sortdate = sc.next();
                                Date date = Date.valueOf(sortdate);
                                List<Podcast> filterbydate = po.getPodcastByDate(Podcastdata, date);
                                po.display(filterbydate);
                                break;
                            case 4:
                                System.out.println("Enter podcast_id");
                                int podcast_id = sc.nextInt();
                                List<Podcast> filterById = po.searchByPodcastId(Podcastdata, podcast_id);
                                po.display(filterById);
                                break;
                            case 5:
                                break;
                            default:
                                System.out.println("Match not found");
                                break;
                        }
                    } while (choice2 != 5);
                case 3:
                    do {
                        System.out.println("1.Create a Playlist\n2.Insert a song into Playlist\n3.Insert a Podcast into a Playlist\n" +
                                "4.Insert an Album into a Playlist\n5.Delete a Playlist\n6.Display my Playlists\n7.Display Playlist Content\n" +
                                "8.Back Menu\n9.Exit the Application");

                        PlayListOperations plo = new PlayListOperations();
                        PlayListDao pdo = new PlayListDao();
                        PlayList pl = new PlayList();
                        SongOperation so2 = new SongOperation();
                        Songsdao sd = new Songsdao();
                        List<Songs> allsongsList = sd.showAllSongs();
                        PodcastDao pd = new PodcastDao();
                        PodcastOperations po = new PodcastOperations();
                        List<Podcast> Podcastdata = pd.getAllPodcast();
                        choice3 = sc.nextInt();
                        switch (choice3) {
                            case 1:
                                System.out.println("Enter playlist name:");
                                String name = sc.next();
                                plo.creatingAPlaylist(userId, name);
                                break;
                            case 2:
                                so2.display(allsongsList);
                                System.out.println("Enter SongId: ");
                                int songId = sc.nextInt();
                                System.out.println("Please enter Playlist Id to insert a Song: ");
                                plo.displayPlayLists(userId);
                                System.out.println("Enter playListId also");
                                int playlistId = sc.nextInt();
                                plo.addSong(playlistId, songId);
                                break;
                            case 3:
                                po.display(Podcastdata);
                                System.out.println("Enter PodcastId: ");
                                int podId = sc.nextInt();
                                System.out.println("Please enter Playlist Id to insert a Song: ");
                                plo.displayPlayLists(userId);
                                int playlistId1 = sc.nextInt();
                                plo.addPodcast(playlistId1, podId);
                                break;
                            case 4:
                                so2.display(allsongsList);
                                System.out.println("Enter the Album name:");
                                String album = sc.next();
                                System.out.println("Please enter Playlist Id to insert a Song: ");
                                plo.displayPlayLists(userId);
                                int playlistId2 = sc.nextInt();
                                plo.addAlbum(playlistId2, album);
                                break;
                            case 5:
                                plo.displayPlayLists(userId);
                                System.out.println("Enter the Playlist Id to delete: ");
                                int playlistId3 = sc.nextInt();
                                plo.deletingPlaylist(playlistId3);
                                break;
                            case 6:
                                plo.displayPlayLists(userId);
                                break;
                            case 7:
                                plo.displayPlayLists(userId);
                                System.out.println("Enter the Playlist Id to delete: ");
                                int playlistId4 = sc.nextInt();
                                plo.displayPlaylistContent(playlistId4);
                                break;
                            case 8:
                                break;
                            case 9:
                                System.exit(1230);
                            default:
                                System.out.println("Incorrect choice!");
                                break;
                        }
                    } while (choice3 != 8);
                case 4:
                    System.out.println("Choose an option to Play Music:-\n1.Playlist\n2.Song\n3.Podcast\n4.Exit");
                    PlayListOperations plo = new PlayListOperations();
                    PlayListDao pdo = new PlayListDao();
                    PlayList pl = new PlayList();
                    SongOperation so2 = new SongOperation();
                    Songsdao sd = new Songsdao();
                    List<Songs> allsongsList = sd.showAllSongs();
                    PodcastDao pd = new PodcastDao();
                    PodcastOperations po = new PodcastOperations();
                    List<Podcast> Podcastdata = pd.getAllPodcast();
                    PlayMusic pc = new PlayMusic();
                    List<AudioData> audioList = new ArrayList<>();
                    choice4 = sc.nextInt();
                    do {
                        switch (choice4) {
                            case 1:
                                plo.displayPlayLists(userId);
                                System.out.println("Enter playlist id to play music:");
                                int playId = sc.nextInt();
                                int song_Id, podcast_Id;
                                //String filePath="";
                                //String songName="";
                                Statement s = conn.createStatement();
                                Statement s1 = conn.createStatement();
                                ResultSet rs = s.executeQuery("select song_id,podcast_id from Audio where playlistid=" + playId);
                                while (rs.next()) {
                                    song_Id = rs.getInt(1);
                                    podcast_Id = rs.getInt(2);
                                    if (song_Id > 0) {
                                        ResultSet rs1 = s1.executeQuery("select song_name,song_url from songs where song_id=" + song_Id);
                                        while (rs1.next()) {
                                            //song_Id = rs1.getInt(1);
                                            //podcast_Id = rs1.getInt(2);
                                            //pc.playerOperation(filePath);
                                            audioList.add(new AudioData(rs1.getString(1), rs1.getString(2)));
                                        }
                                    } else {
                                        ResultSet rs1 = s1.executeQuery("select podcast_name,podcast_url from podcast where podcast_id=" + podcast_Id);
                                        while (rs1.next()) {
                                            audioList.add(new AudioData(rs1.getString(1), rs1.getString(2)));

                                        }
                                    }
                                }
                                pc.playerOperation(audioList);
                                break;
                            case 2:
                                System.out.println("Enter song");
                                so2.display(allsongsList);
                                List<AudioData> songAudioList = new ArrayList<>(0);
                                Statement s2 = conn.createStatement();
                                ResultSet rs2 = s2.executeQuery("select song_name,song_url from songs");
                                while (rs2.next()) {
                                    songAudioList.add(new AudioData(rs2.getString(1), rs2.getString(2)));
                                }
                                pc.playerOperation(songAudioList);
                                break;

                            case 3:
                                po.display(Podcastdata);
                                List<AudioData> podAudioList = new ArrayList<>(0);
                                Statement s3 = conn.createStatement();
                                ResultSet rs3 = s3.executeQuery("select podcast_name,podcast_url from podcast");
                                while (rs3.next()) {
                                    podAudioList.add(new AudioData(rs3.getString(1), rs3.getString(2)));
                                }
                                pc.playerOperation(podAudioList);
                                break;
                            case 4:
                                break;
                        }
                    } while (choice4 != 4);
                case 5:
                    break;
            }while (choice!=5);
        }
            }
        }

