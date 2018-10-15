import java.util.Iterator;


public class Deque<Item> implements Iterable<Item>
{
	private class Node
	{
		Item item;
		Node next;
		Node previous;
	}
	
	private Node head;
	private Node tail;
	private int count;
	
    public Deque()
    {
    	this.count=0;
	}
    
    public boolean isEmpty()
    {
    	
    	return head==null;
    }
 
    
    public int size()
    {
        return count;
    }
    
    public void addFirst(Item item)
    {
        //throw new UnsupportedOperationException();
    	if(item==null)
    	{
    		throw new java.lang.NullPointerException();
    	}
	    else
	    {
	    	Node plus= new Node();
	    	plus.item=item;
	    	
	    	if(head==null)
	    	{
	    		head=plus;
	    		tail=plus;
	    	}
	    	else
	    	{
	    		head.previous=plus;
	    		plus.next=head;
	    		
	    		head=head.previous;
	    	}
				this.count++;
	    	
	    }
	    	
    }
    
    public void addLast(Item item)
    {
	    if(item==null)
	    {
	    	throw new java.lang.NullPointerException();
	    }
    	
    	else
	    {
	    	Node add= new Node();
	    	add.item=item;
	    	
	    	if(head==null)
	    	{
	    		head=add;
	    		tail=add;
	    	}
	    	else
	    	{
	    		tail.next=add;
	    		add.previous=tail;
	    		
	    		tail=tail.next;
				
				

	    	}
	    	count++;
	    }
    	
    }
    
    public Item removeFirst()
    {
    	if(head==null)
    	{
    		throw new java.util.NoSuchElementException();
    	}
    	else
    	{
    		count--;
    		if(count==0)
    		{
    			Item i=head.item;
    			head=null;
    			tail=null;
    			return i;
    		}
    		else
    		{
    			Item i=head.item;
    			head=head.next;
        		head.previous=null;
        		return i;
    		}
    		
    	}
	        
    }
    
    public Item removeLast()
    {
    	if(tail==null)
    	{
    		throw new java.util.NoSuchElementException();
    	}
    	else
    	{
    		count--;
    		if(count==0)
    		{
    			Item i=tail.item;
    			head=null;
    			tail=null;
    			return i;//
    		}
    		
    		else
    		{
    			Item i=tail.item;
    			tail=tail.previous;
        		tail.next=null;
        		return i;
    		}
    		
    	}
     }
    private class DequeIterator implements Iterator<Item>
    {
    	Node current=head;
    	int curnum=count;
    	
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			if(curnum>0)
			{
				curnum--;
				return true;
			}
			return false;
		}

		@Override
		public Item next() {
			// TODO Auto-generated method stub
			Item i=current.item;
				current=current.next;
				return i;
			
		}
    	
    }
    
    public Iterator<Item> iterator()
    {
        return new DequeIterator();
    }
    
    public static void main (String[] args)
    {
    	Deque<String> d=new Deque<String>();
    	d.addLast("no");
    	d.addLast("more");
    	d.addLast("tears");
    	d.addLast("left");
    	Iterator<String> st=d.iterator();
    	while(st.hasNext())
    	{
    		String element= st.next();
    		System.out.println(element);
    	}
    }
 }
