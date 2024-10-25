import org.esports.Model.Player;
import org.esports.Repository.Interface.PlayerRepository;
import org.esports.Service.PlayerService;
import static org.junit.Assert.*;
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

    @Test
    public void testUpdatePlayer() {
        Long playerId = 1L;
        String updatedName = "NewName";
        int updatedAge = 25;

        Player existingPlayer = new Player();
        existingPlayer.setId(playerId);
        existingPlayer.setNickname("OldName");
        existingPlayer.setAge(20);

        when(playerRepository.getPlayer(playerId)).thenReturn(existingPlayer);
        when(playerRepository.updatePlayer(existingPlayer)).thenReturn(true);

        boolean result = playerService.updatePlayer(playerId, updatedName, updatedAge);

        assertTrue(result);
        assertEquals(updatedName, existingPlayer.getNickname());
        assertEquals(updatedAge, existingPlayer.getAge());
        verify(playerRepository).getPlayer(playerId);
        verify(playerRepository).updatePlayer(existingPlayer);
    }

    @Test
    public void testDeletePlayer_SuccessfulDeletion() {
        Long playerId = 1L;
        Player player = new Player();
        player.setId(playerId);

        when(playerRepository.getPlayer(playerId)).thenReturn(player);
        when(playerRepository.deletePlayer(playerId)).thenReturn(true);

        boolean result = playerService.deletePlayer(playerId);

        assertTrue(result);
        verify(playerRepository).getPlayer(playerId);
        verify(playerRepository).deletePlayer(playerId);
    }
}
