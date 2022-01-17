package song_application.service;

import song_application.model.Song;

import java.util.List;

public interface SongService {
    List<Song> findAll();

    Song finById(Long id);

    void save(Song customer);

    void remove(Long id);
}
