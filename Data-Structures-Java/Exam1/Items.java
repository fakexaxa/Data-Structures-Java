
public class Items 
{
	private int id;
	private String title;
	
	public Items(int id, String title)
	{
		this.setId(id);
		this.setTitle(title);
	}

	int getID()
	{
		return id;
	}
	public void setId(int id) 
	{
		this.id = id;
	}

	public String getTitle() 
	{
		return title;
	}

	public void setTitle(String title) 
	{
		this.title = title;
	}
	public String toString()
	{
		return String.format("%s  %-20s", id,title);
	}

}
