
public class Exam3 {

	public static void main(String[] args) {
		
		String file ="p7Arts.txt";
		MyArtList artistList= new MyArtList(file);
		artistList.print("Rynnand Arriola", "Step2output.txt");
		artistList.printtoMonitor();

	}

}
