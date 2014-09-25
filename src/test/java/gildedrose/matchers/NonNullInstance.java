package gildedrose.matchers;

import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.notNullValue;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

public class NonNullInstance<T> extends TypeSafeMatcher<T>
{
	private Class<? extends T> type;
	
	public NonNullInstance (Class<? extends T> type)
	{
		this.type = type;
	}
	
    public static <S> NonNullInstance<S> nonNullInstanceOf(Class<? extends S> type)
	{
		return new NonNullInstance<S>(type);
	}
	
	@Override
    public void describeTo(Description description)
    {
	    description.appendText(" a non-null instance of ");
	    description.appendValue(type.toString());
    }

	@Override
    protected boolean matchesSafely(T object)
    {
		return instanceOf(type).matches(object) && notNullValue().matches(object);
    }
}
