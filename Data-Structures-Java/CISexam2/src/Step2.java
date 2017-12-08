import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;


public class Step2 {

	int STACK_SIZE=20;
    BufferedReader bufferedReader;
    MyStack<MyArt>myArtStack=new MyStack<MyArt>(STACK_SIZE);
    ArrayList<MyArtistList> LIST= new ArrayList<>();
    MyStack<String>titleStack = new MyStack<String>();
	MyStack<String>nameStack = new  MyStack<String>();
	
	

    Step2(String file){
        FileReader reader;
        try{reader = new FileReader(file);
            bufferedReader = new BufferedReader(reader);
            String lines;
            
            try
        	{
        		 File file2 = new File("e2artists.txt");
        		 Scanner input= new Scanner(file2);
        		 
        		 while(input.hasNext())
        		 {
        			 int id=input.nextInt();
        			 String name=input.next();
        			 
        			 input.nextLine();
        			 
        			 MyArtistList a=new MyArtistList(id, name);
        			 LIST.add(a);
        		 }
        	
        	input.close();	
        	}
        	catch(Exception e)
        	{
        		e.printStackTrace();
        	}
            
            while ((lines = bufferedReader.readLine()) != null) 
            {
            	String splitArray[] = lines.split("[+*$]");
            	
            	
 
            	
            	 for(int i=0;i<LIST.size();i++)
        		 {
        			 if(Integer.parseInt(splitArray[2])==LIST.get(i).getId())
        			 
        				// System.out.println(splitArray[1]+" "+LIST.get(i).getName()); 
        			 myArtStack.push(new MyArt(splitArray[1], LIST.get(i).getName()));
        			 
        		 }
            	
            }
            
			
				
            while(!myArtStack.isEmpty())
            {
            	System.out.println(myArtStack.pop());
            }
            
           
           
        }
        catch (Exception e){
           
            e.printStackTrace();
        }
        
       
    }

 
}