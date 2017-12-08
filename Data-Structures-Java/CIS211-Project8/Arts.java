
public class Arts implements Comparable<Artist>
{
	protected int art_id;
	protected String title;
	protected int id;
	protected int apvalue;
	
		public Arts(int art_id, String title, int id, int apvalue)
		{
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
		@Override
		public int compareTo(Artist o) {
			 if (getId() == o.getID())
		            return 1;
		        else if (getId() < o.getID())
		            return -1;
		        else
		            return 0;
		}

		public String toString()
		{
			return String.format("%-10s%-30s%-10s%-10s\n",art_id, title, id, apvalue);
		}

		
}
