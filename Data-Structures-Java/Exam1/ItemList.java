import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ItemList
{
	String line;
	int x=0;
	ItemNode updatedTable;
	ItemNode firstTable;
	ArrayList<ItemNode> firstTableArrayList = new ArrayList<ItemNode>();
	int link;
	
	public void ReadList(ReadItemList records, ArrayList<ItemNode> itemArrayList)
	{
		
		
		while((line=records.readLine())!=null)
		{
			String splitArray[] = line.split(",");
			
			
			
			if(splitArray[0].equalsIgnoreCase("A")||splitArray[0].equalsIgnoreCase("D"))
			{	
			
				if(splitArray[0].equalsIgnoreCase("A"))
				{ 
		  		 
		            updatedTable= new ItemNode(Integer.parseInt(splitArray[1]),splitArray[2]);
		            itemArrayList.add(updatedTable);        
				}
				if(splitArray[0].equalsIgnoreCase("D"))
				{
					for(int i=0;i<itemArrayList.size();i++)
					{
						if(itemArrayList.get(i).getID()==Integer.parseInt(splitArray[1]))
						{
							itemArrayList.get(i).setLink(0);
						}
					}
				}	
				
			}
			else
			{
				
				
				updatedTable= new ItemNode(Integer.parseInt(splitArray[0]),splitArray[1]);
	            itemArrayList.add(updatedTable); 
	            firstTable= new ItemNode(Integer.parseInt(splitArray[0]),splitArray[1]);
	           
	            
	            firstTableArrayList.add(firstTable);
	            
	            
			}
		
			
		}
		
		
		
		try
		{
			File file3 = new File("ex1out3.txt");
			PrintWriter output= new PrintWriter(file3);
			if (!file3.exists())
			{	
				file3.createNewFile();
			}
			 
			output.write("Rynnand Arriola \n\n");
			for(int i=0;i<firstTableArrayList.size();i++)
			{
				output.println(firstTableArrayList.get(i));
			}
			
			output.write("\n\n\n");
			for(int i=0;i<itemArrayList.size();i++)
			{
				output.println(itemArrayList.get(i));
			}
	        output.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
	}
	
}