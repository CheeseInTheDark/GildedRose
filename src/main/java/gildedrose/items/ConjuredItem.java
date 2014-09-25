package gildedrose.items;


public class ConjuredItem extends StoreItem
{
	private final int DEGRADATION = -2;
	private final int DEGRADATION_AFTER_EXPIRATION = -4;
	
	public ConjuredItem(Item item)
	{
		super(item);
	}

	@Override
	public void update()
	{
		updateQuality();
		updateSellIn();
	}
	
	private void updateSellIn()
	{
		item.setSellIn(item.getSellIn() - 1);
	}
	
	private void updateQuality()
	{
		if (isAfterSellIn())
		{
			adjustQualityOnItem(DEGRADATION_AFTER_EXPIRATION);
		}
		else
		{
			adjustQualityOnItem(DEGRADATION);
		}
		
		enforceMinimumQuality();
	}
	
	private void enforceMinimumQuality()
	{
		if (item.getQuality() < 0)
		{
			item.setQuality(0);
		}		
	}
	
	private boolean isAfterSellIn()
	{
		return item.getSellIn() < 0;
	}
	
	private void adjustQualityOnItem(int amount)
	{
		item.setQuality(item.getQuality() + amount);
	}
}

