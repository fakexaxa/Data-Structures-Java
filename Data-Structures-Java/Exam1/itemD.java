
public class itemD extends Items 
{
	private boolean delete;

	public itemD(int id, String title, boolean delete) 
	{
		super(id, title);
		
	}

	public boolean isDelete() {
		return delete;
	}

	public void setDelete(boolean delete) {
		this.delete = delete;
	}
	public String toString()
	{
		return super.toString()+String.format("%s", delete);
		
		
	}

}
