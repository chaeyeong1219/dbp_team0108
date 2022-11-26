package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import service.dto.Post;
import model.dao.JDBCUtil;
public class PostDAO {
	private static JDBCUtil jdbcUtil = null;	// JDBCUtil 참조 변수 선언
	
	public PostDAO() {	// 생성자 
		jdbcUtil = new JDBCUtil();		// JDBCUtil 객체 생성 및 활용	
	}
	
	/*post 관리 테이블에 새로운 post 생성*/
	public int createPost(Post post) throws SQLException {
		String sql = "INSERT INTO POST (postId, title, content, createddate, studyId) VALUES (?, ?, ?, ?, ?)";		
		Object[] param = new Object[] {post.getPostId(), post.getTitle(), 
				post.getContent(), post.getCreatedDate(), post.getStudyId()};
						//(post.getPostId()!=0) ? post.getPostId() : null };				
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
	
	/*기존의 post 정보를 수정*/
	public int updatePost(Post post) throws SQLException {
		String sql = "UPDATE POST "
					+ "SET title=?, content=?, createdDate=?, studyId=?, mtrId=?"
					+ "WHERE postId=?";
		Object[] param = new Object[] {post.getTitle(), post.getContent(), 
					post.getCreatedDate(), post.getStudyId(), post.getMtrId(),
					//(post.getPostId()!=0) ? post.getPostId() : null, 
					post.getPostId()};				
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
	
	/*postId에 해당하는 post 삭제*/
	public int removePost(int id) throws SQLException {
		String sql = "DELETE FROM POST WHERE postId=?";		
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
	
	/*제목으로 post 검색*/
    public static Post findPostInfo(String title) {
    	// printDeptInfo()를 변형 
    	// Department 객체를 생성하고 검색 결과를 저장해서 return함
    	
    	String query = "SELECT title, content, createdDate, studyId, mtrId"
				+ " FROM POST"
				+ " WHERE title = ? ";
    
		
		Post post = null;
		jdbcUtil.setSqlAndParameters(query, new Object[] {title}); //JDBCutil에 쿼리 및 파라미터 설정
		
		try {
			ResultSet rs = jdbcUtil.executeQuery(); //쿼리문실행
			
			if(rs.next()) {
				String postTitle = rs.getString("title");
				String postContent = rs.getString("content");
				java.sql.Date postDate = rs.getDate("createdDate");
				int postStudyId = rs.getInt("studyId");
				post = new Post(postTitle, postContent, postDate, postStudyId);
			}
			else {
				System.out.println("글을 찾지 못했습니다.");
			}
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.close();
			}
    	return post;
    } 
    
    /*키워드 들어가있으면 다 나올 수 있는 것?*/
    public static List<Post> findPostInTitle(String title) {
    	
    	String query = "SELECT title, content, createdDate, studyId"
				+ "FROM POST"
				+ "WHERE title = ? ";
    	
		jdbcUtil.setSqlAndParameters(query, new Object[] {title}); //JDBCutil에 쿼리 및 파라미터 설정
    	
		try {
			ResultSet rs = jdbcUtil.executeQuery(); //쿼리문실행
			
			List<Post> list = new ArrayList<Post>();
			
			while(rs.next()) {
				String postTitle = rs.getString("title");
				String postContent = rs.getString("content");
				java.sql.Date postDate = rs.getDate("createdDate");
				int postStudyId = rs.getInt("studyId");
				Post post = new Post(postTitle, postContent, postDate, postStudyId);
				list.add(post);
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
