package gildedrose.items;

import gildedrose.items.ConjuredItem;

public class StoreItemFactory
{

	public StoreItem createFrom(Item item)
    {
	    return new ConjuredItem(item);
    }

}
