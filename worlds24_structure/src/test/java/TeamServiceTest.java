import org.esports.Model.Player;
import org.esports.Model.Team;
import org.esports.Repository.Interface.TeamRepository;
import org.esports.Service.TeamService;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void testUpdateTeam() {
        Long teamId = 1L;
        String updatedName = "Team B";
        int updatedRanking = 2;

        Team existingTeam = new Team();
        existingTeam.setId(teamId);
        existingTeam.setName("Team A");
        existingTeam.setRanking(1);

        when(teamRepository.getTeam(teamId)).thenReturn(existingTeam);
        when(teamRepository.updateTeam(existingTeam)).thenReturn(true);

        boolean result = teamService.updateTeam(teamId, updatedName, updatedRanking);

        assertTrue(result);
        assertEquals(updatedName, existingTeam.getName());
        assertEquals(updatedRanking, existingTeam.getRanking());
        verify(teamRepository).getTeam(teamId);
        verify(teamRepository).updateTeam(existingTeam);
    }

    @Test
    public void testAddPlayerToTeam() {
        Long teamId = 1L;
        Team team = new Team();
        team.setId(teamId);
        team.setPlayers(new ArrayList<>());

        Player player = new Player();
        player.setTeam(null);

        when(teamRepository.getTeam(teamId)).thenReturn(team);
        when(teamRepository.updateTeam(team)).thenReturn(true);

        boolean result = teamService.addPlayerToTeam(teamId, player);

        assertTrue(result);
        assertTrue(team.getPlayers().contains(player));
        assertEquals(team, player.getTeam());
    }

    @Test
    public void testRemovePlayerFromTeam() {
        Long teamId = 1L;
        Team team = new Team();
        team.setId(teamId);
        Player player = new Player();
        player.setTeam(team);

        List<Player> players = new ArrayList<>();
        players.add(player);
        team.setPlayers(players);

        when(teamRepository.getTeam(teamId)).thenReturn(team);
        when(teamRepository.updateTeam(team)).thenReturn(true);

        boolean result = teamService.removePlayerFromTeam(teamId, player);

        assertTrue(result);
        assertFalse(team.getPlayers().contains(player));
        assertNull(player.getTeam());
    }
}
