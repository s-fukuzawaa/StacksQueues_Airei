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
        else if(size==1&&a[0]==null)
        {
        	a[0]=item;
        }
        else 
        {
    		int loc=StdRandom.uniform(size);

        	if(size==a.length)
        	{
        		resizeEnqueue(2*size,loc);
        	}
        	
        	else
        	{
        		resizeEnqueue(size,loc);
        	}
    		a[loc]=item;
            size++;
        }
    }
    
    private void resizeEnqueue(int s,int loc)
    {
    	Item[] temp=(Item[]) new Object[s];
    	if(loc==0)
    	{
    		for(int i=1; i<a.length+1; i++)
    		{
    			temp[i]=a[i-1];
    		}
    	}
    	else
    	{
    		for(int i=0; i<loc; i++)
    		{
        		temp[i]=a[i];
        	}
        	for(int j=loc+1; j<a.length+1; j++)
        	{
        		temp[j]=a[j-1];
        	}
    	}
    	
    	a=temp;
    			
    }
    
    public Item dequeue()
    {
        if(a==null)
        {
        	throw new java.util.NoSuchElementException();
        }
        else
        {
        	int loc=StdRandom.uniform(size);

        	Item i=a[loc];
        	a[loc]=null;
        	if(size>0 && size==a.length/4)
        	{
        		resizeDequeue(a.length/2,loc);
        	}
        	else
        	{
        		resizeDequeue(size,loc);
        	}

            size--;
            return i;
        }
    }
    private void resizeDequeue(int s, int loc)
    {
    	Item[] temp=(Item[]) new Object[s];
    	for(int i=0; i<loc; i++)
    	{
    		temp[i]=a[i];
    	}
    	for(int j=loc; j<a.length-2; j++)
    	{
    		temp[j]=a[j+1];
    	}
    	a=temp;
    			
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
    
    public static void main(String[] args)
    {
    	RandomizedQueue r= new RandomizedQueue();
    	r.enqueue("No");
    	r.enqueue("tears");
    	r.enqueue("left");
    	r.enqueue("to");
    	r.enqueue("cry");
    	r.dequeue();
    	r.dequeue();
    }
}
