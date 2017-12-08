
public class ArtistLink extends Artists 
{
	private int link;

	public ArtistLink(int id, String name, int link) {
		super(id, name);
		
	}

	public int getLink() 
	{
		return link;
	}

	public void setLink(int newLink) 
	{
		link = newLink;
	}
	public String toString()
	{
		return super.toString()+String.format("%5s", link);
		
	}


}
