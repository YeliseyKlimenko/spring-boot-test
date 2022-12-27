package com.springtest.myboot.song;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/song")
public class SongController {
    private final SongService songService;

    @Autowired
    public SongController(SongService songService) {
        this.songService = songService;
    }

    @GetMapping
    public List<Song> getSong() {
        return songService.getSong();
    }

    @PostMapping
    public void registerNewSong(@RequestBody Song song) throws Exception {
        songService.addNewSong(song);
    }

    @DeleteMapping(path = "{songId}")
    public void deleteSong(@PathVariable("songId") Long songId) throws Exception {
        songService.deleteSong(songId);
    }

    @PutMapping(path = "{songId}")
    public void changeSongArtistName(@PathVariable("songId") Long songId,
                                     @RequestParam String artistName) throws Exception {
        songService.updateSong(songId, artistName);
    }
}
