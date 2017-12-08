
public class ArtistWork
{	protected String name;
	protected int art_id;
	protected String title;
	protected int id;
	protected int apvalue;
	
	
		public ArtistWork(String name, int art_id, String title, int id, int apvalue)
		{
			this.name=name;
			this.art_id=art_id;
			this.title=title;
			this.id=id;
			this.apvalue=apvalue;
		}

		public int getArt_id() 
		{
			return art_id;
		}

		public void setArt_id(int art_id) 
		{
			this.art_id = art_id;
		}

		public String getTitle() 
		{
			return title;
		}

		public void setTitle(String title) 
		{
			this.title = title;
		}
		public String getName() 
		{
			return name;
		}

		public void setName(String name) 
		{
			this.name = name;
		}

		public int getId()
		{
			return id;
		}

		public void setId(int id) 
		{
			this.id = id;
		}

		public int getApvalue() 
		{
			return apvalue;
		}

		public void setApvalue(int apvalue)
		{
			this.apvalue = apvalue;
		}
		public String toString()
		{
			return String.format("%-10s%-30s%-30s%-10s%-10s\n",id,name, title, art_id, apvalue);
		}

}
