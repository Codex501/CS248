// comparable interface

public interface Comparable
{
	public int compareTo(Object x);
	/*
	If we call z.compareTo(x):
	return 0 if z==x
	      +1 if z>x
		  -1 if z<x
	*/
}