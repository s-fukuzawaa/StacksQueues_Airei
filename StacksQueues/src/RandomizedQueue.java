import java.util.Iterator;


public class RandomizedQueue<Item> implements Iterable<Item>
{
	private int size;
	private Item[] a;
	
    public RandomizedQueue()
    {
        this.a=(Item[]) new Object[1];
        this.size=1;
    }
    
    public boolean isEmpty()
    {
        if(a[0]==null&&size==0)
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

    	if(size==0)
    	{
    		size++;
    	}
        
        if(size==1&&a[0]==null)
        {
        	a[0]=item;
        }
        else 
        {
    		int loc=StdRandom.uniform(size);

        	if(size==a.length)
        	{
        		resizeEnqueue(2*(size),loc);
        	}
        	
        	else
        	{
        		resizeEnqueue(a.length,loc);
        	}
    		a[loc]=item;
            size++;
        }
    }
    
    private void resizeEnqueue(int s,int loc)
    {
    	Item[] temp=(Item[]) new Object[s];
    	int count=0;
    	for(int i=0; i<size+1; i++)
    		{
    			if(i==loc)
    			{
    				i++;
    			}
    			
    				temp[i]=a[count];
    				count++;
    			
        	}
    	
    	a=temp;
    			
    }
    
    public Item dequeue()
    {
        if(a[0]==null)
        {
        	throw new java.util.NoSuchElementException();//
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
        	else if(size>0)
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
    	int count=0;
    	for(int i=0; i<temp.length-1; i++)
    	{
    		if(i==loc)
    		{
    			count++;
    		}
    		temp[i]=a[count];
    		count++;
    	}
    	a=temp;
    			
    }
    public Item sample()
    {
        if(size==0)
        {
        	throw new java.util.NoSuchElementException();
        }
        else
        {
        	return a[StdRandom.uniform(size)];
        }
    }
    
    public Iterator<Item> iterator()
    {
        throw new UnsupportedOperationException();
    }
    
    public static void main(String[] args)
    {
    	RandomizedQueue r= new RandomizedQueue();
    	//r.enqueue("No");
    	/*r.enqueue("tears");
    	r.enqueue("left");
    	r.enqueue("to");////
    	r.enqueue("cry");
    	//r.dequeue();
    	r.enqueue("Ariana");
    	r.enqueue("Grande");*/
    	
    	//System.out.println(r.dequeue());
    	//System.out.println(r.dequeue());
    	//System.out.println(r.dequeue());

    	System.out.println(r.sample());    	System.out.println(r.sample());
    	System.out.println(r.sample());
    	System.out.println(r.sample());
    	System.out.println(r.sample());
    	System.out.println(r.sample());
    	System.out.println(r.sample());
    	System.out.println(r.sample());
    	System.out.println(r.sample());
    	System.out.println(r.sample());
    	System.out.println(r.sample());


    	r.enqueue("A");




    	

    }
}
