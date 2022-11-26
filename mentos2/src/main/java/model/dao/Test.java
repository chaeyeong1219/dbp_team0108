package model.dao;

import service.dto.Study;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import service.dto.Apply;
import service.dto.Member;
import service.dto.Mentoring;
import service.dto.Post;
import service.dto.Profile;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Test {

	private static MentoringDAO mtrDAO= new MentoringDAO();
	private static StudyDAO studyDao= new StudyDAO();
	private static ProfileDAO profileDAO = new ProfileDAO();
	private static MemberDAO mDao = new MemberDAO();
	private static PostDAO pDao = new PostDAO();
	private static ApplyDAO aDao = new ApplyDAO();
	
	public static void main(String[] args) throws SQLException{
		// TODO Auto-generated method stub
		
		//create
//		 Study studyDto = new Study(); 
//		 studyDto.setLeaderId(1);
//		 studyDto.setPart("backend"); 
//		 studyDto.setDeadline(new java.sql.Date(System.currentTimeMillis())); 
//		 studyDto.setRegion("서울");
//		 studyDto.setQuota(10);
//		 
//		 if(studyDao.create(studyDto) == 1) 
//			 System.out.println("create success"); 
//		 else
//			 System.out.println("create fail");
		 
		//모든 스터디 읽음
//		List<Study> studys = studyDao.getStudyList();
//		Iterator<Study> s = studys.iterator();
//
//		while (s.hasNext()) {
//			Study studyDto1 = s.next();
//			System.out.println(studyDto1.getStudyId() + " " + 
//					studyDto1.getLeaderId() + " " +
//					studyDto1.getPart() + " " + studyDto1.getDeadline() +
//					" " + studyDto1.getRegion() + " " + 
//					studyDto1.getQuota());
//		}
		
		//update
		//studyDto.setLeaderId(100);
		//studyDao.update(studyDto);
//		 Study studyDtoU = new Study(); 
//		 studyDtoU.setStudyId(48);
//		 studyDtoU.setLeaderId(10);
//		 studyDtoU.setPart("frontend");
//		 studyDtoU.setQuota(20);
//		 studyDtoU.setRegion("울산");
//		 studyDao.update(studyDtoU);
		 
		//모든 스터디 읽음(update 결과 확인)
//		System.out.println("update 결과 확인!");
//		
//		List<Study> studys2 = studyDao.getStudyList();
//		Iterator<Study> s1 = studys2.iterator();
//
//		while (s1.hasNext()) {
//			Study studyDto2 = s1.next();
//			System.out.println(studyDto2.getStudyId() + " " + 
//					studyDto2.getLeaderId() + " " +
//					studyDto2.getPart() + " " + studyDto2.getDeadline() +
//					" " + studyDto2.getRegion() + " " + 
//					studyDto2.getQuota());
//		}
		
		//파트로 스터디 검색
//		System.out.println("백엔드 파트 검색 결과 확인!");
//		
//		List<Study> studys3 = studyDao.findStudysInPart("backend");
//		Iterator<Study> s2 = studys3.iterator();
//
//		while (s2.hasNext()) {
//			Study studyDto3 = s2.next();
//			System.out.println(studyDto3.getStudyId() + " " + 
//					studyDto3.getLeaderId() + " " +
//					studyDto3.getPart() + " " + studyDto3.getDeadline() +
//					" " + studyDto3.getRegion() + " " + 
//					studyDto3.getQuota());
//		}
		
		//apply
		
//		 Study studyDtoA = new Study(); 
//		 studyDtoA.setStudyId(48);
//		 if(studyDao.apply(studyDtoA) == 1) 
//			 System.out.println("apply success"); 
//		 else
//			 System.out.println("apply fail");

		//profile
//		Profile p1 =  new Profile();
//	      p1.setId(6);
//	      p1.setName("홍길동");
//	      p1.setEmail("email");
//	      p1.setPart("백엔드");
//	      p1.setImage("ccc");
//	      p1.setScore(2);
//	      
//	      try {
//	         profileDAO.createProfile(p1);
//	      } catch (Exception e) {
//	         // TODO Auto-generated catch block
//	         e.printStackTrace();
//	      }
	      
//	      Scanner scanner = new Scanner(System.in);
//	      
//	      System.out.print("이름을 입력하시오: ");
//	      String pName = scanner.next();
//	      
//	      Profile p = ProfileDAO.findProInfo(pName);   
//	      
//	      
//	      // dept 객체의 필드 값 출력 ...
//	      if (p != null) {
//	         System.out.println("이름: " + pName);
//	         System.out.println("이메일: " + p.getEmail());
//	         System.out.println("분야: " + p.getPart());
//	         System.out.println("사진: " + p.getImage());
//	         System.out.println("점수: " + p.getScore());
//	         System.out.println();
//	      }
//	      else {
//	         System.out.println("부서를 찾지 못했음");
//	         return;
//	      }
	      
//	      System.out.print("이름을 입력하시오: ");
//	      String pName2 = scanner.next();
//	      
//	       List<Profile> profileList = ProfileDAO.findProfileInName(pName2);  
	       
	      // empList에 포함된 모든 객체들의 필드 값 출력 ...
	      // empList에 포함된 각 emp 객체를 접근하기 위해 empList로부터 Iterator<Employee> 객체를 구해서 활용함
//	       System.out.println("이름    이메일   분야    사진     점수");
//	      System.out.println("------------------------------------");
//	      Iterator<Profile> it = profileList.iterator();
//	      while (it.hasNext()) {
//	      System.out.println(it.next());
//	      }
//	      System.out.println();
//	      
//	      scanner.close();
	      
//		Mentoring studyDtoU = new Mentoring(); 
//		 studyDtoU.setmtrId(40);
//		 studyDtoU.setLeaderId(10);
//		 studyDtoU.setPart("frontend");
//		 studyDtoU.setDeadline(new java.sql.Date(System.currentTimeMillis()));
//		 studyDtoU.setQuota(20);
//		 studyDtoU.setRegion("울산");
//		 mtrDAO.create(studyDtoU);
//		
//	      List<Mentoring> mtrList1 = mtrDAO.findMentoringList();
//			Iterator<Mentoring> mtrIter1 = mtrList1.iterator();
//
//			while (mtrIter1.hasNext()) {
//				Mentoring mtr = mtrIter1.next();
//				System.out.println(mtr.getmtrId() + " " +
//						mtr.getPart() + " " + mtr.getDeadline() + " " + 
//						mtr.getRegion() + " " + mtr.getQuota() + 
//						mtr.getLeaderId() + " ");
//			}
//			
//			//update
//			 Mentoring mtr = new Mentoring(); 
//			 mtr.setmtrId(48);
//			 mtr.setPart("frontend");
//			 mtr.setDeadline(new java.sql.Date(System.currentTimeMillis()));
//			 mtr.setQuota(20);
//			 mtr.setRegion("울산");
//			 mtr.setLeaderId(10);
//			 mtr.update(mtr);
//			 
//			
//			//파트로 스터디 검색
//			System.out.println("백엔드 파트 검색 결과 확인!");
//			
//			List<Mentoring> mtrList2 = mtrDAO.findMentoringInPart("backend");
//			Iterator<Mentoring> mtrIter2 = mtrList2.iterator();
//
//			while (mtrIter2.hasNext()) {
//				Mentoring mtr2 = mtrIter2.next();
//				System.out.println(mtr.getmtrId() + " " +
//						mtr.getPart() + " " + mtr.getDeadline() + " " + 
//						mtr.getRegion() + " " + mtr.getQuota() + 
//						mtr.getLeaderId() + " ");
//			}
//	
		
		Scanner scanner = new Scanner(System.in);
//	      System.out.print("삭제할 아이디: ");
//	      int deleteId = scanner.nextInt();
//	      mDao.deleteMember(deleteId);
//	      
//	      System.out.print("아이디를 입력하시오: ");
//	      int mId = scanner.nextInt();
//	      System.out.print("패스워드를 입력하시오: ");
//	      String mPw = scanner.next();
//	      System.out.print("이름을 입력하시오: ");
//	      String mName = scanner.next();
//	      System.out.print("전화번호를 입력하시오: ");
//	      String mPhone = scanner.next();
//	      System.out.print("이메일을 입력하시오: ");
//	      String mEmail = scanner.next();
//	      System.out.print("분야를 입력하시오: ");
//	      String mPart = scanner.next();
//	      System.out.print("실력 입력하시오: ");
//	      String mPosition = scanner.next(); 
//	      
//	      Member member = new Member(mId, mPw, mName, mPhone, mEmail,mPart,mPosition,null);
//	      mDao.createMember(member);
//	      System.out.print("이름을 입력하시오: ");
//	      String name = scanner.next();
//	      Member member2 = mDao.findMember(name);
//	      
//	      if(member2 != null) {
//	            System.out.println("이름: " + member2.getName());
//	            System.out.println("이메일: " + member2.getEmail());
//	            System.out.println();
//	         }
//	         else {
//	            System.out.println("멤버를 찾지 못했음");
//	            return;
//	         }
	      
	   
	      //삭제
//	      System.out.print("삭제할 아이디: ");
//	      int deleteId = scanner.nextInt();
//	      mDao.deleteMember(deleteId);
	      
	      //업데이트
//	      System.out.print("변경할 이름을 입력하시오: ");
//	      int updateName = scanner.nextInt();
//	      Member member3 = mDao.findMember(updateName);
//	      mDao.updateMember(member3, "지영", "챙", "세아", "혜연", "999", "sdf");
	      
//		 Post post = new Post(1, "팔레트짱","송강송강", new java.sql.Date(System.currentTimeMillis()),50);
//		 pDao.createPost(post);
		 
//		Post post = new Post();
//		post.setTitle("sdfsdg");
//		post.setContent("sdfs");
//		post.setCreatedDate(new java.sql.Date(System.currentTimeMillis()));
//		post.setStudyId(50);
//		post.setPostId(1);
//		post.setMtrId(48);
//		pDao.createPost(post);
//		Post post = pDao.findPostInfo("sdfsdg");
//		System.out.println(post.getTitle());
		
		//Apply apply = new Apply(1, 50, 48, 1);
		//aDao.createApply(apply);
		//aDao.removeApply(1);
//		Apply apply1 = aDao.findApplyInfo(1);
//		System.out.println(apply1.getApplyId());
		
		scanner.close();
	     
	     

	   
	}
}
