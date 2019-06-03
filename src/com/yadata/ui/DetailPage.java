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
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class DetailPage extends JFrame implements ActionListener {

String id;

	private JPanel mainpan = new JPanel(new BorderLayout());
	private JPanel C_pan = new JPanel();
	private JPanel S_pan = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 30));

	private ImageIcon img = new ImageIcon("./src/images/detailpage.jpg");

	private JButton reservebtn = new JButton("예약 하기");

	public DetailPage() {
		setTitle("DetailPage");
		setSize(800, 800);
		Event();
		SetPanel();
		window();
		setVisible(false);

	}

	// 패널 추가
	public void SetPanel() {
		mainpan.add("Center", C_pan);
		mainpan.setBackground(Color.WHITE);
		C_pan.add(new JLabel(img));
		C_pan.setBackground(Color.WHITE);
		mainpan.add("South", S_pan);
		S_pan.add(reservebtn);
		S_pan.setBackground(Color.WHITE);
		add(mainpan);

	}

	public void Event() {
		reservebtn.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == reservebtn) {
			int re = JOptionPane.showConfirmDialog(null, "예약하시겠습니까?", "예약확인",JOptionPane.YES_NO_OPTION);
					if(re==JOptionPane.YES_OPTION) {
						new Reserve(id);
					}else {
						this.setVisible(false);
					}
			
				
			}
			// System.exit(0);
		}
	

	public static void messageBox() {
		JOptionPane.showConfirmDialog(null, "예약하시겠습니까?", "예약확인",JOptionPane.YES_NO_OPTION);
	}// messageBox()

	// 윈도우 띄우기
	public void window() {

		Dimension tsc = Toolkit.getDefaultToolkit().getScreenSize();// 화면크기
		Dimension mySize = getSize();// 띄우는 창 크기
		setLocation(tsc.width / 2 - mySize.width / 2, tsc.height / 2 - mySize.height / 2);
	}// window()
}
