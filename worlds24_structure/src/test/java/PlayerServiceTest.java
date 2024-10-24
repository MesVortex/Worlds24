import org.esports.Model.Player;
import org.esports.Repository.Interface.PlayerRepository;
import org.esports.Service.PlayerService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class PlayerServiceTest {

    @Mock
    private PlayerRepository playerRepository;

    @Mock
    private Player player;

    @InjectMocks
    private PlayerService playerService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddPlayer() {
        String playerName = "Player1";
        int playerAge = 22;
        when(playerRepository.addPlayer(player)).thenReturn(true);

        boolean result = playerService.addPlayer(playerName, playerAge);

        assertTrue(result);
        verify(player).setNickname(playerName);
        verify(player).setAge(playerAge);
        verify(playerRepository, times(1)).addPlayer(player);
    }
}
