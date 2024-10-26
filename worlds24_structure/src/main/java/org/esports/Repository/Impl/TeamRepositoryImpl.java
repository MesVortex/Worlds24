package org.esports.Repository.Impl;

import org.esports.Model.Team;
import org.esports.Repository.Interface.TeamRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class TeamRepositoryImpl implements TeamRepository {
    private final EntityManagerFactory entityManagerFactory;

    public TeamRepositoryImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    private EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    @Override
    public boolean addTeam(Team team) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(team);
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
    public boolean updateTeam(Team team) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(team);
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
    public boolean deleteTeam(Long id) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Team team = em.find(Team.class, id);
            if (team != null) {
                em.remove(team);
                em.getTransaction().commit();
                return true; // Success
            } else {
                em.getTransaction().rollback();
                return false; // Team not found
            }
        } catch (RuntimeException e) {
            em.getTransaction().rollback();
            return false; // Failure
        } finally {
            em.close();
        }
    }

    @Override
    public Team getTeam(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Team.class, id);
        } finally {
            em.close();
        }
    }

    @Override
    public List<Team> getTeams() {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("FROM Team", Team.class).getResultList();
        } finally {
            em.close();
        }
    }
}
