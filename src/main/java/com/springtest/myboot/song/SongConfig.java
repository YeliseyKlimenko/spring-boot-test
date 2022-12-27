package com.springtest.myboot.song;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SongConfig {
    @Bean
    CommandLineRunner commandLineRunner(SongRepository songRepository) {
        return args -> {
            Song Africa = new Song(
                "Africa",
                "Toto",
                298,
                1982
            );

            Song September = new Song(
                    "September",
                    "Earth, Wind & Fire",
                    215,
                    1978
            );

            songRepository.saveAll(
                    List.of(September, Africa)
            );
        };
    }
}
