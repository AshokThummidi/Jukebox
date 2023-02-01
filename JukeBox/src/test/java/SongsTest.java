import Operations.SongOperation;
import dao.Songsdao;
import entity.Songs;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.List;

//import static org.testng.AssertJUnit.assertEquals;

public class SongsTest {
    SongOperation songImpl = new SongOperation();

    public SongsTest() throws SQLException, ClassNotFoundException {
    }


    Songsdao s = new Songsdao();
    List<Songs> songlist = s.showAllSongs();

    @Test
    public void givenSongIdGetSongDetails() {
        assertEquals("kannuladha", songImpl.searchBySongId(songlist, 101).get(0).getSong_name());
        assertEquals("FairyTale", songImpl.searchBySongId(songlist, 104).get(0).getSong_name());
        assertEquals("Believer", songImpl.searchBySongId(songlist, 102).get(0).getSong_name());
    }

    @Test
    public void givenSongArtistGetSongDetails() {
        assertEquals("kannuladha", songImpl.searchbyartistName(songlist, "Anirudh").get(0).getSong_name());
        assertEquals("FairyTale", songImpl.searchbyartistName(songlist, "Justin").get(0).getSong_name());
        //assertEquals("emotion", songImpl.searchbyartistName(songlist, "tanjiro").get(0).getSong_name());
        //assertEquals("00:31", songImpl.searchbyartistName(songlist,"Arjith").get(0).getDuration());
    }

    @Test
    public void givenSongGenreGetSongDetails() {
        assertEquals("Thunder", songImpl.searchByName(songlist, "Thunder").get(0).getSong_name());
        assertEquals("Despacito", songImpl.searchByName(songlist, "Despacito").get(0).getSong_name());

    }
}


