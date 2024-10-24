package org.esports.Repository.Impl;

import org.esports.Model.Game;
import org.esports.Repository.Interface.GameRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class GameRepositoryImpl implements GameRepository {
    private final EntityManagerFactory entityManagerFactory;

    public GameRepositoryImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    private EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    @Override
    public boolean save(Game game) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(game);
            em.getTransaction().commit();
            return true; // Success
        } catch (RuntimeException e) {
            em.getTransaction().rollback();
            return false; // Failure
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
            return null; // In case of error, return null
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
    public boolean update(Game game) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(game);
            em.getTransaction().commit();
            return true; // Success
        } catch (RuntimeException e) {
            em.getTransaction().rollback();
            return false; // Failure
        } finally {
            em.close();
        }
    }

    @Override
    public boolean delete(Long id) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Game game = em.find(Game.class, id);
            if (game != null) {
                em.remove(game);
                em.getTransaction().commit();
                return true; // Success
            } else {
                em.getTransaction().rollback();
                return false; // Game not found
            }
        } catch (RuntimeException e) {
            em.getTransaction().rollback();
            return false; // Failure
        } finally {
            em.close();
        }
    }

}
