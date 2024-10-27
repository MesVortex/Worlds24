package org.esports.Repository.Impl;

import org.esports.Model.Tournament;
import org.esports.Repository.Interface.TournamentRepository;
import org.esports.Utility.JPAUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class TournamentRepositoryImpl implements TournamentRepository {
    private final JPAUtil jpaUtil;

    public TournamentRepositoryImpl(JPAUtil jpaUtil) {
        this.jpaUtil = jpaUtil;
    }

    private EntityManager getEntityManager() {
        return jpaUtil.getEntityManager();
    }

    @Override
    public boolean addTournament(Tournament tournament) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(tournament);
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
    public boolean updateTournament(Tournament tournament) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(tournament);
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
    public boolean deleteTournament(Long id) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Tournament tournament = em.find(Tournament.class, id);
            if (tournament != null) {
                em.remove(tournament);
                em.getTransaction().commit();
                return true; // Success
            } else {
                em.getTransaction().rollback();
                return false; // Tournament not found
            }
        } catch (RuntimeException e) {
            em.getTransaction().rollback();
            return false; // Failure
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

    @Override
    public int calculateEstimatedDuration(Long tournamentId) {
        Tournament tournament = getTournament(tournamentId);
        int numberOfTeams = tournament.getTeams().size();
        int averageMatchDuration = tournament.getGame().getAverageDuration();
        int breakBetweenGames = tournament.getBreakBetweenGames();

        return (numberOfTeams * averageMatchDuration) + breakBetweenGames;
    }
}
