package gildedrose.items;

public class StoreItem
{
	protected Item item;
	
	public StoreItem(Item item)
	{
		this.item = item;
	}
	
	public void update()
    {
    }

	public Item getItem()
    {
	    return item;
    }

}
