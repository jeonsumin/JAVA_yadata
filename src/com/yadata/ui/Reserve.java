package com.yadata.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import com.yadata.domin.YadataVO;
import com.yadata.persistence.YadataCarDAO;
import com.yadata.persistence.YadataReserveDAO;

public class Reserve extends JFrame implements ActionListener,MouseListener, FocusListener {

	//Calendar1 cal=new Calendar1();
	//	CalendarFrame cal2=new CalendarFrame();
	String id;

	YadataReserveDAO y_reDAO = new YadataReserveDAO();
	YadataVO y = new YadataVO();

	int a=0, b=5000,c=4000,d=3000; 


	private JScrollPane JScroll;
	private JPanel pan = new JPanel(new BorderLayout());
	private JPanel panN = new JPanel(new BorderLayout());
	private JPanel panS = new JPanel(new BorderLayout());
	private JPanel panSS = new JPanel(new BorderLayout());
	private JPanel panSN = new JPanel(new FlowLayout());
	private JPanel panC = new JPanel(new BorderLayout());
	private JPanel panCN = new JPanel(new BorderLayout());
	//private JPanel panCNC=new JPanel(new GridLayout(1,2));
	private JPanel panCNC=new JPanel(new BorderLayout());
	private JPanel panCNS=new JPanel(new GridLayout(1,3));
	private JPanel panCNN = new JPanel(new FlowLayout());
	private JPanel panCNNN = new JPanel(new BorderLayout());
	private JPanel panCS = new JPanel(new FlowLayout());
	private JPanel panCC = new JPanel(new BorderLayout());
	private JPanel panCCN = new JPanel(new GridLayout(5, 3));
	private JPanel panCCS = new JPanel(new GridLayout(5, 3));
	private JPanel panCCC = new JPanel(new BorderLayout());
	private JPanel panCCCN = new JPanel(new GridLayout(5, 1));
	private JPanel panCCCS = new JPanel(new BorderLayout());
	private JPanel panCCCC = new JPanel(new BorderLayout());
	private JPanel panCCCCN = new JPanel(new GridLayout(4, 3));

	private JLabel logo;// 1
	private JLabel picL;// 3
	private JLabel reL;// 4
	private JLabel choiceL;// 5
	private JLabel choiceR;// 6
	private JLabel credit;// 7
	private JLabel account;// 8
	private JLabel kakao;// 9
	private JLabel payR;// 10
	private JLabel la_totalP = new JLabel("총 금액");
	private JLabel la_Pdate = new JLabel("원하는 날짜를 선택하세요");
	private JLabel la_Rdate = new JLabel("반납날짜");

	private JButton picDbtn;// 1
	private JButton reDbtn;// 2
	private JButton lo_informbtn;// 3
	private JButton lo_informbtn2;// 3
	private JButton carbtn;// 4
	private JButton nobtn;// 5
	private JButton insur1btn;// 6
	private JButton insur2btn;// 7
	private JButton insur3btn;// 8
	// private JButton zipbtn;//9
	private JButton paybtn;// 10
	private JButton resetbtn;
	private JButton carshow=new JButton();


	private JComboBox location;
	private JComboBox location2;
	private JComboBox emailcom = new JComboBox();
	private JComboBox licencecom;
	private JComboBox carshowcom;

	private JRadioButton rb1;
	private JRadioButton rb2;
	private JRadioButton rb3;
	ButtonGroup group;

	JTextField txt_id = new JTextField();
	JTextField txt_name = new JTextField();
	JTextField txt_birth = new JTextField();
	JTextField txt_phone = new JTextField();
	JTextField txt_email = new JTextField();
	JTextField txt_g_email = new JTextField();
	JTextField txt_totalP = new JTextField();
	JTextField txt_Pdate = new JTextField();
	JTextField txt_Rdate = new JTextField();
	JTextField txt_carkind = new JTextField("차종류");
	JTextField txt_carprice2 = new JTextField("차값");
	JTextField txt_licencenum = new JTextField();
	JTextField txt_Ploc = new JTextField();
	JTextField txt_Rloc = new JTextField();
	JTextField txt_licencek = new JTextField();
	JTextField txt_insurprice = new JTextField(20);
	JTextField txt_getcar=new JTextField(20);


	public Reserve(String id) {
		super("RESRVE");
		txt_id.setText(id);
		com();
		color();
		SetPanel();
		Eventnu_Set();
		setSize(560, 800);
		setVisible(true);

	}

	public void com() {
		String[] kind = { "운전면허종류", "1종", "2종", "대형" };
		String[] loca1 = { "서울영등포", "서울여의도", "서울 강남", "서울 왕십리", "경기도 성남", "경기도 의정부", "경기도 가평", "경기도 양평", "경기도 구리",
				"충남 서산", "부산 서면", "전라도 광주", "제주" };

		String[] loca2 = { "서울영등포", "서울여의도", "서울 강남", "서울 왕십리", "경기도 성남", "경기도 의정부", "경기도 가평", "경기도 양평", "경기도 구리",
				"충남 서산", "부산 서면", "전라도 광주", "제주" };
		//String[] email = { "직접입력", "@naver.com", "@daum.net", "@nate.com", "@google.com", "@hotmail.com" };
		String[] car1= {"차량선택","엑센트(소형)-7,000원","모닝(소형)-7,400원","스파크(소형)-10,000원","기아레이(소형)-12,000원",
				"트위지(소형)-13,400원","볼보(소형)-27,600원","클리오(소형)-17,600원",
				"미니쿠퍼(소형)-15,200원","쏘나타(중형)-12,600원","말리부(중형)-15,600원","K5(중형)-17,600원",
				"마세라티(중형)-30,600원","SM6(중형)-24,100원"};

		//라벨
		logo = new JLabel(new ImageIcon("./src/images/reserve.PNG"));
		picL = new JLabel("픽업 지점 선택");
		reL = new JLabel("반납 지점 선택");
		choiceL = new JLabel("지점선택");
		choiceR = new JLabel("차량손해면책제도 선택");
		credit = new JLabel("신용카드");
		account = new JLabel("무통장입금");
		kakao = new JLabel("카카오페이");
		payR = new JLabel("결제수단");

		//버튼종류
		lo_informbtn = new JButton("지점위치안내");
		carbtn = new JButton("차량둘러보기");
		nobtn = new JButton("선택안함");
		insur1btn = new JButton("일반자차\n 면책금 50만원");
		insur2btn = new JButton("PLUS자차 \n 면책금 30만원");
		insur3btn = new JButton("SUPER자차\n 면책금 5만원");
		paybtn = new JButton("결제하기");
		lo_informbtn2 = new JButton("지점위치안내2");
		resetbtn=new JButton("날짜다시정하기");

		//콤보박스
		location = new JComboBox(loca1);
		location2 = new JComboBox(loca2);
		licencecom = new JComboBox(kind);
		//	emailcom = new JComboBox(email);
		carshowcom=new JComboBox(car1);

		//라디오버튼
		rb1 = new JRadioButton();
		rb2 = new JRadioButton();
		rb3 = new JRadioButton();
		group = new ButtonGroup();// 라디오 버튼 그룹화를 위한 그룹생성//그룹에서는 하나만선택가능

	}

	// 패널 추가
	public void SetPanel() {
		com();
		pan.add("North", new JLabel());
		pan.add("South", new JLabel());
		pan.add("East", new JLabel());
		pan.add("West", new JLabel());

		pan.add("North", panN);
		panN.add(logo);// 로고추가

		pan.add("South", panS);

		panS.add("North", panSN);
		panSN.add(rb1);
		panSN.add(credit);
		panSN.add(rb2);
		panSN.add(account);
		panSN.add(rb3);
		panSN.add(kakao);
		group.add(rb1);
		group.add(rb2);
		group.add(rb3);
		panSN.setBorder(new TitledBorder(new EtchedBorder(), "결제수단"));

		panS.add("South", panSS);
		panSS.add(paybtn);

		pan.add("Center", panC);
		panC.add("North", panCN);

		panCN.add("Center",panCNC);


		panCNC.add("Center",new Cal2(txt_Pdate,txt_Rdate));

		panCN.add("North", panCNN);
		panCNN.add(la_Pdate);

		panCN.add("South",panCNS);
		panCNS.add(txt_Pdate);
		txt_Pdate.setText("픽업날짜받아오기");
		panCNS.add(txt_Rdate);
		panCNS.add(resetbtn);
		txt_Rdate.setText("반납날짜 받아오기");


		panCNN.add("North", panCNNN);

		panC.add("South", panCS);
		panCS.add(la_totalP);
		la_totalP.setPreferredSize(new Dimension(70, 20));
		panCS.add(txt_totalP);
		txt_totalP.setPreferredSize(new Dimension(100, 20));
		txt_totalP.setEditable(false);//합계란에는 입력불가

		panC.add("Center", panCC);
		panCC.add("North", panCCN);
		panCCN.add(choiceL);
		// 빈공간주기
		panCCN.add(new JLabel(" "));
		panCCN.add(new JLabel(" "));
		panCCN.add(new JLabel(" "));

		choiceL.setPreferredSize(new Dimension(70, 20));

		panCCN.add(picL);//
		picL.setPreferredSize(new Dimension(70, 20));
		panCCN.add(location);
		panCCN.add(txt_Ploc);
		panCCN.add(lo_informbtn2);

		// 빈공간주기
		panCCN.add(new JLabel(""));
		panCCN.add(new JLabel(""));
		panCCN.add(new JLabel(""));
		panCCN.add(new JLabel(""));

		location2.setPreferredSize(new Dimension(70, 20));
		panCCN.add(reL);
		panCCN.add(location2);
		panCCN.add(txt_Rloc);

		panCCN.add(lo_informbtn);
		panCCN.add(new JLabel(""));
		panCCN.add(new JLabel(""));

		panCC.add("Center", panCCC);
		panCCC.add("North", panCCCN);
		panCCCN.add(new JLabel("차량선택"));

		panCCCN.add(carbtn);
		panCCCN.add(carshowcom);
		panCCCN.add(txt_carkind);
		panCCCN.add(txt_carprice2);

		panCCC.add("South", panCCCS);
		panCCC.add("Center", panCCCC);

		panCCCC.add("North", panCCCCN);// 차량 손해면책 제도
		panCCCCN.add(choiceR);
		panCCCCN.add(new JLabel(" "));
		panCCCCN.add(nobtn);
		panCCCCN.add(insur1btn);
		panCCCCN.add(insur2btn);
		panCCCCN.add(insur3btn);
		panCCCCN.add(txt_insurprice);

		// 개인정보입력패널
		panCC.add("South", panCCS);
		panCCS.add(new JLabel("개인정보선택"));


		panCCS.add(new JLabel(" "));// 빈공간주기
		panCCS.add(new JLabel(" "));
		panCCS.add(txt_id);
		panCCS.add(txt_name);
		panCCS.add(txt_birth);
		panCCS.add(txt_email);
		panCCS.add(new JLabel(""));
		panCCS.add(new JLabel(""));
		panCCS.add(licencecom);
		panCCS.add(txt_licencek);
		panCCS.add(txt_licencenum);

		JScroll = new JScrollPane(pan);

		add(JScroll);

		txt_name .setText("이름");
		txt_birth.setText("생년월일(901019)입력");
		txt_phone.setText("핸드폰번호입력(-제외)");
		txt_email.setText("이메일입력");
	
		txt_id.setEnabled(false);
		txt_licencenum.setText("면허번호(-제외)입력");



		paybtn.addActionListener(this);
		resetbtn.addActionListener(this);
	}// SetPanel()

	public void color() {
		panCNC.setBackground(Color.pink);
		pan.setBackground(Color.WHITE);
		panN.setBackground(Color.WHITE);
		panS.setBackground(Color.WHITE);
		panSS.setBackground(Color.WHITE);
		panSN.setBackground(Color.WHITE);
		panC.setBackground(Color.WHITE);
		panCN.setBackground(Color.WHITE);
		panCS.setBackground(Color.WHITE);
		panCC.setBackground(Color.WHITE);
		panCCN.setBackground(Color.WHITE);
		panCCS.setBackground(Color.WHITE);
		panCCC.setBackground(Color.WHITE);
		panCCCN.setBackground(Color.WHITE);
		panCCCS.setBackground(Color.WHITE);
		panCCCC.setBackground(Color.WHITE);
		panCCCCN.setBackground(Color.WHITE);
		panCNN.setBackground(Color.WHITE);
		panCNNN.setBackground(Color.WHITE);

	}
	public void Eventnu_Set() {
		location.addActionListener(this);
		location2.addActionListener(this);
		licencecom.addActionListener(this);
		emailcom.addActionListener(this);
		nobtn.addActionListener(this);
		insur1btn.addActionListener(this);
		insur2btn.addActionListener(this);
		insur3btn.addActionListener(this);
		carshowcom.addActionListener(this);
		carbtn.addActionListener(this);
		
		txt_id.addMouseListener(this);
		txt_id.addFocusListener(this);
		txt_name.addMouseListener(this);
		txt_name.addFocusListener(this);
		txt_birth.addMouseListener(this);
		txt_birth.addFocusListener(this);
		txt_email.addMouseListener(this);
		txt_email.addFocusListener(this);
		txt_licencenum.addMouseListener(this);
		txt_licencenum.addFocusListener(this);

	}//Eventnu_Set()


	@Override
	public void actionPerformed(ActionEvent e) {
		
	/*	YadataVO ok;
		System.out.println(id);
		ok=y_reDAO.loginCheck(id);
	//	String id = ok.getYa_id();
		*/
		if(e.getSource() == location) {
			String str=(String)location.getSelectedItem();//선택된 콤보박스 항목이름을 가져옴.
			txt_Ploc.setText(str);//픽업주소 입력박스에 출력
			txt_Ploc.setEditable(false);//픽업주소 입력박스를 수정못하게 비활성화

			if(str.equals("서울영등포")) {
				txt_Ploc.setText("");
				txt_Ploc.setEditable(false);

			}
		}
		if(e.getSource() == location2) {
			String str1=(String)location2.getSelectedItem();//선택된 콤보박스 항목이름을 가져옴.
			txt_Rloc.setText(str1);//반납주소 입력박스에 출력
			txt_Rloc.setEditable(false);//픽업주소 입력박스를 수정못하게 비활성화

			if(str1.equals("서울영등포")) {
				txt_Rloc.setText("");
				txt_Rloc.setEditable(false);

			}
		}
		if(e.getSource() == licencecom) {
			String str2=(String)licencecom.getSelectedItem();//선택된 콤보박스 항목이름을 가져옴.
			txt_licencek.setText(str2);//픽업주소 입력박스에 출력
			txt_licencek.setEditable(false);//픽업주소 입력박스를 수정못하게 비활성화

			if(str2.equals("운전면허종류")) {
				txt_licencek.setText("");
				txt_licencek.setEditable(false);

			}
		}
		if(e.getSource() == carshowcom) {
			String str3=(String)carshowcom.getSelectedItem();//선택된 콤보박스 항목이름을 가져옴.
			

			
			if(str3.equals("차량선택")) {
				 y.setYa_carprice2("0");
			}else if(str3.equals("엑센트(소형)-7,000원")) {
				 y.setYa_carprice2("7000");y.setYa_carkind("엑센트(소형)");
			}else if(str3.equals("모닝(소형)-7,400원)")){
				y.setYa_carprice2("7400");y.setYa_carkind("모닝(소형)");
			}else if(str3.equals("스파크(소형)-10,000원")){
				y.setYa_carprice2("10000");y.setYa_carkind("스파크(소형)");
			}else if(str3.equals("기아레이(소형)-12,000원")){
				y.setYa_carprice2("12000");y.setYa_carkind("기아레이(소형)");
			}else if(str3.equals("트위지(소형)-13,400원")){
				y.setYa_carprice2("13400");y.setYa_carkind("트위지(소형)");
			}else if(str3.equals("볼보(소형)-27,600원")){
				y.setYa_carprice2("27600");y.setYa_carkind("볼보(소형)");
			}else if(str3.equals("클리오(소형)-17,600원")){
				y.setYa_carprice2("17600");y.setYa_carkind("클리오(소형)");
			}else if(str3.equals("미니쿠퍼(소형)-15,200원")){
				y.setYa_carprice2("15200");y.setYa_carkind("미니쿠퍼(소형)");
			}else if(str3.equals("쏘나타(중형)-12,600원")){
				y.setYa_carprice2("12600");y.setYa_carkind("쏘나타(중형)");
			}else if(str3.equals("말리부(중형)-15,600원")){
				y.setYa_carprice2("15600");y.setYa_carkind("말리부(중형)");
			}else if(str3.equals("K5(중형)-17,600원")){
				y.setYa_carprice2("17600");y.setYa_carkind("K5(중형)");
			}else if(str3.equals("마세라티(중형)-30,600원")){
				y.setYa_carprice2("30600");y.setYa_carkind("마세라티(중형)");
			}else if(str3.equals("SM6(중형)-24,100원")){
				y.setYa_carprice2("24100");y.setYa_carkind("SM6(중형)");
			}

			txt_carkind.setText(y.getYa_carkind());//차량종류를 입력박스에 출력
			txt_carkind.setEditable(false);//차량종류를 입력박스를 수정못하게 비활성화	
			
		txt_carprice2.setText(y.getYa_carprice2());
		//txt_carprice2.setEditable(false);
		}

		if(e.getSource()==nobtn) {

			txt_insurprice.setText(a+"원");

		}else if(e.getSource()==insur1btn) {

			txt_insurprice.setText(d+"원");;
		}else if(e.getSource()==insur2btn) {

			txt_insurprice.setText(c+"원");
		}else if(e.getSource()==insur3btn) {

			txt_insurprice.setText(b+"원");
		}


		if(e.getSource()==carbtn) {
			new Price();
		}
		if(e.getSource()==resetbtn) {

			txt_Rdate.setText("");
			txt_Pdate.setText("");

		}
		if (e.getSource() == paybtn) {

			y.setYa_Pdate(txt_Pdate.getText());
			y.setYa_Rdate(txt_Rdate.getText());
			y.setYa_Ploc(txt_Ploc.getText());
			y.setYa_Rloc(txt_Rloc.getText());
			y.setYa_carkind(txt_carkind.getText());
			y.setYa_carprice2(txt_carprice2.getText());
			y.setYa_insurprice(txt_insurprice.getText());
			y.setYa_id(txt_id.getText());
			y.setYa_name(txt_name.getText());
			y.setYa_birth(txt_birth.getText());
			y.setYa_email(txt_email.getText());
			y.setYa_licencek(txt_licencek.getText());
			y.setYa_licencenum(txt_licencenum.getText());
			y.setYa_totalP(txt_totalP.getText());

			if (txt_id.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "아이디가 입력되어 있는지 확인하세요");
				txt_id.requestFocus();
				txt_id.setText("");
				return;
			}

			if (txt_name.getText().equals("")) {
				messageBox(this, "이름이 입력 되어있는지 확인하세요.");
				txt_name.requestFocus();
				txt_name.setText("");
				return;
			} 
			if (txt_birth.getText().equals("")) {
				messageBox(this, "생년월일이 입력 되어있는지 확인하세요.");
				txt_birth.requestFocus();
				txt_birth.setText("");
				return;
			}
			if (txt_email.getText().equals("")) {
				messageBox(this, "이메일이 입력되어 있는지 확인하새요");
				txt_email.requestFocus();
				txt_email.setText("");
				return;
			}
			if (txt_licencenum.getText().equals("")) {
				messageBox(this, "면허번호가 입력되어 있는지 확인하세요.");
				txt_licencenum.requestFocus();
				txt_licencenum.setText("");
				return;

			}
			else if (y_reDAO.insertReserve(y) > 0) {
				messageBox(this, "결제창 이동");
				dispose();// 다이얼로그 박스를 닫는다
			
				
				// yadataVO y=new yadataVO();
				//	JOptionPane.showMessageDialog(this,"결제창으로 이동하시겠습니까?");



			} // if
			new Pay(y);
		} // if else

	}//actionperformed()

	
	public static void messageBox(Object obj, String m) {
		JOptionPane.showMessageDialog((Component) obj, m);
	}// messageBox()

	@Override
	public void focusGained(FocusEvent e) {
		if (e.getSource().equals(txt_id)) {
			txt_id.setText("");
			txt_id.getText();
		}
		if (e.getSource().equals(txt_name)) {
			txt_name.setText("");
			txt_name.getText();
		}
		if (e.getSource().equals(txt_birth)) {
			txt_birth.setText("");
			txt_birth.getText();
		}
		if (e.getSource().equals(txt_email)) {
			txt_email.setText("");
			txt_email.getText();
		}
		if (e.getSource().equals(txt_licencenum)) {
			txt_licencenum.setText("");
			txt_licencenum.getText();
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
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		
	}
	
	
	}
