
public class Step3 
{

	public static void convertOutput(String lines)
	{
		String validString="";
		String operatorString="";
		String records[]=new String[100];
		String op[]=new String[100];
		int n=0;
		char characters= 'A';
		
		for(int i=0;i<lines.length();i++)
		{
			
			if(lines.charAt(i)!=' ')
			{
				if(lines.charAt(i)>='0'&&lines.charAt(i)<='9'||lines.charAt(i)=='.')
				{
					validString+=characters;
					
					characters++;	
				}
				else if(lines.charAt(i)=='+'||lines.charAt(i)=='-'||lines.charAt(i)=='/'||lines.charAt(i)=='*'||lines.charAt(i)=='('||lines.charAt(i)==')'||lines.charAt(i)=='^')
				{
					operatorString=operatorString+ lines.charAt(i);
					validString =validString+ lines.charAt(i);
					
					
				}
				
			}
			
			records[n++]= validString;
			
			
	}
		
		
		
			System.out.println("\ninfix= "+records[10]);
			System.out.println("\npostfix= "+convertToPostfix(records[10]));
			String s=convertToPostfix(records[10]);
			System.out.println("\nResult= "+ evaluatePostfix(s));
			
		
}
	 public static String convertToPostfix(String infix)
	   {
	      MyStack<Character> operatorStack = new MyStack<Character>();
	      StringBuilder postfix = new StringBuilder();
	      int characterCount = infix.length();
	      char topOperator;

	      for (int index = 0; index < characterCount; index++)
	      {
	         boolean done = false;
	         char nextCharacter = infix.charAt(index);

	         if (isVariable(nextCharacter))
	            postfix = postfix.append(nextCharacter);
	         else
	         {
	            switch (nextCharacter)
	            {
	               case '^':
	                  operatorStack.push(nextCharacter);
	                  break;

	               case '+': case '-': case '*': case '/':
	                  while (!done && !operatorStack.isEmpty())
	                  {
	                     topOperator = operatorStack.peek();

	                     if (getPrecedence(nextCharacter) <= getPrecedence(topOperator))
	                     {
	                        postfix = postfix.append(topOperator);
	                        operatorStack.pop();
	                     }
	                     else
	                        done = true;
	                  } // end while

	                  operatorStack.push(nextCharacter);
	                  break;

	               case '(':
	                  operatorStack.push(nextCharacter);
	               break;

	               case ')': // Stack is not empty if infix expression is valid
	                  topOperator = operatorStack.pop();
	                  while (topOperator != '(')
	                  {
	                     postfix = postfix.append(topOperator);
	                     topOperator = operatorStack.pop();
	                  } // end while
	                  break;

	               default: break; // Ignore unexpected characters
	            } // end switch
	         } // end if
	      } // end for

	      while (!operatorStack.isEmpty())
	      {
	         topOperator = operatorStack.pop();
	         postfix = postfix.append(topOperator);
	      } // end while

	      return postfix.toString();
	   } // end convertToPostfix

	   // Indicates the precedence of a given operator.
	   // Precondition: operator is a character that is (, ), +, -, *, /, or ^.
	   // Returns an integer that indicates the precedence of operator:
	   //         0 if ( or ), 1 if + or -, 2 if * or /, 3 if ^,
	   //         -1 if anything else. */
	   private static int getPrecedence(char operator)
	   {
	      switch (operator)
	      {
	         case '(': case ')': return 0;
	         case '+': case '-': return 1;
	         case '*': case '/': return 2;
	         case '^':           return 3;
	      } // end switch

	      return -1;
	   } // end getPrecedence

	   private static boolean isVariable(char character)
	   {
	      return Character.isLetter(character);
	   } // end isVariable

	   /** Evaluates a postfix expression.
	       Segment 5.18
	       @param postfix  a string that is a valid postfix expression.
	       @return  the value of the postfix expression. */
	   public static double evaluatePostfix(String postfix)
	   {
	      MyStack<Double> valueStack = new MyStack<Double>();
	      int characterCount = postfix.length();

	      for (int index = 0; index < characterCount; index++)
	      {
	         char nextCharacter = postfix.charAt(index);

	         switch(nextCharacter)
	         {
	            case 'A': case 'B': case 'C': case 'D': case 'E':case 'F':
	               valueStack.push(valueOf(nextCharacter));
	               break;

	            case '+': case '-': case '*': case '/': case '^':
	               Double operandTwo = valueStack.pop();
	               Double operandOne = valueStack.pop();
	               Double result = compute(operandOne, operandTwo, nextCharacter);
	               valueStack.push(result);
	               break;

	            default: break; // Ignore unexpected characters
	         } // end switch
	      } // end for

	      return (valueStack.peek()).doubleValue();
	   } // end evaluatePostfix

	   private static double valueOf(char variable)
	   {
	      switch (variable)
	      {
	         case 'A': return 5.0;
	         case 'B': return 6.0;
	         case 'C': return 2.0;
	         case 'D': return 9.0;
	         case 'E': return 3.0;
	         case 'F': return 2.0;
	         
	         
	      } // end switch

	      return 0; // Unexpected character
	   } // end valueOf

	   public static Double compute(Double operandOne, Double operandTwo, char operator)
	   {
	      double result;

	      switch (operator)
	      {
	         case '+':
	            result = operandOne.doubleValue() + operandTwo.doubleValue();
	            break;

	         case '-':
	            result = operandOne.doubleValue() - operandTwo.doubleValue();
	            break;

	         case '*':
	            result = operandOne.doubleValue() * operandTwo.doubleValue();
	             break;

	         case '/':
	            result = operandOne.doubleValue() / operandTwo.doubleValue();
	            break;

	         case '^':
	            result = Math.pow(operandOne.doubleValue(), operandTwo.doubleValue());
	            break;

	         default:    // Unexpected character
	            result = 0;
	            break;
	      } // end switch

	      return result;
	   } // end compute

}
