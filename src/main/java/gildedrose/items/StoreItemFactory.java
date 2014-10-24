package gildedrose.items;

import gildedrose.items.ConjuredItem;

public class StoreItemFactory
{
	private static final String CONJURED_ITEM = "Conjured Mana Cake";
	
	public StoreItem createFrom(Item item)
    {
		if (item.getName().equals(CONJURED_ITEM))
		{
			return new ConjuredItem(item);
		}
		else
		{
			return new StoreItem(item);
		}
    }

}
