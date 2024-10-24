package org.esports.Repository.Impl;

import org.esports.Model.Player;
import org.esports.Repository.Interface.PlayerRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class PlayerRepositoryImpl implements PlayerRepository {
    private EntityManagerFactory entityManagerFactory;

    // Setter for dependency injection
    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    private EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    @Override
    public void addPlayer(Player player) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(player);
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    @Override
    public void updatePlayer(Player player) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(player);
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    @Override
    public void deletePlayer(Long id) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Player player = em.find(Player.class, id);
            if (player != null) {
                em.remove(player);
            }
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    @Override
    public Player getPlayer(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Player.class, id);
        } finally {
            em.close();
        }
    }

    @Override
    public List<Player> getPlayers() {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("FROM Player", Player.class).getResultList();
        } finally {
            em.close();
        }
    }
}
