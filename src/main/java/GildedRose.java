import java.util.ArrayList;
import java.util.List;


public class GildedRose {

	private static final int MAXIMUM_QUALITY = 50;
	private static final String DEXTERITY_VEST = "+5 Dexterity Vest";
	private static final String CONJURED_MANA_CAKE = "Conjured Mana Cake";
	private static final String ELIXIR = "Elixir of the Mongoose";
	static final String AGED_BRIE = "Aged Brie";
	static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
	static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
	private static List<Item> items = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
        System.out.println("OMGHAI!");
		
        items = new ArrayList<Item>();
        items.add(new Item(DEXTERITY_VEST, 10, 20));
        items.add(new Item(AGED_BRIE, 2, 0));
        items.add(new Item(ELIXIR, 5, 7));
        items.add(new Item(SULFURAS, 0, 80));
        items.add(new Item(BACKSTAGE_PASSES, 15, 20));
        items.add(new Item(CONJURED_MANA_CAKE, 3, 6));

        for(Item item: items) {
        new GildedRose().updateQuality(item);
        }
	}
	
    public void updateQuality(Item item)
    {

			if ((!isAgedBrie(item)) && !isBackstagePass(item)) 
            {
                if (shouldDecrementQualityOf(item))
                {
                	decrementQualityOf(item);
                }
            }
            else
            {
                if (qualityIsBelowMaximum(item)) {
                    incrementQualityOf(item);

                    if (isBackstagePass(item))
                    {
                        if (item.getSellIn() < 11)
                        {
                            if (qualityIsBelowMaximum(item))
                            {
                                incrementQualityOf(item);
                            }
                        }

                        if (item.getSellIn() < 6)
                        {
                            if (qualityIsBelowMaximum(item))
                            {
                                incrementQualityOf(item);
                            }
                        }
                    }
                }
            }

            if (!isSulfuras(item))
            {
                item.setSellIn(item.getSellIn() - 1);
            }

            if (item.getSellIn() < 0)
            {
                if (!isAgedBrie(item))
                {
                    if (!isBackstagePass(item))
                    {
                    	if (shouldDecrementQualityOf(item))
                    	{
                    		decrementQualityOf(item);
                    	}
                    }
                    else
                    {
                        item.setQuality(0);
                    }
                }
                else
                {
                    if (qualityIsBelowMaximum(item))
                    {
                        incrementQualityOf(item);
                    }
                }
            }
    }

	private static boolean isSulfuras(Item item) {
		return SULFURAS.equals(item.getName());
	}



	private static boolean isAgedBrie(Item item) {
		return AGED_BRIE.equals(item.getName());
	}



	private static boolean isBackstagePass(Item item) {
		return BACKSTAGE_PASSES.equals(item.getName());
	}

	private static boolean shouldDecrementQualityOf(Item item) {
		return qualityIsPositive(item) && !isSulfuras(item);
	}

	private static boolean qualityIsBelowMaximum(Item item) {
		return item.getQuality() < MAXIMUM_QUALITY;
	}

	private static void incrementQualityOf(Item item) {
		item.setQuality(item.getQuality() + 1);
	}

	private static void decrementQualityOf(Item item) {
		item.setQuality(item.getQuality() - 1);
	}

	private static boolean qualityIsPositive(Item item) {
		return item.getQuality() > 0;
	}
}