package com.springtest.myboot.song;

import jakarta.persistence.*;


@Entity
@Table
public class Song {
    @Id
    @SequenceGenerator(
            name = "song_sequence",
            sequenceName = "song_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "song_sequence"
    )
    private Long id;
    private String name;
    private String artistName;
    private Integer length;
    private Integer releaseYear;

    public Song(Long id, String name, String artistName, Integer length, Integer releaseYear) {
        this.id = id;
        this.name = name;
        this.artistName = artistName;
        this.length = length;
        this.releaseYear = releaseYear;
    }

    public Song(String name, String artistName, Integer length, Integer releaseYear) {
        this.name = name;
        this.artistName = artistName;
        this.length = length;
        this.releaseYear = releaseYear;
    }

    public Song() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getArtistName() {
        return artistName;
    }

    public Integer getLength() {
        return length;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }
}
