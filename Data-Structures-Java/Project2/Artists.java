
public class Artists
{

	protected int id;
	protected  String name;
	
	public Artists(int id, String name)
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
	
	
	public String toString()
	{
		return String.format("%s%-20s", id,name);
	}
}
