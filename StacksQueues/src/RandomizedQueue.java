import java.util.Iterator;


public class RandomizedQueue<Item> implements Iterable<Item>
{
	private int count;
	private int size;
	private Item[] a;
	
    public RandomizedQueue()
    {
        this.a=(Item[]) new Object[1];
        this.size=1;
    }
    
    public boolean isEmpty()
    {
        if(a==null)
        {
        	return true;
        }
        return false;
    }
    
    public int size()
    {
        return size;
    }
    
    public void enqueue(Item item)
    {
        if(item==null)
        {
        	throw new java.lang.NullPointerException();
        }
        else if(size==1)
        {
        	a[0]=item;
        }
        else 
        {
        	if(size==a.length)
        	{
        		resizeEnqueue(size,StdRandom.uniform(size));
        		
        	}
        }
        size++;
    }
    
    private void resizeEnqueue(int s,int loc)
    {
    	s>=size
    }
    
    public Item dequeue()
    {
        if(a==null)
        {
        	throw new java.util.NoSuchElementException();
        }
        else
        {
        	
        }
        size--;
    }
    
    public Item sample()
    {
        if(a==null)
        {
        	throw new java.util.NoSuchElementException();
        }
        else
        {
        	return a[StdRandom.uniform(a.length)];
        }
    }
    
    public Iterator<Item> iterator()
    {
        throw new UnsupportedOperationException();
    }
}
