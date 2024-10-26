package org.esports.Service;

import org.esports.Model.Player;
import org.esports.Model.Team;
import org.esports.Repository.Interface.TeamRepository;

import java.util.List;

public class TeamService {
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
            System.out.println("Team not found!");
            return false;
        }

        existingTeam.setName(name);
        existingTeam.setRanking(ranking);

        return teamRepository.updateTeam(existingTeam);
    }

    public boolean addPlayerToTeam(Long teamId, Player player) {
        Team team = teamRepository.getTeam(teamId);

        if (team == null) {
            System.out.println("Team not found.");
            return false;
        }

        team.getPlayers().add(player);
        player.setTeam(team);

        return teamRepository.updateTeam(team);
    }

    public boolean removePlayerFromTeam(Long teamId, Player player) {
        Team team = teamRepository.getTeam(teamId);

        if (team == null) {
            System.out.println("Team not found.");
            return false;
        }

        if (!team.getPlayers().remove(player)) {
            System.out.println("Player is not part of this team.");
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
