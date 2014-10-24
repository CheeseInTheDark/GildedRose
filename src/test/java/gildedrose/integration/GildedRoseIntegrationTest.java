package gildedrose.integration;

import static java.util.Collections.singletonList;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import gildedrose.inventorysystem.InventorySystem;
import gildedrose.items.Item;

import java.util.List;

import org.junit.Test;

public class GildedRoseIntegrationTest
{
	private InventorySystem inventorySystem;

	@Test
	public void shouldUpdateConjuredItem()
	{
		Item conjuredItem = new Item("Conjured Mana Cake", 3, 6);
		List<Item> conjuredItemList = singletonList(conjuredItem);
		
		InventorySystem inventorySystem = new InventorySystem(conjuredItemList);
		inventorySystem.update();
		
		assertThat(conjuredItem.getQuality(), is(4));
		assertThat(conjuredItem.getSellIn(), is(2));
	}

	@Test
	public void shouldNotUpdateOtherItem()
	{
		Item genericItem = new Item("A Generic Item", 4, 5);
		setUpInventorySystemWith(genericItem);
		
		inventorySystem.update();

		assertThat(genericItem.getQuality(), is(5));
		assertThat(genericItem.getSellIn(), is(4));
	}
	
	private void setUpInventorySystemWith(Item item)
	{
		inventorySystem = new InventorySystem(singletonList(item));
	}
}
