package service.dto;

public class Menti {

	private int mtrId;
	private int id;
	
	public int getMtrId() {
		return mtrId;
	}
	public void setMtrId(int mtrId) {
		this.mtrId = mtrId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Menti(int mtrId) {
		super();
		this.mtrId = mtrId;
	}
	
}
