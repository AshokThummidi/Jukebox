package Operations;

import entity.Podcast;

import java.util.*;
import java.util.stream.Collectors;

public class PodcastOperations {
    public List<Podcast> getPodcastByCelebrity(List<Podcast> allPodcastList, String celebrity_name) {
        List<Podcast> searchAndsortByCelebrity = new ArrayList<Podcast>();
        searchAndsortByCelebrity = allPodcastList.stream()
                .filter(p -> p.getCelebrity().equalsIgnoreCase(celebrity_name)).sorted((o1, o2)->o1.getCelebrity().compareToIgnoreCase(o2.getCelebrity())).collect(Collectors.toList());
        return searchAndsortByCelebrity;
    }
    public List<Podcast> getPodcastByDate(List<Podcast> allPodcastList, Date publishedDate) {
        List<Podcast> searchAndsortByDate = new ArrayList<Podcast>();
        searchAndsortByDate = allPodcastList.stream()
                .filter(p -> p.getPublished_date().equals(publishedDate))
                .collect(Collectors.toList());
        return searchAndsortByDate;
    }
    public List<Podcast> searchByPodcastId(List<Podcast> allPodcastList, int podcastId)
    {
        List<Podcast> searchById=new ArrayList<>();
        searchById=allPodcastList.stream()
                .filter(p->p.getPodcast_id()==podcastId).
                sorted((o1,o2)->o1.getPodcast_name().compareToIgnoreCase(o2.getPodcast_name())).
                collect(Collectors.toList());
        return searchById;
    }

    public void display(List<Podcast> podList) {
        podList=podList.stream().sorted((o1,o2)->o1.getPodcast_name().compareToIgnoreCase(o2.getPodcast_name())).collect(Collectors.toList());
        podList.forEach(i-> System.out.println(i));
    }


}

