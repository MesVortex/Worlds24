package org.esports.Service;

import org.esports.Model.Player;
import org.esports.Model.Team;
import org.esports.Repository.Interface.TeamRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class TeamService {
    private static final Logger logger = LoggerFactory.getLogger(TeamService.class);
    private final TeamRepository teamRepository;
    private Team team;

    // Constructor for dependency injection
    public TeamService(TeamRepository teamRepository, Team team) {
        this.teamRepository = teamRepository;
        this.team = team;
    }

    public boolean addTeam(String name, int ranking) {
        team.setName(name);
        team.setRanking(ranking);
        return teamRepository.addTeam(team);
    }

    public boolean updateTeam(Long teamId, String name, int ranking) {
        Team existingTeam = teamRepository.getTeam(teamId);

        if (existingTeam == null) {
            logger.warn("Team with ID {} not found!", teamId);
            return false;
        }

        existingTeam.setName(name);
        existingTeam.setRanking(ranking);
        return teamRepository.updateTeam(existingTeam);
    }

    public boolean addPlayerToTeam(Long teamId, Player player) {
        Team team = teamRepository.getTeam(teamId);

        if (team == null) {
            logger.warn("Team with ID {} not found.", teamId);
            return false;
        }

        team.getPlayers().add(player);
        player.setTeam(team);
        return teamRepository.updateTeam(team);
    }

    public boolean removePlayerFromTeam(Long teamId, Player player) {
        Team team = teamRepository.getTeam(teamId);

        if (team == null) {
            logger.warn("Team with ID {} not found.", teamId);
            return false;
        }

        if (!team.getPlayers().remove(player)) {
            logger.warn("Player {} is not part of team {}", player.getNickname(), team.getName());
            return false;
        }

        player.setTeam(null);
        return teamRepository.updateTeam(team);
    }

    public Team getTeam(Long id) {
        return teamRepository.getTeam(id);
    }

    public List<Team> getTeams() {
        return teamRepository.getTeams();
    }
}
