package entity;

import java.sql.Time;
import java.util.Date;

public class Podcast {
    private int podcast_id;
    private String celebrity;
    private Time duration;
    private Date published_date;
    private String podcast_name;
    private String podcast_url;

    public Podcast(int podcast_id, String celebrity, Time duration, Date published_date, String podcast_name, String podcast_url) {
        this.podcast_id = podcast_id;
        this.celebrity = celebrity;
        this.duration = duration;
        this.published_date = published_date;
        this.podcast_name = podcast_name;
        this.podcast_url = podcast_url;
    }

    public int getPodcast_id() {
        return podcast_id;
    }

    public void setPodcast_id(int podcast_id) {
        this.podcast_id = podcast_id;
    }

    public String getCelebrity() {
        return celebrity;
    }

    public void setCelebrity(String celebrity) {
        this.celebrity = celebrity;
    }

    public Time getDuration() {
        return duration;
    }

    public void setDuration(Time duration) {
        this.duration = duration;
    }

    public Date getPublished_date() {
        return published_date;
    }

    public void setPublished_date(Date published_date) {
        this.published_date = published_date;
    }

    public String getPodcast_name() {
        return podcast_name;
    }

    public void setPodcast_name(String podcast_name) {
        this.podcast_name = podcast_name;
    }

    public String getPodcast_url() {
        return podcast_url;
    }

    public void setPodcast_url(String podcast_url) {
        this.podcast_url = podcast_url;
    }

    @Override
    public String toString() {
        return "Podcast{" +
                "podcast_id=" + podcast_id +
                ", celebrity='" + celebrity + '\'' +
                ", duration=" + duration +
                ", published_date=" + published_date +
                ", podcast_name='" + podcast_name + '\'' +
                ", podcast_url='" + podcast_url + '\'' +
                '}';
    }
}
