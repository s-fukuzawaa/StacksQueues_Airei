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
    
    public Iterator<Item> iterator()
    {
        throw new UnsupportedOperationException();
    }
    
    public static void main (String[] args)
    {
    	Deque<String> d=new Deque<String>();
    	/*d.addLast("no");
    	d.addLast("more");
    	d.addLast("tears");
    	d.addLast("left");
    	d.addFirst("Grande");*/
    	d.addFirst("Ariana");
    	d.removeFirst();/*
    	d.removeLast();
    	d.removeLast();
    	d.removeLast();
    	d.removeLast();
    	d.removeLast();
    	d.addLast("I");
    	d.addFirst("Smith");
    	d.addLast("know");
    	d.addLast("I'm");
    	d.addLast("not");
    	d.addFirst("Sam");
    	d.addLast("the only one");*/
    }
 }
