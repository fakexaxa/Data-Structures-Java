import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class mainProgram {
	
	static Artist artistRecord;
	static Arts artsRecord;
	
	public static void main(String[] args) 
	{
		String file="p7Artist.txt";
		String file2="p7Arts.txt";
		
		printArtist(file, file2);
	}
	public static void printArtist(String file, String file2)
	{
		ArrayList<Artist>artistTable= new ArrayList<Artist>();
		ArrayList<Arts>artsTable= new ArrayList<Arts>();
		
		try
		{
			File inputFile= new File(file2);
			Scanner sc2= new Scanner(inputFile);
			sc2.useDelimiter("\t|\r\n");
			
			while(sc2.hasNext())
			{
				int art_id=sc2.nextInt();
    			String title= sc2.next();
    			int id2=sc2.nextInt();
    			int apvalue=sc2.nextInt();
    				
				artsRecord=new Arts(art_id, title,id2,apvalue);
				artsTable.add(artsRecord);
					
			}
			sc2.close();
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		try
		{
			File inputFile= new File(file);
			Scanner sc= new Scanner(inputFile);
			File xfile = new File("p8out(Rynnand Arriola).txt");
			PrintWriter output= new PrintWriter(xfile);
			if (!xfile.exists())
			{	
				xfile.createNewFile();
			}
			
			while(sc.hasNext())
			{
				int id= sc.nextInt();
				String name= sc.nextLine();
				
				artistRecord= new Artist (id, name);
				artistTable.add(artistRecord);
				
				
			}
			sc.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		try
		{
		File xfile = new File("p8out(Rynnand Arriola).txt");
		PrintWriter output= new PrintWriter(xfile);
		if (!xfile.exists())
		{	
			xfile.createNewFile();
		}
		for (int i=0; i<artistTable.size();i++) 
		{	
			output.println(artistTable.get(i));
			for(int x=0;x<artsTable.size();x++)
			{
				int Result=artsTable.get(x).compareTo(artistTable.get(i));
				
				if(Result==1)
				{
					output.print(artsTable.get(x));
				}
			}
			output.println();
		}
		
		output.close();
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}


}
