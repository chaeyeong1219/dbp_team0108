package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import service.dto.Mentoring;

/**
 * 사용자 관리를 위해 데이터베이스 작업을 전담하는 DAO 클래스
 * MENTORING 테이블에 사용자 정보를 추가, 수정, 삭제, 검색 수행 
 */
public class MentoringDAO {
	private JDBCUtil jdbcUtil = null;
	
	public MentoringDAO() {			
		jdbcUtil = new JDBCUtil();	// JDBCUtil 객체 생성
	}
		
	/**
	 * 사용자 관리 테이블에 새로운 사용자 생성.
	 */
	public int create(Mentoring mentoring) throws SQLException {
		String sql = "INSERT INTO MENTORING (mtrId, part, deadline, region, quota, leaderId) VALUES (?, ?, ?, ?, ?, ?) ";	
		Object[] param = new Object[] {mentoring.getmtrId(), mentoring.getPart(), mentoring.getDeadline(), 
				mentoring.getRegion(), mentoring.getQuota(), mentoring.getLeaderId()};				
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

	/**
	 * 기존의 멘토링 정보를 수정.
	 */
	public int update(Mentoring mentoring) throws SQLException {
		String sql = "UPDATE MENTORING "
					+ "SET part=?, deadline=?, region=?, quota=? "
					+ "WHERE mtrId=? ";
		Object[] param = new Object[] {mentoring.getPart(), mentoring.getDeadline(), 
									mentoring.getRegion(), mentoring.getQuota(), 
									mentoring.getmtrId()};				
		jdbcUtil.setSqlAndParameters(sql, param);	// JDBCUtil에 update문과 매개 변수 설정
			
		try {				
			int result = jdbcUtil.executeUpdate();	// update 문 실행
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

	/**
	 * 사용자 ID에 해당하는 사용자를 삭제.
	 */
	public int remove(String mtrId) throws SQLException {
		String sql = "DELETE FROM MENTORING WHERE mtrId=? ";		
		jdbcUtil.setSqlAndParameters(sql, new Object[] {mtrId});	// JDBCUtil에 delete문과 매개 변수 설정

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

	/**
	 * 주어진 멘토링 아이디에 해당하는 멘토링 정보를 데이터베이스에서 찾아 Mentoring 도메인 클래스에 
	 * 저장하여 반환.
	 */
	public Mentoring findMentoring(int mtrId) throws SQLException {
        String sql = "SELECT mtrId, part, deadline, region, quota, leaderId "
        			+ "FROM Mentoring  "
        			+ "WHERE mtrId=? ";              
		jdbcUtil.setSqlAndParameters(sql, new Object[] {mtrId});	// JDBCUtil에 query문과 매개 변수 설정
		Mentoring mentoring = null;
		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
			if (rs.next()) {						// 멘토링 정보 발견
				mentoring = new Mentoring(	// Mentoring 객체를 생성하여 학생 정보를 저장
					mtrId,
					rs.getString("part"),
					rs.getDate("deadline"),
					rs.getString("region"),
					rs.getInt("quota"),
					rs.getInt("leaderId"));
				return mentoring;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}

	/**
	 * 전체 멘토링 정보를 검색하여 List에 저장 및 반환
	 */
	public List<Mentoring> findMentoringList() throws SQLException {
        String sql = "SELECT mtrId, part, deadline, region, quota, leaderId " 
        		   + "FROM MENTORING "
        		   + "ORDER BY mtrId";
		jdbcUtil.setSqlAndParameters(sql, null);		// JDBCUtil에 query문 설정
					
		try {
			ResultSet rs = jdbcUtil.executeQuery();			// query 실행			
			List<Mentoring> mentoringList = new ArrayList<Mentoring>();	// Mentoring들의 리스트 생성
			while (rs.next()) {
				Mentoring mentoring = new Mentoring(			// Mentoring 객체를 생성하여 현재 행의 정보를 저장
						rs.getInt("mtrId"),
						rs.getString("part"),
						rs.getDate("deadline"),
						rs.getString("region"),
						rs.getInt("quota"),
						rs.getInt("leaderId"));
				mentoringList.add(mentoring);				// List에 Mentoring 객체 저장
			}		
			return mentoringList;					
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}
	
	/**
	 * 전체 멘토링 정보를 검색한 후 현재 페이지와 페이지당 출력할 멘토링 수를 이용하여
	 * 해당하는 멘토링 정보만을 List에 저장하여 반환.
	 */
	public List<Mentoring> findMentoringList(int currentPage, int countPerPage) throws SQLException {
		String sql = "SELECT mtrId, part, deadline, region, quota " 
				 	+ "FROM MENTORING "
      		   		+ "ORDER BY mtrId";
		jdbcUtil.setSqlAndParameters(sql, null,					// JDBCUtil에 query문 설정
				ResultSet.TYPE_SCROLL_INSENSITIVE,				// cursor scroll 가능
				ResultSet.CONCUR_READ_ONLY);						
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();				// query 실행			
			int start = ((currentPage-1) * countPerPage) + 1;	// 출력을 시작할 행 번호 계산
			if ((start >= 0) && rs.absolute(start)) {			// 커서를 시작 행으로 이동
				List<Mentoring> mentoringList = new ArrayList<Mentoring>();	// Mentoring들의 리스트 생성
				do {
					Mentoring mentoring = new Mentoring(			// Mentoring 객체를 생성하여 현재 행의 정보를 저장
							rs.getInt("mtrId"),
							rs.getString("part"),
							rs.getDate("deadline"),
							rs.getString("region"),
							rs.getInt("quota"),
							rs.getInt("leaderId"));
					mentoringList.add(mentoring);								// 리스트에 User 객체 저장
				} while ((rs.next()) && (--countPerPage > 0));		
				return mentoringList;							
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}
	
	/**
	 * 특정 분야에 속한 멘토링들을 검색하여 List에 저장 및 반환
	 */
	public List<Mentoring> findMentoringInPart(String part) throws SQLException {
        String sql = "SELECT mtrId, part, deadline, region, quota FROM mentoring "
     				+ "WHERE part = ?";                         
		jdbcUtil.setSqlAndParameters(sql, new Object[] {part});	// JDBCUtil에 query문과 매개 변수 설정
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
			List<Mentoring> mentoringList = new ArrayList<Mentoring>();	// member들의 리스트 생성
			while (rs.next()) {
				Mentoring mentoring = new Mentoring(			// User 객체를 생성하여 현재 행의 정보를 저장
						rs.getInt("mtrId"),
						rs.getString("part"),
						rs.getDate("deadline"),
						rs.getString("region"),
						rs.getInt("quota"),
						rs.getInt("leaderId"));
				mentoringList.add(mentoring);			// List에 Mentoring 객체 저장
			}		
			return mentoringList;					
				
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}

}
