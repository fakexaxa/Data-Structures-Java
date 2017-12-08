import java.util.*;
import java.io.*;



public class deleteByte
{
	
	
	public static void main(String[] args) 
	{
		ArtistD[] artistList= new ArtistD[200];
		
		
		readFile(artistList);
		  
	}
	
	private static void readFile(ArtistD[] artistList)
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
					artistList[n++]=new ArtistD(artistID, artistName, false);
				}
				
				while(input2.hasNext())
				{
					if(input2.next().equals("A"))
					{
						artistID++;
						String name=input2.nextLine();
						artistList[n++]= new ArtistD(artistID, name,false);
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
									artistList[i].setDelete(true);
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
			
			
			File file3 = new File("p2_2ndApproach.txt");
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
	        output.write("DURATION OF THE METHOD DELETE BYTE IS "+duration+ " NANO SECONDS");
				
			output.close();
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}

}
