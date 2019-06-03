package com.yadata.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Price extends JFrame implements ActionListener {

	int count = 0;

	DetailPage detailpage = new DetailPage();
	// 패널
	private JPanel mainpan = new JPanel(new BorderLayout()); // 메인 패널
	private JPanel C_pan = new JPanel(new BorderLayout()); // 메인의 센터 페널
	private JPanel N_pan = new JPanel(new GridLayout(1, 7)); // 메인의 북쪽 패널
	private JPanel E_pan = new JPanel(new GridLayout(0, 1)); // 메인의 서쪽패널
	private JPanel Card_pan = new JPanel(new FlowLayout(FlowLayout.CENTER));
	private JPanel Card_1 = new JPanel(new GridLayout(0, 3));
	private JPanel Card_2 = new JPanel(new GridLayout(0, 3));
	private JPanel Card_3 = new JPanel(new GridLayout(0, 3));
	private JPanel Card_4 = new JPanel(new GridLayout(0, 3));

	// 이미지
	private ImageIcon accent;
	private ImageIcon accent_in;
	private ImageIcon clio;
	private ImageIcon clio_in;
	private ImageIcon mini;;
	private ImageIcon mini_in;
	private ImageIcon moning;
	private ImageIcon moning_in;
	private ImageIcon ray;
	private ImageIcon ray_in;
	private ImageIcon spake;
	private ImageIcon spake_in;
	private ImageIcon twith;
	private ImageIcon twith_in;
	private ImageIcon bolt;
	private ImageIcon bolt_in;

	private ImageIcon mcar1;
	private ImageIcon mcar1_in;
	private ImageIcon mcar2;
	private ImageIcon mcar2_in;
	private ImageIcon mcar3;
	private ImageIcon mcar3_in;;
	private ImageIcon mcar4;
	private ImageIcon mcar4_in;
	private ImageIcon mcar5;
	private ImageIcon mcar5_in;
	private ImageIcon mcar6;
	private ImageIcon mcar6_in;
	private ImageIcon mcar7;
	private ImageIcon mcar7_in;
	private ImageIcon mcar8;
	private ImageIcon mcar8_in;

	private ImageIcon lcar;
	private ImageIcon lmcar;
	private ImageIcon mcar;
	private ImageIcon scar;
	private ImageIcon scar_in;

	private ImageIcon mcarimg;
	private ImageIcon mcarimg_in;
	private ImageIcon lcarimg;
	private ImageIcon lmcarimg;
	private ImageIcon scarimg;

	// 라벨
	private JLabel info_login;

	// 버튼
	private JButton logout_btn;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;

	private JButton accentbtn;
	private JButton minibtn;
	private JButton cliobtn;
	private JButton spakebtn;
	private JButton twithbtn;
	private JButton moningbtn;
	private JButton morebtn;
	private JButton raybtn;
	private JButton boltbtn;

	private JButton mcar1btn;
	private JButton mcar2btn;
	private JButton mcar3btn;
	private JButton mcar4btn;
	private JButton mcar5btn;
	private JButton mcar6btn;
	private JButton mcar7btn;
	private JButton mcar8btn;
	private JButton more2btn;

	public Price() {
		super("Price");
		setSize(1330, 820);

		SetPanel();
		setVisible(false);

		// 프레임 윈도우 창 정중앙 배치
		Dimension tsc = Toolkit.getDefaultToolkit().getScreenSize();// 화면크기
		Dimension mySize = getSize();// 띄우는 창 크기
		setLocation(tsc.width / 2 - mySize.width / 2, tsc.height / 2 - mySize.height / 2);
	}

	public void Com() {
		accent = new ImageIcon("./src/images/accent.png");
		accent_in = new ImageIcon("./src/images/accent_in.png");
		clio = new ImageIcon("./src/images/clio.png");
		clio_in = new ImageIcon("./src/images/clio_in.png");
		mini = new ImageIcon("./src/images/mini.png");
		mini_in = new ImageIcon("./src/images/mini_in.png");
		moning = new ImageIcon("./src/images/moning.png");
		moning_in = new ImageIcon("./src/images/moning_in.png");
		ray = new ImageIcon("./src/images/ray.png");
		ray_in = new ImageIcon("./src/images/ray_in.png");
		spake = new ImageIcon("./src/images/spake.png");
		spake_in = new ImageIcon("./src/images/spake_in.png");
		twith = new ImageIcon("./src/images/twith.png");
		twith_in = new ImageIcon("./src/images/twith_in.png");
		bolt = new ImageIcon("./src/images/bolt.png");
		bolt_in = new ImageIcon("./src/images/bolt_in.png");

		mcar1 = new ImageIcon("./src/images/mcar1.png");
		mcar1_in = new ImageIcon("./src/images/mcar1_in.png");
		mcar2 = new ImageIcon("./src/images/mcar2.png");
		mcar2_in = new ImageIcon("./src/images/mcar2_in.png");
		mcar3 = new ImageIcon("./src/images/mcar3.png");
		mcar3_in = new ImageIcon("./src/images/mcar3_in.png");
		mcar4 = new ImageIcon("./src/images/mcar4.png");
		mcar4_in = new ImageIcon("./src/images/mcar4_in.png");
		mcar5 = new ImageIcon("./src/images/mcar5.png");
		mcar5_in = new ImageIcon("./src/images/mcar5_in.png");
		mcar6 = new ImageIcon("./src/images/mcar6.png");
		mcar6_in = new ImageIcon("./src/images/mcar6_in.png");
		mcar7 = new ImageIcon("./src/images/mcar7.png");
		mcar7_in = new ImageIcon("./src/images/mcar7_in.png");
		mcar8 = new ImageIcon("./src/images/mcar8.png");
		mcar8_in = new ImageIcon("./src/images/mcar8_in.png");

		lcar = new ImageIcon("./src/images/lcar.png");
		lmcar = new ImageIcon("./src/images/lmcar.png");
		mcar = new ImageIcon("./src/images/mcar.png");
		scar = new ImageIcon("./src/images/scar.png");
		scar_in = new ImageIcon("./src/images/scar_in.png");

		mcarimg = new ImageIcon("./src/images/mcar.png");
		mcarimg_in = new ImageIcon("./src/images/mcar_in.png");
		lcarimg = new ImageIcon("./src/images/lcarimg.png");
		lmcarimg = new ImageIcon("./src/images/lmcarimg.png");
		scarimg = new ImageIcon("./src/images/scarimg.png");

		// 라벨
		info_login = new JLabel("");

		// 버튼
		logout_btn = new JButton("로그아웃");
		btn1 = new JButton("소형");
		btn2 = new JButton("중형");
		btn3 = new JButton("준중형");
		btn4 = new JButton("대형");

		accentbtn = new JButton(accent);
		minibtn = new JButton(mini);
		cliobtn = new JButton(clio);
		spakebtn = new JButton(spake);
		twithbtn = new JButton(twith);
		moningbtn = new JButton(moning);
		morebtn = new JButton(scar);
		raybtn = new JButton(ray);
		boltbtn = new JButton(bolt);

		mcar1btn = new JButton(mcar1);
		mcar2btn = new JButton(mcar2);
		mcar3btn = new JButton(mcar3);
		mcar4btn = new JButton(mcar4);
		mcar5btn = new JButton(mcar5);
		mcar6btn = new JButton(mcar6);
		mcar7btn = new JButton(mcar7);
		mcar8btn = new JButton(mcar8);
		more2btn = new JButton(mcar);

	}

	// 패널 추가
	public void SetPanel() {
		Com();
		Color();
		Event();
		mainpan.add("West", new JLabel());
		mainpan.add("East", new JLabel());
		mainpan.add("South", new JLabel());
		mainpan.add("North", N_pan);

		N_pan.add(new JLabel());
		N_pan.add(new JLabel());
		N_pan.add(new JLabel());
		N_pan.add(new JLabel());
		N_pan.add(new JLabel());
		N_pan.add(info_login);
		N_pan.add(logout_btn);

		mainpan.add("Center", C_pan);

		C_pan.add("North", new JLabel());
		C_pan.add("West", E_pan);
		C_pan.add("South", new JLabel());
		E_pan.add(btn1);
		E_pan.add(btn2);
		E_pan.add(btn3);
		E_pan.add(btn4);

		C_pan.add("Center", Card_pan);
		Card_pan.add(Card_1);
		Card_1.add(accentbtn);
		Card_1.add(cliobtn);
		Card_1.add(moningbtn);
		Card_1.add(twithbtn);
		Card_1.add(boltbtn);
		Card_1.add(raybtn);
		Card_1.add(minibtn);
		Card_1.add(spakebtn);
		Card_1.add(morebtn);

		Card_1.setVisible(true);

		Card_pan.add(Card_2);
		Card_2.add(mcar1btn);
		Card_2.add(mcar2btn);
		Card_2.add(mcar3btn);
		Card_2.add(mcar4btn);
		Card_2.add(mcar5btn);
		Card_2.add(mcar6btn);
		Card_2.add(mcar7btn);
		Card_2.add(mcar8btn);
		Card_2.add(more2btn);
		Card_2.setVisible(false);

		Card_pan.add(Card_3);
		Card_3.add(new JButton("3"));
		Card_3.add(new JButton("1234"));
		Card_3.add(new JLabel(new ImageIcon("./src/images/S_car01.jpeg")));
		Card_3.add(new JLabel(new ImageIcon("./src/images/S_car02.jpg")));
		Card_3.add(new JLabel(new ImageIcon("./src/images/S_car03.jpeg")));
		Card_3.add(new JLabel(new ImageIcon("./src/images/S_car04.jpg")));
		Card_3.add(new JButton("1234"));
		Card_3.add(new JButton("1234"));
		Card_3.add(new JButton("1234"));
		Card_3.add(new JButton("33"));
		Card_3.setVisible(false);

		Card_pan.add(Card_4);
		Card_4.add(new JButton("4"));
		Card_4.add(new JButton("1234"));
		Card_4.add(new JButton("1234"));
		Card_4.add(new JButton("1234"));
		Card_4.add(new JLabel(new ImageIcon("./src/images/S_car01.jpeg")));
		Card_4.add(new JLabel(new ImageIcon("./src/images/S_car02.jpg")));
		Card_4.add(new JLabel(new ImageIcon("./src/images/S_car03.jpeg")));
		Card_4.add(new JLabel(new ImageIcon("./src/images/S_car04.jpg")));
		Card_4.add(new JButton("1234"));
		Card_4.add(new JButton("1234"));

		Card_4.setVisible(false);

		add(mainpan);

	}

	// 이벤트 등록
	public void Event() {

		// 클릭 이벤트
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);

		accentbtn.addActionListener(this);
		moningbtn.addActionListener(this);
		cliobtn.addActionListener(this);
		minibtn.addActionListener(this);
		spakebtn.addActionListener(this);
		twithbtn.addActionListener(this);
		raybtn.addActionListener(this);
		boltbtn.addActionListener(this);
		morebtn.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		PanelChange(e);
		Detail(e);
		Disabled(e);
		MouseEvent();
	}// 버튼 클릭시

	// 디테일 페이지 이동
	public void Detail(ActionEvent e) {
		if (e.getSource() == accentbtn) {
		} else if (e.getSource() == boltbtn) {

		} else if (e.getSource() == cliobtn) {
		} else if (e.getSource() == minibtn) {
			detailpage.setVisible(true);

		} else if (e.getSource() == moningbtn) {

		} else if (e.getSource() == raybtn) {

		} else if (e.getSource() == spakebtn) {

		} else if (e.getSource() == twithbtn) {

		} else if (e.getSource() == morebtn) {
		}
	}// Detail()

	//sold-out 설
	public void Disabled(ActionEvent e) {

		if (e.getSource() == accentbtn) {
			count++;
			if (count == 4) {

				accentbtn.setEnabled(false);

			}
		}
	}//Disabled()

	// 마우스이벤
	public void MouseEvent() {
		// 마우스 이벤트
		accentbtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				accentbtn.setIcon(accent_in);
				accentbtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				accentbtn.setIcon(accent);
				accentbtn.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

		});

		moningbtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				moningbtn.setIcon(moning_in);
				moningbtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				moningbtn.setIcon(moning);
				moningbtn.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});

		cliobtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				cliobtn.setIcon(clio_in);
				cliobtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				cliobtn.setIcon(clio);
				cliobtn.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

		});
		spakebtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				spakebtn.setIcon(spake_in);
				spakebtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				spakebtn.setIcon(spake);
				spakebtn.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

		});
		minibtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				minibtn.setIcon(mini_in);
				minibtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				minibtn.setIcon(mini);
				minibtn.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

		});
		raybtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				raybtn.setIcon(ray_in);
				raybtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				raybtn.setIcon(ray);
				raybtn.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

		});
		twithbtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				twithbtn.setIcon(twith_in);
				twithbtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				twithbtn.setIcon(twith);
				twithbtn.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

		});
		boltbtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				boltbtn.setIcon(bolt_in);
				boltbtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				boltbtn.setIcon(bolt);
				boltbtn.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

		});
		morebtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				morebtn.setIcon(scar_in);
				morebtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				morebtn.setIcon(scar);
				morebtn.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

		});
		mcar1btn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				mcar1btn.setIcon(mcar1_in);
				mcar1btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				mcar1btn.setIcon(mcar1);
				mcar1btn.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

		});
		mcar2btn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				mcar2btn.setIcon(mcar2_in);
				mcar2btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				mcar2btn.setIcon(mcar2);
				mcar2btn.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

		});
		mcar3btn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				mcar3btn.setIcon(mcar3_in);
				mcar3btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				mcar3btn.setIcon(mcar3);
				mcar3btn.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

		});
		mcar4btn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				mcar4btn.setIcon(mcar4_in);
				mcar4btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				mcar4btn.setIcon(mcar4);
				mcar4btn.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

		});
		mcar5btn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				mcar5btn.setIcon(mcar5_in);
				mcar5btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				mcar5btn.setIcon(mcar5);
				mcar5btn.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

		});
		mcar6btn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				mcar6btn.setIcon(mcar6_in);
				mcar6btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				mcar6btn.setIcon(mcar6);
				mcar6btn.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

		});
		mcar7btn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				mcar7btn.setIcon(mcar7_in);
				mcar7btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				mcar7btn.setIcon(mcar7);
				mcar7btn.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

		});
		mcar8btn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				mcar8btn.setIcon(mcar8_in);
				mcar8btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				mcar8btn.setIcon(mcar8);
				mcar8btn.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

		});
		more2btn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				more2btn.setIcon(mcarimg_in);
				more2btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				more2btn.setIcon(mcarimg);
				more2btn.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

		});
	}// MouseEvent()

	// 패널 변경 이벤트
	public void PanelChange(ActionEvent e) {
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
		} else if (e.getSource() == btn4) {
			Card_1.setVisible(false);
			Card_2.setVisible(false);
			Card_3.setVisible(false);
			Card_4.setVisible(true);
		}
	}// PanelChange()

	// 다이얼로그창 띄우기
	public static void messageBox(Object obj, String m) {
		JOptionPane.showMessageDialog((Component) obj, m);
	}// messageBox()

	public void Color() {
		// 패널 배경 흰색
		setBackground(Color.WHITE);
		N_pan.setBackground(Color.WHITE);
		mainpan.setBackground(Color.WHITE);
		C_pan.setBackground(Color.WHITE);
		E_pan.setBackground(Color.WHITE);
		Card_pan.setBackground(Color.WHITE);
		Card_1.setBackground(Color.WHITE);
		Card_2.setBackground(Color.WHITE);
		Card_3.setBackground(Color.WHITE);
		Card_4.setBackground(Color.WHITE);

		// 버튼 배경 지우기
		accentbtn.setContentAreaFilled(false);
		accentbtn.setFocusPainted(false);
		accentbtn.setBorderPainted(false);

		cliobtn.setContentAreaFilled(false);
		cliobtn.setFocusPainted(false);
		cliobtn.setBorderPainted(false);

		minibtn.setContentAreaFilled(false);
		minibtn.setFocusPainted(false);
		minibtn.setBorderPainted(false);

		moningbtn.setContentAreaFilled(false);
		moningbtn.setFocusPainted(false);
		moningbtn.setBorderPainted(false);

		raybtn.setContentAreaFilled(false);
		raybtn.setFocusPainted(false);
		raybtn.setBorderPainted(false);

		spakebtn.setContentAreaFilled(false);
		spakebtn.setFocusPainted(false);
		spakebtn.setBorderPainted(false);

		twithbtn.setContentAreaFilled(false);
		twithbtn.setFocusPainted(false);
		twithbtn.setBorderPainted(false);

		morebtn.setContentAreaFilled(false);
		morebtn.setFocusPainted(false);
		morebtn.setBorderPainted(false);

		boltbtn.setContentAreaFilled(false);
		boltbtn.setFocusPainted(false);
		boltbtn.setBorderPainted(false);

		btn1.setContentAreaFilled(false);
		btn1.setFocusPainted(false);
		btn1.setBorderPainted(false);

		btn2.setContentAreaFilled(false);
		btn2.setFocusPainted(false);
		btn2.setBorderPainted(false);

		btn3.setContentAreaFilled(false);
		btn3.setFocusPainted(false);
		btn3.setBorderPainted(false);

		btn4.setContentAreaFilled(false);
		btn4.setFocusPainted(false);
		btn4.setBorderPainted(false);

		btn4.setContentAreaFilled(false);
		btn4.setFocusPainted(false);
		btn4.setBorderPainted(false);

		btn4.setContentAreaFilled(false);
		btn4.setFocusPainted(false);
		btn4.setBorderPainted(false);

		mcar1btn.setContentAreaFilled(false);
		mcar1btn.setFocusPainted(false);
		mcar1btn.setBorderPainted(false);

		mcar2btn.setContentAreaFilled(false);
		mcar2btn.setFocusPainted(false);
		mcar2btn.setBorderPainted(false);

		mcar3btn.setContentAreaFilled(false);
		mcar3btn.setFocusPainted(false);
		mcar3btn.setBorderPainted(false);

		mcar4btn.setContentAreaFilled(false);
		mcar4btn.setFocusPainted(false);
		mcar4btn.setBorderPainted(false);

		mcar5btn.setContentAreaFilled(false);
		mcar5btn.setFocusPainted(false);
		mcar5btn.setBorderPainted(false);

		mcar6btn.setContentAreaFilled(false);
		mcar6btn.setFocusPainted(false);
		mcar6btn.setBorderPainted(false);

		mcar7btn.setContentAreaFilled(false);
		mcar7btn.setFocusPainted(false);
		mcar7btn.setBorderPainted(false);

		mcar8btn.setContentAreaFilled(false);
		mcar8btn.setFocusPainted(false);
		mcar8btn.setBorderPainted(false);

		more2btn.setContentAreaFilled(false);
		more2btn.setFocusPainted(false);
		more2btn.setBorderPainted(false);

	}
}