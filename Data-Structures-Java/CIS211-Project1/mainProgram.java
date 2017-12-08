import java.util.*;
import java.io.*;



public class mainProgram 
{
	public static void main (String[]args) throws IOException
	{
		ArrayList<Artists> myListArtist = new ArrayList<Artists>();
		ArrayList<Arts> myListArts = new ArrayList<Arts>();
		
		Arts  b;
		Artists a;
		int numOfArtist=0;
		int numOfArtworks=0;
		double totalAppValue=0;
		
		 
		File file2 = new File("p1artists_out1.txt");
		if (!file2.exists())
		{
			
			file2.createNewFile();
		}

		File file4 = new File("p1arts_out.txt");
		if (!file4.exists())
		{
			
			file4.createNewFile();
		}
		
		FileWriter output2 = new FileWriter(file4);
	 
	
		try
		{
		File file = new File("p1artists.txt");
		Scanner input = new Scanner(file);
		
		File file3 = new File("p1arts.txt");
	
		
		Scanner input2 = new Scanner(file3);
		input2.useDelimiter("\t|\r\n");
		
		
		while(input2.hasNext())
		{	

			
			
			int art_id=input2.nextInt();
			String title= input2.next();
			int id2=input2.nextInt();
			int apvalue=input2.nextInt();
			
			b= new Arts(art_id,title,id2,apvalue); 
			myListArts.add(b);		
			
			numOfArtworks=myListArts.size();
			
			totalAppValue=apvalue +totalAppValue;
			
			
			while(input.hasNext())
			{
				int id=input.nextInt();
				String name= input.nextLine();
				
				 a= new Artists(id,name); 
					myListArtist.add(a);	
					
					numOfArtist=id++;
					
			}
			
			
				
					for(int i=0;i<myListArtist.size();i++)
					{
					Artists d=myListArtist.get(i);
					int ID = d.getID();
					
					
					if (ID == id2)
						
					
						output2.write(String.format("%-10s%-30s%-20s%-10s%-10s\n",art_id, title,d.getName(), id2, apvalue));	
					
					
					}
					
		}
					output2.write("\nTOTAL NUMBER OF ARTISTS:	"	+numOfArtist
							+"\nTOTAL NUMBER OF ARTS:	"			+ numOfArtworks
							+ "\nTOTAL APPRAISE VALUE:	"			+totalAppValue);
					
		output2.close();
		input2.close();
		input.close();
		}
		
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		
		
		try (
				PrintWriter output = new PrintWriter(file2);
			)
		{
				// write to file using text I/O
				for (Artists l: myListArtist) 
				{
					output.print(l + "\n");
				
				}
				
				
		}
			
			
		
	}
}