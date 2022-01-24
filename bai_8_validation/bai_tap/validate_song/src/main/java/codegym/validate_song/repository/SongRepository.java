package codegym.validate_song.repository;

import codegym.validate_song.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends JpaRepository <Song, Long> {
}