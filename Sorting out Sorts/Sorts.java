class Sorts
{
	public static void selection(Comparable [] list)
	{
		for(int swapto=list.length-1; swapto>0; swapto--)
		{
			int maxpos;
			maxpos=findmax(list,swapto);
			swap(list,maxpos,swapto);
		}
	}
	
	private static void swap(Comparable [] list,
			int x, int y)
	{
		// swap list[x] with list[y]
		Comparable temp;
		temp=list[x];
		list[x]=list[y];
		list[y]=temp;
	}
	private static int findmax(Comparable [] list,
			int swapto)
	{
		int max=0;
		for(int i=1; i<=swapto; i++)
			if(list[i].compareTo(list[max])>0)
				max=i;
		return max;
	}		
	
	public static void bubble(Comparable [] list)
	{
		boolean done=false;
		while(!done)
		{
			done=true;
		//for(int j=0; j<list.length-1; j++)
			for(int i=0; i+1<list.length; i++)
				if(list[i].compareTo(list[i+1])>0)
				{
					swap(list,i,i+1);
					done=false;
				}
		}
	}
	public static void insertion(Comparable [] list)
	{
		for(int toins=1; toins<list.length; toins++)
		{
			Comparable side=list[toins];
			for(int j=toins-1; j>=-1; j--)
			{
				if(j>=0 && list[j].compareTo(side)>0)
					list[j+1]=list[j];
				else
				{
					list[j+1]=side;
					break;
				}
			}
			/*
			for(int i=0; i<list.length; i++)
				System.out.println(list[i]);
			System.out.println("**");
			*/
		}
	}
	
	public static void insertion(Comparable [] list,
			int offset, int gap)
	{
		for(int toins=offset+gap; toins<list.length;
				toins=toins+gap)
		{
			Comparable side=list[toins];
			for(int j=toins-gap; j>=offset-gap; j=j-gap)
			{
				if(j>=0 && list[j].compareTo(side)>0)
					list[j+gap]=list[j];
				else
				{
					list[j+gap]=side;
					break;
				}
			}
		}
	}
	public static void shell(Comparable [] list)
	{
		int gap=list.length/3;
		while(gap>1)
		{
			for(int offset=0; offset<gap; offset++)
				insertion(list,offset,gap);
			gap=(int)(gap/2.2);
		}
		insertion(list);
	}

	public static void quick(Comparable [] list)
	{
		quickrec(list,0,list.length-1);
	}
	
	private static void quickrec(Comparable [] list,
				int left, int right)
	{
		// base cases
		if(left>=right) // size 0 or 1
			return;
		if(left+1==right) // size 2
		{
			if(list[left].compareTo(list[right])>0)
				swap(list,left,right);
			return;
		}
		// recursive case
		int pivotpos;
		pivotpos=partition(list,left,right);
		quickrec(list,left,pivotpos-1);
		quickrec(list,pivotpos+1,right);
	}
	private static int partition(Comparable [] list,
				int left, int right)
	{
		Comparable pivot=list[right];
		int fbp=left;
		for(int i=left; i<right; i++)
		{
			if(list[i].compareTo(pivot)<0)
			{
				swap(list,i,fbp);
				fbp++;
			}
		}
		swap(list,right,fbp);
		return fbp;
	}
	
	public static void merge(Comparable [] list)
	{
		mergerec(list,0,list.length-1);
	}
	private static void mergerec(Comparable [] list,
		int left, int right)
	{
		// base cases
		if(left>=right) // size 0 or 1
			return;
		if(left+1==right) // size 2
		{
			if(list[left].compareTo(list[right])>0)
				swap(list,left,right);
			return;
		}
		// recursive case
		int mid=(left+right)/2;
		mergerec(list,left,mid);
		mergerec(list,mid+1,right);
		domerge(list,left,mid,right);
	}
	private static void domerge(Comparable [] list,
		int left, int mid, int right)
	{
		Comparable [] A;
		A=new Comparable[right-left+1];
		int hootie=left, blowfish=mid+1;
		for(int i=0; i<A.length; i++)
		{
			// blowfish is empty OR
			// ( hootie is not empty AND 
			//   list[hootie]<=list[blowfish] )
			if(blowfish>right || (hootie<=mid && 
				list[hootie].compareTo(list[blowfish])<=0) )
				A[i]=list[hootie++];
			else
				A[i]=list[blowfish++];
		}
		for(int i=0; i<A.length; i++)
			list[left+i]=A[i];
	}
}