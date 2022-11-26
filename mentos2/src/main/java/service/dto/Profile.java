package service.dto;

public class Profile {
	private int id = 0;
	
	private String name = null;
	private String email = null;
	private String part = null;
	private String image = null;
	private float score = 0;

	public Profile() {}
	public Profile(String name, String email, String part, String image, float score){
		//this.id = id;
		this.name = name;
		this.email = email;
		this.part = part;
		this.image = image;
		this.score = score;
	}
	public Profile(int id, String name, String email, String part, String image, float score){
		this.id = id;
		this.name = name;
		this.email = email;
		this.part = part;
		this.image = image;
		this.score = score;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) { 
		this.id = id; 
		}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPart() {
		return part;
	}
	public void setPart(String part) {
		this.part = part;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
}
