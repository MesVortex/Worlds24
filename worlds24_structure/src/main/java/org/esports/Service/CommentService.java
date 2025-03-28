package org.esports.Service;

import org.esports.Model.Comment;
import org.esports.Model.Tournament;
import org.esports.Repository.Interface.CommentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;

public class CommentService {
    private static final Logger logger = LoggerFactory.getLogger(CommentService.class);
    private CommentRepository commentRepository;
    private Comment comment;

    public CommentService(CommentRepository commentRepository, Comment comment) {
        this.commentRepository = commentRepository;
        this.comment = comment;
    }

    public boolean addComment(String content, Tournament tournament){
        comment.setContent(content);
        comment.setCreationDate(LocalDate.now());
        comment.setTournament(tournament);

        return(commentRepository.save(comment));
    }
}
