import org.esports.Model.Game;
import org.esports.Repository.Interface.GameRepository;
import org.esports.Service.GameService;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class GameServiceTest {

    @Mock
    private GameRepository gameRepository;

    @Mock
    private Game game;

    @InjectMocks
    private GameService gameService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateGame() {
        String gameName = "New Game";
        int gameDifficulty = 3;
        int averageDuration = 45;

        when(gameRepository.save(game)).thenReturn(true);

        boolean result = gameService.addGame(gameName, gameDifficulty, averageDuration);

        assertTrue(result);
        verify(gameRepository, times(1)).save(game);
    }
}
