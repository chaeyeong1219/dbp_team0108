package service.dto;

public class Member {

   private int id;
   private String password;
   private String name;
   private String phoneNum;
   private String email;
   private String part;
   private String position;
   private String image;
   
   
   public Member(int id, String password, String name, String phoneNum, String email, String part, String position,
         String image) {
      super();
      this.id = id;
      this.password = password;
      this.name = name;
      this.phoneNum = phoneNum;
      this.email = email;
      this.part = part;
      this.position = position;
      this.image = image;
   }
   
   
   


   public Member(int id, String password, String name, String phoneNum, String email, String part,
         String position) {
      super();
      this.id = id;
      this.password = password;
      this.name = name;
      this.phoneNum = phoneNum;
      this.email = email;
      this.part = part;
      this.position = position;
   }





   public int getId() {
      return id;
   }
   public void setId(int id) {
      this.id = id;
   }
   public String getPassword() {
      return password;
   }
   public void setPassword(String password) {
      this.password = password;
   }
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   public String getPhoneNum() {
      return phoneNum;
   }
   public void setPhoneNum(String phoneNum) {
      this.phoneNum = phoneNum;
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
   public String getPosition() {
      return position;
   }
   public void setPosition(String position) {
      this.position = position;
   }
   public String getImage() {
      return image;
   }
   public void setImage(String image) {
      this.image = image;
   }


   @Override
   public String toString() {
      return "Member [id=" + id + ", password=" + password + ", name=" + name + ", phoneNum=" + phoneNum
            + ", email=" + email + ", part=" + part + ", position=" + position + ", image=" + image + "]";
   }
   
   
   
}