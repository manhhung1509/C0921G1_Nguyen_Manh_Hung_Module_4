package song_application.repository.impl;

import song_application.model.Song;
import song_application.repository.SongRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class SongRepositoryImpl implements SongRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Song> findAll() {
        TypedQuery<Song> query = entityManager.createQuery("select c from Song c ", Song.class);
        return query.getResultList();
    }

    @Override
    public Song finById(Long id) {
        TypedQuery<Song> query = entityManager.createQuery("select c from Song c where c.id = :id", Song.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void save(Song song) {
        if (song.getId() != null) {
            entityManager.merge(song);
        } else {
            entityManager.persist(song);
        }
    }

    @Override
    public void remove(Long id) {
         Song customer = finById(id);
         if (customer != null){
             entityManager.remove(customer);
         }
    }

}
