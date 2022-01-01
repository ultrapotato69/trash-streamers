package ru.trash.trashstreamers.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "video")
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "video_sequence")
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String youtubeId;
    private String description;

    @ManyToMany
    @Fetch(FetchMode.SUBSELECT)
    @JoinTable(name = "streamer_video",
            joinColumns = @JoinColumn(name = "video_id", foreignKey = @ForeignKey(name = "video_fk")),
            inverseJoinColumns = @JoinColumn(name = "streamer_id"))
    @JsonIgnore
    private List<Streamer> streamers = new ArrayList<>();

    public List<Streamer> getStreamers() {
        return streamers;
    }

    public void setStreamers(List<Streamer> streamers) {
        this.streamers = streamers;
    }

    public String getYoutubeId() {
        return youtubeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setYoutubeId(String path) {
        this.youtubeId = path;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
