import org.esports.Model.Enum.TournamentStatus;
import org.esports.Model.Game;
import org.esports.Model.Team;
import org.esports.Model.Tournament;
import org.esports.Repository.Interface.TournamentRepository;
import org.esports.Service.TournamentService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class TournamentServiceTest {

    @Mock
    private TournamentRepository tournamentRepository;

    @Mock
    private Tournament tournament;

    @Mock
    private Team team;

    @InjectMocks
    private TournamentService tournamentService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddTournament() {
        String title = "Champions League";
        LocalDate startDate = LocalDate.of(2025, 5, 1);
        LocalDate endDate = LocalDate.of(2025, 5, 15);
        int numberOfSpectators = 5000;
        int estimatedDuration = 120;
        int breakBetweenGames = 10;
        int ceremonyTime = 30;
        TournamentStatus status = TournamentStatus.PLANNED;

        Game game = new Game();
        game.setId(1L);
        game.setName("LeagueOfLegends");

        when(tournamentRepository.addTournament(any(Tournament.class))).thenReturn(true);

        boolean result = tournamentService.addTournament(title, startDate, endDate, numberOfSpectators,
                estimatedDuration, breakBetweenGames, ceremonyTime,
                status, game);

        assertTrue(result);
        verify(tournamentRepository, times(1)).addTournament(tournament);
    }


    @Test
    public void testUpdateTournament() {
        Long tournamentId = 1L;
        String updatedTitle = "Updated Championship Tournament";
        LocalDate updatedStartDate = LocalDate.of(2024, 6, 15);
        LocalDate updatedEndDate = LocalDate.of(2024, 6, 25);
        int updatedNumberOfSpectators = 7000;
        int updatedEstimatedDuration = 150;
        int updatedBreakBetweenGames = 20;
        int updatedCeremonyTime = 40;
        TournamentStatus updatedStatus = TournamentStatus.IN_PROGRESS;

        Tournament existingTournament = new Tournament();
        existingTournament.setId(tournamentId);
        existingTournament.setTitle("Old Title");
        existingTournament.setStartDate(LocalDate.of(2024, 5, 10));
        existingTournament.setEndDate(LocalDate.of(2024, 5, 20));
        existingTournament.setNumberOfSpectators(5000);
        existingTournament.setEstimatedDuration(120);
        existingTournament.setBreakBetweenGames(15);
        existingTournament.setCeremonyTime(30);
        existingTournament.setStatus(TournamentStatus.PLANNED);

        when(tournamentRepository.getTournament(tournamentId)).thenReturn(existingTournament);
        when(tournamentRepository.updateTournament(existingTournament)).thenReturn(true);

        boolean result = tournamentService.updateTournament(
                tournamentId, updatedTitle, updatedStartDate, updatedEndDate,
                updatedNumberOfSpectators, updatedEstimatedDuration,
                updatedBreakBetweenGames, updatedCeremonyTime, updatedStatus
        );

        assertTrue(result);
        assertEquals(existingTournament.getTitle(), updatedTitle);
        assertEquals(existingTournament.getStartDate(), updatedStartDate);
        assertEquals(existingTournament.getEndDate(), updatedEndDate);
        assertEquals(existingTournament.getNumberOfSpectators(), updatedNumberOfSpectators);
        assertEquals(existingTournament.getEstimatedDuration(), updatedEstimatedDuration);
        assertEquals(existingTournament.getBreakBetweenGames(), updatedBreakBetweenGames);
        assertEquals(existingTournament.getCeremonyTime(), updatedCeremonyTime);
        assertSame(existingTournament.getStatus(), updatedStatus);

        verify(tournamentRepository).getTournament(tournamentId);
        verify(tournamentRepository).updateTournament(existingTournament);
    }

    @Test
    public void testAddTeamToTournament() {
        Long tournamentId = 1L;
        Team team = new Team();
        team.setId(2L);
        team.setName("Team A");

        Tournament existingTournament = new Tournament();
        existingTournament.setId(tournamentId);
        existingTournament.setTitle("Championship Tournament");
        existingTournament.setTeams(new ArrayList<>());

        when(tournamentRepository.getTournament(tournamentId)).thenReturn(existingTournament);
        when(tournamentRepository.updateTournament(existingTournament)).thenReturn(true);

        boolean result = tournamentService.addTeamToTournament(tournamentId, team);

        assertTrue(result);
        assertTrue(existingTournament.getTeams().contains(team));
        assertEquals(existingTournament, team.getTournament());
    }


    @Test
    public void testRemoveTeamFromTournament() {
        Long tournamentId = 1L;
        Long teamId = 2L;
        Team team = new Team();
        team.setId(teamId);
        team.setName("Team A");

        Tournament tournament = new Tournament();
        tournament.setId(tournamentId);
        tournament.setTeams(new ArrayList<>());
        tournament.getTeams().add(team);

        when(tournamentRepository.getTournament(tournamentId)).thenReturn(tournament);
        when(tournamentRepository.updateTournament(tournament)).thenReturn(true);

        boolean result = tournamentService.removeTeamFromTournament(tournamentId, team);

        assertTrue(result);
        assertFalse(tournament.getTeams().contains(team));
        verify(tournamentRepository, times(1)).updateTournament(tournament);
    }

    @Test
    public void testGetEstimatedDuration() {
        Long tournamentId = 1L;
        int expectedDuration = 240;

        when(tournamentRepository.calculateEstimatedDuration(tournamentId)).thenReturn(expectedDuration);

        int actualDuration = tournamentService.getEstimatedDuration(tournamentId);

        assertEquals(expectedDuration, actualDuration);
        verify(tournamentRepository, times(1)).calculateEstimatedDuration(tournamentId);
    }

}
