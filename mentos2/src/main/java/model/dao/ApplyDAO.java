package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import service.dto.Apply;

public class ApplyDAO {
private static JDBCUtil jdbcUtil = null;	// JDBCUtil 참조 변수 선언
	
	public ApplyDAO() {	// 생성자 
		jdbcUtil = new JDBCUtil();		// JDBCUtil 객체 생성 및 활용	
	}
	
	/*Apply 관리 테이블에 새로운 Apply 생성*/
	public int createApply(Apply apply) throws SQLException {
		String sql = "INSERT INTO APPLY VALUES (?, ?, ?, ?)";		
		Object[] param = new Object[] {apply.getApplyId(), apply.getStudyId(), 
							apply.getMtrId(), apply.getis_applied()};
						//(apply.getApplyId()!=0) ? apply.getApplyId() : null };				
		jdbcUtil.setSqlAndParameters(sql, param);	// JDBCUtil 에 insert문과 매개 변수 설정
						
		try {				
			int result = jdbcUtil.executeUpdate();	// insert 문 실행
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {		
			jdbcUtil.commit();
			jdbcUtil.close();	// resource 반환
		}		
		return 0;		
	}
	
	/*ApplyId에 해당하는 Apply 삭제*/
	public int removeApply(int id) throws SQLException {
		String sql = "DELETE FROM APPLY WHERE applyId=?";		
		jdbcUtil.setSqlAndParameters(sql, new Object[] {id});	// JDBCUtil에 delete문과 매개 변수 설정

		try {				
			int result = jdbcUtil.executeUpdate();	// delete 문 실행
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();	// resource 반환
		}		
		return 0;
	}
	
	/*applyId로 apply 검색*/
    public static Apply findApplyInfo(int id) {
    	// printDeptInfo()를 변형 
    	// Department 객체를 생성하고 검색 결과를 저장해서 return함
    	
    	String query = "SELECT applyId, studyId, mtrId, is_applied"
				+ " FROM APPLY"
				+ " WHERE applyId = ? ";
    	
		
		Apply apply = null;
		jdbcUtil.setSqlAndParameters(query, new Object[] {id}); //JDBCutil에 쿼리 및 파라미터 설정
		
		try {
			ResultSet rs = jdbcUtil.executeQuery(); //쿼리문실행
			
			if(rs.next()) {
				int applyId = rs.getInt("applyId");
				int studyId = rs.getInt("studyId");
				int mtrId = rs.getInt("mtrId");
				int isapplied = rs.getInt("is_applied");
				apply = new Apply(applyId, studyId, mtrId, isapplied);
			}
			else {
				System.out.println("신청내역을 찾지 못했습니다.");
			}
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.close();
			}
    	return apply;
    } 
    
    /*멘토가 자기한테 들어온 신청 볼 수 있도록 studyId로 다 나올 수 있는  것*/
    public static List<Apply> findApplyInMtrId(int mtrId) {
    	
    	String query = "SELECT applyId, studyId, is_applied"
				+ " FROM APPLY"
				+ " WHERE mtrId = ? ";
    	
		jdbcUtil.setSqlAndParameters(query, new Object[] {mtrId}); //JDBCutil에 쿼리 및 파라미터 설정
    	
		try {
			ResultSet rs = jdbcUtil.executeQuery(); //쿼리문실행
			
			List<Apply> list = new ArrayList<Apply>();
			
			while(rs.next()) {
				int applyId = rs.getInt("applyId");
				int studyId = rs.getInt("studyId");
				int isapplied = rs.getInt("is_applied");
				Apply apply = new Apply(applyId, studyId, isapplied);
				list.add(apply);
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
