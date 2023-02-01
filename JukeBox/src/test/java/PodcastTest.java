import Operations.PodcastOperations;
import dao.PodcastDao;
import entity.Podcast;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

//import static org.testng.AssertJUnit.assertEquals;

public class PodcastTest {
    PodcastOperations podcastImpl = new PodcastOperations();
    PodcastDao pd = new PodcastDao();
    // PodcastImpl podcastImpl;
    List<Podcast> podlist = pd.getAllPodcast();

    public PodcastTest() throws SQLException, ClassNotFoundException {
    }

    @Test
    public void givenPodcastNameGetPodcastDetails() {
        assertEquals("The self love", podcastImpl.searchByPodcastId(podlist,501).get(0).getPodcast_name());
        assertEquals("Enjoy every moment", podcastImpl.searchByPodcastId(podlist,506).get(0).getPodcast_name());
        //assertEquals(Date.valueOf("1947-08-15"), podcastImpl.searchByPodcastId(podlist,505).get(0).getPodDate());
    }

    @Test
    public void givenPodcastCelebrityGetPodcastDetails() {
        assertEquals("Dhanush", podcastImpl.getPodcastByCelebrity(podlist,"Dhanush").get(0).getCelebrity());
        assertEquals("NTR", podcastImpl.getPodcastByCelebrity(podlist,"NTR").get(0).getCelebrity());
        //assertEquals(Date.valueOf("1947-08-15"), podcastImpl.getPodcastByCelebrity(podlist,"DSP").get(0).getPodDate());
    }

    //@Test
    //public void givenPodcastDateGetPodcastDetails() {
        //Date date1=Date.valueOf("1947-08-15"),date2=Date.valueOf("2000-08-15");
        //assertEquals("2016-08-18", podcastImpl.getPodcastByDate(podlist,'2016-08-18').get(0).getPublished_date());
       // assertEquals("arjith", podcastImpl.getPodcastByDate(podlist,date2).get(0).getCelebrity());
   // }


}

