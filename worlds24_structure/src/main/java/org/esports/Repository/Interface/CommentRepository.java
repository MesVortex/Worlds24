package org.esports.Repository.Interface;

import org.esports.Model.Comment;

public interface CommentRepository {
    boolean save(Comment comment);
}
