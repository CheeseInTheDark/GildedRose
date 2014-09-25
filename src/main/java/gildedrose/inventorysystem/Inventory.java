package gildedrose.inventorysystem;

import gildedrose.items.StoreItem;

import java.util.List;

public class Inventory
{
	private List<StoreItem> storeItems;
		
	public Inventory(List<StoreItem> storeItems)
    {
		this.storeItems = storeItems;
    }

	public void update()
    {
		for (StoreItem item : storeItems)
		{
			item.update();
		}
    }

}
