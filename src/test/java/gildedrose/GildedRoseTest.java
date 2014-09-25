package gildedrose;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyListOf;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.whenNew;
import gildedrose.inventorysystem.InventorySystem;
import gildedrose.items.Item;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.OngoingStubbing;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest( {GildedRose.class, InventorySystem.class} )
public class GildedRoseTest 
{
	@Mock
	private InventorySystem inventorySystem; 

	@Before
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testTheTruth()
	{
		assertTrue(true);
	}
	
	@Test
	public void shouldRunTheInventoryUpdate() throws Exception
	{
		whenCreatingInventorySystem().thenReturn(inventorySystem);
		
		GildedRose.main(null);
		
		verify(inventorySystem).update();
	}
	
	private OngoingStubbing<InventorySystem> whenCreatingInventorySystem() throws Exception
	{
		return whenNew(InventorySystem.class).withArguments(anyListOf(Item.class));
	}
}
