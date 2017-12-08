import java.util.ArrayList;
import java.util.*;
import java.io.*;

public class MyArtistList 
{
	String file;
	ArrayList<Artist>artistRecord= new ArrayList<Artist>();
	
	MyArtistList(String file)
	{
		try
		{
			File inputFile= new File(file);
			Scanner sc= new Scanner(inputFile);
			
			while(sc.hasNext())
			{
				int id= sc.nextInt();
				String name= sc.nextLine();
				
				artistRecord.add(new Artist(id, name));
				
			}
			sc.close();
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	public void print(String myName,String outputFile)
	{
		try
		{
		File xfile = new File(outputFile);
		PrintWriter output= new PrintWriter(xfile);
		if (!xfile.exists())
		{	
			xfile.createNewFile();
		}
		output.println(myName);
		for (Artist l: artistRecord) 
		{	
			output.println(l);
		}
		
		output.close();
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void printtoMonitor()
	{
		for (Artist l: artistRecord) 
		{	
			System.out.println(l);
		}
	}
	

}
