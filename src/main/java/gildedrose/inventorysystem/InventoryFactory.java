package gildedrose.inventorysystem;

import gildedrose.items.Item;
import gildedrose.items.StoreItem;
import gildedrose.items.StoreItemFactory;

import java.util.ArrayList;
import java.util.List;

public class InventoryFactory
{
	private StoreItemFactory storeItemFactory = new StoreItemFactory();
	
	public Inventory createFrom(List<Item> items)
    {
		List<StoreItem> storeItems = new ArrayList<StoreItem>();
		
		for(Item item : items)
		{
			storeItems.add(storeItemFactory.createFrom(item));
		}
		
	    return new Inventory(storeItems);
    }
}
