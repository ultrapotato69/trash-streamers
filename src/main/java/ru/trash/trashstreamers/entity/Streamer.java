package ru.trash.trashstreamers.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.*;
import java.util.stream.Collectors;


//Добавить еще один сет с оскорбительными кличками.
@Entity
@Table(name = "streamer")
public class Streamer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "streamer_sequence")
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "pseudonym", nullable = false)
    private String pseudonym;
    @Column(name = "description", columnDefinition="text")
    private String description;
    @Column(name = "firstname")
    private String firstname;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "picture_name")
    private String pictureName;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(joinColumns =
        @JoinColumn(foreignKey = @ForeignKey(name = "streamer_other_pseudonym_fk")))
    @Column(name = "other_pseudonym")
    private Set<String> otherPseudonyms = new LinkedHashSet<>();

    @ManyToMany
    @Fetch(FetchMode.SUBSELECT)
    @JoinTable(name = "streamer_video",
            joinColumns = @JoinColumn(name = "streamer_id", foreignKey = @ForeignKey(name = "streamer_fk")),
            inverseJoinColumns = @JoinColumn(name = "video_id") )
    private List<Video> videos = new ArrayList<>();

    public Streamer() {
    }

    public Streamer(String pseudonym, String firstname, String lastname) {
        this.id = null;
        this.pseudonym = pseudonym;
        this.firstname = firstname;
        this.lastname = lastname;
        this.otherPseudonyms = new HashSet<>();
    }

    public Streamer(Long id, String pseudonym, String description,
                    String firstname, String lastname,
                    String pictureName, Set<String> otherPseudonyms, List<Video> videos) {
        this.id = id;
        this.pseudonym = pseudonym;
        this.description = description;
        this.firstname = firstname;
        this.lastname = lastname;
        this.pictureName = pictureName;
        this.otherPseudonyms = otherPseudonyms;
        this.videos = videos;
    }

    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void addVideo(Video video) {
        if(this.getVideos() == null) {
            this.videos = new ArrayList<>();
        }
        this.videos.add(video);
    }
    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

    public Set<String> getOtherPseudonyms() {
        return otherPseudonyms;
    }

    public void setOtherPseudonyms(Set<String> otherPseudonym) {
        this.otherPseudonyms = otherPseudonym;
    }


    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }


    public String getPseudonym() {
        return pseudonym;
    }

    public void setPseudonym(String pseudonym) {
        this.pseudonym = pseudonym;
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


    @Override
    public String toString() {
        String otherPseudonymsStr = "null";
        if(otherPseudonyms != null) {
            otherPseudonymsStr = otherPseudonyms.stream().collect(Collectors.joining(" , "));
        }
        return "Streamer{" +
                "id=" + id +
                ", pseudonym='" + pseudonym + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                "\notherNames= [" +
                otherPseudonymsStr  + "]" +
                "\ndescription='" + description + '\'' +
                "}\n";
    }
}