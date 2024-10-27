package org.esports.Repository.Impl;

import org.esports.Model.Team;
import org.esports.Repository.Interface.TeamRepository;
import org.esports.Utility.JPAUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class TeamRepositoryImpl implements TeamRepository {
    private final JPAUtil jpaUtil;

    public TeamRepositoryImpl(JPAUtil jpaUtil) {
        this.jpaUtil = jpaUtil;
    }

    private EntityManager getEntityManager() {
        return jpaUtil.getEntityManager();
    }

    @Override
    public boolean addTeam(Team team) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(team);
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
    public boolean updateTeam(Team team) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(team);
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
