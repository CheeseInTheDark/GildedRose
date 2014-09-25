package gildedrose.items;

import static gildedrose.matchers.StoreItemWithQuality.hasQualityOf;
import static org.junit.Assert.assertThat;

import org.junit.Test;


public class StoreItemTest
{
	@Test
	public void testDefaultUpdateDoesNotChangeQuality()
	{
		StoreItem underTest = new StoreItem(new Item("Item", 1, 1));
		
		underTest.update();
		
		assertThat(underTest, hasQualityOf(1));
	}
}
