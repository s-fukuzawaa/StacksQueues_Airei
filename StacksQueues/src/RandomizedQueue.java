import java.util.Iterator;

import Deque.Node;


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
        	if(size==a.length)
        	{
        		resize(2*size);
        	}
        	
        	a[size]=item;
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
        	if(loc==size-1)
        	{
        		a[loc]=null;
        		size--;
        		return i;
        	}
        	else if(size==a.length/4)
        	{
        		resize(a.length/2);
        	}
        	a[loc]=a[size-1];//////
        	a[size-1]=null;
            size--;
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
    
    private class RandomizedQueueIterator implements Iterator<Item>
    {
    	private int random=StdRandom.uniform(size);
    	private int count=random;
    	private Item item=a[count];
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
		
			if(a[count]==null)
			{
				return false;
			}
			return true;
		}

		@Override
		public Item next() {
			// TODO Auto-generated method stub
			if(a[count]==null)
			{
				throw new java.util.NoSuchElementException();
			}
			Item i=item;
			count++;
				item=a[count];
				return i;
			
		}
    	
    }
    
    public Iterator<Item> iterator()
    {
        return new RandomizedQueueIterator();
    }
    
    public static void main(String[] args)
    {
    	RandomizedQueue r= new RandomizedQueue();
    	//r.enqueue("No");
    	r.enqueue("tears");
    	r.enqueue("left");
    	r.enqueue("to");////
    	r.enqueue("cry");
    	//r.dequeue();
    	r.enqueue("Ariana");
    	r.enqueue("Grande");



    	r.enqueue("Ariana");
    	r.enqueue("b");
    	r.enqueue("c");


    	r.dequeue();
    	r.dequeue();
    	r.dequeue();
    	r.enqueue("c");





    	

    }
}
