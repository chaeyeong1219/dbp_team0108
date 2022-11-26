package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import service.dto.Member;

public class MemberDAO {
   private JDBCUtil jdbcUtil = null;
   
   public MemberDAO(){
      jdbcUtil = new JDBCUtil();
   }
   
   public Member findMember(int id) throws SQLException{
       String query = "SELECT id, password, name, phonenum, email, part, position "
                + "FROM member "
                + "WHERE id = ? ";
       Member member = null;
       jdbcUtil.setSqlAndParameters(query, new Object[] {id});
       try {
          ResultSet rs = jdbcUtil.executeQuery();
          if(rs.next()) {
          int memberID = rs.getInt("id");      
          String memberPW = rs.getString("password");
          String memberName = rs.getString("name");
          String phoneNum = rs.getString("phonenum");
          String memberEmail = rs.getString("email");
          String memberPart = rs.getString("part");
          String position = rs.getString("position");
      
          
          member = new Member(memberID, memberPW, memberName, phoneNum,memberEmail,memberPart,position);
          }
          }catch (SQLException ex) {
          ex.printStackTrace();
          }finally {
          jdbcUtil.close();
          }
          return member;
               }
   
   public void createMember(Member member) throws SQLException {
      String sql = "INSERT INTO member (id, password, name,  phonenum, email, part, position, image) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";      
      Object[] param = new Object[] {member.getId(), member.getPassword(),member.getName(),
            member.getPhoneNum(), member.getEmail(), member.getPart(), member.getPosition(), member.getImage()};            
      jdbcUtil.setSqlAndParameters(sql, param);
         
      try {    
         jdbcUtil.executeUpdate();  // insert 문 실행
         
      } catch (Exception ex) {
         jdbcUtil.rollback();
         ex.printStackTrace();
      } finally {      
         jdbcUtil.commit();
         jdbcUtil.close();   // resource 반환
      }   
      
   }
   
   public int deleteMember(int id) throws SQLException{
      String query = "DELETE FROM member WHERE id=?";
      jdbcUtil.setSqlAndParameters(query, new Object[] {id});
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
   public int updateMember(Member member, String pw, String name, String email, String part, String position, String phoneNum) throws SQLException {
      String query = "UPDATE member "
               + "SET password=?, name=?, email=?, part=?, phonenum=?, position=? "
               + "WHERE id=?";
      Object[] param = new Object[] {pw, name, email, part, phoneNum, position, member.getId()};            
      jdbcUtil.setSqlAndParameters(query, param);   // JDBCUtil에 update문과 매개 변수 설정
         
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
}
