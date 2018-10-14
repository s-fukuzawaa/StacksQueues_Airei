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
	    	plus.next=null;
	    	plus.previous=null;
	    	
	    	if(head==null)
	    	{
	    		head=plus;
	    		tail=plus;
	    	}
	    	else
	    	{
	    		head.previous=plus;
	    		plus.next=head;
	    		
	    		Node temp2=tail;
				Node temp3=temp2.previous;

				while(temp3.previous!=null)
				{
					temp2=temp3.previous;
					temp3=temp2;
					
				}
				head=temp3;	
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
	    	add.next=null;
	    	add.previous=null;
	    	
	    	if(head==null)
	    	{
	    		head=add;
	    		tail=add;
	    	}
	    	else
	    	{
	    		tail.next=add;
	    		add.previous=tail;
	    		
	    		Node temp2=head;
				Node temp3=temp2.next;

				while(temp3.next!=null)
				{
					temp2=temp3.next;
					temp3=temp2;
					
				}
				tail=temp3;
				

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
    		Item i=head.item;
    		head=head.next;
    		if(head==null)
    		{
    			tail=null;
    		}
    		return i;
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
    		Item i=tail.item;
    		tail=tail.previous;
    		if(tail==null)
    		{
    			head=null;
    		}
    		return i;
    	}
     }
    
    public Iterator<Item> iterator()
    {
        throw new UnsupportedOperationException();
    }
    
    public static void main (String[] args)
    {
    	Deque<String> d=new Deque<String>();
    	d.addLast("no");
    	d.addLast("more");
    	d.addLast("tears");
    	d.addLast("left");
    	d.addFirst("Grande");
    	d.addFirst("Ariana");
    	d.removeFirst();
    	d.removeLast();
    }
 }
