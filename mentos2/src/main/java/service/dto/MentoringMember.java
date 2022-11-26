package service.dto;

public class MentoringMember {

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
	public MentoringMember(int mtrId) {
		super();
		this.mtrId = mtrId;
	}
}
