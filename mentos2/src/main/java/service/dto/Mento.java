package service.dto;

public class Mento {

	private int mtrId;
	private int id;
	private float score;
	private String introduce = null;
	
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
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	
	public Mento(int mtrId, float score, String introduce) {
		super();
		this.mtrId = mtrId;
		this.score = score;
		this.introduce = introduce;
	}
	
}
