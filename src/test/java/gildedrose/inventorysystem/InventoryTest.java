package gildedrose.inventorysystem;

import static org.mockito.Mockito.verify;
import gildedrose.items.StoreItem;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class InventoryTest
{
	private Inventory underTest;
	
	private List<StoreItem> storeItems;
	
	@Mock
	private StoreItem firstItem;
	
	@Mock
	private StoreItem secondItem;
	
	@Before
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
		
		initializeStoreItems();		
		
		underTest = new Inventory(storeItems);
	}
	
	private void initializeStoreItems()
	{
		storeItems = new ArrayList<StoreItem>();
		storeItems.add(firstItem);
		storeItems.add(secondItem);
	}

	@Test
	public void shouldUpdateAllItems()
	{
		underTest.update();
		
		verify(firstItem).update();
		verify(secondItem).update();
	}
}
