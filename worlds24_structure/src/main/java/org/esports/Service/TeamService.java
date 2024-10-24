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

    public boolean addTeam(Team team) {
        return teamRepository.addTeam(team);
    }

    public boolean updateTeam(Team team) {
        return teamRepository.updateTeam(team);
    }

    public boolean deleteTeam(Long id) {
        return teamRepository.deleteTeam(id);
    }

    public Team getTeam(Long id) {
        return teamRepository.getTeam(id);
    }

    public List<Team> getTeams() {
        return teamRepository.getTeams();
    }

}
