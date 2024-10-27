package org.esports.Model;

import org.esports.Model.Enum.TournamentStatus;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.FutureOrPresent;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tournaments")
public class Tournament {

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
        System.out.println("Tournament ID: " + id);
        System.out.println("Title: " + title);
        System.out.println("Game: " + game.getName());
        System.out.println("Start Date: " + startDate);
        System.out.println("End Date: " + endDate);
        System.out.println("Number of Spectators: " + numberOfSpectators);
        System.out.println("Estimated Duration: " + estimatedDuration + " minutes");
        System.out.println("Break Between Games: " + breakBetweenGames + " minutes");
        System.out.println("Ceremony Time: " + ceremonyTime + " minutes");
        System.out.println("Status: " + status);
        System.out.println("Teams:");

        if (teams != null && !teams.isEmpty()) {
            for (Team team : teams) {
                System.out.println(" - Team Name: " + team.getName() + " (Ranking: " + team.getRanking() + ")");
            }
        } else {
            System.out.println(" No teams assigned to this tournament.");
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
