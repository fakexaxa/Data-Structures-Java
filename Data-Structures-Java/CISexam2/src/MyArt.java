
public class MyArt 
{

	private String artName;
	private String artistName;
	
	MyArt(String artName, String artistName)
	{
		this.artName=artName;
		this.artistName=artistName;
		
	}

	public String getArtName() {
		return artName;
	}

	public void setArtName(String artName) {
		this.artName = artName;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}
	public String toString()
	{
		return (artName+"\t"+artistName);
	}

}
