package org.esports.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
@Table(name = "games")
public class Game {
    private static final Logger logger = LoggerFactory.getLogger(Game.class);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "difficulty")
    private int difficulty;

    @Column(name = "average_duration")
    private int averageDuration;

    @OneToMany(mappedBy = "game", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    private List<Tournament> tournaments;

    public Game() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public int getAverageDuration() {
        return averageDuration;
    }

    public void setAverageDuration(int averageDuration) {
        this.averageDuration = averageDuration;
    }

    public List<Tournament> getTournaments() {
        return tournaments;
    }

    public void setTournaments(List<Tournament> tournaments) {
        this.tournaments = tournaments;
    }

    public void showDetails() {
        logger.info("Game ID: {}", id);
        logger.info("Name: {}", name);
        logger.info("Difficulty: {}", difficulty);
        logger.info("Average Duration: {} minutes", averageDuration);
        logger.info("Tournaments:");

        if (tournaments != null && !tournaments.isEmpty()) {
            for (Tournament tournament : tournaments) {
                logger.info(" - Tournament Title: {} (ID: {}, Start Date: {})",
                        tournament.getTitle(), tournament.getId(), tournament.getStartDate());
            }
        } else {
            logger.info(" No tournaments associated with this game.");
        }
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", difficulty=" + difficulty +
                ", averageDuration=" + averageDuration +
                ", tournaments=" + tournaments +
                '}';
    }
}
