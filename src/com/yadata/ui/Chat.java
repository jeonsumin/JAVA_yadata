package com.yadata.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Chat extends JFrame implements ActionListener {

	//MultiChatClient multichat =new MultiChatClient();
	// 패널
	private JPanel mainpan = new JPanel(new BorderLayout());
	private JPanel C_pan = new JPanel(new BorderLayout());
	private JPanel N_pan = new JPanel(new FlowLayout(FlowLayout.RIGHT));
	private JPanel W_pan = new JPanel(new FlowLayout());
	private JPanel CS_pan = new JPanel(new FlowLayout(FlowLayout.CENTER));
	private JPanel CN_pan = new JPanel();
	private JPanel CC_pan = new JPanel(new BorderLayout());

	// 라벨
	private JLabel MNla;
	private JLabel Chatimg;
	// 버튼
	private JButton MNbtn;
	private JButton btnTransfer;
	//텍스트필드
	private JTextField txtF;
	private JTextArea txtA;
	private JButton btn1;
	
	public Chat() {
		super("Chat");

		SetPanel();
		EventSet();
		window();
		setSize(800, 700);
		setVisible(false);

	}

	// 패널 추가
	public void SetPanel() {
		Com();
		mainpan.add("North", N_pan);
		mainpan.setBackground(Color.WHITE);
		N_pan.add(MNla);
		N_pan.add(MNbtn);
		N_pan.setBackground(Color.WHITE);
		
		mainpan.add("Center",C_pan );
		C_pan.add("Center",Chatimg);
		C_pan.add("South",btn1);
		C_pan.setBackground(Color.WHITE);
				
		add(mainpan);
	}// SetPanel()

	public void Com() {
		MNla = new JLabel("..님 로그인 하셨습니다.");
		MNbtn = new JButton("로그아웃");
		Chatimg= new JLabel(new ImageIcon("./src/images/Chat_main.png"));
		btn1 = new JButton(new ImageIcon("./src/images/join2.png"));
		
		btn1.setContentAreaFilled(false);
		btn1.setFocusPainted(false);
		btn1.setBorderPainted(false);
	}

	// 이벤트 추가
	public void EventSet() {
		btn1.addActionListener(this);
	}// EventSet()

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btn1) {

		}
	}
	
	//윈도우 띄우기
		public void window() {

			Dimension tsc = Toolkit.getDefaultToolkit().getScreenSize();// 화면크기
			Dimension mySize = getSize();// 띄우는 창 크기
			setLocation(tsc.width / 2 - mySize.width / 2, tsc.height / 2 - mySize.height / 2);
		}//window()
}
