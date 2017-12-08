import java.io.BufferedReader;
import java.io.FileReader;


public class ReadItemD {

    BufferedReader bufferedReader;

    ReadItemD(String file){
        FileReader reader;
        try{reader = new FileReader(file);
            bufferedReader = new BufferedReader(reader);
        }
        catch (Exception e){
           
            e.printStackTrace();
        }

    }

    String readLine(){
        try {
            return bufferedReader.readLine();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    void close(){
        try {
            bufferedReader.close();
        }
        catch (Exception e){
            e.printStackTrace();

        }

    }
}