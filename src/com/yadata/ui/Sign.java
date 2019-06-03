package com.yadata.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import com.yadata.domin.YadataVO;
import com.yadata.persistence.YadataDAOlmpl;

public class Sign extends JFrame implements ActionListener, MouseListener, FocusListener {

	// 패널생성
	private JPanel pan = new JPanel(new BorderLayout());// 기본프레임
	private JPanel panW = new JPanel(new BorderLayout());
	private JPanel panE = new JPanel(new BorderLayout());
	private JPanel panN = new JPanel(new BorderLayout());
	private JPanel panNS = new JPanel(new BorderLayout());
	private JPanel panNC = new JPanel(new BorderLayout());
	private JPanel panC = new JPanel(new BorderLayout());
	private JPanel panCN = new JPanel(new BorderLayout());
	private JPanel panCNN = new JPanel(new FlowLayout());
	private JPanel panCNS = new JPanel(new FlowLayout());
	private JPanel panCNE = new JPanel(new BorderLayout());
	private JPanel panCCN = new JPanel(new BorderLayout());
	private JPanel panCCCN = new JPanel(new BorderLayout());
	private JPanel mainpan = new JPanel(new BorderLayout());
	private JPanel panCCS = new JPanel(new BorderLayout());
	private JPanel panCS = new JPanel(new BorderLayout());
	private JPanel panS = new JPanel(new BorderLayout());
	private JPanel panCCC = new JPanel(new BorderLayout());
	private JPanel panCC = new JPanel(new BorderLayout());

	private JLabel line;
	private JLabel logo = new JLabel(new ImageIcon("./src/images/logo2.jpg"));
	private JLabel face;
	private JLabel la01 = new JLabel(new ImageIcon("./src/images/white.png"));

	// 텍스트필드
	private static JTextField txt_id;
	private JPasswordField txt_pwd;// 입력값을 암호화
	char passwordChar;
	// 버튼
	private JButton logbtn = new JButton("login");
	private JButton newbtn = new JButton(new ImageIcon("./src/images/newbtn.png"));
	private JButton informbtn = new JButton("비밀번호를 잊으셨나요?");

	Font f1 = new Font("san serif", Font.BOLD, 15);

	// 회원가입 버튼 누르면 연결되는 회원가입 폼 부르기
	NewUser newuser;
	// 회원가입을 하면 정보가 들어간 DB부르기
	YadataDAOlmpl ydao = new YadataDAOlmpl();

	public Sign() {
		super("Sign");

		// 라벨,텍스트필드,버튼생성
		txt_id = new JTextField("아이디");
		txt_id.setPreferredSize(new Dimension(250, 40));

		txt_pwd = new JPasswordField("비밀번호");
		passwordChar = txt_pwd.getEchoChar();
		txt_pwd.setEchoChar((char) 0);
		txt_pwd.setText("비밀번호");
		txt_pwd.setPreferredSize(new Dimension(250, 40));

		panelset();// 패널들어갈 자리지정 생성자
		setSize(320, 400);
		setVisible(false);

		// 프레임 윈도우 창 정중앙 배치
		Dimension tsc = Toolkit.getDefaultToolkit().getScreenSize();// 화면크기
		Dimension mySize = getSize();// 띄우는 창 크기
		setLocation(tsc.width / 2 - mySize.width / 2, tsc.height / 2 - mySize.height / 2);

	}// 기본생성자

	public void SetCom() {
		logbtn = new JButton(new ImageIcon("./src/images/loginbtn.png"));
		// logbtn.setPreferredSize(new Dimension(20,40));
		line = new JLabel("----------------------------------또는----------------------------------");
		face = new JLabel(new ImageIcon("./src/images/face.png"));

		newbtn = new JButton("계정이 없으신가요?가입하기");
	}

	public void panelset() {

		SetCom();
		Design();
		eventset();// 버튼 이벤트 들어갈 생성자
		// 패널 바깥 상하좌
		mainpan.add("North", new JLabel());
		mainpan.add("South", new JLabel());
		mainpan.add("East", new JLabel());
		mainpan.add("West", new JLabel());

		mainpan.add("Center", pan);
		pan.add("North", panN);
		panN.add(la01);
		pan.add("East", panE);
		pan.add("West", panW);

		panN.add("South", panNS);
		panNS.add(logo);

		pan.add("South", panS);
		panS.add(newbtn);
		pan.add("Center", panC);

		panC.add("North", panCN);
		panCN.add("North", panCNN);
		panCNN.add(txt_id);

		panCN.add("East", panCNE);
		panCN.add("South", panCNS);

		panCNS.add(txt_pwd);

		panC.add("South", panCS);
		panCS.add(informbtn);

		panC.add("Center", panCC);
		panCC.add("North", panCCN);
		panCCN.add(logbtn);

		panCC.add("South", panCCS);
		panCCS.add(face);

		panCC.add("Center", panCCC);
		panCCC.add("Center", panCCCN);
		panCCCN.add("Center", line);

		add(mainpan);

	}

	// 텍스트 필드 초기화
	public void reset() {
		txt_id.setText("");
		txt_pwd.setText("");
	}// reset()

	// 아이디값 반환메서드
	public static String id_get(String e) {
		String getid = txt_id.getText().trim();// trim()은
		// 양쪽공백제거
		return getid;
	}// id_get()

	public void eventset() {
		logbtn.addActionListener(this);
		newbtn.addActionListener(this);
		logbtn.setActionCommand("login");

		txt_id.addMouseListener(this);
		txt_id.addFocusListener(this);

		txt_pwd.addMouseListener(this);
		txt_pwd.addFocusListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == newbtn) {// 가입하기
			new NewUser();
		} else if (e.getSource() == "LOGIN" || e.getSource() == logbtn) {
			String id = txt_id.getText().trim();// 로그인 아이디
			String pwd = txt_pwd.getText().trim();

			if (id.equals("")) {
				messageBox(this, "아이디를 입력하세요");
				txt_id.setText("");// 아이디 입력박스 초기화
				txt_id.requestFocus();// 아이디 입력박스 커서이동
			} else if (pwd.equals("")) {
				messageBox(this, "비밀번호을 입력하세요");
				txt_pwd.setText("");
				txt_pwd.requestFocus();
			} else if (ydao.loginCheck(id) == null) {// 로그인 인증
				messageBox(this, "등록되지 않은 아이디입니다");
				reset();
				txt_id.requestFocus();
			} else if (ydao.loginCheck(id) != null) {
				YadataVO db_id = ydao.loginCheck(id);// 아이디에 해
				// 당하는 회원정보를 오라클로 부터 가져온다.
				if (!db_id.getYa_pwd().equals(pwd)) {
					messageBox(this, "비밀번호가 일치하지 않습니다");
					txt_pwd.setText("");
					txt_pwd.requestFocus();

				} else {// 비번이 일치하는 경우
					messageBox(this, id + "님 로그인을 환영합니다");
					new MainGate_login(id);// 로그인 후 메인화면
					new MainGate().setVisible(false);
					dispose();// 로그인 창 닫기
				} // if else
			}
		}

		// 텍스트 필드 엔터키 이벤트
		txt_id.registerKeyboardAction(this, "login", KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0),
				JComponent.WHEN_FOCUSED);// 아이디 입력박스 엔터키 ,VK_ENTER상수는 엔터키

		txt_pwd.registerKeyboardAction(this, "login", KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0),
				JComponent.WHEN_FOCUSED);
	}

	public static void messageBox(Object obj, String m) {
		JOptionPane.showMessageDialog((Component) obj, m);
	}// messageBox()

	public void Design() {
		pan.setBackground(Color.WHITE);
		panW.setBackground(Color.WHITE);
		panE.setBackground(Color.WHITE);
		panN.setBackground(Color.WHITE);
		panNS.setBackground(Color.WHITE);
		panNC.setBackground(Color.WHITE);
		panC.setBackground(Color.WHITE);
		panCN.setBackground(Color.WHITE);
		panCNN.setBackground(Color.WHITE);
		panCNS.setBackground(Color.WHITE);
		panCNE.setBackground(Color.WHITE);
		panCCN.setBackground(Color.WHITE);
		panCCCN.setBackground(Color.WHITE);
		mainpan.setBackground(Color.WHITE);
		panCCS.setBackground(Color.WHITE);
		panCS.setBackground(Color.WHITE);
		panS.setBackground(Color.WHITE);
		panCCC.setBackground(Color.WHITE);
		panCC.setBackground(Color.WHITE);
		newbtn.setBorderPainted(false);// 버튼외곽선없애기
		newbtn.setContentAreaFilled(false);// 버튼 배경색없애기
		newbtn.setFocusPainted(false);// 선택되엇을때 테두리 사용안함
		logbtn.setBorderPainted(false);// 버튼외곽선없애기
		logbtn.setContentAreaFilled(false);// 버튼 배경색없애기
		logbtn.setFocusPainted(false);// 선택되엇을때 테두리 사용안함
		informbtn.setBorderPainted(false);// 버튼외곽선없애기
		informbtn.setContentAreaFilled(false);// 버튼 배경색없애기
		informbtn.setFocusPainted(false);// 선택되엇을때 테두리 사용안함

	}

	@Override
	public void focusGained(FocusEvent e) {
		if (e.getSource().equals(txt_pwd)) {
			txt_pwd.setText("");
			txt_pwd.setEchoChar(passwordChar);
			txt_pwd.getText();
		}
	}

	@Override
	public void focusLost(FocusEvent e) {

	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getSource().equals(txt_id)) {
			txt_id.setText("");
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

}