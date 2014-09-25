package gildedrose.items;

import static gildedrose.matchers.NonNullInstance.nonNullInstanceOf;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import gildedrose.items.Item;
import gildedrose.items.StoreItem;
import gildedrose.matchers.NonNullInstance;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class StoreItemFactoryTest
{
	private StoreItemFactory underTest;
	
	@Before
	public void setup()
	{
		underTest = new StoreItemFactory();
	}
	
	@Test
	public void shouldCreateConjuredItem()
	{
		Item conjuredItem = new Item("Conjured Mana Cake", 0, 0);
		
		StoreItem actualItem = underTest.createFrom(conjuredItem);
		
		Assert.assertThat(actualItem, nonNullInstanceOf(ConjuredItem.class));
	}
	
	@Test
	public void shouldCreateItemWithinStoreItem()
	{
		Item item = new Item("An Item", 0, 0);
		
		StoreItem actualItem = underTest.createFrom(item);
		
		assertThat(actualItem.getItem(), is(item));
	}
}
