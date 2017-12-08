import java.util.ArrayList;
import java.util.*;
import java.io.*;

public class MyArtList 
{
	String file;
	ArrayList<Artist>artistRecord= new ArrayList<Artist>();
	ArrayList<Arts>artsRecord= new ArrayList<Arts>();
	ArrayList<ArtistWork>WorksRecord= new ArrayList<ArtistWork>();
	
	
	MyArtList(String file)
	{
		try
		{
			File inputFile= new File(file);
			Scanner sc_Arts= new Scanner(inputFile);
			sc_Arts.useDelimiter("\t|\r\n");
			while(sc_Arts.hasNext())
			{
				int art_id=sc_Arts.nextInt();
    			String title= sc_Arts.next();
    			int id2=sc_Arts.nextInt();
    			int apvalue=sc_Arts.nextInt();
    				
				artsRecord.add(new Arts(art_id, title,id2,apvalue));
				
			}
			sc_Arts.close();
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		try
		{
			File inputFile= new File("p7Artist.txt");
			Scanner sc= new Scanner(inputFile);
			
			while(sc.hasNext())
			{
				int id= sc.nextInt();
				String name= sc.nextLine();
				
				artistRecord.add(new Artist(id, name));
				
				for(int i=0;i<artsRecord.size();i++)
				{
					if(id==artsRecord.get(i).getId())
					{
						WorksRecord.add(new ArtistWork(name,artsRecord.get(i).getArt_id(), artsRecord.get(i).getTitle(), artsRecord.get(i).getId(), artsRecord.get(i).getApvalue()));
					}
				}
				
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
		for (ArtistWork l: WorksRecord) 
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
		for (ArtistWork l: WorksRecord) 
		{	
			System.out.println(l);
		}
	}
	

}
