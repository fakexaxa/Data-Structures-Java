
public class Exam3 {

	public static void main(String[] args) {
		
		String file ="p7Artist.txt";
		MyArtistList artistList= new MyArtistList(file);
		artistList.print("Rynnand Arriola", "Step1output.txt");
		artistList.printtoMonitor();

	}

}
