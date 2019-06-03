package com.yadata.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.yadata.domin.YadataVO;
import com.yadata.persistence.YadataDAOlmpl;
import com.yadata.persistence.YadataReserveDAO;

public class Mypage extends JFrame implements ActionListener {
	
	
	// 패널
	private JPanel mainpan = new JPanel(new BorderLayout()); // 메인 패널
	private JPanel C_pan = new JPanel(new BorderLayout()); // 메인의 센터 페널
	private JPanel N_pan = new JPanel(new GridLayout(1, 7)); // 메인의 북쪽 패널
	private JPanel E_pan = new JPanel(new GridLayout(0, 1)); // 메인의 서쪽패널
	private JPanel Card_pan = new JPanel(new FlowLayout(FlowLayout.CENTER));
	private JPanel Card_1 = new JPanel(new GridLayout(0, 2));
	private JPanel Card_2 = new JPanel(new GridLayout(0, 2));
	private JPanel Card_3 = new JPanel(new GridLayout(0, 2));
	private JPanel Card_4 = new JPanel(new GridLayout(0, 3));

	// 버튼
	private JButton logout_btn;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	
	private JButton btn1_1;
	private JButton btn1_2;
	
	private JButton btn3_1;
	
	private JTextField Pdate ;
	private JTextField Rdate;
	private JTextField Ploc;
	private JTextField Rloc;
	private JTextField carkind;
	private JTextField carprice2;
	private JTextField insurprice;
	private JTextField id1;
	private JTextField name;
	private JTextField birth;
	private JTextField email;
	private JTextField licencek;
	private JTextField licencenum;
	private JTextField totalP;
	
	private JTextField id2;
	private JTextField pwd2;
	private JTextField name2;
	private JTextField email2;
	
	private JPanel mpanel = new JPanel(new GridLayout(1, 7));

	YadataVO y = new YadataVO();
	YadataDAOlmpl ydao = new YadataDAOlmpl(); 
	YadataReserveDAO y_reDAO = new YadataReserveDAO();
	String id;
	Font f1 = new Font("HGSSoeiKakugothicUB", Font.BOLD, 14);
	private JButton btn2_1;
	private JButton btn2_2;
	private JButton btn6 = new JButton("LOGOUT");

	public Mypage(String id) {
		
		super("Price");
		this.id=id;
		y.setYa_id(id);
		System.out.println("생성자 id : " + id);
		//if()
		mpanel.add(new JLabel());
		mpanel.add(new JLabel());
		mpanel.add(new JLabel());
		mpanel.add(new JLabel());
		mpanel.add(new JLabel(id + "님 로그인"));
		mpanel.add(btn6 );
		add(mpanel, "North");
		
		
		SetPanel();
		window();
		
		setSize(600, 900);	
		reserConfrim(id);
		setVisible(true);
	}
	
	public void reserConfrim(String id) {
		YadataVO yv =y_reDAO.reserveinfo(id);
		//	System.out.println(yv.getYa_Pdate());
			Pdate.setText(yv.getYa_Pdate());
			Rdate.setText(yv.getYa_Rdate());
			Ploc.setText(yv.getYa_Ploc());
			Rloc.setText(yv.getYa_Rloc());
			carkind.setText(yv.getYa_carkind());
			carprice2.setText(yv.getYa_carprice2());
			insurprice.setText(yv.getYa_insurprice());
			id1.setText(yv.getYa_id());
			name.setText(yv.getYa_name());
			birth.setText(yv.getYa_birth());
			email.setText(yv.getYa_email());
			licencek.setText(yv.getYa_licencek());
			licencenum.setText(yv.getYa_licencenum());
			totalP.setText(yv.getYa_totalP());
	}//예약확인하기 !

	public void com() {
		logout_btn = new JButton(new ImageIcon("./src/images/logout.png"));
		btn1 = new JButton(new ImageIcon("./src/images/reokB.png"));
		btn1_1  = new JButton("예약 수정하기");
		btn1_2	= new JButton("예약 취소");
		btn2 = new JButton(new ImageIcon("./src/images/reokB2.png"));
		btn2_1 = new JButton("정보 수정하기");
		btn2_2 = new JButton("닫기");
		btn3 = new JButton(new ImageIcon("./src/images/reokB3.png"));
		// private JButton btn4 = new JButton("대형");
		btn3_1 = new JButton("눼에에에에!!!");
		
		Pdate = new JTextField();
		Rdate = new JTextField();
		Ploc = new JTextField();
		Rloc = new JTextField();
		carkind = new JTextField();
		carprice2 = new JTextField();
		insurprice = new JTextField();
		id1 = new JTextField();
		name = new JTextField();
		birth = new JTextField();
		email = new JTextField();
		licencek = new JTextField();
		licencenum = new JTextField();
		totalP = new JTextField();
		
		id2 = new JTextField();
		pwd2 = new JTextField();
		name2 = new JTextField();
		email2 = new JTextField();


	}

	// 패널 추가
	public void SetPanel() {
		com();
		Event();
		
		mainpan.add("West", new JLabel());
		mainpan.add("East", new JLabel());
		mainpan.add("South", new JLabel());
		
		
		
		mainpan.add("West", new JLabel());
		mainpan.add("East", new JLabel());
		mainpan.add("South", new JLabel());
		mainpan.add("North", N_pan);

		N_pan.add(new JLabel());
		// N_pan.add(new JLabel());
		N_pan.add(new JLabel());
		// N_pan.add(new JLabel());
		// N_pan.add(new JLabel());

		N_pan.add(logout_btn);
		N_pan.setBackground(Color.white);

		mainpan.add("Center", C_pan);
		mainpan.setBackground(Color.white);

		C_pan.add("North", new JLabel());
		C_pan.add("East", E_pan);
		C_pan.add("South", new JLabel());
		C_pan.setBackground(Color.WHITE);
		;
		E_pan.add(btn1);
		E_pan.add(btn2);
		E_pan.add(btn3);
		E_pan.setBackground(Color.WHITE);
		btn1.setBackground(Color.WHITE);
		btn1.setFocusPainted(false);
		btn1.setBorderPainted(false);
		btn2.setBackground(Color.WHITE);
		btn2.setFocusPainted(false);
		btn2.setBorderPainted(false);
		btn3.setBackground(Color.WHITE);
		btn3.setFocusPainted(false);
		btn3.setBorderPainted(false);

		logout_btn.setBackground(Color.WHITE);
		logout_btn.setFocusPainted(false);
		logout_btn.setBorderPainted(false);

		// E_pan.add(btn4);
		
		id2.setEditable(false);

		C_pan.add("Center", Card_pan);

		Card_pan.add(Card_1);
		Card_pan.setBackground(Color.white);
		Card_1.add(new JLabel(new ImageIcon("./src/images/lo1_1.png")));
		Card_1.add(new JLabel(new ImageIcon("./src/images/lo2_1.png")));
		Card_1.add(new JLabel(new ImageIcon("./src/images/lo3_1.png")));
		Card_1.add(new JLabel(new ImageIcon("./src/images/lo4_1.png")));
		Card_1.add(new JLabel(new ImageIcon("./src/images/lo5_1.png")));
		Card_1.add(new JLabel(new ImageIcon("./src/images/lo6_1.png")));
		Card_1.add(new JLabel("    차가져가는날"));
		Card_1.add(Pdate);
		Card_1.add(new JLabel("    차돌려주는날"));
		Card_1.add(Rdate);
		Card_1.add(new JLabel("    차가져가는곳"));
		Card_1.add(Ploc);
		Card_1.add(new JLabel("    차돌려주는곳"));
		Card_1.add(Rloc);
		Card_1.add(new JLabel("    차종류"));
		Card_1.add(carkind);
		Card_1.add(new JLabel("    차가격"));
		Card_1.add(carprice2);
		Card_1.add(new JLabel("    보험가격"));
		Card_1.add(insurprice);
		Card_1.add(new JLabel("    아이디"));
		Card_1.add(id1);
		Card_1.add(new JLabel("    이름"));
		Card_1.add(name);
		Card_1.add(new JLabel("    생년월일"));
		Card_1.add(birth);
		Card_1.add(new JLabel("    이메일"));
		Card_1.add(email);
		Card_1.add(new JLabel("    면허종류"));
		Card_1.add(licencek);
		Card_1.add(new JLabel("    면허넘버"));
		Card_1.add(licencenum);
		Card_1.add(new JLabel("    총금액"));
		Card_1.add(totalP);
		Card_1.add(btn1_1);
		Card_1.add(btn1_2);

		Card_1.setBackground(Color.white);
		Card_1.setVisible(true);
		Card_1.setFont(f1);

		Card_pan.add(Card_2);
		Card_2.add(new JLabel(new ImageIcon("./src/images/lo1.png")));
		Card_2.add(new JLabel(new ImageIcon("./src/images/lo2.png")));
		Card_2.add(new JLabel(new ImageIcon("./src/images/lo3.png")));
		Card_2.add(new JLabel(new ImageIcon("./src/images/lo4.png")));
		Card_2.add(new JLabel(new ImageIcon("./src/images/lo5.png")));
		Card_2.add(new JLabel(new ImageIcon("./src/images/lo6.png")));

		Card_2.add(new JLabel("ID "));
		Card_2.add(id2);
		Card_2.add(new JLabel("PASSWORD"));
		Card_2.add(pwd2);
		Card_2.add(new JLabel("NAME"));
		Card_2.add(name2);
		Card_2.add(new JLabel("e-mail"));
		Card_2.add(email2);
		Card_2.add(btn2_1);
		Card_2.add(btn2_2);
		Card_2.setBackground(Color.white);
		Card_2.setVisible(false);

		Card_pan.add(Card_3);
		Card_3.add(new JLabel(new ImageIcon("./src/images/out1.png")));
		Card_3.add(new JLabel(new ImageIcon("./src/images/out2.png")));
		Card_3.add(new JLabel(new ImageIcon("./src/images/out3.png")));
		Card_3.add(new JLabel(new ImageIcon("./src/images/out4.png")));
		Card_3.add(new JLabel(new ImageIcon("./src/images/out5.png")));
		Card_3.add(new JLabel(new ImageIcon("./src/images/out6.png")));
		Card_3.add(new JLabel(""));
		Card_3.add(new JLabel(""));
		Card_3.add(new JLabel(new ImageIcon("./src/images/list1.png")));
		Card_3.add(new JLabel(new ImageIcon("./src/images/list2.png")));
		Card_3.add(new JLabel(new ImageIcon("./src/images/list3.png")));
		Card_3.add(new JLabel(new ImageIcon("./src/images/list4.png")));
		Card_3.add(new JLabel(new ImageIcon("./src/images/list5.png")));
		Card_3.add(new JLabel(new ImageIcon("./src/images/list6.png")));
		Card_3.add(new JLabel(""));
		Card_3.add(new JLabel(""));
		Card_3.add(new JLabel("탈퇴하시겠습니까?"));
		Card_3.add(btn3_1);

		Card_3.setBackground(Color.white);
		Card_3.setVisible(false);


		add(mainpan);
	
	}

	// 윈도우 띄우기
	public void window() {

		Dimension tsc = Toolkit.getDefaultToolkit().getScreenSize();// 화면크기
		Dimension mySize = getSize();// 띄우는 창 크기
		setLocation(tsc.width / 2 - mySize.width / 2, tsc.height / 2 - mySize.height / 2);
	}// window()

	public void Event() {
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn1_1.addActionListener(this);
		btn2_1.addActionListener(this);
		btn3_1.addActionListener(this);
		// btn4.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		YadataVO ok;
		System.out.println(id);
		ok = y_reDAO.RerserveOK(id);
		YadataVO ev = new YadataVO();
		YadataVO dv = new YadataVO();
		
		String pwd = ok.getYa_pwd();
		String name = ok.getYa_name();
		String email = ok.getYa_email();
		
		YadataVO rok;
		rok = y_reDAO.reserveinfo(id);
		 String Pdate = rok.getYa_Pdate();
		 String Rdate = rok.getYa_Rdate();
		 String Rloc = rok.getYa_Ploc();
		 String Ploc = rok.getYa_Rloc();
		 String carkind = rok.getYa_carkind();
		 String carprice2 = rok.getYa_carprice2();
		 String insurprice = rok.getYa_insurprice();
		 String id1 = rok.getYa_id();
	//	 String name = rok.getYa_name();
		 String birth = rok.getYa_birth();
	//	 String email = rok.getYa_email();
		 String licencek = rok.getYa_licencek();
		 String licencenum = rok.getYa_licencenum();
		 String totapP = rok.getYa_totalP();
		
		if(e.getSource() == btn2) {//예약 확인 눌렀을때
			//	ok=y_reDAO.RerserveOK(id);
			System.out.println(id + " " + pwd +  " " + name +  " " + email);
			id2.setText(id);
			pwd2.setText(pwd);
			name2.setText(name);
			email2.setText(email);		
		}else if(e.getSource() == btn2_1) {
			ev.setYa_id(id2.getText().trim());
			ev.setYa_pwd(pwd2.getText().trim());
			ev.setYa_name(name2.getText().trim());
			ev.setYa_email(email2.getText().trim());
			int re = y_reDAO.updateMember(ev);
			if(re > 0 ) {
				messageBox(this,"회원정보 수정하였습니다.");
				dispose();
			
			}
		}
		else if(e.getSource() == btn1) {
			reserConfrim(id);
			
		} 
		
		
			  if(e.getSource() == btn3_1) {
				  
				  if(y_reDAO.dropMember(id)>0) {
					  messageBox(this,"탈퇴했냐 ?");
				  }else{
					  messageBox(this,"ㅋ안됨");
				  }
				
			  }
	      
		//이벤트 발생시 호출
		//System.out.println("e.getSource(): "+ e.getSource()  );
//		yadataVO ok;
//		YadataDAOlmpl dao = new YadataDAOlmpl();
//		ok = dao.RerserveOK(id);
//		String name = ok.getYa_name();
//		String brith = ok.getYa_birth();
//		String phone = ok.getYa_phone();
//		String email = ok.getYa_email();
//
//		if (e.getActionCommand().equals("수정하시겠습니까?")) {
//		
//			
//			
//			//System.out.println("name : " + name);
//
//		}
//		// System.out.println("action : " + e.getActionCommand());
//		// System.out.println("source : " + e.getSource());
		Panchange(e);
	}
	
	
	//패널 변경 이벤트 
	public void Panchange(ActionEvent e) {
		if (e.getSource() == btn1) {
			Card_1.setVisible(true);
			Card_2.setVisible(false);
			Card_3.setVisible(false);
			Card_4.setVisible(false);
		} else if (e.getSource() == btn2) {
			Card_1.setVisible(false);
			Card_2.setVisible(true);
			Card_3.setVisible(false);
			Card_4.setVisible(false);
		} else if (e.getSource() == btn3) {
			Card_1.setVisible(false);
			Card_2.setVisible(false);
			Card_3.setVisible(true);
			Card_4.setVisible(false);
		} //Panchange()
	}
	
	//메시지 박스
		public static void messageBox(Object obj,String m) {
	     JOptionPane.showMessageDialog((Component)obj,m);		
		}//messageBox()
}