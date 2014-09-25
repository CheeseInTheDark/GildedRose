package gildedrose.inventorysystem;

import gildedrose.items.Item;

import java.util.List;

public class InventorySystem
{
	private InventoryFactory inventoryFactory = new InventoryFactory();
	
	private Inventory inventory;
	
	public InventorySystem(List<Item> items)
	{
		inventory = inventoryFactory.createFrom(items);
	}
	
	public void update() 
	{
		inventory.update();
	}

}
