package org.esports.Service;

import org.esports.Repository.Interface.TeamRepository;

public class TeamService {
    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }
}
