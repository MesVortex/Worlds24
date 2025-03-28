package org.esports.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
@Table(name = "teams")
public class Team {
    private static final Logger logger = LoggerFactory.getLogger(Team.class);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "ranking")
    private int ranking;

    @ManyToOne
    @JoinColumn(name = "tournamentID")
    private Tournament tournament;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "team", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<Player> players;

    public Team() {

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

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    public void showDetails() {
        logger.info("Team ID: {}", id);
        logger.info("Name: {}", name);
        logger.info("Ranking: {}", ranking);
        logger.info("Players:");

        if (players != null && !players.isEmpty()) {
            for (Player player : players) {
                logger.info(" - {} (ID: {}, Age: {})", player.getNickname(), player.getId(), player.getAge());
            }
        } else {
            logger.info(" No players in this team.");
        }
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ranking=" + ranking +
                ", players=" + players +
                '}';
    }
}
