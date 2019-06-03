package com.yadata.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.yadata.domin.YadataVO;
import com.yadata.persistence.YadataDAOlmpl;

public class NewUser extends JFrame implements ActionListener, MouseListener, FocusListener {

	private JPanel backpan01 = new JPanel(new BorderLayout(100, 10));
	private JPanel mainpan = new JPanel(new BorderLayout());
	private JPanel mainpan_W = new JPanel(new BorderLayout());
	private JPanel mainpan_E = new JPanel(new BorderLayout());
	private JPanel mainpan_EN = new JPanel(new BorderLayout());
	private JPanel mainpan_EC = new JPanel(new BorderLayout());
	private JPanel mainpan_ES = new JPanel(new BorderLayout());
	private JPanel mainpan_ECN = new JPanel(new BorderLayout());
	private JPanel mainpan_ECNW = new JPanel(new BorderLayout());
	private JPanel mainpan_ECNE = new JPanel(new BorderLayout());
	private JPanel mainpan_ECNC = new JPanel(new GridLayout(4, 1, 10, 10));
	private JPanel mainpan_ECC = new JPanel(new BorderLayout());
	private JPanel mainpan_ECCC = new JPanel(new BorderLayout());
	private JPanel mainpan_ECCN = new JPanel(new BorderLayout());
	private JPanel mainpan_ECS = new JPanel(new BorderLayout());

	private JTextField textemail;
	private JTextField textname;
	private JTextField textid;
	private JPasswordField textpwd;
	char passwordChar;
	// private JButton join;
	private JButton joinB;
	private JButton loginB;

	private JLabel Wimg;
	private JLabel logoimg;
	private JLabel loginimg;
	private JLabel joinimg;
	private JLabel yesimg;;
	private JLabel wh;

	YadataVO y = new YadataVO();
	YadataDAOlmpl ydao = new YadataDAOlmpl();

	public NewUser() {
		setTitle("join in");

		textid = new JTextField("아이디");
		textid.setPreferredSize(new Dimension(250, 50));

		textpwd = new JPasswordField("비밀번호");
		passwordChar = textpwd.getEchoChar();
		textpwd.setEchoChar((char) 0);
		textpwd.setText("비밀번호를 입력하세요");
		textpwd.setPreferredSize(new Dimension(250, 50));

		textname = new JTextField("성명");
		textname.setPreferredSize(new Dimension(250, 50));

		textemail = new JTextField("이메일 주소");
		textemail.setPreferredSize(new Dimension(250, 50));

		// join = new JButton("가입");

		Wimg = new JLabel(new ImageIcon("./src/images/w.png"));
		logoimg = new JLabel(new ImageIcon("./src/images/yadata_logo.png"));
		loginB = new JButton(new ImageIcon("./src/images/login.png"));
		joinB = new JButton(new ImageIcon("./src/images/join.png"));
		yesimg = new JLabel(new ImageIcon("./src/images/yes.png"));
		wh = new JLabel(new ImageIcon("./src/images/wh.png"));

		Panelnu_Set();
		Eventnu_Set();

		setSize(600, 400);
		setVisible(true);
		// setResizable(false);

		Dimension tsc = Toolkit.getDefaultToolkit().getScreenSize();// 화면사이즈
		Dimension mySize = getSize();// 띄우는 창 크기
		setLocation(tsc.width / 2 - mySize.width / 2, tsc.height / 2 - mySize.height / 2);// 정중앙 위치

		pack();

	}

	public void Panelnu_Set() {

		backpan01.add("North", new JLabel());
		backpan01.add("South", new JLabel());
		backpan01.add("East", new JLabel());
		backpan01.add("West", new JLabel());
		backpan01.add("Center", mainpan);

		mainpan.add("West", mainpan_W);
		mainpan_W.add(Wimg);
		mainpan.add("East", mainpan_E);

		mainpan_W.setBackground(Color.WHITE);

		mainpan_E.add("North", mainpan_EN);

		mainpan_EN.add(logoimg);
		mainpan_E.add("Center", mainpan_EC);

		mainpan_E.add("South", mainpan_ES);

		mainpan_EC.add("North", mainpan_ECN);
		mainpan_ECN.add("West", mainpan_ECNW);
		mainpan_ECNW.add(wh);
		mainpan_ECNW.setBackground(Color.GREEN);
		// mainpan_ECN.add("East",mainpan_ECNE);
		mainpan_ECNE.add(wh);
		mainpan_ECN.add("Center", mainpan_ECNC);
		// mainpan_ECNN.add(textmail);
		// mainpan_ECN.setBackground(Color.WHITE);

		mainpan_ECNC.add(textid);
		mainpan_ECNC.add(textpwd);
		mainpan_ECNC.add(textname);
		mainpan_ECNC.add(textemail);
		mainpan_ECNC.setBackground(Color.WHITE);

		mainpan_EC.add("Center", mainpan_ECC);
		mainpan_ECC.add("North", mainpan_ECCN);
		mainpan_ECCN.add(joinB);
		mainpan_ECC.add("Center", mainpan_ECCC);
		mainpan_ECCC.add(yesimg);

		// mainpan_ECC.add(yesimg);
		mainpan_ECC.setBackground(Color.WHITE);
		mainpan_EC.setBackground(Color.WHITE);
		mainpan_ECCN.setBackground(Color.WHITE);
		mainpan_ECCC.setBackground(Color.WHITE);
		backpan01.setBackground(Color.WHITE);
		mainpan_EN.setBackground(Color.WHITE);

		joinB.setBackground(Color.WHITE);
		joinB.setFocusPainted(false);
		joinB.setContentAreaFilled(false);
		joinB.setBorderPainted(false);

		loginB.setBackground(Color.WHITE);
		loginB.setFocusPainted(false);
		loginB.setContentAreaFilled(false);
		loginB.setBorderPainted(false);

		mainpan_EC.add("South", mainpan_ECS);
		mainpan_ECS.add(loginB);
		mainpan_ECS.setBackground(Color.WHITE);

		add(backpan01);

	}

	// 입력박스 초기화
	public void Reset() {
		textid.setText("");
		textpwd.setText("");
		// ntpwde.setText(""); ntname.setText("");
		// emailcom.setSelectedItem("선택");//콤보박스 해당항
		// 목을 선택하게 함
	}// Reset()

	// 이벤트 등록
	public void Eventnu_Set() {
		joinB.addActionListener(this);
		joinB.setActionCommand("join");
		loginB.addActionListener(this);
		loginB.setActionCommand("login");

		textid.addMouseListener(this); // 마우스 이벤트 등록
		textid.addFocusListener(this); // 마우스 이벤트 등록

		textpwd.addMouseListener(this);
		textpwd.addFocusListener(this);

		textname.addMouseListener(this);
		textname.addFocusListener(this);

		textemail.addMouseListener(this);
		textemail.addFocusListener(this);

	}// Eventnu_Set()

	// public static void main(String[] args) {
	// new NewUesr();

	// }
	public static void messageBox(Object obj, String m) {
		JOptionPane.showMessageDialog((Component) obj, m);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 회원가입 저장
		if (e.getSource() == joinB) {
			if (ydao.idCheck(textid.getText().trim()) == false) {
				messageBox(this, "이미 사용중인 아이디 입니다.");
				textid.setText("");
				textid.requestFocus();
			}
			/* copy begin */
			if (textid.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "아이디를 입력하세요.");
				textid.requestFocus();
				textid.setText("");

				return;

			}
			if (textpwd.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "비밀번호을 입력하세요.");
				textpwd.requestFocus();
				return;
			}

			if (textname.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "이름을 입력하세요.");
				textname.requestFocus();
				return;
			}
			if (textemail.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "이메일을 입력하세요.");
				textemail.requestFocus();
				return;
			} else {// 회원가입정보를 모두 입력한 경우
				String pwd = new String(textpwd.getPassword());
				// 비밀번호를 단일문자 배열로 가져온다.이것을
				// 문자열객체 pwd로변경
				y.setYa_id(textid.getText().trim());// setter()메
				// 서드에 아이디를 저장
				y.setYa_pwd(pwd.trim());// trim() 은 양쪽공백 제
				// 거
				y.setYa_name(textname.getText().trim());
				y.setYa_email(textemail.getText().trim());

				if (ydao.insertMember(y) > 0) {
					messageBox(this, textid.getText() + "아이디 님" + " 가입을 환영합니다!");
					Reset();
					dispose();// 다이얼로그 박스를 닫는다
				} // if
			} // if else
		}
		if (e.getSource() == loginB) {
			// sign.setVisible(true);
			// dispose();
			messageBox(this, "로그인화면으로 이동합니다.");
			dispose();
			setVisible(false);
		}
	}// 이벤트

	@Override
	public void focusGained(FocusEvent e) {
		if (e.getSource().equals(textpwd)) { // 패스워드필드에 포커스를 가졌을떄
			textpwd.setText(""); // 패스워드 필드 초기
			textpwd.setEchoChar(passwordChar); // 입력했을때 ***으로표기
		}else if(e.getSource().equals(textname)) {
			textname.setText("");
		}else if(e.getSource().equals(textemail)) {
			textemail.setText("");
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
		/*
		 * if(e.getSource().equals(textid)) {// 아이디 필드가 포커스를 잃었을 textid.setText("아이디 ");
		 * } if(e.getSource().equals(textpwd)) { //패스워드필드가 포커스를 잃었을때
		 * textpwd.setText("비밀번호"); textpwd.setEchoChar((char)0); }else
		 * if(e.getSource().equals(textname)) { textname.setText("이름"); }else
		 * if(e.getSource().equals(textemail)) { textemail.setText("이메일"); }
		 */
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getSource().equals(textid)) {
			textid.setText("");

		} else if (e.getSource().equals(textname)) {
			textname.setText("");
		} else if (e.getSource().equals(textemail)) {
			textemail.setText("");
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}
}