package org.esports.Repository.Interface;

import org.esports.Model.Team;
import java.util.List;

public interface TeamRepository {
    void addTeam(Team team);
    void updateTeam(Team team);
    void deleteTeam(Long id);
    Team getTeam(Long id);
    List<Team> getTeams();
}
