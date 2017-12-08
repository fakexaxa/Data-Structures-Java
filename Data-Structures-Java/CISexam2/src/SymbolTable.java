import java.util.ArrayList;

public class SymbolTable 
{
	
	ArrayList<Variable> table= new ArrayList<>();
	Variable a;
	char characters='A';
	
	
	SymbolTable(String input)
	{
		for (int i=0;i<input.length();i++)
		{
			
			
			if(input.charAt(i)>='0'&&input.charAt(i)<='9')
			{
				a= new Variable(characters, input.charAt(i)-48); 
				
				characters++;
				table.add(a);
			}
		}
				
		System.out.println("\nExam2:Step 3 by Rynnand Arriola\nSymbol Table");
		for(int i=0;i<table.size();i++)
		{
			System.out.println(table.get(i));
		}
		  
	}
	

}
