package Operations;

import entity.Songs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class SongOperation {
    public List<Songs> searchbyartistName(List<Songs> allsonglist, String artist_name) {
        List<Songs> sa = new ArrayList<>();
        sa=allsonglist.stream().filter(p->p.getArtist_name().equalsIgnoreCase(artist_name)).sorted(((o1, o2) -> o1.getSong_name().compareToIgnoreCase(o2.getSong_name()))).collect(Collectors.toList());
        return sa;
    }

    public List<Songs> searchByName(List<Songs> songList,String songName) {
        List<Songs> songNameList=new ArrayList<>();
        songNameList= songList.stream().filter(i->i.getSong_name().startsWith(songName)).sorted((o1,o2)->o1.getSong_name().compareToIgnoreCase(o2.getSong_name())).collect(Collectors.toList());
        return songNameList;
    }


    //public List<Songs> searchBySongId(List<Songs> allSongsList, int song_id){
       // List<Songs> sa=new ArrayList<>();
        //sa=allSongsList.stream().filter(p->p.getSong_id()==(song_id)).sorted(Comparator.comparing(Songs::getSong_id)).collect(Collectors.toList());
        //return sa;
    //}
    public List<Songs> searchBySongId(List<Songs> songList,int songId) {
            songList = songList.stream().filter(i -> i.getSong_id() == (songId)).sorted((o1, o2) -> o1.getSong_name().compareToIgnoreCase(o2.getSong_name())).collect(Collectors.toList());

        return songList;
    }


            public List<Songs> searchByGenre(List<Songs> songList, String genre) {
        List<Songs> sa=new ArrayList<>();
        sa=songList.stream().filter(s -> s.getGenre().equalsIgnoreCase(genre)).collect(Collectors.toList());
        return sa;
    }

    public static List<Songs> searchByAlbum(List<Songs> songList, String albumName) {
        List<Songs> sa= new ArrayList<>();
        sa= songList.stream().filter(s -> s.getAlbum().equalsIgnoreCase(albumName)).collect(Collectors.toList());
        return sa;
    }
    public void display(List<Songs> displayby ){
        Consumer<Songs> dis= d->System.out.println(d);
        displayby.stream().forEach(dis);
    }

}
