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
	
    public Deque()
    {
    	//
	}
    
    public boolean isEmpty()
    {
    	if(head==null)
    	{
    		return true;
    	}
    	return false;
    }
 
    
    public int size()
    {
        int count=1;
        Node temp=head;
        while(temp.next!=null)
        {
        	count ++;
        	temp=temp.next;
        }
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
	    		head=plus;
	    	}
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
	    		tail=add;
	    	}
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
    		Node temp=new Node();
	        temp.item=head.next.item;
	        temp.next=head.next.next;
	        Item result=head.item;
	        head=null;
	        head=temp;
	        return result;
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
        	Node temp=new Node();
            temp.item=tail.previous.item;
            temp.previous=tail.previous.previous;
            Item result=tail.item;
            tail=null;
            tail=temp;
            return result;
    	}
     }
    
    public Iterator<Item> iterator()
    {
        throw new UnsupportedOperationException();
    }
    
    public static void main (String[] args)
    {
    	Deque<String> d=new Deque<String>();
    	d.addFirst("no");
    	d.addFirst("more");
    	d.addFirst("tears");
    }
 }
