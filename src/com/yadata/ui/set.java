package com.yadata.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class set extends JFrame implements ActionListener {

	private JPanel pan=new JPanel(new BorderLayout());
	private JPanel panN=new JPanel(new BorderLayout());//관리자페이지 로고
	private JPanel panS=new JPanel(new BorderLayout());
	private JPanel panC=new JPanel(new BorderLayout());
	private JPanel panCN=new JPanel(new FlowLayout());
	private JPanel panCS=new JPanel(new BorderLayout());
	private JPanel panNN=new JPanel(new BorderLayout());
	private JPanel panNS=new JPanel(new BorderLayout());

	private JButton btn1=new JButton("예약자정보");
	private JButton btn2=new JButton("예약차량");
	private JButton btn3=new JButton("결제한 수단");
	private JButton btn4=new JButton("회원명단");
	private JButton btn5=new JButton("비회원명단");
	private JButton btn6=new JButton("출차현황");
	private JButton btn7=new JButton("방문자수");


	private JLabel set_logo=new JLabel(new ImageIcon("./src/images/set_logo.PNG"));

	public set() {
		super("set");

		SetPanel();
		window();
		setcolor();
		setSize(600, 500);
		setVisible(false);

	}// 생성자

	// 패널 추가
	public void SetPanel() {
		pan.add("North",panN);
		panN.add(set_logo);
		pan.add("South",panS);
		pan.add("Center",panC);

		panC.add("North",panCN);
		panCN.add(btn1); panCN.add(btn2);
		panCN.add(btn3); panCN.add(btn4);
		panCN.add(btn5); panCN.add(btn6);
		panCN.add(btn7);

		panC.add("South",panCS);

		add(pan);

		
	}// SetPane()
	
	public void setcolor() {
		pan.setBackground(Color.white);
		panN.setBackground(Color.white);
		panS.setBackground(Color.white);
		panC.setBackground(Color.white);
		panCN.setBackground(Color.white);
		panCS.setBackground(Color.white);
		panNN.setBackground(Color.white);
		panNS.setBackground(Color.white);
		
		
		btn1.setBackground(Color.WHITE);
		btn1.setFocusPainted(false);//선택되엇을때 테두리 사용안함
		
		btn2.setBackground(Color.WHITE);
		btn2.setFocusPainted(false);
		btn3.setBackground(Color.WHITE);
		btn3.setFocusPainted(false);
		btn4.setBackground(Color.WHITE);
		btn4.setFocusPainted(false);
		btn5.setBackground(Color.WHITE);
		btn5.setFocusPainted(false);
		btn6.setBackground(Color.WHITE);
		btn6.setFocusPainted(false);
		btn7.setBackground(Color.WHITE);
		btn7.setFocusPainted(false);
		
		
	}

	public void window() {

		Dimension tsc = Toolkit.getDefaultToolkit().getScreenSize();// 화면크기
		Dimension mySize = getSize();// 띄우는 창 크기
		setLocation(tsc.width / 2 - mySize.width / 2, tsc.height / 2 - mySize.height / 2);
	}// window()

	@Override
	public void actionPerformed(ActionEvent e) {

	}

}
