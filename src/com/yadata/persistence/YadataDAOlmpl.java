package com.yadata.persistence;

//전반적인 DB관리

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.yadata.domin.YadataVO;

public class YadataDAOlmpl {
	// 회원관리 jdbc클래스

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "week";
	String pwd = "week";

	Connection con = null; // 오라클 디비 연결 con
	Statement st = null; // 쿼리문 수행 st
	PreparedStatement pt = null; // 쿼리문 수행 pt
	ResultSet rs = null; // select문 수행결과 검색 레코드를 저장
	String sql = null; // 쿼리문 저장변수

	public YadataDAOlmpl() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pwd);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// 기본 생성자

	// 연결 닫기
	public void dbClose() {
		try {
			if (rs != null)
				rs.close();
			if (pt != null)
				pt.close();
			if (st != null)
				st.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// dbClose()
	
	//회원정보 수정
		public int userUpdate(YadataVO y) {
			int re=-1;//수정 실패시 반환값
			try {
	sql="update yadata_memT set y_pwd=?,y_name=?,eamil=? where  y_id=?";
	//아이디를 기준으로 이름,나이,주소를 수정한다.
	        pt=con.prepareStatement(sql);
	        pt.setString(1,y.getYa_pwd());
	        pt.setString(2,y.getYa_name());
	        pt.setString(3,y.getYa_email());
	        pt.setString(4,y.getYa_id());
	        
	        re=pt.executeUpdate();//수정 성공한 레코드 행의
	        //개수 반환
			}catch(Exception e) {e.printStackTrace();}
			finally {
				dbClose();
			}
			return re;
		}//userUpdate()
		
		//회원삭제
		public int userDelete(String id) {
			int re=-1;//삭제 실패시 반환값
			try {
				sql="delete from yadata_memT where id=?";
				//아이디를 기준으로 삭제
				pt=con.prepareStatement(sql);
				pt.setString(1,id);
				re=pt.executeUpdate();//삭제 성공한 레코드행
				//의 개수 1반환
			}catch(Exception e) {e.printStackTrace();}
			finally {dbClose();}
			return re;
		}//userDelete()

	// 아이디 중복 검색
	public boolean idCheck(String id) {
		boolean re = true; // 중복 아이디가 없을 경우 반환값;
		try {
			sql = "select * from yadata_memT where y_id=?";
			pt = con.prepareStatement(sql);
			pt.setString(1, id);
			rs = pt.executeQuery();
			if (rs.next()) {
				re = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return re;
	}

//	
//	// 회원 저장
//	public int insertMember(yadataVO m) {
//		int re = -1;
//		try {
//			sql="insert into yadata_memT values(?,?,?,?,sysdate)";
//			pt=con.prepareStatement(sql);
//			pt.setString(2, m.getYa_pwd());
//			pt.setString(3, m.getYa_name());
//			pt.setString(4, m.getYa_email());		
//			
//			re=pt.executeUpdate();
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		finally {
//			dbClose();
//		}
//		return re;
//	}

	// 로그인 인증 체크
	public YadataVO loginCheck(String id) {
		YadataVO db_y_id = null;
		try {
			sql = "select * from yadata_memT where y_id=?";
			pt = con.prepareStatement(sql);
			pt.setString(1, id);
			rs = pt.executeQuery();
			if (rs.next()) {
				db_y_id = new YadataVO();
				db_y_id.setYa_id(rs.getString("y_id"));
				db_y_id.setYa_pwd(rs.getString("y_pwd"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {dbClose();}
		return db_y_id;
	}

	public int insertMember(YadataVO y) {
		int re=-1;
		try {
			sql="insert into yadata_memT values(?,?,?,?,sysdate)";
			pt = con.prepareStatement(sql);
			pt.setString(1, y.getYa_id());
			pt.setString(2, y.getYa_pwd());
			pt.setString(3, y.getYa_name());
			pt.setString(4, y.getYa_email());
			
			re=pt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			dbClose();
		}
		return re;
	}

	//사용자의 예약 확인
		public YadataVO RerserveOK(String id) {
			YadataVO ok=new YadataVO();
			try {
	sql="select y_name, y_pwd, y_email from yadata_memT where y_id=?";
	pt = con.prepareStatement(sql);
	pt.setString(1, id);
	rs = pt.executeQuery();
	//for(int i=0;i<id.getRowCount();)
	if(rs.next()) {	
		ok.setYa_id(id);
		ok.setYa_pwd(rs.getString("y_pwd"));
		ok.setYa_name(rs.getString("y_name"));
		ok.setYa_email(rs.getString("y_email"));
		System.out.println("DAO pwd : " + rs.getString("y_pwd"));
		
	}
			}catch (Exception e) {
				e.printStackTrace();
			}
			finally {dbClose();}
			return ok;
		}
	
}