package org.esports.Repository.Impl;

import org.esports.Model.Comment;
import org.esports.Model.Game;
import org.esports.Repository.Interface.CommentRepository;
import org.esports.Utility.JPAUtil;

import javax.persistence.EntityManager;

public class CommentRepositoryImpl implements CommentRepository {
    private final JPAUtil jpaUtil;

    public CommentRepositoryImpl(JPAUtil jpaUtil) {
        this.jpaUtil = jpaUtil;
    }

    private EntityManager getEntityManager() {
        return jpaUtil.getEntityManager();
    }

    @Override
    public boolean save(Comment comment) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(comment);
            em.getTransaction().commit();
            return true;
        } catch (RuntimeException e) {
            em.getTransaction().rollback();
            return false;
        } finally {
            em.close();
        }
    }
}
