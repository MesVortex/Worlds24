package org.esports.Utility;

import org.esports.Model.Comment;
import org.esports.Model.Enum.TournamentStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CommentValidator {
    private static final Logger logger = LoggerFactory.getLogger(CommentValidator.class);
    private static Comment comment;

    public CommentValidator(Comment comment) {
        this.comment = comment;
    }

    public static String getCommentContent(Scanner scanner) {
        logger.info("type comment (must not exceed {} characters): ", comment.getMaximumLength());
        String content = scanner.nextLine();
        if (content.length() > comment.getMaximumLength()){
            logger.warn("Comment is too long");
            return null;
        }else{
            return content;
        }
    }
}