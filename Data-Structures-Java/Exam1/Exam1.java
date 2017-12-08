import java.util.*;
import java.io.*;
import java.util.ArrayList;

public class Exam1 
{
	
	
	public static void main(String[] args) 
	{
		
		ArrayList<itemD> itemArrayList = new ArrayList<itemD>();
		ArrayList<ItemNode> LinkList = new ArrayList<ItemNode>();
		
		
	
		new ArrayList<itemD>();
		String file=("items.txt");
		String file2=("changes.txt");
		
		ReadItemD items= new ReadItemD(file);
		ReadItemD changes= new ReadItemD(file2);
		
		ReadItemList itemsList= new ReadItemList(file);
		ReadItemList changesList= new ReadItemList(file2);
		
		
		
		Step2 deleteByte = new Step2();
		deleteByte.Read(items, itemArrayList);
		deleteByte.Read(changes, itemArrayList);
		
		ItemList Link= new ItemList();
		Link.ReadList(itemsList, LinkList);
		Link.ReadList(changesList, LinkList);
		
		
				
		  
	}
	

}
class Step2
{
	String line;
	
	itemD updatedTable;
	itemD firstTable;
	ArrayList<itemD> firstTableArrayList = new ArrayList<itemD>();
	
	public void Read(ReadItemD records, ArrayList<itemD> itemArrayList)
	{
		
		
		while((line=records.readLine())!=null)
		{
			String splitArray[] = line.split(",");
			
			
			
			if(splitArray[0].equalsIgnoreCase("A")||splitArray[0].equalsIgnoreCase("D"))
			{	
			
				if(splitArray[0].equalsIgnoreCase("A"))
				{ 
		  		 
		            updatedTable= new itemD(Integer.parseInt(splitArray[1]),splitArray[2],false);
		            itemArrayList.add(updatedTable);        
				}
				if(splitArray[0].equalsIgnoreCase("D"))
				{
					for(int i=0;i<itemArrayList.size();i++)
					{
						if(itemArrayList.get(i).getID()==Integer.parseInt(splitArray[1]))
						{
							itemArrayList.get(i).setDelete(true);
						}
					}
				}	
				
			}
			else
			{
				updatedTable= new itemD(Integer.parseInt(splitArray[0]),splitArray[1],false);
	            itemArrayList.add(updatedTable); 
	            firstTable= new itemD(Integer.parseInt(splitArray[0]),splitArray[1],false);
	            firstTableArrayList.add(firstTable);
			}
			
		}
		try
		{
			File file3 = new File("ex1out2.txt");
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

