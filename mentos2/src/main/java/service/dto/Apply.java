package service.dto;

public class Apply {
	private int applyId;
	private int studyId;
	private int mtrId;
	private int is_applied;
	
	public int getApplyId() {
		return applyId;
	}
	public void setApplyId(int applyId) {
		this.applyId = applyId;
	}
	public int getStudyId() {
		return studyId;
	}
	public void setStudyId(int studyId) {
		this.studyId = studyId;
	}
	public int getMtrId() {
		return mtrId;
	}
	public void setMtrId(int mtrId) {
		this.mtrId = mtrId;
	}
	public int getis_applied() {
		return is_applied;
	}
	public void setis_applied(int is_applied) {
		this.is_applied = is_applied;
	}
	
	public Apply() {}
	
	public Apply(int applyId, int studyId, int is_applied) {
		this.applyId = applyId;
		this.studyId = studyId;
		this.is_applied = is_applied;
	}
	public Apply(int applyId, int studyId, int mtrId, int is_applied) {
		this.applyId = applyId;
		this.studyId = studyId;
		this.mtrId = mtrId;
		this.is_applied = is_applied;
	}
	
	
	
}

