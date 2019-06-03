package com.yadata.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.yadata.domin.YadataVO;
import com.yadata.persistence.YadataCarDAO;

public class Pay extends JFrame implements ActionListener {
	private JPanel pan=new JPanel(new BorderLayout());
	private JPanel panS=new JPanel(new FlowLayout());
	private JPanel panN=new JPanel(new BorderLayout());
	private JPanel panC=new JPanel(new BorderLayout());
	private JPanel panCS=new JPanel(new BorderLayout());
	private JPanel panCN=new JPanel(new FlowLayout());
	private JPanel panCC=new JPanel(new BorderLayout());
	private JPanel panCCN=new JPanel(new GridLayout(1,2));
	private JPanel panCCC=new JPanel(new BorderLayout());
	private JPanel panCCS=new JPanel(new GridLayout(1,2));
	private JPanel panCCCN=new JPanel(new GridLayout(1,3));
	private JPanel panCCCS=new JPanel(new GridLayout(1,2));
	private JPanel panCCCC=new JPanel(new BorderLayout());
	private JPanel panCCCCN=new JPanel(new GridLayout(1,3));
	private JPanel panCCCCS=new JPanel(new GridLayout(1,8));
	private JPanel panCCCCC=new JPanel(new BorderLayout());




	private JLabel logo=new JLabel(new ImageIcon("./src/images/paylogo.PNG"));
	private JLabel logo2=new JLabel("신용카드 정보입력");
	private JLabel la1=new JLabel("결제금액");
	private JLabel la2=new JLabel("카드종류");
	private JLabel la3=new JLabel("카드번호");
	private JLabel la4=new JLabel("        -");
	private JLabel la5=new JLabel("        -");
	private JLabel la6=new JLabel("        -");
	private JLabel la7=new JLabel("유효기간");
	private JLabel la8=new JLabel("주민번호 뒷번호");
	private JLabel la9=new JLabel("XXXXXX-");
	private JLabel la11=new JLabel("카드비밀번호");
	private JLabel m=new JLabel("월");
	private JLabel y=new JLabel("년");

	private JPasswordField num;
	char passwordChar;
	private JTextArea txtA=new JTextArea("1.카드청구에서는 KCP,CO,KR로 명시됩니다.\n"
			+"2.국민/비씨카드는 ISP안전결제로 가능합니다.\n"
			+"3.기업 법인 카드는 사업자 번호 , 개인법인 카드는 주민번호를 필히 입력하세요\n"
			+"4.SSL보안암호화로 안전합니다.");

	private JButton confirm=new JButton("결제확인");

	JTextField price=new JTextField (20);
	//JTextField getCard=new JTextField ("카드종류받아오기");
	//JTextField num=new JTextField("주민번호뒷자리");
	JTextField num2=new JTextField(20);
	JTextField t1=new JTextField(4);
	JTextField t2=new JTextField(4);
	JTextField t3=new JTextField(4);
	JTextField t4=new JTextField(4);



	private JComboBox creditK;
	private JComboBox period=new JComboBox();
	private JComboBox period2=new JComboBox();
	Font f=new Font("san serif",Font.BOLD,15);

	YadataCarDAO ydao=new YadataCarDAO();
	YadataVO yVO;
	public Pay(YadataVO yVO){
		this.yVO=yVO;
		setSize(450,400);
		setpanel();
		setVisible(true);
		color();

	}

	public void setpanel() {
		String [] credit= {"신한","농협","국민","우리","현대","하나","카카오뱅크","미래에셋"};
		String [] mon= {"1","2","4","5","6","7","8","9","10","11","12"};
		String [] year= {"2019","2020","2021","2022","2023","2024","2025"};

		creditK=new JComboBox(credit);
		period=new JComboBox(mon);
		period2=new JComboBox(year);
		num=new JPasswordField("비밀번호");

		pan.add("North",panN);
		panN.add(logo);
		pan.add("South",panS);
		panS.add(confirm);
		pan.add("Center",panC);

		panC.add("North",panCN);
		panCN.add(logo2);
		logo2.setFont(f);
		panC.add("South",panCS);
		panCS.add(txtA);
		panC.add("Center",panCC);

		panCC.add("North",panCCN);
		panCCN.add(la1);
		panCCN.add(price);
		panCC.add("South",panCCS);
		panCCS.add(la11);
		panCCS.add(num2);
		panCC.add("Center",panCCC);

		panCCC.add("North",panCCCN);
		panCCCN.add(la2);
		panCCCN.add(creditK);
		//panCCCN.add(getCard);
		panCCC.add("South",panCCCS);
		panCCCS.add(la8);
		panCCCS.add(la9);
		panCCCS.add(num);

		passwordChar = num.getEchoChar();
		num.setEchoChar((char) 0);

		panCCC.add("Center",panCCCC);

		panCCCC.add("Center",panCCCCC);
		panCCCC.add(panCCCCS);
		panCCCCS.add(la7);
		panCCCCS.add(period);
		panCCCCS.add(m);
		panCCCCS.add(period2);
		panCCCCS.add(y);

		panCCCC.add("North",panCCCCN);
		panCCCCN.add(la3);
		panCCCCN.add(t1);
		panCCCCN.add(la4);
		panCCCCN.add(t2);
		panCCCCN.add(la5);
		panCCCCN.add(t3);
		panCCCCN.add(la6);
		panCCCCN.add(t4);

		add(pan);
		confirm.addActionListener(this);
	}	
	public void color() {
		pan.setBackground(Color.white);
		panS.setBackground(Color.white);
		panN.setBackground(Color.white);
		panC.setBackground(Color.white);
		panCS.setBackground(Color.white);
		panCN.setBackground(Color.white);
		panCC.setBackground(Color.white);
		panCCN.setBackground(Color.white);
		panCCC.setBackground(Color.white);
		panCCS.setBackground(Color.white);
		panCCCN.setBackground(Color.white);
		panCCCS.setBackground(Color.white);
		panCCCC.setBackground(Color.white);
		panCCCCN.setBackground(Color.white);
		panCCCCS.setBackground(Color.white);
		panCCCCC.setBackground(Color.white);

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if (e.getSource() ==confirm ) {
            yVO.setYa_reser("출차");

			if (price.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "금액이 입력되어 있는지 확인하세요");
				price.requestFocus();
				price.setText("");
				return;
			}

			if (t1.getText().equals("")) {
				messageBox(this, "카드 일련번호를 입력하세요.");
				num2.requestFocus();
				num2.setText("");
				return;
			} 
			if (t2.getText().equals("")) {
				messageBox(this, "카드 일련번호를 입력하세요.");
				num2.requestFocus();
				num2.setText("");
				return;
			}
			if (num.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "주민번호를 입력하세요.");
				num.requestFocus();
				num.setText("");
				return;
			}
			if (num2.getText().equals("")) {
				messageBox(this, "카드 비밀번호를 입력하세요.");
				num2.requestFocus();
				num2.setText("");
				return;
			} 
			if (t3.getText().equals("")) {
				messageBox(this, "카드 일련번호를 입력하세요.");
				num2.requestFocus();
				num2.setText("");
				return;
			}
			if (t4.getText().equals("")) {
				messageBox(this, "카드 일련번호를 입력하세요.");
				num2.requestFocus();
				num2.setText("");
				return;
			}else {// 모든 카드정보를 입력한 경우
				
				if(ydao.carUpdate(yVO)>0) {
					JOptionPane.showMessageDialog(this,"결제완료");
				}
			}
      System.out.println(yVO.getYa_carkind());
      System.out.println( yVO.getYa_reser());
      System.out.println(yVO.getYa_carkind());

		} // if
	} // if else

	public static void messageBox(Object obj, String m) {
		JOptionPane.showMessageDialog((Component) obj, m);
	}// messageBox()

}



