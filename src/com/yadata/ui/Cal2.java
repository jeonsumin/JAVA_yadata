package com.yadata.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.yadata.domin.YadataVO;
import com.yadata.persistence.YadataReserveDAO;

public class Cal2 extends JPanel implements ActionListener {
	// private static final String YEAR = null;
	String[] days = { "일", "월", "화", "수", "목", "금", "토" };
	int year, month, day, todays, memoday = 0;// 객채생성 후 초기값

	Font f;// 폰트
	Color bc, fc;// 색상
	Calendar today;
	Calendar cal;

	JButton beforebtn, afterbtn;
//	JButton addbtn, delbtn;
	JButton[] calbtn = new JButton[49];

	JLabel thing;
	JLabel time;
	JPanel Pan = new JPanel(new BorderLayout());
	JPanel panWest;
	JPanel panEast;
	JPanel panSouth;
	JPanel panNorth;

	private JTextField txtYear = new JTextField();
	private JTextField txtMonth = new JTextField();
	private JTextField txtWrite = new JTextField();
	JTextField txtTime;

	BorderLayout blayout = new BorderLayout();
	
	YadataVO v=new YadataVO();
	YadataReserveDAO d;

	Connection con = null; // DB와 연결객체
	Statement stmt = null;

	// DB연결
	// oracle.jdbc.driver는 패키지명,OracleDriver는 오라클//jdbc드라이버 클래스명
	String driver = "oracle.jdbc.driver.OracleDriver";
	// 오라클 접속주소, localhost는 모든 내자신 컴퓨터, 1521은 오라클 연결 포트번호, xe는 디비명
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "week";// 오라클 접속 사용자
	String pwd = "week";// 비번
	ResultSet rs = null;

	String sql, tempmemo;
	
	JTextField txt_Pdate;
	JTextField txt_Rdate;

	public Cal2(JTextField txt_Pdate,JTextField txt_Rdate) {
		this.txt_Pdate=txt_Pdate;
		this.txt_Rdate=txt_Rdate;
		//System.out.println(txt_Pdate.getText());
		//System.out.println(txt_Rdate.getText());
		
		today = Calendar.getInstance();
		cal = new GregorianCalendar();// Caelendar의 구상서브 클래스 및 표준적 달력시스템

		year = today.get(Calendar.YEAR);
		month = today.get(Calendar.MONTH) + 1;// 1월값이 0이 부터 나오기에 1을 더해준다.

		panNorth = new JPanel();
		panNorth.add(beforebtn = new JButton("Before"));
		panNorth.add(txtYear = new JTextField(year + "년"));
		panNorth.add(txtMonth = new JTextField(month + "월"));
		// 비활성화
		txtYear.setEnabled(false);
		txtMonth.setEnabled(false);

		panNorth.add(afterbtn = new JButton("After"));
		f = new Font("sherif", Font.BOLD, 24);
		txtYear.setFont(f);
		txtMonth.setFont(f);
		
		Pan.add(panNorth, "North");

		// 달력의 날에 해당되는 부분
		panWest = new JPanel(new GridLayout(7, 7));

		gridInit();
		calSet();
		hideInit();
		
		Pan.add(panWest, "Center");
		
		// 메모부분
		panEast = new JPanel();
		panEast.add(time = new JLabel("메모"));
		panEast.add(txtWrite = new JTextField());
		txtWrite.setPreferredSize(new Dimension(30, 30));
	

		beforebtn.addActionListener(this);
		afterbtn.addActionListener(this);
		
		add(Pan);
		setVisible(true);
		
	}

	

	public void calSet() {
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, (month - 1));
		cal.set(Calendar.DATE, 1);
		int dayofWeek = cal.get(Calendar.DAY_OF_WEEK);
		// get 및 set을 위한 필드 값으로 요일을 나타냄. get()메소드로 인해 요일이 숫자로 변환

		int j = 0;
		int hopping = 0;
		calbtn[0].setForeground(new Color(255, 0, 0));// 일요일 "일"
		calbtn[6].setForeground(new Color(0, 0, 255));// 토요일 "토"

		for (int i = cal.getFirstDayOfWeek(); i < dayofWeek; i++) {
			j++;
		}
		hopping = j;
		for (int kk = 0; kk < hopping; kk++) {
			// calbtn[kk + 7].setText(" ");
		}
		for (int i = cal.getMinimum(Calendar.DAY_OF_MONTH); i <= cal.getMaximum(Calendar.DAY_OF_MONTH); i++) {
			cal.set(Calendar.DATE, i);
			if (cal.get(Calendar.MONTH) != month - 1) {
				break;

			}
			//dbConnect();
			todays = i;
			// checkday();
			if (memoday == 1) {
				calbtn[i + 6 + hopping].getBackground();// .setForeground(new Color(0, 255, 0));
			} else {
				calbtn[i + 6 + hopping].getBackground();// .setForeground(new Color(0, 0, 0));
				if ((i + hopping - 1) % 7 == 0) {// 일요일
					calbtn[i + 6 + hopping].getBackground();// .setForeground(new Color(255, 0, 0));
				}
				if ((i + hopping) % 7 == 0) {// 토요일
					calbtn[i + 6 + hopping].setForeground(new Color(0, 0, 255));
				} // if
			} // else
			calbtn[i + 6 + hopping].setText((i) + "");
		} // for

	}// end calset()

	private void dbConnect() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pwd);
			stmt = con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == beforebtn) {
			this.panWest.removeAll();
			calInput(-1);
			gridInit();
			panelInit();
			calSet();
			hideInit();

			this.txtYear.setText(year + "년");
			this.txtMonth.setText(month + "월");

		} else if (e.getSource() == afterbtn) {
			this.panWest.removeAll();

			calInput(1);
			gridInit();
			panelInit();
			calSet();
			hideInit();

			this.txtWrite.setText(year + "년");
			this.txtMonth.setText(month + "월");

		}
		
		else if (Integer.parseInt(e.getActionCommand()) >= 1 && Integer.parseInt(e.getActionCommand()) <= 31) {
			day = Integer.parseInt(e.getActionCommand());
			Reserve r =null;
			
			    if(txt_Pdate.getText().equals("픽업날짜받아오기")) {
				txt_Pdate.setText(year+"."+month+"."+e.getActionCommand());
				txt_Pdate.setEnabled(false);
			    }
			    if(!txt_Pdate.getText().equals("픽업날짜받아오기")) {
			    	txt_Rdate.setText(year+"."+month+"."+e.getActionCommand());
				    txt_Rdate.setEnabled(false);
			    }
			    if (Integer.parseInt(e.getActionCommand()) >= 1 && Integer.parseInt(e.getActionCommand()) <= 31) {
			         day = Integer.parseInt(e.getActionCommand());
			         Reserve res =null;
			             if(txt_Pdate.getText().equals("픽업날짜받아오기")) {
			            txt_Pdate.setText(year+"."+month+"."+e.getActionCommand());
			            txt_Pdate.setEnabled(false);
			             }else if(txt_Pdate.getText().equals("")) {
			            	 txt_Pdate.setText(year+"."+month+"."+e.getActionCommand());
			             }
			             if(!txt_Pdate.getText().equals("픽업날짜받아오기")) {
			                txt_Rdate.setText(year+"."+month+"."+e.getActionCommand());
			                txt_Rdate.setEnabled(false);
			             }else if(txt_Rdate.getText().equals("")) {
			            	 txt_Rdate.setText(year+"."+month+"."+e.getActionCommand());
			                 txt_Rdate.setEnabled(false);
			             }
			   
			calSet();

			    }
		
	}
	}

	private void del() {
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url, user, pwd);
			
			sql = "delete from memo where year=";

			sql += year + "and month=";
			sql += month + "and day=";
			sql += day + ";";
			System.out.println(sql);
			stmt.executeUpdate(sql);
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(stmt != null) stmt.close();
				if(con != null) con.close();
			}catch(Exception e) {e.printStackTrace();}
		}
	}// del()

	
	
	public void hideInit() {
		for (int i = 0; i < calbtn.length; i++) {
			if ((calbtn[i].getText()).equals(""))
				calbtn[i].setEnabled(false);// 일이 찍히지 않는 나머지 버튼을 비활성화
		} // for
	}// hideInit()

	public void gridInit() {
		for (int i = 0; i < days.length; i++)
			panWest.add(calbtn[i] = new JButton(""));
		// calbtn[i].addActionListener(this);

		for (int i = days.length; i < 49; i++) {
			panWest.add(calbtn[i] = new JButton(""));
			calbtn[i].addActionListener(this);
		}
	}

	public void panelInit() {
		GridLayout gridLayout = new GridLayout(7, 7);
		panWest.setLayout(gridLayout);
	}

	public void dbConnect1() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pwd);
			stmt = con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void add() {
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url, user, pwd);
			
			String temp = txtWrite.getText();
			if (temp.equals("")) {
				JOptionPane.showMessageDialog(null, "내용을 입력하세요 ");
				return;
			}
			sql = "insert into memo values(";

			sql += year + "and month=";
			sql += month + "and day=";
			sql += "" + day + ");";

			System.out.println(sql);
			rs = stmt.executeQuery(sql);
			String gettemp = "";
			while (rs.next()) {
				gettemp += rs.getString("memo") + " ";
			}
			txtWrite.setText(gettemp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(con != null) con.close();
			}catch(Exception e) {e.printStackTrace();}
		}
	}// searchmemo

	public void calInput(int gap) {
		month += (gap);
		if (month <= 0) {
			month = 12;
			year = year - 1;
		} else if (month >= 13) {
			month = 1;
			year = year + 1;

		}
	}
}
