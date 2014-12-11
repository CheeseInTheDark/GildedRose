import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

	GildedRose underTest = new GildedRose();
	@Test
	public void testTheTruth() {
		assertTrue(true);
	}
	
	@Test
	public void shouldDecrementIemQuality() {
		Item item = new Item("Any item", 5, 5);
		
		underTest.updateQuality(item);
		
		assertThat(item.getQuality(), is(4));
	}
	
	@Test
	public void shouldIncrementIemQualityForAgedBrie() {
		Item item = new Item(GildedRose.AGED_BRIE, 5, 5);
		
		underTest.updateQuality(item);
		
		assertThat(item.getQuality(), is(6));
	}
	
	@Test
	public void shouldNotSetQualityBelowZero() {
		Item item = new Item("Any item", 5, 0);
		
		underTest.updateQuality(item);
		
		assertThat(item.getQuality(), is(0));
	}
	
	@Test
	public void shouldNotReduceSulfurasQuality() {
		Item item = new Item(GildedRose.SULFURAS, 5, 10);
		
		underTest.updateQuality(item);
		
		assertThat(item.getQuality(), is(10));
	}
	
	@Test
	public void shouldIncreaseQualityForBackstagePassWhenSellInMoreThan11() {
		Item item = new Item(GildedRose.BACKSTAGE_PASSES, 12, 5);
		
		underTest.updateQuality(item);
		
		assertThat(item.getQuality(), is(6));
	}
}
