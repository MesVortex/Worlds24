package org.esports.Model;

import org.esports.Model.Enum.TournamentStatus;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.FutureOrPresent;
import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
@Table(name = "tournaments")
public class Tournament {
    private static final Logger logger = LoggerFactory.getLogger(Tournament.class);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "title", length = 200, nullable = false)
    private String title;

    @NotNull
    @FutureOrPresent
    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @NotNull
    @FutureOrPresent
    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @Column(name = "number_of_spectators")
    private int numberOfSpectators;

    @OneToMany(mappedBy = "tournament", fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Team> teams;

    @Column(name = "estimated_duration")
    private int estimatedDuration;

    @Column(name = "break_between_games")
    private int breakBetweenGames;

    @Column(name = "ceremony_time")
    private int ceremonyTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private TournamentStatus status;

    @ManyToOne
    @JoinColumn(name = "gameID")
    @NotNull(message = "game cannot be null")
    private Game game;

    public Tournament() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getNumberOfSpectators() {
        return numberOfSpectators;
    }

    public void setNumberOfSpectators(int numberOfSpectators) {
        this.numberOfSpectators = numberOfSpectators;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public int getEstimatedDuration() {
        return estimatedDuration;
    }

    public void setEstimatedDuration(int estimatedDuration) {
        this.estimatedDuration = estimatedDuration;
    }

    public int getBreakBetweenGames() {
        return breakBetweenGames;
    }

    public void setBreakBetweenGames(int breakBetweenGames) {
        this.breakBetweenGames = breakBetweenGames;
    }

    public int getCeremonyTime() {
        return ceremonyTime;
    }

    public void setCeremonyTime(int ceremonyTime) {
        this.ceremonyTime = ceremonyTime;
    }

    public TournamentStatus getStatus() {
        return status;
    }

    public void setStatus(TournamentStatus status) {
        this.status = status;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public void showDetails() {
        logger.info("Tournament ID: {}", id);
        logger.info("Title: {}", title);
        logger.info("Game: {}", game.getName());
        logger.info("Start Date: {}", startDate);
        logger.info("End Date: {}", endDate);
        logger.info("Number of Spectators: {}", numberOfSpectators);
        logger.info("Estimated Duration: {} minutes", estimatedDuration);
        logger.info("Break Between Games: {} minutes", breakBetweenGames);
        logger.info("Ceremony Time: {} minutes", ceremonyTime);
        logger.info("Status: {}", status);
        logger.info("Teams:");

        if (teams != null && !teams.isEmpty()) {
            for (Team team : teams) {
                logger.info(" - Team Name: {} (Ranking: {})", team.getName(), team.getRanking());
            }
        } else {
            logger.info(" No teams assigned to this tournament.");
        }
    }

    @Override
    public String toString() {
        return "Tournament{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", numberOfSpectators=" + numberOfSpectators +
                ", teams=" + teams +
                ", estimatedDuration=" + estimatedDuration +
                ", breakBetweenGames=" + breakBetweenGames +
                ", ceremonyTime=" + ceremonyTime +
                ", status=" + status +
                '}';
    }
}
