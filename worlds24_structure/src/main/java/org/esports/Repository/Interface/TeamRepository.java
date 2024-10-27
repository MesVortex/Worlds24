package org.esports.Repository.Interface;

import org.esports.Model.Team;
import java.util.List;

public interface TeamRepository {
    boolean addTeam(Team team);
    boolean updateTeam(Team team);
    Team getTeam(Long id);
    List<Team> getTeams();
}
