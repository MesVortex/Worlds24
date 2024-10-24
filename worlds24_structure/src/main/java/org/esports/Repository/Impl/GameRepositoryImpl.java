package org.esports.Repository.Impl;

import org.esports.Model.Game;
import org.esports.Repository.Interface.GameRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class GameRepositoryImpl implements GameRepository {
    private EntityManagerFactory entityManagerFactory;

    // Setter for dependency injection
    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    private EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    @Override
    public void save(Game game) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(game);
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    @Override
    public Game findById(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Game.class, id);
        } catch (RuntimeException e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    @Override
    public List<Game> findAll() {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("FROM Game", Game.class).getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public void update(Game game) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(game);
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    @Override
    public void delete(Long id) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Game game = em.find(Game.class, id);
            if (game != null) {
                em.remove(game);
            }
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }
}
