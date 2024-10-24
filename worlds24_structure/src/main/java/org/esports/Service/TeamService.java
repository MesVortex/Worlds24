package org.esports.Service;

import org.esports.Model.Team;
import org.esports.Repository.Interface.TeamRepository;

import java.util.List;

public class TeamService {
    private final TeamRepository teamRepository;

    // Constructor for dependency injection
    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public void addTeam(Team team) {
        teamRepository.addTeam(team);
    }

    public void updateTeam(Team team) {
        teamRepository.updateTeam(team);
    }

    public void deleteTeam(Long id) {
        teamRepository.deleteTeam(id);
    }

    public Team getTeam(Long id) {
        return teamRepository.getTeam(id);
    }

    public List<Team> getTeams() {
        return teamRepository.getTeams();
    }
}
