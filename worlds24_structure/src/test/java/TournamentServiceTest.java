import org.esports.Model.Enum.TournamentStatus;
import org.esports.Model.Tournament;
import org.esports.Repository.Interface.TournamentRepository;
import org.esports.Service.TournamentService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class TournamentServiceTest {

    @Mock
    private TournamentRepository tournamentRepository;

    @Mock
    private Tournament tournament;

    @InjectMocks
    private TournamentService tournamentService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddTournament() {
        String title = "Championship Tournament";
        LocalDate startDate = LocalDate.of(2024, 5, 10);
        LocalDate endDate = LocalDate.of(2024, 5, 20);
        int numberOfSpectators = 5000;
        int estimatedDuration = 120;
        int breakBetweenGames = 15;
        int ceremonyTime = 30;
        TournamentStatus status = TournamentStatus.PLANNED;

        when(tournamentRepository.addTournament(tournament)).thenReturn(true);

        boolean result = tournamentService.addTournament(title, startDate, endDate, numberOfSpectators, estimatedDuration, breakBetweenGames, ceremonyTime, status);

        assertTrue(result);
        verify(tournamentRepository, times(1)).addTournament(tournament);
    }
}
