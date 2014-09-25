package gildedrose.items;

import static gildedrose.matchers.StoreItemWithQuality.hasQualityOf;
import static gildedrose.matchers.StoreItemWithSellIn.hasSellInOf;
import static org.junit.Assert.assertThat;
import gildedrose.matchers.StoreItemWithSellIn;

import org.junit.Test;


public class ConjuredItemTest
{
	@Test
	public void shouldDegradeFromTwoToZero()
	{
		ConjuredItem underTest = buildConjuredItemWithQuality(2);
		
		underTest.update();
		
		assertThat(underTest, hasQualityOf(0));
	}
	
	@Test
	public void shouldDegradeFromFourToTwo()
	{
		ConjuredItem underTest = buildConjuredItemWithQuality(4);
		
		underTest.update();
		
		assertThat(underTest, hasQualityOf(2));
	}
	
	@Test
	public void shouldDegradeByFourAfterSellin()
	{
		ConjuredItem underTest = buildConjuredItem(-2, 4);
		
		underTest.update();
		
		assertThat(underTest, hasQualityOf(0));
	}
	
	@Test
	public void shouldNeverDegradeBelowZero()
	{
		ConjuredItem underTest = buildConjuredItemWithQuality(1);
		
		underTest.update();
		
		assertThat(underTest, hasQualityOf(0));
	}
	
	@Test
	public void shouldDecreaseSellIn()
	{
		ConjuredItem underTest = buildConjuredItemWithSellIn(1);
		
		underTest.update();
		
		assertThat(underTest, hasSellInOf(0));
	}
	
	private ConjuredItem buildConjuredItemWithQuality(int quality)
	{
		return new ConjuredItem(new Item("Conjured", 1, quality));
	}
	
	private ConjuredItem buildConjuredItemWithSellIn(int sellIn)
	{
		return new ConjuredItem(new Item("Conjured", sellIn, 0));
	}
	
	private ConjuredItem buildConjuredItem(int sellIn, int quality)
	{
		return new ConjuredItem(new Item("Conjured", sellIn, quality));
	}
}
