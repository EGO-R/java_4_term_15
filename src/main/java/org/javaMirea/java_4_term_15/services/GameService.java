package org.javaMirea.java_4_term_15.services;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.javaMirea.java_4_term_15.entities.Game;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GameService {
    private final SessionFactory sessionFactory;
    private Session session;

    @PostConstruct
    void init() {
        this.session = sessionFactory.openSession();
    }

    public List<Game> getGames() {
        return session.createQuery("select g from Game g", Game.class).getResultList();
    }

    public void save(Game game) {
        var transaction = session.beginTransaction();
        try {
            session.saveOrUpdate(game);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }

    public void delete(Game game) {
        var transaction = session.beginTransaction();
        try {
            session.delete(game);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }
}
