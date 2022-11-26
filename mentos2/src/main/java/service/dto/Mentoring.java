package service.dto;

import java.sql.Date;

/**
 * 사용자 관리를 위해 필요한 도메인 클래스. USERINFO 테이블과 대응됨
 */
public class Mentoring {
	 private int mtrId;
	   private String part;
	   private Date deadline;
	   private String region;
	   private int quota;
	   private int leaderId;

	   public Mentoring() { }      // 기본 생성자
	   
	   public Mentoring(int mtrId, String part, Date deadline, String region, int quota, int leaderId) {
	      super();
	      this.mtrId = mtrId;
	      this.part = part;
	      this.deadline = deadline;
	      this.region = region;
	      this.quota = quota;
	      this.leaderId = leaderId;
	   }
	   
	   public Mentoring(String part, Date deadline, String region, int quota) {
	      super();
	      this.part = part;
	      this.deadline = deadline;
	      this.region = region;
	      this.quota = quota;
	   }
	   
	   public Mentoring(String part, Date deadline, String region, int quota, int leaderId) {
	      super();
	      this.part = part;
	      this.deadline = deadline;
	      this.region = region;
	      this.quota = quota;
	      this.leaderId = leaderId;
	   }

	   public void update(Mentoring updateMentoring) {
	      this.mtrId = updateMentoring.mtrId;
	        this.part = updateMentoring.part;
	        this.deadline = updateMentoring.deadline;
	        this.region = updateMentoring.region;
	        this.quota = updateMentoring.quota;
	        this.leaderId = updateMentoring.leaderId;
	    }
	   
	   public int getmtrId() {
	      return mtrId;
	   }
	   
	   public void setmtrId(int studentId) {
	      this.mtrId = studentId;
	   }

	   public String getPart() {
	      return part;
	   }
	   
	   public void setPart(String part) {
	      this.part = part;
	   }

	   public Date getDeadline() {
	      return deadline;
	   }
	   
	   public void setDeadline(Date deadline) {
	      this.deadline = deadline;
	   }

	   public String getRegion() {
	      return region;
	   }
	   
	   public void setRegion(String region) {
	      this.region = region;
	   }

	   public int getQuota() {
	      return quota;
	   }
	   
	   public void setQuota(int quota) {
	      this.quota = quota;
	   }
	   
	   public int getLeaderId() {
	      return leaderId;
	   }
	   
	   public void setLeaderId(int leaderId) {
	      this.leaderId = leaderId;
	   }

	   @Override
	   public String toString() {
	      return "Mentoring [mtrId=" + mtrId + ", part=" + part + ", deadline=" + deadline + ", region="
	            + region + ", quota=" + quota + ", leaderId=" + leaderId + "]";
	   }



}
