import java.util.Iterator;


public class RandomizedQueue<Item> implements Iterable<Item>
{
	private int size;
	private Item[] a;
	
    public RandomizedQueue()
    {
        this.a=(Item[]) new Object[2];
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
    		size=1;
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
        		resize(2*size);
        	}
    		Item temp=a[loc];
    		Item temp2=a[loc+1];
        	for(int i=loc+1;i<a.length; i++)
        	{
        		a[i]=temp;
        		if(i+1==a.length)
        		{
        			break;
        		}
        		temp=temp2;
        		temp2=a[i+1];
        	}
        	a[loc]=item;
            size++;
        }
    }
    
    private void resize(int s)
    {
    	Item[] temp=(Item[]) new Object[s];
    	for(int i=0; i<size; i++)
    	{
    		temp[i]=a[i];	
    			
        }
    	
    	a=temp;
    			
    }
    
    public Item dequeue()
    {
        if(size==0)
        {
        	throw new java.util.NoSuchElementException();//
        }
        if(size==1)
        {
        	Item i=a[0];
        	a[0]=null;

            size--;
            return i;
        }
        else
        {
        	int loc=StdRandom.uniform(size);

        	Item i=a[loc];
        	a[loc]=null;
        	if(size>0&&size==a.length/4)
        	{
        		resize(a.length/2);
        	}
        	
        	Item temp=a[loc+1];
        	for(int j=loc+1;j<a.length-1; j++)
        	{
        		a[j-1]=temp;
        		temp=a[j+1];
        	}
        	a[size-1]=null;
            size--;
            if(size==0)
            {
            	a=(Item[]) new Object[2];
            }
            return i;
        }
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
    	
    	r.dequeue();
    	r.dequeue();
    	r.dequeue();

    	r.dequeue();
    	r.dequeue();

    	r.dequeue();
    	r.dequeue();  	
    	


    	r.enqueue("A");

    	r.enqueue("Ariana");
    	r.enqueue("Grande");

    	r.enqueue("tears");
    	r.enqueue("left");
    	r.enqueue("to");////
    	r.enqueue("cry");
    	
    	r.dequeue();
    	r.dequeue();




    	

    }
}
