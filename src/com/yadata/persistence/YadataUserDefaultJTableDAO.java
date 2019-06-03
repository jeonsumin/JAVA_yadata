package com.yadata.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

import com.yadata.domin.YadataVO;
import com.yadata.ui.NewUser;
import com.yadata.ui.YadataUserJDialogGUI;

public class YadataUserDefaultJTableDAO {//오라클 연결 클래스
	
	String driver="oracle.jdbc.OracleDriver";
	//oracle.jdbc는 패키지명,OracleDriver는 오라클 jdbc
	//드라이버 클래스명
	String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
	//오라클 접속주소,1521은 포트번호,xe디비명
	String user="week";//오라클 접속 사용자
	String pwd="week";//접속 비번
	
	Connection con=null;//오라클 연결 con
	PreparedStatement pt=null;//쿼리문 수행 pt
	Statement st=null;//쿼리문 수행 st
	ResultSet rs=null;//select검색 결과 레코드를 저장할 rs
	String sql=null;//쿼리문 저장변수
	
    public YadataUserDefaultJTableDAO() {
      try {
    	  Class.forName(driver);//jdbc드라이버클래스 로드
con=DriverManager.getConnection(url,user,pwd);
//오라클 연결 con생성
      }catch(Exception e) {e.printStackTrace();}
    }//생성자
    
    //닫기
    public void dbClose() {
    	try {
    		if(rs != null) rs.close();
    		if(st != null) st.close();
    		if(pt != null) pt.close();
    	}catch(Exception e) {e.printStackTrace();}
    }//dbClose()
    
    //모든예약 검색 ---------공유해야할것 ';
    public void userSelectAll(DefaultTableModel dt) { //이건 스윙에서밖에 못씀 ;; 파이널프로젝트때 못씀 
    	try {
        sql="select * from reserT order by r_id desc";
        //아이디를 기준으로 내림차순 정렬
        pt=con.prepareStatement(sql);//쿼리문 미리 컴파일
        //하여 쿼리문 수행 pt생성
        rs=pt.executeQuery();//select검색 결과 레코드를 
        //rs에 저장
        for(int i=0;i<dt.getRowCount();) {
        	dt.removeRow(0);//DefaultTableModel에 있는
        	//자료가 있다면 기존 데이터 지우기
        }//for
        while(rs.next()) {//next ()는 다음 회원이 있다면참
        	Object[] data= {
        			rs.getString("y_Pdate"),
        			rs.getString("y_Rdate"),
        			rs.getString("y_Ploc"),
        			rs.getString("y_Rloc"),
        			rs.getString("y_carkind"),
        			rs.getString("y_carprice2"),
        			rs.getString("y_insurprice"),
        			rs.getString("y_id"),
        			rs.getString("y_name"),
        			rs.getString("y_birth"),
        			rs.getString("y_email"),
        			rs.getString("y_licencek"),
        			rs.getString("y_licencenum"),
        			rs.getString("y_totalp"),
        			      		
        	};//data배열에 컬럼 레코드값을 가져와 저장
        	dt.addRow(data);//디폴트 테이블 모델에 배열
        	//원소값 추가
        }//while
    	}catch(Exception e) {e.printStackTrace();}
    	finally { dbClose();}
    }//userSelectAll()
    
    //모든회원 검색 ------이거 공유해야댐 ;
    public void usermemberAll(DefaultTableModel dt) { //이건 스윙에서밖에 못씀 ;; 파이널프로젝트때 못씀 
    	try {
        sql="select * from yadata_memT order by y_id desc";
        //아이디를 기준으로 내림차순 정렬
        pt=con.prepareStatement(sql);//쿼리문 미리 컴파일
        //하여 쿼리문 수행 pt생성
        rs=pt.executeQuery();//select검색 결과 레코드를 
        //rs에 저장
        for(int i=0;i<dt.getRowCount();) {
        	dt.removeRow(0);//DefaultTableModel에 있는
        	//자료가 있다면 기존 데이터 지우기
        }//for
        while(rs.next()) {//next ()는 다음 회원이 있다면참
        	Object[] data= {
        			rs.getString("y_id"),
        			rs.getString("y_pwd"),
        			rs.getString("y_name"),
        			rs.getString("y_email")
        	};//data배열에 컬럼 레코드값을 가져와 저장
        	dt.addRow(data);//디폴트 테이블 모델에 배열
        	//원소값 추가
        }//while
    	}catch(Exception e) {e.printStackTrace();}
    	finally { dbClose();}
    }//userSelectAll()
    

    //아이디 중복검색
	public boolean getIdByCheck(String id) {
		boolean re=true;//중복아이디가 없는경우 반환값
		try {
        sql="select * from yadatamanageT where id=?";//쿼리문
        pt=con.prepareStatement(sql);
        pt.setString(1,id);//쿼리문 첫번째 물음표에 문자열로 아이디 저장
        rs=pt.executeQuery();//select 문 수행후 결과 레코드를 rs에 저장
        if(rs.next()) {//검색 결과 레코드가 하나일때 if
        	//해당 아이디가 있는 경우
        	re=false;
        }
		}catch(Exception e) {e.printStackTrace();}
		finally {dbClose();}
		return re;
	}//getIdByCheck()

	//회원저장
	public int userListInsert(YadataVO Y) {  
		int re=-1;//저장 실패시
		try {
         sql="insert into yadatamanageT values(?,?,?,?,sysdate)";
         //sysdate는 오라클 날짜함수
         pt=con.prepareStatement(sql);
         pt.setString(1,Y.getYa_id());
         pt.setString(2,Y.getYa_pwd());
         pt.setString(3,Y.getYa_name());
         pt.setString(4,Y.getYa_email());
         
         re=pt.executeUpdate();//저장성공한 레코드행의
         //개수 1반환
		}catch(Exception e) {e.printStackTrace();}
		finally {dbClose();}
		return re;
	}//userListInsert()

	//회원정보 수정  -----공유해야댐 ㅣ;;;
	public int userUpdate(YadataUserJDialogGUI user) {
		int re=-1;//수정 실패시 반환값
		try {
sql="update yadatamanageT set pwd=?,name=?,e_mail=? where  id=?";
//아이디를 기준으로 이메일주소,이름,비밀번호를 수정한다.
        pt=con.prepareStatement(sql);
        pt.setString(1,user.pwd.getText());
        pt.setString(2,user.name.getText());
        pt.setString(3,user.e_mail.getText());
        pt.setString(4,user.id.getText());
        
        re=pt.executeUpdate();//수정 성공한 레코드 행의개수 반환
		}catch(Exception e) {e.printStackTrace();}
		finally {dbClose();}
		return re;
	}//userUpdate()

	//회원삭제
	public int userDelete(String id) {
		int re=-1;//삭제 실패시 반환값
		try {
			sql="delete from yadatamanageT where id=?";
			//아이디를 기준으로 삭제
			pt=con.prepareStatement(sql);
			pt.setString(1,id);
			re=pt.executeUpdate();//삭제 성공한 레코드행의 개수 1반환
		}catch(Exception e) {e.printStackTrace();}
		finally {dbClose();}
		return re;
	}//userDelete()

	//회원검색
	public void getUserSearch(DefaultTableModel dt,
			String fieldName, String word) {
		try {
		st=con.createStatement();//쿼리문 수행객체 st생성
sql="select * from yadatamanageT where "+fieldName+" like "
+" '%"+word.trim()+"%'";
/* like는 쿼리문에서 검색연산자 키워드
 * %는 하나이상의 임의의 문자와 매핑대응
 */
         rs=st.executeQuery(sql);
         
         for(int i=0;i<dt.getRowCount();) {
        	 dt.removeRow(0);//디폴트 테이블 모델의 모든
        	 //자료 지우기=>초기화
         }//for
         
         while(rs.next()) {
        	 Object[] data= {
        		rs.getString("id"),	 
        		rs.getString("pwd"),
        		rs.getString("name"),
        		rs.getString("e_mail")
        	 };
        	 dt.addRow(data);//디폴트 테이블 모델에 추가
         }
		}catch(Exception e) {e.printStackTrace();}
		finally {dbClose();}
	}//getUserSearch()
	
	//예약자 검색 ---공유공유 ;;
	public void getreserveSearch(DefaultTableModel dt,
			String fieldName, String word) {
		try {
		st=con.createStatement();//쿼리문 수행객체 st생성
sql="select * from reserT where "+fieldName+" like "
+" '%"+word.trim()+"%'";
/* like는 쿼리문에서 검색연산자 키워드
 * %는 하나이상의 임의의 문자와 매핑대응
 */
         rs=st.executeQuery(sql);
         
         for(int i=0;i<dt.getRowCount();) {
        	 dt.removeRow(0);//디폴트 테이블 모델의 모든
        	 //자료 지우기=>초기화
         }//for
         
         while(rs.next()) {
        	 Object[] data= {
        			rs.getString("y_Pdate"),
         			rs.getString("y_Rdate"),
         			rs.getString("y_Ploc"),
         			rs.getString("y_Rloc"),
         			rs.getString("y_carkind"),
         			rs.getString("y_carprice2"),
         			rs.getString("y_insurprice"),
         			rs.getString("y_id"),
         			rs.getString("y_name"),
         			rs.getString("y_birth"),
         			rs.getString("y_email"),
         			rs.getString("y_licencek"),
         			rs.getString("y_licencenum"),
         			rs.getString("y_totalp") 
        	 };
        	 dt.addRow(data);//디폴트 테이블 모델에 추가
         }
		}catch(Exception e) {e.printStackTrace();}
		finally {dbClose();}
	}//getreserveSearch()
}