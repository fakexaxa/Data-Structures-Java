public final class ArrayBag<T> implements BagInterface<T>
{
	private final T[] bag; 
	private int numberOfEntries;
   	private boolean initialized = false;
	private static final int DEFAULT_CAPACITY = 5;
	

	/** Creates an empty bag whose initial capacity is 25. */
	public ArrayBag() 
	{
		this(DEFAULT_CAPACITY);
	} // end default constructor

	public ArrayBag(int desiredCapacity)
	{
      if (desiredCapacity >=DEFAULT_CAPACITY)
      {
         @SuppressWarnings("unchecked")
         T[] tempBag = (T[])new Object[desiredCapacity]; // Unchecked cast
         bag = tempBag;
         numberOfEntries = 0;
         initialized = true;
      }
      else
         throw new IllegalStateException("Attempt to create a bag " +
                                         "whose capacity exceeds " +
                                         "allowed maximum.");
	} // end constructor
   
	public boolean add(T newEntry)
	{
		checkInitialization();
      boolean result = true;
      if (isArrayFull())
      {
         result = false;
      }
      else
      {  // Assertion: result is true here
         bag[numberOfEntries] = newEntry;
         numberOfEntries++;
      } // end if
      
      return result;
	} // end add
   
	public T[] toArray()
	{
		checkInitialization();
      
      // The cast is safe because the new array contains null entries.
      @SuppressWarnings("unchecked")
      T[] result = (T[])new Object[numberOfEntries]; // Unchecked cast

      for (int index = 0; index < numberOfEntries; index++) 
      {
         result[index] = bag[index];
      } // end for
      
      return result;
      // Note: The body of this method could consist of one return statement,
      // if you call Arrays.copyOf
	} // end toArray

	public boolean isEmpty()
	{
      return numberOfEntries == 0;
	} // end isEmpty

	public int getCurrentSize()
	{
      return numberOfEntries;
	} // end getCurrentSize

	public int getFrequencyOf(T anEntry)
	{
		checkInitialization();
      int counter = 0;

      for (int index = 0; index < numberOfEntries; index++) 
      {
         if (anEntry.equals(bag[index]))
         {
            counter++;
         } // end if
      } // end for

      return counter;
	} // end getFrequencyOf

   public boolean contains(T anEntry)
	{
		checkInitialization();
      return getIndexOf(anEntry) > -1; // or >= 0
	} // end contains
   
	public void clear() 
	{
      while (!isEmpty())
         remove();
	} // end clear
	
	public T remove()
	{
		checkInitialization();
      T result = removeEntry(numberOfEntries - 1);
      return result;
	} // end remove
	
	public boolean remove(T anEntry)
	{
		checkInitialization();
      int index = getIndexOf(anEntry);
      T result = removeEntry(index);         
      return anEntry.equals(result);
	} // end remove   
	
   // Returns true if the array bag is full, or false if not.
	private boolean isArrayFull()
	{
		
		
		return numberOfEntries >= bag.length;
	} // end isArrayFull
   
	private int getIndexOf(T anEntry)
	{
		int where = -1;
		boolean found = false;      
		int index = 0;
      
      while (!found && (index < numberOfEntries))
		{
			if (anEntry.equals(bag[index]))
			{
				found = true;
				where = index;
			} // end if
         index++;
		} // end while
      
		return where;
	} // end getIndexOf
   
	private T removeEntry(int givenIndex)
	{
		T result = null;
      
		if (!isEmpty() && (givenIndex >= 0))
		{
         result = bag[givenIndex];          // Entry to remove
         int lastIndex = numberOfEntries - 1;
         bag[givenIndex] = bag[lastIndex];  // Replace entry to remove with last entry
         bag[lastIndex] = null;             // Remove reference to last entry
         numberOfEntries--;
		} // end if
      
      return result;
	} // end removeEntry
   
   private void checkInitialization()
   {
      if (!initialized)
         throw new SecurityException("ArrayBag object is not initialized properly.");
   } // end checkInitialization
} // end ArrayBag