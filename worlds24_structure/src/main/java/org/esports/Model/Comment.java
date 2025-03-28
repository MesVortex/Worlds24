package org.esports.Model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String content;
    private LocalDate creationDate;
    private Integer MaximumLength;
    @ManyToOne
    @JoinColumn(name = "tournamentID")
    private Tournament tournament;

    public Comment(int id, String content, LocalDate creationDate, Integer maximumLength) {
        this.id = id;
        this.content = content;
        this.creationDate = creationDate;
        MaximumLength = maximumLength;
    }

    public Comment() {
    }

    public int getId() {
        return id;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getMaximumLength() {
        return MaximumLength;
    }

    public void setMaximumLength(Integer maximumLength) {
        MaximumLength = maximumLength;
    }
}
