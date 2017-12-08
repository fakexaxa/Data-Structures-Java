
public class mainProgram {

	public static void main(String[] args) 
	{
		System.out.println("	Exam2 Rynnand Arriola ");
		String file=("1038+Spring Flowers*1$800.99");
		Step1 s= new Step1(file);
		
		String artFile=("e2arts.txt");
		
		System.out.println("\nStep2 Rynnand Arriola \n");
		Step2 s2= new Step2(artFile);
		
		String step3string=("5+6*2-9/3/2");
		SymbolTable symboltable= new SymbolTable(step3string);
		
		Step3 s3= new Step3();
		s3.convertOutput(step3string);
	}

}
