import java.util.*;
import java.io.*;



public class arrayApproach 
{
	
	
	public static void main(String[] args) 
	{
		Artists[] artistList= new Artists[82];
		
		
		readFile(artistList);
		  
	}
	
	private static void readFile(Artists[] artistList)
	{
	
		int n=0;
		try
		{		
			File file= new File("p2Artists.txt");
			File file2= new File("p2changes.txt");
			Scanner input= new Scanner(file);
			Scanner input2= new Scanner(file2);
			
			try
			{
				
				int artistID=0;
				
				while(input.hasNext())
				{
					artistID=input.nextInt();
					String artistName=input.nextLine();
					artistList[n++]=new Artists(artistID, artistName);
				}
				
				while(input2.hasNext())
				{
					if(input2.next().equals("A"))
					{
						artistID++;
						String name=input2.nextLine();
						artistList[n++]= new Artists(artistID, name);
					}	
					else
					{
						int id=input2.nextInt();
						input2.nextLine();
						
						boolean found=false;
						int i=0;
						
						while(!found&&i<n)
							if(artistList[i].getID()==id)
							{
								found=true;
								for(int y=i;y<n-1;y++)
								{
									artistList[y]=artistList[y+1];
								}
								n--;
							}
							else
								i++;
					}	
					
				}	
				
			}
			
			catch(Exception e)
			{
				e.printStackTrace();
			}
			input.close();
			input2.close();
			
			
			File file3 = new File("p2_1stApproach.txt");
			PrintWriter output= new PrintWriter(file3);
			if (!file3.exists())
			{	
				file3.createNewFile();
			}
			long startTime = System.nanoTime();    
			
			for(int i=0;i<n;i++)
			{
				output.println(artistList[i]);
			}
			
	        long endTime = System.nanoTime();
	        long duration = (endTime - startTime);
	        output.write("DURATION OF THE METHOD ARRAY APPROACH IS "+duration+ " NANO SECONDS");
				
			output.close();
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}

}
