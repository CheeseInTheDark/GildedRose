package gildedrose.inventorysystem;

import static java.util.Collections.singletonList;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.argThat;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.whenNew;
import gildedrose.items.Item;
import gildedrose.items.StoreItem;
import gildedrose.items.StoreItemFactory;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.OngoingStubbing;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({InventoryFactory.class, Inventory.class})
public class InventoryFactoryTest
{
	@InjectMocks
	private InventoryFactory underTest;
	
	private List<Item> items;
	
	@Mock
	private Item item;
	
	@Mock
	private StoreItem storeItem;
	
	@Mock
	private StoreItemFactory storeItemFactory;
	
	@Mock
	private Inventory expectedInventory;
	
	@Before
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
		
		items = singletonList(item);
	}
	
	@Test
	public void shouldCreateInventoryWithStoreItems() throws Exception
	{
		whenConverting(item).thenReturn(storeItem);
		whenCreatingInventoryUsing(storeItem).thenReturn(expectedInventory);
		
		Inventory actualInventory = underTest.createFrom(items);

		assertThat(actualInventory, is(expectedInventory));
	}
	
	private OngoingStubbing<StoreItem> whenConverting(Item item)
	{
		return when(storeItemFactory.createFrom(item));
	}
	
	private OngoingStubbing<Inventory> whenCreatingInventoryUsing(StoreItem storeItem) throws Exception
	{
		return whenNew(Inventory.class).withArguments(argThat(hasItem(storeItem)));
	}
}
