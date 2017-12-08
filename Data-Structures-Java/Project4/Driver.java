import java.util.*;

import java.io.*;


public class Driver
{
	public static void main(String[] args) 
	{
		
	
		
		readFile();
		
		 
	}  // end main
		
	public static void testPostfix(String infixExpression)
	{
		String postfixExpression =  Postfix.convertToPostfix(infixExpression);
		System.out.println( infixExpression+ "   "+ postfixExpression);
		
	} // end testPostfix 
	public static void readFile()
	{
		String records[]=new String[100];
		ArrayList<String> Input = new ArrayList<String>();
		
		char []charValues = {'a','b','c','d','e','f','g','h'};
		double []doubleValues={2.0,3.0,4.0,5.0,6.0,0.0,1.0,8.0};
		Variable symbolTable;
		
		
		
		int n=0;
		try
		{
			File file= new File("p4in.txt");
			Scanner input= new Scanner(file);
			
			while(input.hasNext())
			{
				String validString="";
				String operatorString="";
				String lines=input.nextLine();
				Input.add(lines);
				
				
				for(int i=0;i<lines.length();i++)
				{
					if(lines.charAt(i)!=' ')
					{
						if(lines.charAt(i)>='0'&&lines.charAt(i)<='9'||lines.charAt(i)=='.')
						{
							
							if(lines.charAt(i)=='1')
							{
								validString+= 'g';
							}
							if(lines.charAt(i)=='2')
							{
								validString+= 'a';
							}
							if(lines.charAt(i)=='3')
							{
								validString+= 'b';
							}
							if(lines.charAt(i)=='4')
							{
								validString+= 'c';
							}
							if(lines.charAt(i)=='5')
							{
								validString+= 'd';
							}
							if(lines.charAt(i)=='6')
							{
								validString+= 'e';
							}
							if(lines.charAt(i)=='0')
							{
								validString+= 'f';
							}
							if(lines.charAt(i)=='8')
							{
								validString+= 'h';
							}
							
						}
						else if(lines.charAt(i)=='+'||lines.charAt(i)=='-'||lines.charAt(i)=='/'||lines.charAt(i)=='*'||lines.charAt(i)=='('||lines.charAt(i)==')'||lines.charAt(i)=='^')
						{
							operatorString=operatorString+ lines.charAt(i);
							validString =validString+ lines.charAt(i);
							
						}
					}
				}
				
			records[n++]= (validString);
			
				
				
			}
			
			input.close();
			try
			{
				File file3 = new File("p41out.txt");
				PrintWriter output= new PrintWriter(file3);
				if (!file3.exists())
				{	
					file3.createNewFile();
				}
				output.println("  Symbol Table  ");
				output.println("Variable     Value");
				for(int i=0; i<8;i++)
				{
					symbolTable=new Variable(charValues[i], doubleValues[i]);
					output.println(symbolTable);
				}
				 
				output.printf("\n%-40s%-40s%-40s%-40s\n", "Input", "Infix", "Postfix", "Result");
				for(int i=0;i<n;i++)
				{
					
					
					String postfix =  Postfix.convertToPostfix(records[i]);
					output.printf("%-40s%-40s%-40s%-40s\n", Input.get(i), records[i], postfix, Postfix.evaluatePostfix(postfix));
				}
				
				
				output.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
							
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
}  // end Driver

/*
 Testing postfix expressions with
 a = 2, b = 3, c = 4, d = 5, e = 6
 
 
 Infix:   a+b
 Postfix: ab+
 
 
 Infix:   (a + b) * c
 Postfix: ab+c*
 
 
 Infix:   a * b / (c - d)
 Postfix: ab*cd-/
 
 
 Infix:   a / b + (c - d)
 Postfix: ab/cd-+
 
 
 Infix:   a / b + c - d
 Postfix: ab/c+d-
 
 
 Infix:   a^b^c
 Postfix: abc^^
 
 
 Infix:   (a^b)^c
 Postfix: ab^c^
 
 
 Infix:   a*(b/c+d)
 Postfix: abc/d+*
 
 
 Testing Question 6, Chapter 5:
 
 Infix:   (a+b)/(c-d)
 Postfix: ab+cd-/
 
 
 Infix:   a/(b-c)*d
 Postfix: abc-/d*
 
 
 Infix:   a-(b/(c-d)*e+f)^g
 Postfix: abcd-/e*f+g^-
 
 
 Infix:   (a-b*c)/(d*e^f*g+h)
 Postfix: abc*-def^*g*h+/
 
 
 Testing Question 7, Chapter 5:
 
 Q7a: ae+bd-/ : -4.0
 
 Q7b: abc*d*- : -58.0
 
 Q7c: abc-/d* : -10.0
 
 Q7d: ebca^*+d- : 49.0
 
 
 
 Done.
 */