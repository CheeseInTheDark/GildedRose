package gildedrose.matchers;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

import gildedrose.items.StoreItem;

public class StoreItemWithQuality<T> extends TypeSafeMatcher<T>
{
	private int quality;
	
	public StoreItemWithQuality(int quality)
	{
		this.quality = quality;
	}
	
	public static StoreItemWithQuality<? super StoreItem> hasQualityOf(int quality)
	{
		return new StoreItemWithQuality<StoreItem>(quality);
	}
	
	@Override
    public void describeTo(Description description)
    {
		description.appendText("a StoreItem with a quality of " + quality);
    }

	@Override
    protected boolean matchesSafely(T item)
    {
	    return ((StoreItem) item).getItem().getQuality() == quality;
    }

}
