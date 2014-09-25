package gildedrose.inventorysystem;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.whenNew;
import gildedrose.items.Item;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.OngoingStubbing;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest( {InventorySystem.class, InventoryFactory.class, Inventory.class} )
public class InventorySystemTest
{
	private List<Item> items;
	
	private InventorySystem underTest;

	@Mock
	private Inventory inventory;
	
	@Mock
	private InventoryFactory inventoryFactory;
	
	@Before
	public void setup() throws Exception
	{
		MockitoAnnotations.initMocks(this);
		whenCreatingInventoryFactory().thenReturn(inventoryFactory);
		whenCreatingInventoryFrom(items).thenReturn(inventory);
		underTest = new InventorySystem(items);
	}
	
	private OngoingStubbing<Inventory> whenCreatingInventoryFrom(List<Item> items)
	{
		return when(inventoryFactory.createFrom(items));
	}
	
	private OngoingStubbing<InventoryFactory> whenCreatingInventoryFactory() throws Exception
	{
		return whenNew(InventoryFactory.class).withAnyArguments();
	}
	
	@Test
	public void shouldUpdateTheItems()
	{
		underTest.update();
		
		verify(inventory).update();
	}
}
