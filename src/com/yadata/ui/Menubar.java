package com.yadata.ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Menubar extends JFrame implements ActionListener {
	private JPanel pan=new JPanel(new GridLayout(0,6));
	private JButton b1=new JButton("RESERVE");
	private JButton b2=new JButton("PRICE");
	private JButton b3=new JButton("REVIEW");
	private JButton b4=new JButton("EVENT");
	private JButton b5=new JButton("MYPAGE");
	private JButton b6=new JButton("CHAT");


	public Menubar() {

		
		b1.add(pan);
		b2.add(pan); 
		b3.add(pan); 
		b4.add(pan);
		b5.add(pan);
		b6.add(pan);
		
		add(pan);
		
		setSize(200,500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



	}
	public static void main(String[] args) {

		new Menubar();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
