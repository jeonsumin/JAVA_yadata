package com.yadata.ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainGate extends JFrame implements ActionListener {
	
//	Reserve reserve = new Reserve();
	Sign sign = new Sign();
	
	Price price =new Price();
	Event event = new Event();
	Chat chat = new Chat();
	setlogin Setlogin=new setlogin();
	
	//패널 
	private CardLayout Card = new CardLayout();

	private JPanel mainpan = new JPanel(new BorderLayout(10, 10));
	private JPanel toppan = new JPanel(new FlowLayout(FlowLayout.RIGHT));
	private JPanel pan01 = new JPanel(new BorderLayout());
	private JPanel pan02 = new JPanel(new BorderLayout());

	private JPanel pan03 = new JPanel();
	private JPanel pan04 = new JPanel();
	private JPanel pan05 = new JPanel(new GridLayout(0, 1));

	private JPanel pan06 = new JPanel(new CardLayout());
	
	private JPanel underpan = new JPanel(new FlowLayout());

	//버튼 
	private JButton Sign = new JButton("LOGIN");
	private JButton Menu = new JButton("MENU");
	private JButton confirm=new JButton("비회원예약확인");
	
	private JButton RESERVE = new JButton(new ImageIcon("./src/images/la01.png"));
	private JButton PRICE = new JButton(new ImageIcon("./src/images/la02.png"));
	private JButton EVENT = new JButton(new ImageIcon("./src/images/la03.png"));
	private JButton MYPAGE = new JButton(new ImageIcon("./src/images/la04.png"));
	private JButton CHAT = new JButton(new ImageIcon("./src/images/la05.png"));
	Font f1=new Font("san serif",Font.BOLD,17);

	//라벨
	private JLabel logo=new JLabel(new ImageIcon("./src/images/logo.jpg"));
	private JLabel img = new JLabel(new ImageIcon("./src/images/car3.png"));
	private JLabel underl=new JLabel("                                                                              skadlfwlgusz@naver.com | yousound@naver.com | soomis7@naver.com");
	private JButton set=new JButton(new ImageIcon("./src/images/set.jpg"));
	
          

	
	//기본생성자
	public MainGate() {

		setSize(1330, 780);
		setResizable(false);
		// ------------------------------------------
		Setpanel();
		exit();
		setVisible(true);
		//pack();
		
	}//MainGate()
	
	
	//패널
	public void Setpanel() {
		Color();
		Eventne();
		window();
		
		mainpan.add("North", new JLabel());
		mainpan.add("South",new JLabel());

		mainpan.add("West", pan01);
		mainpan.add("East", pan02);
		pan01.add("West", img);
		pan01.add("Center",logo);
		pan01.add("South",underpan);
		underpan.add(underl);
		underpan.add(set);

		
		pan02.add("East", pan05);
		pan05.add(RESERVE);
		pan05.add(PRICE);
		pan05.add(EVENT);
		pan05.add(MYPAGE);
		pan05.add(CHAT);

		pan05.setVisible(false);

		//toppan.add(confirm);
		toppan.add(Sign);
		toppan.add(Menu);

		mainpan.add("Center", pan02);
		mainpan.add("North", toppan);
		mainpan.add("South", pan04);		

		add(mainpan);
	}//Setpanel()

	//이벤트 등록
	public void Eventne() {
		Sign.addActionListener(this);
		Menu.addActionListener(this);
		confirm.addActionListener(this);
		RESERVE.addActionListener(this);
		PRICE.addActionListener(this);
		EVENT.addActionListener(this);
		MYPAGE.addActionListener(this);
		CHAT.addActionListener(this);
		set.addActionListener(this);
		
	}//Eventne()

	//윈도우 띄우기
	public void window() {
		Dimension tsc = Toolkit.getDefaultToolkit().getScreenSize();// 화면크기
		Dimension mySize = getSize();// 띄우는 창 크기
		setLocation(tsc.width / 2 - mySize.width / 2, tsc.height / 2 - mySize.height / 2);
	}//window()
	
	public void exit() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);//프레임 윈도우 닫기
			}//프레임 윈도우 닫기 했을때 호출    	  
	      });//내부 무명클래스 이벤트 처리
		}//기본생성자
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == Menu) {
			pan05.setVisible(true);
		}else if(e.getSource() == Sign) {
			sign.setVisible(true);
		}else if( e.getSource() == PRICE ) {
			price.setVisible(true);
		}else if(e.getSource() == EVENT) {
			event.setVisible(true);
		}else if(e.getSource() == CHAT) {
			chat.setVisible(true);
		}else if(e.getSource() == set) {
			Setlogin.setVisible(true);
		}
	}//버튼 클릭했을때 이벤트 
	public void Color() {
		Sign.setBackground(Color.WHITE);
		Sign.setFocusPainted(false);
		Sign.setFont(f1);
		
		underl.setFont(f1);
		
		Menu.setBackground(Color.WHITE);
		Menu.setFocusPainted(false);
		Menu.setFont(f1);
		
		confirm.setBackground(Color.white);
		confirm.setFocusPainted(false);
		confirm.setFont(f1);
		
		RESERVE.setContentAreaFilled(false);
		RESERVE.setFocusPainted(false);
		RESERVE.setBorderPainted(false);
		
		PRICE.setContentAreaFilled(false);
		PRICE.setFocusPainted(false);
		PRICE.setBorderPainted(false);
		
		EVENT.setContentAreaFilled(false);
		EVENT.setFocusPainted(false);
		EVENT.setBorderPainted(false);
		
		MYPAGE.setContentAreaFilled(false);
		MYPAGE.setFocusPainted(false);
		MYPAGE.setBorderPainted(false);
		
		CHAT.setContentAreaFilled(false);
		CHAT.setFocusPainted(false);
		CHAT.setBorderPainted(false);
		
		set.setContentAreaFilled(false);
		set.setFocusPainted(false);
		set.setBorderPainted(false);
		
		mainpan.setBackground(Color.white);
		toppan.setBackground(Color.white);
		pan01.setBackground(Color.white);
		pan02.setBackground(Color.white);
		pan03.setBackground(Color.white);
		pan04.setBackground(Color.white);
		pan05.setBackground(Color.white);
		pan06.setBackground(Color.white);
		underpan.setBackground(Color.white);
	}


	public static void main(String[] args) {

		new MainGate();
		
	}
}