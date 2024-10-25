import org.esports.Model.Team;
import org.esports.Repository.Interface.TeamRepository;
import org.esports.Service.TeamService;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class TeamServiceTest {

    @Mock
    private TeamRepository teamRepository;

    @Mock
    private Team team;

    @InjectMocks
    private TeamService teamService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddTeam() {
        String teamName = "Team A";
        int ranking = 1;

        when(teamRepository.addTeam(any(Team.class))).thenReturn(true);

        boolean result = teamService.addTeam(teamName, ranking);

        verify(team).setName(teamName);
        verify(team).setRanking(ranking);
        verify(teamRepository, times(1)).addTeam(team);
        assertTrue(result);
    }
}
