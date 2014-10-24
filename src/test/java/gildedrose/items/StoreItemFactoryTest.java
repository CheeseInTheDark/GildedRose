package gildedrose.items;

import static gildedrose.matchers.NonNullInstance.nonNullInstanceOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

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
	public void shouldCreateGenericItem()
	{
		Item genericItem = new Item("Some Generic Item", 0, 0);
		
		StoreItem actualItem = underTest.createFrom(genericItem);
		
		assertThat(actualItem.getClass(), equalTo(StoreItem.class));
	}
	
	@Test
	public void shouldCreateConjuredItem()
	{
		Item conjuredItem = new Item("Conjured Mana Cake", 0, 0);
		
		StoreItem actualItem = underTest.createFrom(conjuredItem);
		
		assertThat(actualItem, nonNullInstanceOf(ConjuredItem.class));
	}
	
	@Test
	public void shouldCreateItemWithinStoreItem()
	{
		Item item = new Item("An Item", 0, 0);
		
		StoreItem actualItem = underTest.createFrom(item);
		
		assertThat(actualItem.getItem(), is(item));
	}
}
