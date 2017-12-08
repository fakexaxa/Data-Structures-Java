
public class Artist
{

	private int id;
	private String name;
	
	public Artist(int id, String name)
	{
		this.id=id;
		this.name=name;
	}
	
	int getID()
	{
		return id;
	}
	String getName()
	{
		return name;
	}
	void setID(int newID)
	{
		id=newID;
	}
	void setName(String newName)
	{
		name=newName;
	}
	
	
	
}
