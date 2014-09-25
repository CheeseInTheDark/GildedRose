package gildedrose.integration;

import static java.util.Collections.singletonList;
import static org.junit.Assert.*;

import java.util.Collections;
import java.util.List;

import gildedrose.inventorysystem.InventorySystem;
import gildedrose.items.Item;

import org.hamcrest.Matchers;
import org.junit.Test;

public class GildedRoseIntegrationTest
{

	@Test
	public void shouldUpdateConjuredItem()
	{
		Item conjuredItem = new Item("Conjured Mana Cake", 3, 6);
		List<Item> conjuredItemList = singletonList(conjuredItem);
		
		InventorySystem inventorySystem = new InventorySystem(conjuredItemList);
		inventorySystem.update();
		
		assertThat(conjuredItem.getQuality(), Matchers.is(4));
		assertThat(conjuredItem.getSellIn(), Matchers.is(2));
	}

}
