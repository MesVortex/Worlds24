package org.esports.Repository.Impl;

import org.esports.Model.Tournament;
import org.esports.Repository.Interface.TournamentRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class TournamentRepositoryImpl implements TournamentRepository {
    private EntityManagerFactory entityManagerFactory;

    // Setter for dependency injection
    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    private EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    @Override
    public void addTournament(Tournament tournament) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(tournament);
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    @Override
    public void updateTournament(Tournament tournament) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(tournament);
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    @Override
    public void deleteTournament(Long id) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Tournament tournament = em.find(Tournament.class, id);
            if (tournament != null) {
                em.remove(tournament);
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
    public Tournament getTournament(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tournament.class, id);
        } finally {
            em.close();
        }
    }

    @Override
    public List<Tournament> getTournaments() {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("FROM Tournament", Tournament.class).getResultList();
        } finally {
            em.close();
        }
    }
}
