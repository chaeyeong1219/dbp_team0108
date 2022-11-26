package service.dto;

import java.sql.Date;

public class Post {
	private int postId;
	private String title;
	private String content;
	private Date createdDate;
	private int studyId;
	private int mtrId;
	
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
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
	public Post() {}
	public Post(String title, String content, Date createdDate, int studyId) {
		this.title = title;
		this.content = content;
		this.createdDate = createdDate;
		this.studyId = studyId;
	
	}
	
	public Post(int postId, String title, String content, Date createdDate, int studyId) {
		this.postId = postId;
		this.title = title;
		this.content = content;
		this.createdDate = createdDate;
		this.studyId = studyId;
	
	}
	
	
	
	
}
