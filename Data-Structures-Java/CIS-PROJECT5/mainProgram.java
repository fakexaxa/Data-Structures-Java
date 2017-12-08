import java.util.ArrayList;

public class mainProgram {

	public static void main(String[] args)
	{
		ArrayList<Long> factorialRecord = new ArrayList<>();
		ArrayList<Long> factorialTime = new ArrayList<>();
		ArrayList<Long> nfactorialRecord = new ArrayList<>();
		ArrayList<Long> nfactorialTime = new ArrayList<>();
		
		ArrayList<Long> fibonacciRecord = new ArrayList<>();
		ArrayList<Long> fibonacciTime = new ArrayList<>();
		ArrayList<Long> nfibonacciRecord = new ArrayList<>();
		ArrayList<Long> nfibonacciTime = new ArrayList<>();
		
		
		
		
		
		System.out.println("\tTest Recursive Factorial");
		getFactorialRecords(factorialRecord, factorialTime);
		printList(factorialRecord, factorialTime);
		
		System.out.println("\tTest Iterative Factorial");
		getnFactorialRecords(nfactorialRecord, nfactorialTime);
		printList(nfactorialRecord, nfactorialTime);
		
		System.out.println("\tTest Recursive Fibonacci");
		getFibonacciRecords(fibonacciRecord, fibonacciTime);
		printList(fibonacciRecord, fibonacciTime);
		
		System.out.println("\tTest Iterative Fibonacci");
		getnFibonacciRecords(nfibonacciRecord, nfibonacciTime);
		printList(nfibonacciRecord, nfibonacciTime);
		
		
		System.out.println("\tPrint Palindrome\n");
		printPalindrome();
		
		System.out.println("\tPrint Binary Search\n");
		printBinarySearch();
		
		
		
		
		
	}
	public static long factorial(int n)
	{
		if(n==0)
		
			return 1;
		else
		
			return n*factorial(n-1);
	}
	public static long nfactorial(int n)
	{
		
		long result = 1;

        for (int factor = 2; factor <= n; factor++)
        {
            result *= factor;
        }

        return result;	     	
	}
	public static void printList(ArrayList<Long> record, ArrayList<Long> time)
	{
		System.out.printf("%-10s%-30s%-10s\n","n","Result", "Time\n");
		for(int i=0;i<20;i++)
		{
			
			System.out.printf("%-10s%-30s%-10s\n",i+1, record.get(i), time.get(i));
		}
		System.out.println("\n");
	}
	public static void getFactorialRecords(ArrayList<Long> record, ArrayList<Long> time)
	{
		for(int i=1;i<=20;i++)
		{
			long start =System.nanoTime();
			record.add((long) factorial(i));
			long end= System.nanoTime();
			time.add(end-start);	
		}
		
	}
	public static void getnFactorialRecords(ArrayList<Long> record, ArrayList<Long> time)
	{
		for(int i=1;i<=20;i++)
		{
			long start =System.nanoTime();
			record.add((long) nfactorial(i));
			long end= System.nanoTime();
			time.add(end-start);	
		}	
	}
	public static long nfibonacci(int index)
	{
		long f0 = 0;       
		long f1 = 1; 
		long currentFib = 0;  

		if (index == 0)
			return f0;
		else if (index == 1)
			return f1;       
      else 
      {
			for (int i = 1; i < index; i++)
			{
				currentFib = f0 + f1;     
				f0 = f1;                  
				f1 = currentFib;          
			} 
			return currentFib;                            
      }                       
	}
	public static long fibonacci(int index)
	{
		if(index==0)
			return 0;
		else if(index==1)
			return 1;
		else 
			return fibonacci(index-1)+fibonacci(index-2);
		
	}
	public static void getFibonacciRecords(ArrayList<Long> record, ArrayList<Long> time)
	{
		for(int i=1;i<=20;i++)
		{
			long start =System.nanoTime();
			record.add((long) fibonacci(i));
			long end= System.nanoTime();
			time.add(end-start);	
		}	
	}
	public static void getnFibonacciRecords(ArrayList<Long> record, ArrayList<Long> time)
	{
		for(int i=1;i<=20;i++)
		{
			long start =System.nanoTime();
			record.add((long) nfibonacci(i));
			long end= System.nanoTime();
			time.add(end-start);	
		}	
	}
	public static boolean istPalindrom(char[] word){
	    int i1 = 0;
	    int i2 = word.length - 1;
	    while (i2 > i1) {
	        if (word[i1] != word[i2]) {
	            return false;
	        }
	        ++i1;
	        --i2;
	    }
	    return true;
	}
	public static void printPalindrome()
	{
		String[] Words= {"kayak", "mom","civic","moon","radar","noob","anime","games","noon","stats","ugly","coins"};
		
		for(int i=0;i<Words.length;i++)
		{
			System.out.println("The word "+Words[i]+ " Palindrome? "+ istPalindrom(Words[i].toCharArray()));
		}
		System.out.println("\n");
	}
	public static int binarySearch(int[] a, int target) {
	    return binarySearch(a, 0, a.length-1, target);
	}

	public static int binarySearch(int[] a, int start, int end, int target) 
	{
	    int middle = (start + end) / 2;
	    if(end < start) {
	        return -1;
	    } 

	    if(target==a[middle]) {
	        return middle;
	    } else if(target<a[middle]) {
	        return binarySearch(a, start, middle - 1, target);
	    } else {
	        return binarySearch(a, middle + 1, end, target);
	    }
	}
	public static void printBinarySearch()
	{
int[] number= new int[1000];
	
		int rand= (int)(Math.random()*1000+1);
		
		for(int i = 0; i<number.length; i++) 
		{
				number[i]=(i+1)*3;	
		}
		System.out.println("Number "+rand*3+ " is in index of "+ binarySearch(number, rand*3));
	}

}
