

public class Step1 {


    Step1(String lines){
    	String[] arr= lines.split("\\+|\\*|\\$");
    	String artID= " "+arr[0];
    	String artName= "-"+arr[1];
    	String artistID= "-"+arr[2];
    	String artValue= "-"+arr[3];
    	
            	
            
          System.out.println(artID + artName + artistID+ artValue);
    }

    
}