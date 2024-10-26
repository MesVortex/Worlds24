package org.esports.Repository.Impl;

import org.esports.Model.Game;
import org.esports.Repository.Interface.GameRepository;
import org.esports.Utility.JPAUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class GameRepositoryImpl implements GameRepository {
    private final JPAUtil jpaUtil;

    public GameRepositoryImpl(JPAUtil jpaUtil) {
        this.jpaUtil = jpaUtil;
    }

    private EntityManager getEntityManager() {
        return jpaUtil.getEntityManager();
    }

    @Override
    public boolean save(Game game) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(game);
            em.getTransaction().commit();
            return true;
        } catch (RuntimeException e) {
            em.getTransaction().rollback();
            return false;
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
            return null;
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
            return true;
        } catch (RuntimeException e) {
            em.getTransaction().rollback();
            return false;
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
                return true;
            } else {
                em.getTransaction().rollback();
                return false;
            }
        } catch (RuntimeException e) {
            em.getTransaction().rollback();
            return false;
        } finally {
            em.close();
        }
    }
}
