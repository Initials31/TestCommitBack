package prono;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

import com.apside.prono.model.Player;
import com.apside.prono.repository.PlayerDao;
import com.apside.prono.service.PlayerServiceImpl;


public class PlayerTest {
	
	@Mock
    private PlayerDao playerDao;
	
	@InjectMocks
    private PlayerServiceImpl playerServiceImpl;
	
	@Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
	
	Player playerMock = new Player(1L, "Emilie", "Malo", "malo@gmail.com", new Date());
	List<Player> players = new ArrayList<>();

	
	@Test
	public void canGetById() throws Exception {
		
		when(playerDao.getById(1L)).thenReturn(playerMock);		
		
		Player player = playerServiceImpl.getById(1L);
		
		assertEquals("Emilie", player.getFirstName());
		
	}
	
	@Test
	public void canGetAllPlayers() throws Exception {
		
//		players.addAll(0, "Genia", "Antoine", "antoine@gmail.com", new Date(),(1, "Genia", "Antoine", "antoine@gmail.com", new Date());
//		when(playerDao.getAllPlayers()).thenReturn(players);		
//			
//		players = playerServiceImpl.getAllPlayers();
//		
//		assertEquals("", players.get(0).getFirstName());
//		
	}

}
