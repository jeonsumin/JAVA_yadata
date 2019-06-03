package com.yadata.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.yadata.domin.YadataVO;

public class YadataCarDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "week";
	String pwd = "week";

	Connection con = null; // 오라클 디비 연결 con
	Statement stmt = null; // 쿼리문 수행 st
	PreparedStatement pt = null; // 쿼리문 수행 pt
	ResultSet rs = null; // select문 수행결과 검색 레코드를 저장
	String sql = null; // 쿼리문 저장변수
	
	public int carUpdate(YadataVO y) {
		int re=-1;//수정 실패시 반환값
		try {
			Class.forName(driver);
		con = DriverManager.getConnection(url, user, pwd);
sql="update carT set y_id=?, y_carreser=? where  y_carkind=?";
//아이디를 기준으로 이름,나이,주소를 수정한다.

        pt=con.prepareStatement(sql);
        
        pt.setString(1,y.getYa_id());
        pt.setString(2,y.getYa_reser());
        pt.setString(3,y.getYa_carkind());
       
        
        
        
        re=pt.executeUpdate();//수정 성공한 레코드 행의
        //개수 반환
		}catch(Exception e) {e.printStackTrace();}
		finally {try {
			if(con != null) con.close();
			if(pt != null) pt.close();
		}catch(Exception e) {e.printStackTrace();}}
		return re;
	}//userUpdate()
	
}
