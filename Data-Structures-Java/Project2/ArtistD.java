
public class ArtistD extends Artists 
{
	private boolean delete;

	public ArtistD(int id, String name, boolean delete) 
	{
		super(id, name);
		
	}

	public boolean isDelete() {
		return delete;
	}

	public void setDelete(boolean delete) {
		this.delete = delete;
	}
	public String toString()
	{
		return super.toString()+String.format("%5s", delete);
		
		
	}

}
