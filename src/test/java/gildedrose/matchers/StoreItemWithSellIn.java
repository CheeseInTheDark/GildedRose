package gildedrose.matchers;

import gildedrose.items.StoreItem;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

public class StoreItemWithSellIn<T> extends TypeSafeMatcher<T>
{
	private int sellIn;
	
	public StoreItemWithSellIn(int sellIn)
    {
		this.sellIn = sellIn;
    }
	
	public static StoreItemWithSellIn<? super StoreItem> hasSellInOf(int sellIn)
	{
		return new StoreItemWithSellIn<StoreItem>(sellIn);
	}
	
	@Override
    public void describeTo(Description description)
    {
	    description.appendText(" a StoreItem with a sellIn of ");
	    description.appendValue(sellIn);
    }

	@Override
    protected boolean matchesSafely(T item)
    {
	    return ((StoreItem) item).getItem().getSellIn() == sellIn;
    }

}
