import java.util.*;
import java.io.*;



public class LinkApproach
{
	
	
	public static void main(String[] args) 
	{
		ArtistLink[] artistList= new ArtistLink[200];
		
		
		readFile(artistList);
		  
	}
	
	private static void readFile(ArtistLink[] artistList)
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
					
					artistList[n]=new ArtistLink(artistID, artistName, n+1);
					artistList[n].setLink(artistList[n].getID());
					n++;
				}
				
				while(input2.hasNext())
				{
					if(input2.next().equals("A"))
					{
						
						artistID++;
						String name=input2.nextLine();
						
						artistList[n]= new ArtistLink(artistID, name,n+1);
						artistList[n].setLink(artistList[n].getID());
						n++;
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
								if(i!=0)
								
									artistList[i-1].setLink(artistList[i].getID());
									artistList[i].setLink(0);
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
			
			
			File file3 = new File("p2_3rdApproach.txt");
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
	        output.write("DURATION OF THE METHOD LINK APPROACH IS "+duration+ " NANO SECONDS");
				
			output.close();
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}

}
