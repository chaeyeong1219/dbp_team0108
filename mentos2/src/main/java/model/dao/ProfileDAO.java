package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import service.dto.Profile;

public class ProfileDAO {
	
	private static JDBCUtil jdbcUtil = null;   // JDBCUtil 참조 변수 선언
    
	   public ProfileDAO() {   // 생성자 
	      jdbcUtil = new JDBCUtil();      // JDBCUtil 객체 생성 및 활용
	      
	   }
	   
	   /*프로필 관리 테이블에 새로운 프로필 생성*/
	   public int createProfile(Profile profile) throws SQLException {
	      String sql = "INSERT INTO PROFILE (id, name, email, part, image, score) VALUES (?, ?, ?, ?, ?, ?)";      
	      Object[] param = new Object[] {profile.getId(), profile.getName(), profile.getEmail(),
	                  profile.getPart(), profile.getImage(), profile.getScore()};            
	      jdbcUtil.setSqlAndParameters(sql, param);   // JDBCUtil 에 insert문과 매개 변수 설정
	                  
	      try {            
	         int result = jdbcUtil.executeUpdate();   // insert 문 실행
	         return result;
	      } catch (Exception ex) {
	         jdbcUtil.rollback();
	         ex.printStackTrace();
	      } finally {      
	         jdbcUtil.commit();
	         jdbcUtil.close();   // resource 반환
	      }      
	      return 0;      
	   }
	   
	   /*기존의 프로필 정보를 수정*/
	   public int updateProfile(Profile profile) throws SQLException {
	      String sql = "UPDATE PROFILE "
	               + "SET name=?, email=?, part=?, image=?, score=? "
	               + "WHERE id=?";
	      Object[] param = new Object[] {profile.getName(), profile.getEmail(), 
	               profile.getPart(), profile.getImage(), profile.getScore(), 
	               (profile.getId()!=0) ? profile.getId() : null, 
	               profile.getId()};            
	      jdbcUtil.setSqlAndParameters(sql, param);   // JDBCUtil에 update문과 매개 변수 설정
	         
	      try {            
	         int result = jdbcUtil.executeUpdate();   // update 문 실행
	         return result;
	      } catch (Exception ex) {
	         jdbcUtil.rollback();
	         ex.printStackTrace();
	      }
	      finally {
	         jdbcUtil.commit();
	         jdbcUtil.close();   // resource 반환
	      }      
	      return 0;
	   }
	   
	   /*ID에 해당하는 프로필 삭제*/
	   public int removeProfile(int id) throws SQLException {
	      String sql = "DELETE FROM PROFILE WHERE id=?";      
	      jdbcUtil.setSqlAndParameters(sql, new Object[] {id});   // JDBCUtil에 delete문과 매개 변수 설정

	      try {            
	         int result = jdbcUtil.executeUpdate();   // delete 문 실행
	         return result;
	      } catch (Exception ex) {
	         jdbcUtil.rollback();
	         ex.printStackTrace();
	      }
	      finally {
	         jdbcUtil.commit();
	         jdbcUtil.close();   // resource 반환
	      }      
	      return 0;
	   }
	   
	   
	    public static Profile findProInfo(String name) {
	       // printDeptInfo()를 변형 
	       // Department 객체를 생성하고 검색 결과를 저장해서 return함
	       
	       String query = "SELECT name, email, part, score, image"
	            + " FROM PROFILE"
	            + " WHERE name = ? ";
	       
	      
	      Profile p = null;
	      jdbcUtil.setSqlAndParameters(query, new Object[] {name}); //JDBCutil에 쿼리 및 파라미터 설정
	      
	      try {
	         ResultSet rs = jdbcUtil.executeQuery(); //쿼리문실행
	         
	         if(rs.next()) {
	            String pName = rs.getString("name");
	            String pEmail = rs.getString("email");
	            String pPart = rs.getString("part");
	            float pScore = rs.getFloat("score");
	            String pImage = rs.getString("image");
	            p = new Profile(pName, pEmail, pPart,pImage, pScore);
	         }
	         else {
	            System.out.println("이름을 찾지 못했습니다.");
	         }
	      }
	      catch (SQLException ex) {
	         ex.printStackTrace();
	      }
	      finally {
	         jdbcUtil.close();
	         }
	       return p;
	    } 

	    public static List<Profile> findProfileInName(String name) {
	       // printEmployeesInDept()를 변형
	       // ArrayList<Employee> 객체를 생성하고, 검색된 각 사원 정보에 대해 Employee 객체를 생성 및 저장하고, 그 객체를 ArrayList에 추가함
	       String query = "SELECT name, email, part, score, image"
	            + "FROM PROFILE"
	            + "WHERE name = ? ";
	       
	      jdbcUtil.setSqlAndParameters(query, new Object[] {name}); //JDBCutil에 쿼리 및 파라미터 설정
	       
	      try {
	         ResultSet rs = jdbcUtil.executeQuery(); //쿼리문실행
	         
	         List<Profile> list = new ArrayList<Profile>();
	         
	         while(rs.next()) {
	            String pName = rs.getString("name");
	            String pEmail = rs.getString("email");
	            String pPart = rs.getString("part");
	            float pScore = rs.getFloat("score");
	            String pImage = rs.getString("image");
	            Profile p = new Profile(pName, pEmail, pPart, pImage, pScore);
	            list.add(p);
	         }
	         return list;
	      }
	      catch (SQLException ex) {
	         ex.printStackTrace();
	      }
	      finally {
	         jdbcUtil.close();
	      }
	      return null;
	    }
}

