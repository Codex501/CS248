class QueueLL implements Queue
{
	private class qnode
	{
		public Object data;
		public qnode next;
	}
	qnode front, back;
	int count;
		
	public QueueLL()
	{
		count=0;
		front=back=null;
	}
	
	public void enqueue(Object x)
	{
		count++;
		qnode newnode=new qnode();
		newnode.data=x;
		newnode.next=null;
		if(front!=null)
		  back.next=newnode;
		else
		  front=newnode;
		back=newnode;		
	}
	public Object dequeue()
	{
		if(isEmpty()) return null;
		count--;
		Object savedfront=front.data;
		front=front.next;
		if(front==null) back=null;
		return savedfront;
	}
		 	
	
	public Object getFront()
	{ 
		if(isEmpty()) return null;
		return front.data; 
	}
	
	public int size() { return count; }
	public boolean isEmpty()
	{ return count<=0; }
	public boolean isFull()	{ return false; }
	public void makeEmpty()
	{ back=front=null; count=0;	}
}