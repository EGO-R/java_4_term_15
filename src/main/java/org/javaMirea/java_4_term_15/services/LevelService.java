package org.javaMirea.java_4_term_15.services;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.javaMirea.java_4_term_15.entities.Game;
import org.javaMirea.java_4_term_15.entities.Level;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LevelService {
    private final SessionFactory sessionFactory;
    private Session session;

    @PostConstruct
    void init() {
        this.session = sessionFactory.openSession();
    }

    public List<Level> getLevels() {
        return session.createQuery("select l from Level l", Level.class).getResultList();
    }

    public void save(Level level) {
        var transaction = session.beginTransaction();
        try {
            session.saveOrUpdate(level);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }

    public void delete(Level level) {
        var transaction = session.beginTransaction();
        try {
            session.delete(level);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }
}
