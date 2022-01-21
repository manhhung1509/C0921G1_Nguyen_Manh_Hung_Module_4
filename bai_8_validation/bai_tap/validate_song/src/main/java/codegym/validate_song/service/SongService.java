package codegym.validate_song.service;


import codegym.validate_song.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface SongService {
    void Save(Song song);

    Optional<Song> findById(Long id);

    Page<Song> findAll(Pageable pageable);
}
