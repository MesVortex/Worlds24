package org.esports.Model;

import org.esports.Model.Enum.TournamentStatus;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.FutureOrPresent;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tournaments")
public class Tournament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "title", length = 200, nullable = false)
    private String title;

    @NotNull
    @FutureOrPresent
    @Column(name = "start_date", nullable = false)
    private Date startDate;

    @NotNull
    @FutureOrPresent
    @Column(name = "end_date", nullable = false)
    private Date endDate;

    @Column(name = "number_of_spectators")
    private int numberOfSpectators;

    @OneToMany
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

    public Tournament() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public @NotNull @Size(min = 1, max = 200) String getTitle() {
        return title;
    }

    public void setTitle(@NotNull @Size(min = 1, max = 200) String title) {
        this.title = title;
    }

    public @NotNull @FutureOrPresent Date getStartDate() {
        return startDate;
    }

    public void setStartDate(@NotNull @FutureOrPresent Date startDate) {
        this.startDate = startDate;
    }

    public @NotNull @FutureOrPresent Date getEndDate() {
        return endDate;
    }

    public void setEndDate(@NotNull @FutureOrPresent Date endDate) {
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
