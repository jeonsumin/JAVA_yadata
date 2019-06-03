package com.yadata.persistence;

//전반적인 DB관리

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.yadata.domin.YadataVO;


public class YadataReserveDAO {
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


	
	// 아이디 중복 검색
	public boolean idCheck(String id) {
		boolean re = true; // 중복 아이디가 없을 경우 반환값;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pwd);
			sql = "select * from yadataT where y_id=?";
			pt = con.prepareStatement(sql);
			pt.setString(1, id);
			rs = pt.executeQuery();
			if (rs.next()) {
				re = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pt != null)
					pt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return re;
	}

	// 예약시 정보를 마이페이지에 입력하게 할 수있다.
	public String getReserve(String id) {
		String ya = "";// 변수초기화(지역변수는 초기값을줘야함)
		String y_id = id;
		// String y_Pdate;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pwd);
			
			sql = "select * from yadataT where y_id=?";
			pt = con.prepareStatement(sql);
			pt.setString(1, id);
			rs = pt.executeQuery();

			while (rs.next()) {

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pt != null)
					pt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return ya;
	}

	// 로그인 인증 체크
	public YadataVO loginCheck(String id) {
		YadataVO db_y_id = null;
		try {
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pwd);
			sql = "select * from reserveT where y_id=?";
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
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pt != null)
					pt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return db_y_id;
	}

	public int insertReserve(YadataVO y) {
		int re = -1;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pwd);
			sql = "insert into reserT values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			pt = con.prepareStatement(sql);
			pt.setString(1, y.getYa_Pdate());
			pt.setString(2, y.getYa_Rdate());
			pt.setString(3, y.getYa_Ploc());
			pt.setString(4, y.getYa_Rloc());
			pt.setString(5, y.getYa_carkind());
			pt.setString(6, y.getYa_carprice2());
			pt.setString(7, y.getYa_insurprice());
			pt.setString(8, y.getYa_id());
			pt.setString(9, y.getYa_name());
			pt.setString(10, y.getYa_birth());
			pt.setString(11, y.getYa_email());
			pt.setString(12, y.getYa_licencek());
			pt.setString(13, y.getYa_licencenum());
			pt.setString(14, y.getYa_totalP());

			re = pt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				
				if (pt != null)
					pt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return re;
	}

	public YadataVO RerserveOK(String id) {
		YadataVO ok=new YadataVO();
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pwd);
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
		finally {
			try {
				if (rs != null)
					rs.close();
				if (pt != null)
					pt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return ok;
	}

	//MyPage 정보수정 
	public int updateMember(YadataVO ev) {
		int re= -1; //정보 수정 실패시반환값 
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pwd);
			sql = "update yadata_memT set y_pwd=?, y_name=?, y_email=? "
					+ " where y_id=?"; //아이디를 기준으로 비번,이름,이메일 수정 
			pt = con.prepareStatement(sql);
			pt.setString(1, ev.getYa_pwd());
			pt.setString(2, ev.getYa_name());
			pt.setString(3, ev.getYa_email());
			pt.setString(4, ev.getYa_id());
			
			re = pt.executeUpdate(); //수정성공한 레코드 행의 개수를 반환한다.
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {			
				if (pt != null)
					pt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return re;
	}// updateMember ();
	
	
	//MyPage 탈퇴
		public int dropMember(String id) {
			int re= -1; //정보 삭제 실패시반환값 
			try {
				Class.forName(driver);
				con = DriverManager.getConnection(url, user, pwd);
				sql = "delete from yadata_memT where y_id =?";
				pt = con.prepareStatement(sql);
				pt.setString(1, id);				
				re = pt.executeUpdate(); //삭제성공한 레코드 행의 개수를 반환한다.
			}catch(Exception e) {
				e.printStackTrace();
			}
			finally {
				try {			
					if (pt != null)
						pt.close();
					if (con != null)
						con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return re;
		}// updateMember ();
		
		
		//마이페이지 예약확인 !!
		public YadataVO reserveinfo(String id) {
			YadataVO ok=new YadataVO();
			try {
				Class.forName(driver);
				con = DriverManager.getConnection(url, user, pwd);
				sql="select * from reserT where y_id=?";
				pt = con.prepareStatement(sql);
				pt.setString(1, id);
				rs = pt.executeQuery();
				//for(int i=0;i<id.getRowCount();)
				if(rs.next()) {	
					
					ok.setYa_Pdate(rs.getString("y_pdate"));
					ok.setYa_Rdate(rs.getString("y_rdate"));
					ok.setYa_Ploc(rs.getString("y_ploc"));
					ok.setYa_Rloc(rs.getString("y_rloc"));
					ok.setYa_carkind(rs.getString("y_carkind"));
					ok.setYa_carprice2(rs.getString("y_carprice"));
					ok.setYa_insurprice(rs.getString("y_insurprice"));
					ok.setYa_id(rs.getString("y_id"));
					ok.setYa_name(rs.getString("y_name"));
					ok.setYa_birth(rs.getString("y_birth"));
					ok.setYa_email(rs.getString("y_email"));
					ok.setYa_licencek(rs.getString("y_licencek"));
					ok.setYa_licencenum(rs.getString("y_licencenum"));
					ok.setYa_totalP(rs.getString("y_totalp"));
				
					
					//System.out.println("DAO id : " + rs.getString("y_id"));
					
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				try {
					if (rs != null)
						rs.close();
					if (pt != null)
						pt.close();
					if (con != null)
						con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return ok;
		}

}