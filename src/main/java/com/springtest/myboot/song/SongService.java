package com.springtest.myboot.song;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongService {

    private final SongRepository songRepository;

    @Autowired
    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }
    public List<Song> getSong() {
        return songRepository.findAll();
    }

    public void addNewSong(Song song) throws Exception {
        Optional<Song> songOptional = songRepository.findSongByName(song.getName());
        if (songOptional.isEmpty()) {
            songRepository.save(song);
        } else {
            throw new Exception("Song already exists");
        }
    }

    public void deleteSong(Long songId) throws Exception {
        if (!songRepository.existsById(songId)) {
            throw new Exception("The requested song does not exist. Song id = " + songId);
        } else {
            songRepository.deleteById(songId);
        }
    }

    @Transactional
    public void updateSong(Long songId, String artistName) throws Exception {
        Song song = songRepository.findById(songId).orElseThrow(() -> new Exception("Song does not exist"));
        if (artistName != null && !artistName.isEmpty()) {
            song.setArtistName(artistName);
        }
    }
}
